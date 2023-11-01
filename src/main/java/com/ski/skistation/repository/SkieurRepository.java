package com.ski.skistation.repository;

import com.ski.skistation.entities.Skieur;
import com.ski.skistation.entities.enums.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface SkieurRepository extends JpaRepository<Skieur,Long> {

    @Query("SELECT s FROM Skieur s WHERE s.abonnement.TypeAbonnement = :typeAbonnement")

    List<Skieur> findByAbonnementTypeAbonnement(@Param("typeAbonnement")TypeAbonnement typeAbonnement);






}
