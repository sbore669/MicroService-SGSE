package com.examtechnolab.encadreurService.repositories;

import com.examtechnolab.encadreurService.model.Encadreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EncadreurRepository extends JpaRepository<Encadreur, Long> {
    Optional<Encadreur> findByEmail(String email);
}
