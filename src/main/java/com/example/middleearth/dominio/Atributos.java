/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.dominio;

/**
 *
 * @author USER
 */
public class Atributos {
    private int fuerza;
    private int agilidad;
    private int sigilo;
    private int valor;
    
    
    @Override
    public String toString(){
        return "Sus atributos son: Fuerza -> "+ getFuerza()+
                " Agilidad -> " + getAgilidad() +
                " Sigilo -> " + getSigilo() +
                " Valor -> " + getValor();
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getSigilo() {
        return sigilo;
    }

    public void setSigilo(int sigilo) {
        this.sigilo = sigilo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
