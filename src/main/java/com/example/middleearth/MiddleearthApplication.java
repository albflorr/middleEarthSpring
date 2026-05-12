package com.example.middleearth;

import com.example.middleearth.aplicacion.IPersonajeRepository;
import com.example.middleearth.aplicacion.PersonajeService;
import com.example.middleearth.dominio.Personaje;
import com.example.middleearth.infraestructura.MysqlPersonajeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MiddleearthApplication {
    
    public static void main(String[] args) {
            SpringApplication.run(MiddleearthApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", 
        defaultValue = "World") String name) {
      return String.format("Hello %s!",name);
    }
    
    @GetMapping("/personajes")
    public List<Personaje> getAllPersonajes(){
        IPersonajeRepository repositorio 
                = new MysqlPersonajeRepository();
        PersonajeService servicio 
                = new PersonajeService(repositorio);
        return servicio.listarHeroes();                
    }
    
}
