package com.ski.skistation.entities;

import com.ski.skistation.entities.enums.Couleur;
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
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long numPiste;



    String nomPiste;

    Integer longeur;

    Integer pente;

    @Enumerated(EnumType.STRING)
      Couleur couleur;

    @ManyToMany(mappedBy = "pistes")


    Set<Skieur> skieurs;

}
