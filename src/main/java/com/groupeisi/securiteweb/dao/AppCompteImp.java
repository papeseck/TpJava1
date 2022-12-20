package com.groupeisi.securiteweb.dao;

import com.groupeisi.securiteweb.dto.AppCompteDto;
import com.groupeisi.securiteweb.dto.AppDroitDto;
import com.groupeisi.securiteweb.entities.AppCompte;
import com.groupeisi.securiteweb.entities.AppDroit;

import java.util.ArrayList;
import java.util.List;

public abstract class AppCompteImp extends RepostoryImpl<AppCompte> implements Icompte {
    @Override
    public AppCompte getByUsername(String username) {

        return (AppCompte) session.createQuery("FROM AppCompte role WHERE compte.nom = :droit_nom")
                .setParameter("compte_nom", username).uniqueResult();
    }

    public AppCompte appDroitDtoToAppDroitEntity (AppCompteDto appCompteDto) {
        AppCompte appCompte = new AppCompte();
        appCompte.setId(appCompte.getId());
        appCompte.setUsername(appCompteDto.getUsername());
        if (appCompteDto.getAppDroits() != null) {
            List<AppDroit> appDroits = new ArrayList<AppDroit>();
            appCompteDto.getAppDroits().forEach(nom->{
                String appDroit = new AppDroitDto().getName();
              //  appComptes.add(appCompte);
            });
            appCompte.setAppRoles(appDroits);
        }

        return appCompte;
    }

    public AppCompteDto appRoleEntityToAppRoleDto (AppCompte appCompte) {
        AppCompteDto appCompteDto = new AppCompteDto();
        appCompteDto.setId(appCompte.getId());
        appCompteDto.setUsername(appCompte.getUsername());
        if (appCompte.getAppDroits() != null) {
            List<String> droits = new ArrayList<>();
            appCompte.getAppDroits().forEach(droit->{
                droits.add(droit.getName());
            });
            appCompteDto.setAppDroits(droits);
        }
        return appCompteDto;
    }
}
