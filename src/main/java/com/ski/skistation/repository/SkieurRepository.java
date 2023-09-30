package com.ski.skistation.repository;

import com.ski.skistation.entities.Skieur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface SkieurRepository extends CrudRepository<Skieur,String> {


     List<Skieur> retrieveAllSkieurs();

     Skieur addSkieur(Skieur skieur);
     Skieur retrieveSkieur(Long numSkieur);
    void removeSkieur(String numSkieur );




}
