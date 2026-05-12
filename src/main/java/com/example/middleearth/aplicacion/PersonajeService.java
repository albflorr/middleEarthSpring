/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.aplicacion;

import com.example.middleearth.dominio.Personaje;
import com.example.middleearth.dominio.RazaStrategy;
import com.example.middleearth.infraestructura.CharacterFactory;
import java.util.List;

/**
 *
 * @author USER
 */
public class PersonajeService {
    // Puerto de salida: Inyección por constructor para cumplir con DIP [6, 9]
    private final IPersonajeRepository repository;

    public PersonajeService(IPersonajeRepository repository) {
        this.repository = repository;
    }

    public void crearHeroe(String nombre, String tipoRaza) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new RuntimeException("El nombre del héroe es obligatorio.");
        }
        RazaStrategy estrategia = CharacterFactory.getStrategy(tipoRaza);
        Personaje nuevoHeroe = new Personaje(nombre, tipoRaza, estrategia);
        nuevoHeroe.aplicarBonosRaza();
        repository.guardar(nuevoHeroe);
     
        System.out.println("Héroe " + nombre + " forjado y guardado correctamente.");
    }

    public List<Personaje> listarHeroes() {
        return repository.obtenerTodos();
    }
}
