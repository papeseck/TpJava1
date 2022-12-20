package com.groupeisi.securiteweb.dto;

import java.util.ArrayList;
import java.util.List;

public class AppCompteDto {
    private int id;
    private String Username;
    private String Password;
    private List<String> appDroits = new ArrayList<>();

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

    public List<String> getAppDroits() {
        return appDroits;
    }

    public void setAppDroits(List<String> appDroits) {
        this.appDroits = appDroits;
    }
}
