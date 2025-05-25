/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConfig {

    // Datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/patrones";
    private static final String USER = "root";
    private static final String PASSWORD = "55429387";

    // Instancia única (parte del patrón Singleton)
    private static DataConfig instance;
    private Connection connection;

    // Constructor privado para prevenir instanciación directa
    private DataConfig() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error al crear la conexión: " + e.getMessage());
            throw e;
        }
    }

    // Método para obtener la instancia (Singleton)
    public static DataConfig getInstance() throws SQLException {

        if (instance == null) {
            instance = new DataConfig();
        }

        return instance;
    }

    // Método para obtener la conexión única
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
