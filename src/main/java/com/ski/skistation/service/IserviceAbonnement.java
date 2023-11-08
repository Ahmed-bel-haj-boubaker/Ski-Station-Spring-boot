package com.ski.skistation.service;

import com.ski.skistation.entities.Abonnement;
import com.ski.skistation.entities.enums.TypeAbonnement;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IserviceAbonnement {
    List<Abonnement> retrieveAllAbonnements();

    Abonnement addAbonnements(Abonnement abonnement);

    Abonnement updateAbonnements(Abonnement abonnement);

    Abonnement retrieveAbonnements(Long numAbon);

    void removeAbonnements(Long numAbon);

    List<Abonnement> getSubsciptionByType(TypeAbonnement typeAbonnement);

    List<Abonnement> getAbonnementByType(TypeAbonnement typeAbonnement);

    List<Abonnement> getAbonnementByDate(LocalDate dateDebut , LocalDate dateFin);

    List<Abonnement> findByDateDebutAfterAndDataFinAfter(LocalDate dateDebut , LocalDate dateFin);
}
