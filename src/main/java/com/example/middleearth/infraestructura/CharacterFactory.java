/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.infraestructura;

import com.example.middleearth.dominio.ElfoStrategy;
import com.example.middleearth.dominio.EnanoStrategy;
import com.example.middleearth.dominio.HobbitStrategy;
import com.example.middleearth.dominio.HumanoStrategy;
import com.example.middleearth.dominio.RazaStrategy;

/**
 * Implementación del patrón Simple Factory.
 * Centraliza la creación de las estrategias de raza para cumplir con el 
 * Principio de Abierto/Cerrado (OCP).
 */
public class CharacterFactory {

    public static RazaStrategy getStrategy(String tipoRaza) {
        if (tipoRaza == null) {
            throw new IllegalArgumentException("El tipo de raza no puede ser nulo.");
        }

        switch(tipoRaza.toUpperCase()) {
            case "HOBBIT" -> {
                return new HobbitStrategy();
            }
            case "ELFO" -> {
                return new ElfoStrategy();
            }
            case "ENANO" -> {
                return new EnanoStrategy();
            }
            case "HUMANO" -> {
                return new HumanoStrategy();
            }
            default -> throw new IllegalArgumentException("Raza de la Tierra Media no reconocida: " + tipoRaza);
        }
    }
}