/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Persona;

/**
 *
 * @author Victus
 */
public class PersonaService {
    
     private PersonaRepository personaRepository = new PersonaRepository();

    public Persona getPersonaById(int id) throws SQLException {
        return personaRepository.findById(id);
    }

    public boolean login(int id, String password) {
        return personaRepository.login(id, password);
    }

    public boolean personaBuilder(int id, String nombre, String apellido, int edad, String correo, String rol, String password) throws
            SQLException, InvalidUsuarioDataException {
        if (!PersonaValidator.validatePassword(password) || !PersonaValidator.validateNombre(nombre) || !PersonaValidator.validateEdad(edad) || !PersonaValidator.validaApellido(apellido) || !PersonaValidator.validateEdad(edad) || !PersonaValidator.validateCorreo(correo) || !PersonaValidator.validateRol(rol)) {
            throw new InvalidPersonaDataException("Datos inválidos");
        }
        Persona persona = new Persona(id, nombre, apellido, edad, correo, rol, password);
        personaRepository.save(persona);
        return true;
    }

    public boolean updatePersona(int id, String nombre, String apellido, int edad, String correo, String rol, String password) throws SQLException, InvalidPersonaDataException {
        if (!PersonaValidator.validateId(id)
                || !PersonaValidator.validateNombre(nombre)
                || !PersonaValidator.validateApellido(apellido)
                || !PersonaValidator.validateEdad(edad)
                || !PersonaValidator.validateCorreo(correo)
                || !PersonaValidator.validateRol(rol)
                || !PersonaValidator.validatePassword(password)) {

            throw new InvalidPersonaDataException("Datos inválidos");
        }

        Persona aux = personaRepository.findById(id);
        if (aux == null) {
            throw new InvalidPersonaDataException("Persona no encontrado");
        }

        Persona usuarioActualizado = new Persona(id, nombre, apellido, edad, correo, rol, password);
        personaRepository.updatePersona(personaActualizado);
        return true;
    }

    public boolean deletePersona(int id) throws SQLException, InvalidPersonaDataException {
        Persona personaExistente = personaRepository.findById(id);
        if (personaExistente == null) {
            throw new InvalidPersonaDataException("Persona no encontrado");
        }

        personaRepository.deletePersona(id);
        return true;
    }
    
    public ArrayList<Persona> listarPersonas() throws SQLException {
        return personaRepository.listarPersonas();
    }

    public ArrayList<Persona> listarProductos() throws SQLException {
        return personaRepository.listarProductos();
    }

    public DefaultTableModel llenarTabla() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Id", "Nombre", "Apellido", "Edad", "Correo", "Rol", "Password"});

        try {
            for (int i = 0; i < listarPersonas().size(); i++) {
                Persona aux = listarPersonas().get(i);
                modelo.addRow(new Object[]{
                    aux.getId(),
                    aux.getNombre(),
                    aux.getApellido(),
                    aux.getEdad(),
                    aux.getCorreo(),
                    aux.getRol(),
                    aux.getPassword()
                });
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar Personas: " + ex.getMessage());
            throw ex; 
        }

        return modelo;
    }
    
    
    public DefaultTableModel llenarTablaPersona() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Id", "Nombre", "Apellido", "edad", "Correo", "Rol", "Intereses"});

        try {
            for (int i = 0; i < listarPersonas().size(); i++) {
                Persona aux = listarPersonas().get(i);
                modelo.addRow(new Object[]{
                    aux.getId(),
                    aux.getNombre(),
                    aux.getApellido(),
                    aux.getEdad(),
                    aux.getCorreo(),
                    aux.getRol(),
                    aux.getPassword()
                });
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar Personas: " + ex.getMessage());
            throw ex; 
        }

        return modelo;
    }
}
