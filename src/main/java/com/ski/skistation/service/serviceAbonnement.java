package com.ski.skistation.service;

import com.ski.skistation.entities.Abonnement;
import com.ski.skistation.entities.enums.TypeAbonnement;
import com.ski.skistation.repository.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class serviceAbonnement implements IserviceAbonnement{

    @Autowired
    public AbonnementRepository repoAbon;
    @Override
    public List<Abonnement> retrieveAllAbonnements() {
        return (List<Abonnement>)repoAbon.findAll();

    }

    @Override
    public Abonnement addAbonnements(Abonnement abonnement) {
        return repoAbon.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnements(Abonnement abonnement) {
        return repoAbon.save(abonnement);
    }

    @Override
    public Optional<Abonnement> retrieveAbonnements(Long numAbon) {
        Optional<Abonnement> abonnement = repoAbon.findById(numAbon);
        if(abonnement.isPresent()){
            return abonnement;
        }else {
            throw new IllegalArgumentException("Abonnement with ID " + numAbon + " not found");
        }
    }



    @Override
    public void removeAbonnements(Long numAbon) {
        if (repoAbon.existsById(numAbon)) {
            repoAbon.deleteById(numAbon);
        } else {
            throw new IllegalArgumentException("Abonnement with ID " + numAbon + " not found");

        }

    }

    @Override
    public List<Abonnement> getSubsciptionByType(TypeAbonnement typeAbonnement) {
        return repoAbon.getSubscriptionByType(typeAbonnement);
    }
}
