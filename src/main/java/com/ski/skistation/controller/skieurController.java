package com.ski.skistation.controller;

import com.ski.skistation.entities.Skieur;
import com.ski.skistation.service.IservicePiste;
import com.ski.skistation.service.IserviceSkieur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skieur")
public class skieurController {

    @Autowired
    IserviceSkieur iserviceSkieur;



@GetMapping
    public List<Skieur> getAllSkieurs(){
        return iserviceSkieur.retrieveAllSkieurs();
    }

    @GetMapping("/{numSkieur}")
    public Optional<Skieur> getSkieurById(@PathVariable("numSkieur") Long numSkieur){
    return iserviceSkieur.retrieveSkieur(numSkieur);
    }

    @PostMapping("/addSkieur")
    public Skieur addSkieur(@RequestBody  Skieur skieur){
    return iserviceSkieur.addSkieur(skieur);
    }

    @PutMapping("/updateSkieur")
    public Skieur updateSkieur(@RequestBody Skieur skieur){
    return iserviceSkieur.updateSkieur(skieur);

    }

    @DeleteMapping("/deleteSkieur/{numSkieur}")

    public  void deleteSkieur(@PathVariable("numSkieur") Long numSkieur){
    iserviceSkieur.removeSkieur(numSkieur);
    }


    @GetMapping ("/AddSkieurToPiste")

    public  long assignSkieurToPiste(@RequestParam Long numSkieur,@RequestParam Long numPiste){

return iserviceSkieur.assignSkieurToPiste(numSkieur,numPiste);

    }

}
