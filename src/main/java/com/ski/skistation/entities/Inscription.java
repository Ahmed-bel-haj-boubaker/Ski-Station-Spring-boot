package com.ski.skistation.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "numInscription")
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
