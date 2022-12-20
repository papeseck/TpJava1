package com.groupeisi.securiteweb.dao;

import com.groupeisi.securiteweb.dto.AppDroitDto;
import com.groupeisi.securiteweb.entities.AppCompte;
import com.groupeisi.securiteweb.entities.AppDroit;

import java.util.ArrayList;
import java.util.List;

public class AppDroitImpl extends RepostoryImpl<AppDroit> implements Idroit{
    @Override
    public AppDroit getByNom(String nom) {

        return (AppDroit) session.createQuery("FROM AppRole role WHERE role.nom = :role_nom")
                .setParameter("role_nom", nom).uniqueResult();
    }

    @Override
    public AppCompte getByUsername(String username) {
        return null;
    }

    public AppDroit appRoleDtoToAppRoleEntity (AppDroitDto appDroitDto) {
        AppDroit appDroit = new AppDroit();
        appDroit.setId(appDroitDto.getId());
        appDroit.setName(appDroitDto.getName());
        if (appDroitDto.getAppComptes() != null) {
            List<AppCompte> appUsers = new ArrayList<AppCompte>();
            appDroitDto.getAppComptes().forEach(email->{
                AppCompte appCompte = new AppCompteImp() {
                    @Override
                    public AppDroit getByNom(String nom) {
                        return null;
                    }

                    @Override
                    public AppCompte getUsername(String username) {
                        return null;
                    }

                    @Override
                    public AppCompte getPassword(String password) {
                        return null;
                    }
                }.getUsername(email);
                appUsers.add(appCompte);
            });
            appDroit.setAppComptes(appUsers);
        }

        return appDroit;
    }

    public AppDroitDto appRoleEntityToAppRoleDto (AppDroit appDroit) {
        AppDroitDto appDroitDto = new AppDroitDto();
        appDroitDto.setId(appDroit.getId());
        appDroitDto.setName(appDroit.getName());
        if (appDroit.getAppComptes() != null) {
            List<String> emailUsers = new ArrayList<String>();
            appDroit.getAppComptes().forEach(user->{
                emailUsers.add(user.getUsername());
            });
            appDroitDto.setAppComptes(emailUsers);
        }
        return appDroitDto;
    }

    @Override
    public AppDroit getName(String name) {
        return null;
    }
}
