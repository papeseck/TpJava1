package com.groupeisi.securiteweb.dao;

import com.groupeisi.securiteweb.config.HibernateUtil;
import com.groupeisi.securiteweb.entities.AppCompte;
import com.groupeisi.securiteweb.entities.AppDroit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class RepostoryImpl <T> implements Repostory<T> {

    protected Session session;
    protected Transaction transaction;

    public RepostoryImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public int add(T t) {
        int result = 1;
        transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();

        return result;
    }

    @Override
    public int delete(int id, T t) {
        int result = 1;

        transaction = session.beginTransaction();
        session.delete(session.get(t.getClass(), id));
        transaction.commit();
        return result;
    }

    @Override
    public int update(T t) {
        int result = 1;
        transaction = session.beginTransaction();
        session.merge(t);
        transaction.commit();
        return result;
    }

    @Override
    public List<T> list(T t) {
        return null;
    }

    @Override
    public T get(int id, T t) {
        return null;
    }

    public abstract AppDroit getByNom(String nom);

    public abstract AppCompte getByUsername(String username);
}

