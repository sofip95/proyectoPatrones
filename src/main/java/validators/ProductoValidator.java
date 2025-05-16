/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

/**
 *
 * @author JUAN
 */
public class ProductoValidator {

    public static boolean validateNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean validateDescripcion(String descripcion) {
        return descripcion != null && !descripcion.trim().isEmpty();
    }

    public static boolean validateFechaCaducidad(String fechaCaducidad) {
        return fechaCaducidad != null && !fechaCaducidad.trim().isEmpty();
    }

    public static boolean validateCantidad(int cantidad) {
        return cantidad >= 0;
    }

    public static boolean validatePrecio(float precio) {
        return precio >= 0;
    }

    public static boolean validateCategoria(String categoria) {
        return categoria != null && (categoria.equalsIgnoreCase("Aseo") || categoria.equalsIgnoreCase("Comida") || categoria.equalsIgnoreCase("Electronica") || categoria.equalsIgnoreCase("Basico"));
    }

}
