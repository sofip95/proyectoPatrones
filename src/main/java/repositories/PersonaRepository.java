/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import com.mycompany.inventario.DataConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Persona;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author sofia
 */
public class PersonaRepository {
    
    public Persona findById(int id) throws SQLException {
        String query = "SELECT * FROM persona WHERE id = " + id;
        
        try (Connection connection = DataConfig.getInstance().getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                 return new Persona(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getInt("edad"),
                        resultSet.getString("correo"),
                        resultSet.getString("rol"),
                        resultSet.getString("password")
                );
            } else {
                return null;
            }
        }
    }

    public void save(Persona persona) throws SQLException {
        String hashedPassword = hashPassword(persona.getPassword());
        String query = "INSERT INTO persona(id,nombre,apellido,edad,correo,rol,password) VALUES ('" + persona.getId() + "', '" + persona.getNombre() + "', '" + persona.getApellido()+ "', '" + persona.getEdad()+ "', '" + persona.getCorreo() + "', '" + persona.getRol()+ "', '" + hashedPassword + "')";
        try (Connection connection = DataConfig.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private static boolean checkPassword(String password, String storedHash) {
        return BCrypt.checkpw(password, storedHash);
    }

    public void updateUser (Persona persona) throws SQLException {
    String hashedPassword = hashPassword(persona.getPassword());
    String query = "UPDATE persona SET password = ?, nombre = ?, apellido = ?, edad = ?, correo = ?, rol = ? WHERE id = ?";
    
    try (Connection connection = DataConfig.getInstance().getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        preparedStatement.setString(1, hashedPassword);
        preparedStatement.setString(2, persona.getNombre());
        preparedStatement.setString(3, persona.getApellido());
        preparedStatement.setInt(4, persona.getEdad());
        preparedStatement.setString(5, persona.getCorreo());
        preparedStatement.setString(6, persona.getRol());
        preparedStatement.setInt(7, persona.getId()); // Aquí se usa el ID del usuario
        
        preparedStatement.executeUpdate();
    }
}

    public void deleteUser(int id) throws SQLException {
        String query = "DELETE FROM persona WHERE id = " + id + "";
        try (Connection connection = DataConfig.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }
    public boolean login(int id, String contrasenia) {
        String query = "SELECT password FROM persona WHERE id = ?";

        try (Connection conn = DataConfig.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedPasswordHash = rs.getString("password");

                return checkPassword(contrasenia, storedPasswordHash);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Persona> listarEmpleados() throws SQLException {
        ArrayList<Persona> empleados = new ArrayList<>();
        String query = "SELECT id,nombre,apellido,edad,correo,rol,password FROM persona WHERE rol = 'Empleado';";
        try (PreparedStatement stmt =DataConfig.getInstance().getConnection().prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Persona persona = new Persona(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getString("correo"),
                        rs.getString("rol"),
                        rs.getString("password")
                );
                empleados.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }


}
