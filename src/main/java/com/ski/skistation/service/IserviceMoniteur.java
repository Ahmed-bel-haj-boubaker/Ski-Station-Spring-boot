package com.ski.skistation.service;

import com.ski.skistation.entities.Moniteur;

import java.util.List;

public interface IserviceMoniteur {
    List<Moniteur> retrieveAllMoniteurs();

    Moniteur addMoniteur(Moniteur moniteur);

    Moniteur updateMoniteur(Moniteur moniteur);

    Moniteur retrieveMoniteur(Long numMoniteur);

}
