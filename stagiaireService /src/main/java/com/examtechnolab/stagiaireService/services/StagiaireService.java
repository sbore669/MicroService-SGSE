package com.examtechnolab.stagiaireService.services;

import com.examtechnolab.stagiaireService.clients.EncadreurClient;
import com.examtechnolab.stagiaireService.dto.EncadreurDTO;
import com.examtechnolab.stagiaireService.model.Stagiaire;
import com.examtechnolab.stagiaireService.repositories.Stagiairerepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StagiaireService {

    @Autowired
    private Stagiairerepository stagiaireRepository;

    @Autowired
    private EncadreurClient encadreurClient;

    private final EntityManager em;

    public StagiaireService(EntityManager em) {
        this.em = em;
    }

    public Stagiaire create(Stagiaire stagiaire){
        try {
            System.out.println("create");

            EncadreurDTO encadreur = encadreurClient.findEncadreurById(stagiaire.getEncadreurId());
            System.out.println(encadreur);
            stagiaire.setEncadreurId(encadreur.getId());
            return stagiaireRepository.saveAndFlush(stagiaire);
        } catch (Exception e) {
            return null;
        }

    }
    public Stagiaire update(Long id, Stagiaire o) {
        try {
            return stagiaireRepository
                    .findById(id)
                    .map(oldEntity -> stagiaireRepository.saveAndFlush(o))
                    .orElseGet(() -> null);

        } catch (Exception e) {
            return null;
        }
    }
    public String delete(Long id) {
        try {
            Optional<Stagiaire> optional = stagiaireRepository.findById(id);
            if (!optional.isPresent()) {
                return "error";
            }
            Stagiaire o = optional.get();
            stagiaireRepository.delete(o);
            return "succes";
        } catch (Exception e) {
            return "error";
        }
    }

    public Stagiaire findById(Long id) {
        try {
            return Optional.ofNullable(id)
                    .flatMap(stagiaireRepository::findById).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
    public List<Stagiaire> finAll(){
        return stagiaireRepository.findAll();
    }
}
