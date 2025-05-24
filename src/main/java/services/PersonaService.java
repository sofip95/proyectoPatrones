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
import interfaces.Observer;
import interfaces.Subject;

/**
 *
 * @author Victus
 */
public class PersonaService implements Subject {

    private PersonaRepository personaRepository = new PersonaRepository();
    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public Persona getPersonaById(int id) throws SQLException {
        return personaRepository.findById(id);
    }

    public void createPersona(int id, String nombre, String apellido, int edad, String correo, String rol, String password) throws SQLException, InvalidPersonaDataException {
        if (!PersonaValidator.validateName(nombre) || !PersonaValidator.validateName(apellido) || !PersonaValidator.validateEdad(edad) || !PersonaValidator.validateEmail(correo) || !PersonaValidator.validateRol(rol)) {
            throw new InvalidPersonaDataException("Datos inválidos");
        }
        Persona persona = new Persona(id, nombre, apellido, edad, correo, rol, password);
        personaRepository.save(persona);
        notifyObservers();
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
        notifyObservers();
        return true;
    }

    public boolean deletePersona(int id) throws SQLException, InvalidPersonaDataException {
        Persona existingPersona = personaRepository.findById(id);
        if (existingPersona == null) {
            throw new InvalidPersonaDataException("Persona no encontrada");
        }

        personaRepository.deleteUser(id);
        notifyObservers();
        return true;
    }

    public ArrayList<Persona> listarEmpleados() throws SQLException {
        return personaRepository.listarEmpleados();
    }
}

