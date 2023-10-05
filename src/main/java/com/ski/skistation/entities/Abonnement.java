package com.ski.skistation.entities;

import com.ski.skistation.entities.enums.TypeAbonnement;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numAbon;

    LocalDate dateDebut;
    LocalDate dataFin;
    Float prixAbon;

    @Enumerated(EnumType.STRING)
    TypeAbonnement TypeAbonnement;


}
