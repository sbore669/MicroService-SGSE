package com.examtechnolab.encadreurService.services;

import com.examtechnolab.encadreurService.model.Encadreur;
import com.examtechnolab.encadreurService.repositories.EncadreurRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EncadreurService {

    @Autowired
    private EncadreurRepository encadreurRepository;

    private final EntityManager em;

    public EncadreurService(EntityManager em) {
        this.em = em;
    }

    public Encadreur create(Encadreur encadreur) {
        try {
            return encadreurRepository.saveAndFlush(encadreur);
        } catch (Exception e) {
            return null;
        }

    }
    public Encadreur update(Long id, Encadreur encadreur) {
        try {
            return encadreurRepository
                    .findById(id)
                    .map(oldEntity -> encadreurRepository.saveAndFlush(encadreur))
                    .orElseGet(() -> null);

        } catch (Exception e) {
            return null;
        }
    }
    public String delete(Long id) {
        try {
            Optional<Encadreur> optional = encadreurRepository.findById(id);
            if (!optional.isPresent()) {
                return "error";
            }
            Encadreur o = optional.get();
            encadreurRepository.delete(o);
            return "succes";
        } catch (Exception e) {
            return "error";
        }
    }

    public Encadreur findById(Long id) {
        try {
            return Optional.ofNullable(id)
                    .flatMap(encadreurRepository::findById).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
    public List<Encadreur> finAll(){
        return encadreurRepository.findAll();
    }

    public List<Encadreur> search(String nom) {
        List<Encadreur> l = new ArrayList<Encadreur>();
        String hql = "";
        try {
            hql += "FROM Encadreur as o where o.id >0";
            if (nom != null && !nom.equals("") ) {
                hql += " and o.nom like '%" + nom + "%' ";
            }
            l = (List<Encadreur>) em.createQuery(hql).getResultList();
            return l;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

}
