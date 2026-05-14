/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.dominio;

/**
 *
 * @author USER
 */
public class HumanoStrategy implements RazaStrategy {
    @Override
    public void aplicarBonos(Atributos attr) {
        attr.setValor(attr.getValor() + 15);
    }
    @Override
    public String getHabilidadEspecial() { return "Incremento de Supervivencia"; }
}
