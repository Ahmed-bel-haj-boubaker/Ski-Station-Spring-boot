package com.ski.skistation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ski.skistation.entities.Cours;

@Repository

public interface CoursRepository extends CrudRepository<Cours,Long> {

//@Query(value = "SELECT * FROM cours c JOIN moniteur_cours mc ON c.num_cours = mc.cours_num_cours " +
         //      " JOIN moniteur m ON m.num_moniteur = mc.moniteur_num_moniteur WHERE m.nomm= :nameMoniteur",nativeQuery = true)
// @Query("SELECT c " +
      //   "FROM Cours c " +
      ///   "JOIN Moniteur m ON  c member m.cours " +   //member car le cours n pas une relation direct avec le moniteur donc bch nlawjou m chira ta3 moniteur
     //    "WHERE m.nomM = :nomMoniteur ")
//List<Cours> getMoniteurByCours(@Param("nameMoniteur") String nameMoniteur);

 // la difference entre jpql et keyword ( jpa)  : bch nekteb keyword yrodha ba3ed query ou temchi l mysql

    Cours getCoursByNumCours(Long numCours);


}
