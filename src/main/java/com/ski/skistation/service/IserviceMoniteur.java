package com.ski.skistation.service;

import com.ski.skistation.entities.Moniteur;

import java.util.List;
import java.util.Optional;

public interface IserviceMoniteur {
    List<Moniteur> retrieveAllMoniteurs();

    Moniteur addMoniteur(Moniteur moniteur);

    Moniteur updateMoniteur(Moniteur moniteur);

    Optional<Moniteur> retrieveMoniteur(Long numMoniteur);

    void removeMoniteur(Long numMoniteur);

}
