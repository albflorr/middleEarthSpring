/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.infraestructura;

import com.example.middleearth.aplicacion.IPersonajeRepository;
import com.example.middleearth.dominio.Personaje;
import com.example.middleearth.dominio.RazaStrategy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class MysqlPersonajeRepository implements IPersonajeRepository {

    @Override
    public void guardar(Personaje p) {
String sql = "INSERT INTO personajes (nombre, raza, habilidad_especial,fuerza,agilidad,sigilo,valor) "
        + "VALUES (?, ?,?,?,?,?,?)";
System.out.println(p.getTipoRaza() + sql);
        try {
            java.sql.Connection conn = DatabaseConnection.getInstance();
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, p.getNombre());
                ps.setString(2, p.getTipoRaza());
                ps.setString(3, p.getEstrategia().getHabilidadEspecial());
                ps.setInt(4, p.getAtributos().getFuerza());
                ps.setInt(5, p.getAtributos().getAgilidad());
                ps.setInt(6, p.getAtributos().getSigilo());
                ps.setInt(7, p.getAtributos().getValor());
                ps.executeUpdate();
                System.out.println("Personaje guardado en base de datos correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al persistir personaje: " + e.getMessage());
            throw new RuntimeException("Error al guardar personaje en BD", e);
        }
    }

    @Override
    public List<Personaje> obtenerTodos() {
        List<Personaje> lista = new ArrayList<>();
        String sql = "SELECT * FROM personajes";

        try {
            java.sql.Connection conn = DatabaseConnection.getInstance();
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery(sql)) {

                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String raza = rs.getString("raza");

                    if (raza == null || raza.isBlank()) continue;

                    int fuerza = rs.getInt("fuerza");
                    int agilidad = rs.getInt("agilidad");
                    int sigilo = rs.getInt("sigilo");
                    int valor = rs.getInt("valor");

                    RazaStrategy estrategia = CharacterFactory.getStrategy(raza);
                    Personaje p = new Personaje(nombre, raza, estrategia);
                    p.getAtributos().setFuerza(fuerza);
                    p.getAtributos().setAgilidad(agilidad);
                    p.getAtributos().setSigilo(sigilo);
                    p.getAtributos().setValor(valor);

                    lista.add(p);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar personajes: " + e.getMessage());
            throw new RuntimeException("Error al listar personajes de BD", e);
        }
        return lista;
    }
    
}
