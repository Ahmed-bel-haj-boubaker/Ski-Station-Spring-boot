package com.ski.skistation.service;

import com.ski.skistation.entities.Cours;
import com.ski.skistation.entities.Inscription;
import com.ski.skistation.entities.Skieur;
import com.ski.skistation.repository.CoursRepository;
import com.ski.skistation.repository.InscriptionRepository;
import com.ski.skistation.repository.SkieurRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class serviceIscription implements IserviceInscription{

    @Autowired
    InscriptionRepository inscriptionRepo;
    @Autowired
    SkieurRepository skieurRepository;
    @Autowired
    CoursRepository coursRepository;
    @Override
    public List<Inscription> retrieveAllInscriptions() {
        return (List<Inscription>) inscriptionRepo.findAll();
    }

    @Override
    public Inscription addInscriptions(Inscription inscription) {
        return inscriptionRepo.save(inscription);
    }

    @Override
    public Inscription updateInscriptions(Inscription inscription) {
        return inscriptionRepo.save(inscription);
    }


    @Override
    public Optional<Inscription> retrieveInscriptions(Long numInscription) {
        Optional<Inscription> inscriptionOptional = inscriptionRepo.findById(numInscription);

        if (inscriptionOptional.isPresent()) {
            return inscriptionOptional;
        } else {

            throw new IllegalArgumentException("Cours with ID " + numInscription + " not found");
        }
    }

    @Override
    public boolean removeInscriptions(Long numInscription) {

        inscriptionRepo.deleteById(numInscription);
        return !(inscriptionRepo.existsById(numInscription));

    }

    @Override
    public Inscription addRegistrationAndAssignToSkieur(Inscription inscription, Long numSkieur) {

        Skieur skieur = skieurRepository.findById(numSkieur).get();
        inscription.setSkieurs(skieur);
        return inscriptionRepo.save(inscription);
    }

    @Override
    public Inscription assignRegistrationToCourse(Long numInscription, Long numCours) {
        Cours cours = coursRepository.findById(numCours).get();
        Inscription inscription = inscriptionRepo.findById(numInscription).get();

        inscription.setCours(cours);
        inscriptionRepo.save(inscription);

     return inscription;
    }
}
