/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.dominio;

/**
 *
 * @author USER
 */
public class EnanoStrategy implements RazaStrategy {
    @Override
    public void aplicarBonos(Atributos attr) {
        attr.setValor(attr.getValor() + 15);
        attr.setFuerza(attr.getFuerza() + 25);
    }
    @Override
    public String getHabilidadEspecial() { return "Detección de metales"; }
}
