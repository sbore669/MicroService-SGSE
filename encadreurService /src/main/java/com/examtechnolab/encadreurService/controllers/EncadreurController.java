package com.examtechnolab.encadreurService.controllers;
import com.examtechnolab.encadreurService.model.Encadreur;
import com.examtechnolab.encadreurService.services.EncadreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("encadreur/api/encadreurs")
public class EncadreurController {
    @Autowired
    private EncadreurService encadreurService;

    @PostMapping
    public Encadreur create(@RequestBody Encadreur encadreur){
        System.out.println("create Registration");

        return encadreurService.create(encadreur);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id,@RequestBody Encadreur encadreur){
        encadreurService.update(id,encadreur);
    }
    @DeleteMapping("/{id}")
    public String  delete(@PathVariable long id){
        return encadreurService.delete(id);
    }
    @GetMapping("/{id}")
    public Encadreur get(@PathVariable long id){
        return encadreurService.findById(id);
     }
    @GetMapping
    public List<Encadreur> find(){
        return  encadreurService.finAll();
    }


}
