package com.ski.skistation.repository;

import com.ski.skistation.entities.Skieur;
import com.ski.skistation.entities.enums.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkieurRepository extends JpaRepository<Skieur,Long> {

  ///  @Query("SELECT s FROM Skieur s WHERE s.abonnement.typeAbonnement = :typeAbonnement")

   // List<Skieur> findByAbonnementTypeAbonnementt(@Param("typeAbonnement")TypeAbonnement typeAbonnement);


  List<Skieur> findByAbonnementTypeAbonnement(TypeAbonnement abonnement_typeAbonnement);

  // List<Skieur> findByAbonnement_AbonnementTypeAndPistesCouleurAndInscriptionsCoursSupportAndInscriptionsCoursCoursType(TypeAbonnement abonnement_typeAbonnement, Couleur pistes_couleur, Support inscriptions_cours_support, TypeCours inscriptions_cours_typeCours); // optionelle

/*@Query(value = "\n" +
        "SELECT * FROM skieur s \n" +
        "JOIN inscription  i ON s.num_skieur = i.skieur_num_skieur \n" +
        "JOIN  moniteur_cours mc ON  i.cour_num_cours = mc.cours_num_cours\n" +
        "JOIN moniteur m ON m.num_moniteur = mc.moniteur_num_moniteur\n" +
        "WHERE m.nomm" , nativeQuery = true)*/

@Query("select s from Skieur s " +
        "join  Inscription i on  i.skieurs.numSkieur = s.numSkieur " +
        "join Cours c on i.cours.numCours = c.numCours " +
        "join  Moniteur m on c member m.cours " +
        " where m.nomM= :moniteurName") //JPQL


  List<Skieur> getSkieurByMoniteurName(String moniteurName); // bch ne5dmouha jpql 5ater manajemch nod5ol l moniteur

  Skieur getSkieurByNumSkieur(Long numSkieur);
}
