package com.ski.skistation.service;

import com.ski.skistation.entities.Moniteur;
import com.ski.skistation.entities.Piste;

import java.util.List;
import java.util.Optional;

public interface IservicePiste {

    List<Piste> retrieveAllPistes();

    Piste addPistes(Piste piste);

    Piste updatePistes(Piste piste);

    Optional<Piste> retrievePistes(Long numPiste);

    void removePistes(Long numPiste);
}


