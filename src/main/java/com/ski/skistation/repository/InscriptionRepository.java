package com.ski.skistation.repository;

import com.ski.skistation.entities.Inscription;
import com.ski.skistation.entities.enums.Support;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends CrudRepository<Inscription,Long> {

    @Query("SELECT i.numSemaine FROM Inscription i " +
            "WHERE i.cours IN (SELECT c FROM Moniteur m JOIN m.cours c WHERE m.numMoniteur = :numMoniteur) " +
            "AND i.cours.support = :support")
    List<Integer> numWeeksCoursOfMoniteurBySupport(@Param("numMoniteur") Long numMoniteur, @Param("support") Support support);


}
