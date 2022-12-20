package com.groupeisi.securiteweb.dao;

import com.groupeisi.securiteweb.entities.AppDroit;

public interface Idroit extends Repostory<AppDroit> {
    public AppDroit getName(String name);
}
