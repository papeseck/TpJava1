package com.groupeisi.securiteweb.config;

import java.util.Properties;

import com.groupeisi.securiteweb.entities.AppCompte;
import com.groupeisi.securiteweb.entities.AppDroit;
import com.groupeisi.securiteweb.entities.User;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import  org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/devoir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
                settings.put(Environment.USER, "seck");
                settings.put(Environment.PASS, "seck");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                    //cette ligne est très importante
                settings.put(Environment.HBM2DDL_AUTO, "update");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(AppCompte.class);
                configuration.addAnnotatedClass(AppDroit.class);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
