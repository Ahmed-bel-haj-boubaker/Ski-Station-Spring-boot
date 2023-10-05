package com.ski.skistation.controller;

import com.ski.skistation.entities.Piste;
import com.ski.skistation.entities.Skieur;
import com.ski.skistation.service.IservicePiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/piste")
public class pisteController {
    @Autowired
    IservicePiste iservicePiste;


    @GetMapping
    public List<Piste> getAllPistess(){
        return iservicePiste.retrieveAllPistes();
    }

    @GetMapping("/{numPiste}")
    public Optional<Piste> getPisteById(@PathVariable("numPiste") Long numPiste){
        return iservicePiste.retrievePistes(numPiste);
    }

    @PostMapping("/addPiste")
    public Piste addPiste(@RequestBody  Piste piste){
        return iservicePiste.addPistes(piste);
    }

    @PutMapping("/updatePiste")
    public Piste updatePiste(@RequestBody Piste piste){
        return iservicePiste.updatePistes(piste);

    }

    @DeleteMapping("/deletePiste/{numPiste}")

    public  void deletePiste(@PathVariable("numPiste") Long numPiste){
        iservicePiste.removePistes(numPiste);
    }


}
