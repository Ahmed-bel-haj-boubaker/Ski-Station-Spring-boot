package com.ski.skistation.controller;

import com.ski.skistation.entities.Skieur;
import com.ski.skistation.entities.enums.TypeAbonnement;
import com.ski.skistation.service.IserviceSkieur;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skieur")
@RequiredArgsConstructor // injection par constructeur ( lombok ) on n a pas besoin d utiliser le @Autowired

public class skieurController {

 private final  IserviceSkieur iserviceSkieur;




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


    @PostMapping ("/AddSkieurToPiste")

    public  long assignSkieurToPiste(@RequestParam Long numSkieur,@RequestParam Long numPiste){

       return iserviceSkieur.assignSkieurToPiste(numSkieur,numPiste);

    }

    @PostMapping("/addSkierAndAssignToCourse/{numCourse}")

    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur,@PathVariable Long numCourse){
    return  iserviceSkieur.addSkieurAndAssignToCourse(skieur,numCourse);
    }

    @GetMapping("/findSkieurByTypeAbon")

    public List<Skieur> getSkieursBySubscriptionType(@RequestParam String subscriptionType) {
        TypeAbonnement typeAbonnement = TypeAbonnement.valueOf(subscriptionType); // Convert the request parameter to an enum
        return iserviceSkieur.retrieveSkieurBySubscriptionType(typeAbonnement);
    }

}
