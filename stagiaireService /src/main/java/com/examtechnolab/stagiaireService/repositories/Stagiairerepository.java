package com.examtechnolab.stagiaireService.repositories;

import com.examtechnolab.stagiaireService.model.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stagiairerepository extends JpaRepository<Stagiaire, Long> {
}
