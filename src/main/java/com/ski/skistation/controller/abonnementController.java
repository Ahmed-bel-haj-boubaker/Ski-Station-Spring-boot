package com.ski.skistation.controller;

import com.ski.skistation.entities.Abonnement;
import com.ski.skistation.entities.enums.TypeAbonnement;
import com.ski.skistation.service.IserviceAbonnement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/abonnement")
@RequiredArgsConstructor
public class abonnementController {

  private  final  IserviceAbonnement iserviceAbonnement;

    @GetMapping
    public List<Abonnement> getAll(){
        return iserviceAbonnement.retrieveAllAbonnements();
    }
    @PostMapping("/addAbon")
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement){
        return iserviceAbonnement.addAbonnements(abonnement);
    }
    @GetMapping("/{numAbonnement}")
    public Abonnement getByIdAbonnement(@PathVariable("numAbonnement") Long numAbon){
        return  iserviceAbonnement.retrieveAbonnements(numAbon);
    }

    @PutMapping("/updateAbonnement")
    public Abonnement updateAbonnement (@RequestBody  Abonnement abonnement){
        return iserviceAbonnement.updateAbonnements(abonnement);
    }

    @DeleteMapping("/deleteAbonnement/{numAbon}")
    public void deleteAbonnement(@PathVariable("numAbon") Long numAbon){

        iserviceAbonnement.removeAbonnements(numAbon);

    }

    @GetMapping("/subscriptions")
    public List<Abonnement> getSubscriptionsByType(@RequestParam TypeAbonnement typeAbonnement) {
        return iserviceAbonnement.getAbonnementByType(typeAbonnement);
    }

    @GetMapping("/getAbonnementByDate")
    public List<Abonnement> getAbonnementByDate(@RequestParam LocalDate dateDebut , @RequestParam LocalDate dateFin){
return iserviceAbonnement.findByDateDebutAfterAndDataFinAfter(dateDebut,dateFin);

    }

}
