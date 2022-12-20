package com.groupeisi.securiteweb.dao;

import com.groupeisi.securiteweb.entities.AppCompte;

public interface Icompte extends Repostory<AppCompte>{
    public AppCompte getUsername (String username);
    public AppCompte getPassword(String password);
}
