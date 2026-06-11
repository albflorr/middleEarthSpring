/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.dominio;

/**
 *
 * @author HP
 */
public class EntStrategy implements RazaStrategy {

    @Override
    public void aplicarBonos(Atributos attr) {
        attr.setFuerza(attr.getFuerza()+30);
        attr.setAgilidad(attr.getAgilidad()-15);
    }

    @Override
    public String getHabilidadEspecial() {
        return "Fuerza vital aumentada";
    }
    
}
