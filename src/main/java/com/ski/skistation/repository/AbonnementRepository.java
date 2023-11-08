package com.ski.skistation.repository;

import com.ski.skistation.entities.Abonnement;
import com.ski.skistation.entities.Skieur;
import com.ski.skistation.entities.enums.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {

    List<Abonnement> findByTypeAbonnementOrderByDateDebut(TypeAbonnement typeAbonnement);
    @Query("SELECT ab FROM Abonnement ab WHERE ab.typeAbonnement = :typeAbonnement ORDER BY ab.dateDebut ASC"  )
    List<Abonnement> getSubscriptionByType(@Param("typeAbonnement") TypeAbonnement typeAbonnement);

    List<Abonnement> findByDateDebutAfterAndDataFinBefore(LocalDate dateDebut , LocalDate dateFin);

    @Query("SELECT ab FROM Abonnement ab WHERE ab.dateDebut >= :dateDebut AND ab.dataFin <= :dateFin")

    List<Abonnement> getAbonnementByDate(@Param("dateDebut")LocalDate dateDebut , @Param("dateFin") LocalDate dateFin);
}
