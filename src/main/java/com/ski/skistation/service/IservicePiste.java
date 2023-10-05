package com.ski.skistation.service;

import com.ski.skistation.entities.Moniteur;
import com.ski.skistation.entities.Piste;

import java.util.List;

public interface IservicePiste {

    List<Piste> retrieveAllPistes();

    Moniteur addPistes(Piste piste);

    Moniteur updatePistes(Piste piste);

    List<Piste> retrievePistes(Long numPiste);

    void removePistes(Long numPiste);
}


