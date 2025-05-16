/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

/**
 *
 * @author JUAN
 */
public class PersonaValidator {

    public static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean validateEdad(int edad) {
        return edad >= 18;
    }

    public static boolean validateEmail(String email) {
        return email != null && email.contains("@");
    }

    public static boolean validateRol(String rol) {
        return rol != null && (rol.equalsIgnoreCase("Empleado") || rol.equalsIgnoreCase("Admin"));
    }

}
