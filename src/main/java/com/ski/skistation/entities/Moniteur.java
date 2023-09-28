package com.ski.skistation.entities;

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
public class Moniteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numMoniteur;
    String nomM;
    String prenomM;
    LocalDate dateRecru;
}
