package com.ski.skistation.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "numSkieur")
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long numSkieur;
     String nomS;
     String prenomS;
     LocalDate dateNaissance;
     String villa;
@JsonIgnore
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
