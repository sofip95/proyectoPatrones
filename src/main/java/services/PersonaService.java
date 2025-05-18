/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import exception.InvalidPersonaDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Persona;
import repositories.PersonaRepository;
import validators.PersonaValidator;

/**
 *
 * @author Victus
 */
public class PersonaService {

    private PersonaRepository personaRepository = new PersonaRepository();

    public Persona getPersonaById(int id) throws SQLException {
        return personaRepository.findById(id);
    }

    public void createPersona(int id, String nombre, String apellido, int edad, String correo, String rol, String password) throws SQLException, InvalidPersonaDataException {
        if (!PersonaValidator.validateName(nombre) || !PersonaValidator.validateName(apellido) || !PersonaValidator.validateEdad(edad) || !PersonaValidator.validateEmail(correo) || !PersonaValidator.validateRol(rol)) {
            throw new InvalidPersonaDataException("Datos inválidos");
        }
        Persona persona = new Persona(id, nombre, apellido, edad, correo, rol, password);
        personaRepository.save(persona);
    }

    public boolean updatePersona(int id, String nombre, String apellido, int edad, String correo, String rol, String password) throws SQLException, InvalidPersonaDataException {
        if (!PersonaValidator.validateName(nombre) || !PersonaValidator.validateName(apellido) || !PersonaValidator.validateEdad(edad) || !PersonaValidator.validateEmail(correo) || !PersonaValidator.validateRol(rol)) {
            throw new InvalidPersonaDataException("Datos inválidos");
        }

        Persona existingPersona = personaRepository.findById(id);
        if (existingPersona == null) {
            throw new InvalidPersonaDataException("Persona no encontrada");
        }

        Persona updatedPersona = new Persona(id, nombre, apellido, edad, correo, rol, password);
        personaRepository.updateUser(updatedPersona);
        return true;
    }

    public boolean deletePersona(int id) throws SQLException, InvalidPersonaDataException {
        Persona existingPersona = personaRepository.findById(id);
        if (existingPersona == null) {
            throw new InvalidPersonaDataException("Persona no encontrada");
        }

        personaRepository.deleteUser(id);
        return true;
    }

    public ArrayList<Persona> listarEmpleados() throws SQLException {
        return personaRepository.listarEmpleados();
    }
}

