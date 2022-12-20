package com.groupeisi.securiteweb.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AppDroit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100 ,nullable = false)
    private String name;
    @ManyToMany(mappedBy ="adroit", fetch = FetchType.EAGER)
    private List<AppCompte> appComptes = new ArrayList<AppCompte>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AppCompte> getAppComptes() {
        return appComptes;
    }

    public void setAppComptes(List<AppCompte> appComptes) {
        this.appComptes = appComptes;
    }
}
