package com.ski.skistation.service;

import com.ski.skistation.entities.Cours;
import com.ski.skistation.entities.Moniteur;
import com.ski.skistation.repository.CoursRepository;
import com.ski.skistation.repository.MoniteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class serviceMoniteur implements  IserviceMoniteur{
@Autowired
    MoniteurRepository moniteurRepo;
@Autowired
    CoursRepository coursRepository;

    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return (List<Moniteur>) moniteurRepo.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepo.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepo.save(moniteur) ;
    }

    @Override
    public Optional<Moniteur> retrieveMoniteur(Long numMoniteur) {
         Optional< Moniteur > moniteur = moniteurRepo.findById(numMoniteur);

        if (moniteur.isPresent()) {
            return moniteur;
        } else {
            // Handle the case where no Inscription was found with the specified ID, e.g., return an empty Optional or throw an exception.
            return Optional.empty(); // You can change this to your desired behavior.
        }
    }

    @Override
    public void removeMoniteur(Long numMoniteur) {
        if (moniteurRepo.existsById(numMoniteur)) {
            moniteurRepo.deleteById(numMoniteur);
        } else {
            throw new IllegalArgumentException("Moniteur with ID " + numMoniteur + " not found");

        }
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {


            Cours cours = coursRepository.findById(numCourse).get();


            if (moniteur.getCours() == null) {
                moniteur.setCours(new HashSet<>());
            }
            moniteur.getCours().add(cours);
            moniteur = moniteurRepo.save(moniteur);

            return moniteur;


    }
}
