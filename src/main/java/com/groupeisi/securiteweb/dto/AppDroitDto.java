package com.groupeisi.securiteweb.dto;

import java.util.ArrayList;
import java.util.List;

public class AppDroitDto {
    private int id;
    private String name;
    private List<String> appComptes = new ArrayList<>();

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

    public List<String> getAppComptes() {
        return appComptes;
    }

    public void setAppComptes(List<String> appComptes) {
        this.appComptes = appComptes;
    }
}
