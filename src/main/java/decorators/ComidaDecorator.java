/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorators;

import interfaces.Producto;

/**
 *
 * @author JUAN
 */
public class ComidaDecorator extends ProductoDecorator {

    public ComidaDecorator(Producto producto) {
        super(producto);
        this.setCategoria("Comida");
        this.setPrecio(9);
    }

    @Override
    public String getCategoria() {
        return "Comida";
    }

    @Override
    public float getPrecio() {
        return 9;
    }

}
