package com.ski.skistation.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long numSkieur;
     String nomS;
     String prenomS;
     LocalDate dateNaissance;
     String villa;

@ManyToMany

@JoinTable(
        name = "piste_skieur",
        joinColumns = @JoinColumn(name = "skieurs_num_skieur"),
        inverseJoinColumns = @JoinColumn(name = "pistes_num_piste"))
        Set<Piste> pistes;

    @OneToMany(mappedBy = "skieurs")
    Set<Inscription> inscriptions ;
    @OneToOne(cascade = CascadeType.ALL)
    Abonnement abonnement;
}
