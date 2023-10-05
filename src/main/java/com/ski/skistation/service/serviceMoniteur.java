package com.ski.skistation.service;

import com.ski.skistation.entities.Moniteur;
import com.ski.skistation.repository.MoniteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceMoniteur implements  IserviceMoniteur{
@Autowired
    MoniteurRepository moniteurRepo;

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

}
