package com.ski.skistation.service;

import com.ski.skistation.entities.Abonnement;
import com.ski.skistation.entities.enums.TypeAbonnement;
import com.ski.skistation.exceptions.ResourceNotFoundException;
import com.ski.skistation.repository.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public Abonnement retrieveAbonnements(Long numAbon) {
        Abonnement abonnement = repoAbon.findById(numAbon).orElseThrow(
                ()-> new ResourceNotFoundException("abonnement","id", numAbon)
        );
   return abonnement;
    }



    @Override
    public void removeAbonnements(Long numAbon) {
        if (repoAbon.existsById(numAbon)) {
            repoAbon.deleteById(numAbon);
        } else {
            throw new ResourceNotFoundException("abonnement","id", numAbon);

        }

    }

    @Override
    public List<Abonnement> getSubsciptionByType(TypeAbonnement typeAbonnement) {
        return repoAbon.getSubscriptionByType(typeAbonnement);
    }

    @Override
    public List<Abonnement> getAbonnementByDate(LocalDate dateDebut, LocalDate dateFin) {
        return repoAbon.getAbonnementByDate(dateDebut,dateFin);
    }

    @Override
    public List<Abonnement> getAbonnementByType(TypeAbonnement typeAbonnement) {
        return repoAbon.findByTypeAbonnementOrderByDateDebut(typeAbonnement);
    }

    @Override
    public List<Abonnement> findByDateDebutAfterAndDataFinAfter(LocalDate dateDebut, LocalDate dateFin) {
        return repoAbon.findByDateDebutAfterAndDataFinBefore(dateDebut,dateFin);
    }
}
