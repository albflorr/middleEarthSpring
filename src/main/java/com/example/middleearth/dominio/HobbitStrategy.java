/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.dominio;

/**
 *
 * @author USER
 */
public class HobbitStrategy implements RazaStrategy{
    @Override
    public void aplicarBonos(Atributos attr) {
        attr.setSigilo(attr.getSigilo() + 15);
        attr.setValor(attr.getValor() + 10);
    }
    @Override
    public String getHabilidadEspecial() { return "Resistencia a la Sombra"; }
}