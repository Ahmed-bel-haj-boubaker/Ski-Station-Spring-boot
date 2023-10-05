package com.ski.skistation.service;

import com.ski.skistation.entities.Cours;
import com.ski.skistation.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceCours implements IserviceCours {

   @Autowired
    CoursRepository coursRepo;


    @Override
    public List<Cours> retrieveAllCourses() {
        return (List<Cours>) coursRepo.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepo.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepo.save(cours);
    }

    @Override
    public Optional<Cours> retrieveCours(Long numCours) {
        Optional<Cours> cours = coursRepo.findById(numCours);
        if(cours.isPresent()){

            return cours ;
        }else {
            throw new IllegalArgumentException("Cours with ID " + numCours + " not found");
        }
    }

    @Override
    public void removeCours(Long numCours) {
        if (coursRepo.existsById(numCours)) {
            coursRepo.deleteById(numCours);
        } else {
            throw new IllegalArgumentException("Cours with ID " + numCours + " not found");

        }
    }
}
