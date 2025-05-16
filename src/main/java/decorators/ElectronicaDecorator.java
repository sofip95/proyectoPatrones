/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorators;

import interfaces.Producto;

/**
 *
 * @author Victus
 */
public class ElectronicaDecorator extends ProductoDecorator {

    public ElectronicaDecorator(Producto producto) {
        super(producto);
        this.setCategoria("Electrodomestico");
        this.setPrecio(12);
    }

    @Override
    public String getCategoria() {
        return "Electrodomestico";
    }

    @Override
    public float getPrecio() {
        return 12;
    }
    
}
