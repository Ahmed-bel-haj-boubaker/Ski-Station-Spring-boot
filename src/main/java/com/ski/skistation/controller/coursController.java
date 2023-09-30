package com.ski.skistation.controller;

import com.ski.skistation.entities.Cours;
import com.ski.skistation.service.IserviceCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cours")
public class coursController {

@Autowired
    IserviceCours iserviceCours;

@GetMapping
    public List<Cours> getAll(){
    return iserviceCours.retrieveAllCourses();
}

@GetMapping("/{numCours}")
public Optional<Cours> retrieveCours(@PathVariable("numCours") Long numCours){

    return  iserviceCours.retrieveCours(numCours);
}

@PostMapping("/addCours")
    public Cours addCours(@RequestBody Cours cours){
    return  iserviceCours.addCours(cours);
}

@PutMapping("/updateCours")
    public Cours updateCours(@RequestBody Cours cours){
    return iserviceCours.updateCours(cours);
}



}
