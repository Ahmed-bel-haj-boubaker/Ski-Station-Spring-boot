package com.ski.skistation.controller;

import com.ski.skistation.entities.Moniteur;
import com.ski.skistation.service.IserviceMoniteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/moniteur")
public class moniteurController {

    @Autowired
    IserviceMoniteur iserviceMoniteur;

    @GetMapping
    public List<Moniteur> getAllMoniteurs(){
        return iserviceMoniteur.retrieveAllMoniteurs();
    }

    @GetMapping("/{numMoniteur}")
    public Optional<Moniteur> getMoniteurById(@PathVariable("numMoniteur") Long numMoniteur){
        return iserviceMoniteur.retrieveMoniteur(numMoniteur);
    }

    @PostMapping("/addMoniteur")
    public Moniteur addMoniteur(@RequestBody  Moniteur moniteur){
        return iserviceMoniteur.addMoniteur(moniteur);
    }

    @PutMapping("/updateMoniteur")
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur){
        return iserviceMoniteur.updateMoniteur(moniteur);

    }

    @DeleteMapping("/deleteMoniteur/{numMoniteur}")

    public  void deleteSkieur(@PathVariable("numMoniteur") Long numMoniteur){
        iserviceMoniteur.removeMoniteur(numMoniteur);
    }

}
