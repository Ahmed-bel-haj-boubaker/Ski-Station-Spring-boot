package com.ski.skistation.entities;

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
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numInscription;
    Integer numSemaine;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Cours cours;

    @ManyToOne
    @JoinColumn(name = "skieur_id")
    Skieur skieurs;
}
