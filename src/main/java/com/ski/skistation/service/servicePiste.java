package com.ski.skistation.service;

import com.ski.skistation.entities.Piste;
import com.ski.skistation.entities.Skieur;
import com.ski.skistation.repository.PisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class servicePiste implements  IservicePiste{
    @Autowired
    PisteRepository pisteRepository;
    @Override
    public List<Piste> retrieveAllPistes() {
        return (List<Piste>) pisteRepository.findAll();
    }

    @Override
    public Piste addPistes(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePistes(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Optional<Piste> retrievePistes(Long numPiste) {

        Optional<Piste> Piste = pisteRepository.findById(numPiste);
        if(Piste.isPresent()){
            return Piste;
        }else{
            throw new IllegalArgumentException("Piste ID"+numPiste+" is not defined");
        }
    }

    @Override
    public void removePistes(Long numPiste) {
        if(pisteRepository.existsById(numPiste)){
            pisteRepository.deleteById(numPiste);
        }else {
            throw new IllegalArgumentException("Piste ID"+numPiste+" is not defined");
        }
    }
}
