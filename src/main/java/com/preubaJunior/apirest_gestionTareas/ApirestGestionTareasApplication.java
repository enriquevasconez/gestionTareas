package com.preubaJunior.apirest_gestionTareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApirestGestionTareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestGestionTareasApplication.class, args);
	}
    @GetMapping
    public String hellow(){
        return "Gestión de  tareas";
    }

}

