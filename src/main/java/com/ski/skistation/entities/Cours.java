package com.ski.skistation.entities;

import com.ski.skistation.entities.enums.Support;
import com.ski.skistation.entities.enums.TypeCours;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long numCours ;
    Integer niveau;

    @Enumerated(EnumType.STRING)
    TypeCours TypeCours;
    Support Support;

    Float prix;
    Integer creneau;

    @OneToMany(mappedBy = "cours")
    Set<Inscription> inscriptions ;





}
