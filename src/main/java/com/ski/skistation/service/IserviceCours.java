package com.ski.skistation.service;

import com.ski.skistation.entities.Cours;

import java.util.List;
import java.util.Optional;


public interface IserviceCours {

    List<Cours> retrieveAllCourses();

    Cours addCours(Cours cours);

    Cours updateCours(Cours cours);

    Optional<Cours> retrieveCours(Long numCours);

    void removeCours(Long numCours);
}
