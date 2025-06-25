package com.examtechnolab.stagiaireService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StagiaireServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StagiaireServiceApplication.class, args);
	}

}
