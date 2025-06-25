package com.examtechnolab.stagiaireService.clients;


import com.examtechnolab.stagiaireService.dto.EncadreurDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ENCADREURSERVICE")
public interface EncadreurClient {

    @GetMapping("/encadreur/api/encadreurs/{id}")
    EncadreurDTO findEncadreurById(@PathVariable long id);
}
