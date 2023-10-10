package com.ski.skistation.service;

import com.ski.skistation.entities.Piste;
import com.ski.skistation.entities.Skieur;
import com.ski.skistation.repository.PisteRepository;
import com.ski.skistation.repository.SkieurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceSkieur implements  IserviceSkieur{

    @Autowired
    SkieurRepository skieurRep;
    @Autowired
    PisteRepository pisteRepository;

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return (List<Skieur>) skieurRep.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRep.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
          return skieurRep.save(skieur);
    }

    @Override
    public Optional<Skieur> retrieveSkieur(Long numSkieur) {

        Optional<Skieur> skieur = skieurRep.findById(numSkieur);
        if(skieur.isPresent()){
            return skieur;
        }else{
            throw new IllegalArgumentException("Skieur ID"+numSkieur+" is not defined");
        }

    }

    @Override
    public void removeSkieur(Long numSkieur) {
         if(skieurRep.existsById(numSkieur)){
             skieurRep.deleteById(numSkieur);
         }else {
             throw new IllegalArgumentException("Skieur ID"+numSkieur+" is not defined");
         }
    }

    @Override
    public long assignSkieurToPiste(Long numSkieur, Long numPiste) {

        Skieur skieur = skieurRep.findById(numSkieur).get();
        System.out.println(skieur);
        Piste piste = pisteRepository.findById(numPiste).get();
        System.out.println(piste);
        skieur.getPistes().add(piste);
        skieurRep.save(skieur);

       return skieur.getNumSkieur();

    }
}
