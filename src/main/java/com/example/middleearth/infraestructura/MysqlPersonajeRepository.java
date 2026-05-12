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
                + "VALUES (?, ?, ?,?,?,?,?)";
        
        try (java.sql.Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTipoRaza());
            ps.setString(3, p.getEstrategia().getHabilidadEspecial());
            ps.setString(4, String.valueOf(p.getAtributos().getFuerza()));
            ps.setString(5, String.valueOf(p.getAtributos().getAgilidad()));
            ps.setString(6, String.valueOf(p.getAtributos().getSigilo()));
            ps.setString(7, String.valueOf(p.getAtributos().getValor()));

            
            ps.executeUpdate();
            System.out.println("Personaje guardado en base de datos correctamente.");
            
        } catch (SQLException e) {
            System.err.println("Error al persistir personaje: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Personaje> obtenerTodos() {
        List<Personaje> lista = new ArrayList<>();
        String sql = "SELECT * FROM personajes";

        try (java.sql.Connection conn = DatabaseConnection.getInstance();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String raza = rs.getString("raza");
                
                // Reconstrucción del objeto de dominio usando la Factoría [4]
                RazaStrategy estrategia = CharacterFactory.getStrategy(raza);
                Personaje p = new Personaje(nombre, raza, estrategia);
                p.aplicarBonosRaza(); // Restauramos su estado lógico
                
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar personajes: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
    
}
