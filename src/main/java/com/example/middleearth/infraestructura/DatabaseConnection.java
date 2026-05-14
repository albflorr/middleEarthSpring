/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.infraestructura;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */

public class DatabaseConnection {
    private static Connection connection;
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties props = new Properties();
            try (InputStream input 
                    = DatabaseConnection.class.getClassLoader()
                    .getResourceAsStream("application.properties")) {
                if (input == null) {
                    throw new RuntimeException("No se encontró application.properties");
                }
                props.load(input);
            } catch (IOException ex) {
                Logger.getLogger(DatabaseConnection.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
            String dbUrl = props.getProperty("spring.datasource.url");
            String dbUser = props.getProperty("spring.datasource.username");
            String dbPass = props.getProperty("spring.datasource.password");
            
            if (dbUrl == null || dbUser == null || dbPass == null) {
                throw new RuntimeException(
                        "Faltan propiedades DB en application.properties");
            }
           
            connection = DriverManager
                    .getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException e) {
            throw new RuntimeException(
                    "Error al inicializar conexión DB", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            throw new RuntimeException(
                    "Conexión cerrada, reinicia la app");
        }
        return connection;
    }
}
