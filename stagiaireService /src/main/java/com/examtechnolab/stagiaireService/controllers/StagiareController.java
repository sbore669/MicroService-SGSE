package com.examtechnolab.stagiaireService.controllers;


import com.examtechnolab.stagiaireService.model.Stagiaire;
import com.examtechnolab.stagiaireService.services.StagiaireService;
import jakarta.servlet.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stagiaire/api/stagiares")
public class StagiareController {
    @Autowired
    private StagiaireService stagiaireService;

    @PostMapping
    public Stagiaire create(@RequestBody Stagiaire stagiaire){
        System.out.println("create Registration");

        return stagiaireService.create(stagiaire);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id,@RequestBody Stagiaire stagiaire){
        stagiaireService.update(id,stagiaire);
    }
    @DeleteMapping("/{id}")
    public String  delete(@PathVariable long id){
        return stagiaireService.delete(id);
    }
    @GetMapping("/{id}")
    public Stagiaire get(@PathVariable long id){
        return stagiaireService.findById(id);
     }
    @GetMapping
    public List<Stagiaire> find(){
        return  stagiaireService.finAll();
    }


}
