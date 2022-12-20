package com.groupeisi.securiteweb.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AppCompte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100 , nullable = false)
    private String Username;
    @Column (length = 100 , nullable = false)
    private  String Password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppDroit> appDroits = new ArrayList<AppDroit>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<AppDroit> getAppDroits() {
        return appDroits;
    }

    public void setAppRoles(List<AppDroit> appDroits) {
        this.appDroits = appDroits;
    }

    public boolean validate(String username, String password) {

        return false;
    };
}
