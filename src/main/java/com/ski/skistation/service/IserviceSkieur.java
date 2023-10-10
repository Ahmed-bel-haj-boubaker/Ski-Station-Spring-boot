package com.ski.skistation.service;

import com.ski.skistation.entities.Skieur;

import java.util.List;
import java.util.Optional;

public interface IserviceSkieur {

    List<Skieur> retrieveAllSkieurs();

    Skieur addSkieur(Skieur skieur);

    Skieur updateSkieur(Skieur skieur);

    Optional<Skieur> retrieveSkieur(Long numSkieur);
    void removeSkieur(Long numSkieur );

    long assignSkieurToPiste(Long numSkieur , Long numPiste);


}
