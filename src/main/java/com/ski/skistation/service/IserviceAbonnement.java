package com.ski.skistation.service;

import com.ski.skistation.entities.Abonnement;
import com.ski.skistation.entities.enums.TypeAbonnement;

import java.util.List;
import java.util.Optional;

public interface IserviceAbonnement {
    List<Abonnement> retrieveAllAbonnements();

    Abonnement addAbonnements(Abonnement abonnement);

    Abonnement updateAbonnements(Abonnement abonnement);

    Optional<Abonnement> retrieveAbonnements(Long numAbon);

    void removeAbonnements(Long numAbon);

    List<Abonnement> getSubsciptionByType(TypeAbonnement typeAbonnement);
}
