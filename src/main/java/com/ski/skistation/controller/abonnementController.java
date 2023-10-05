package com.ski.skistation.controller;

import com.ski.skistation.entities.Abonnement;
import com.ski.skistation.service.IserviceAbonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/abonnement")
public class abonnementController {
    @Autowired
    IserviceAbonnement iserviceAbonnement;

    @GetMapping
    public List<Abonnement> getAll(){
        return iserviceAbonnement.retrieveAllAbonnements();
    }
    @PostMapping("/addAbon")
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement){
        return iserviceAbonnement.addAbonnements(abonnement);
    }
    @GetMapping("/{numAbonnement}")
    public Optional<Abonnement> getByIdAbonnement(@PathVariable("numAbonnement") Long numAbon){
        return (Optional<Abonnement>) iserviceAbonnement.retrieveAbonnements(numAbon);
    }

    @PutMapping("/updateAbonnement")
    public Abonnement updateAbonnement (@RequestBody  Abonnement abonnement){
        return iserviceAbonnement.updateAbonnements(abonnement);
    }

    @DeleteMapping("/deleteAbonnement/{numAbon}")
    public void deleteAbonnement(@PathVariable("numAbon") Long numAbon){
        iserviceAbonnement.removeAbonnements(numAbon);

    }

}
