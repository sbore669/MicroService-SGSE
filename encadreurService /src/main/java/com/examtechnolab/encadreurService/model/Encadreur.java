package com.examtechnolab.encadreurService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "encadreur")
public class Encadreur {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @Column(unique = true)
    private String email;

    private String telephone;
}
