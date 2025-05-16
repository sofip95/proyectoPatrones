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
public class AseoDecorator extends ProductoDecorator {

    public AseoDecorator(Producto producto) {
        super(producto);
        this.setCategoria("Aseo");
        this.setPrecio(11);
    }

    @Override
    public String getCategoria() {
        return "Aseo";
    }

    @Override
    public float getPrecio() {
        return 11;
    }

}
