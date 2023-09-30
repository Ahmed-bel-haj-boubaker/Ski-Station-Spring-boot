package com.ski.skistation.service;

import com.ski.skistation.entities.Skieur;

import java.util.List;

public interface IserviceSkieur {

    List<Skieur> retrieveAllSkieurs();

    Skieur addSkieur(Skieur skieur);

    Skieur updateSkieur(Skieur skieur);

    Skieur retrieveSkieur(Long numSkieur);
    void removeSkieur(String numSkieur );


}
