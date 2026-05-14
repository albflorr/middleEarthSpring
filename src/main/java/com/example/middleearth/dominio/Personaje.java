/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.dominio;

/**
 *
 * @author USER
 */
public class Personaje {
    private String nombre;
    private String tipoRaza;
    private Atributos atributos;
    private final RazaStrategy estrategia;
    
    @Override
    public String toString(){
        return getNombre() + " es un " + getTipoRaza() + atributos.toString();
    }
    
    public Personaje(String nombre, String tipoRaza, RazaStrategy estrategia) {
        this.nombre = nombre;
        this.tipoRaza = tipoRaza;
        this.estrategia = estrategia;
        this.atributos = new Atributos();
    }
    
    public void aplicarBonosRaza(){
        if (estrategia != null) {
            estrategia.aplicarBonos(atributos);
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoRaza() {
        return tipoRaza;
    }

    public void setTipoRaza(String tipoRaza) {
        this.tipoRaza = tipoRaza;
    }

    public Atributos getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributos atributos) {
        this.atributos = atributos;
    }

    public RazaStrategy getEstrategia() {
        return estrategia;
    }

    public String getHabilidadEspecial() {
        return estrategia != null ? estrategia.getHabilidadEspecial() : "Ninguna";
    }
    
}
