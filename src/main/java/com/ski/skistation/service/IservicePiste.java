package com.ski.skistation.service;

import com.ski.skistation.entities.Piste;

import java.util.List;

public interface IservicePiste {

    List<Piste> retrieveAllPistes();

    Piste addPiste(Piste piste);

    Piste updatePiste(Piste piste);

    Piste retrievePiste(Long numPiste);
}
