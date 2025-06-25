package com.examtechnolab.stagiaireService.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EncadreurDTO {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
}
