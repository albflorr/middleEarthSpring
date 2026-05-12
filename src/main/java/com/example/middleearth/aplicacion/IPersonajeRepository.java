/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.middleearth.aplicacion;

import com.example.middleearth.dominio.Personaje;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IPersonajeRepository {
    void guardar(Personaje p);
    List<Personaje> obtenerTodos();
}
