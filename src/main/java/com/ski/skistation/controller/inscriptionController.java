    package com.ski.skistation.controller;

    import com.ski.skistation.entities.Inscription;

    import com.ski.skistation.entities.enums.Support;
    import com.ski.skistation.service.IserviceInscription;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/inscription")
    public class inscriptionController {

        @Autowired
        IserviceInscription iserviceInscription;


        @GetMapping
        public List<Inscription> getAllInscriptions(){
            return iserviceInscription.retrieveAllInscriptions();
        }

        @GetMapping("/{numInscription}")
        public Optional<Inscription> getInscriptionById(@PathVariable("numInscription") Long numInscription){
            return iserviceInscription.retrieveInscriptions(numInscription);
        }

        @PostMapping("/addInscription")
        public Inscription addInscription(@RequestBody  Inscription inscription){
            return iserviceInscription.addInscriptions(inscription);
        }

        @PutMapping("/updateInscription")
        public Inscription updateInscription(@RequestBody Inscription inscription){
            return iserviceInscription.updateInscriptions(inscription);

        }

        @DeleteMapping("/deleteInscription/{numInscription}")

        public  void deleteInscription(@PathVariable("numInscription") Long numInscription){
            iserviceInscription.removeInscriptions(numInscription);
        }

        @PostMapping("/addRegisterToSkieur")

        public Inscription addRegisterationAndAssignToSkieur(@RequestBody  Inscription inscription ,@RequestParam Long numSkieur){

            iserviceInscription.addRegistrationAndAssignToSkieur(inscription,numSkieur);
            return inscription;
        }

        @PostMapping("/addRegisterToCours")

        public Inscription addRegisterationAndAssignToCours(@RequestParam Long numInscription , @RequestParam Long numCours){

           return iserviceInscription.assignRegistrationToCourse(numInscription,numCours);
        }

        @PostMapping("/addRegisterAndAssignItToSkieurAndCours")

        public Inscription addRegisterAndAssignItToSkieurAndCours(@RequestBody Inscription inscription,@RequestParam Long numCours ,@RequestParam Long numSkieur){
            return iserviceInscription.addRegistrationAndAssignToSkieurAndCours(inscription,numCours,numSkieur);
        }

        @GetMapping("/numWeeksCourseOfInstructorBySupport")
        List<Integer> numWeeksCourseOfInstructorBySupport(Long numMoniteur, Support support){
            return iserviceInscription.numWeeksCourseOfInstructorBySupport(numMoniteur,support);
        }
    }
