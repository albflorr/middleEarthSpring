/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.dominio;

/**
 *
 * @author USER
 */
public class ElfoStrategy implements RazaStrategy {
    @Override
    public void aplicarBonos(Atributos attr) {
        attr.setSigilo(attr.getSigilo() + 25);
        attr.setAgilidad(attr.getAgilidad()+15);
    }
    @Override
    public String getHabilidadEspecial() { return "Agilidad aumentada"; }
}
