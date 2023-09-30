package com.ski.skistation.repository;

import com.ski.skistation.entities.Moniteur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoniteurRepository extends CrudRepository<Moniteur,String> {

    List<Moniteur> retrieveAllMoniteurs();

    Moniteur addMoniteur(Moniteur moniteur);

    Moniteur updateMoniteur(Moniteur moniteur);

    Moniteur retrieveMoniteur(Long numMoniteur);


}
