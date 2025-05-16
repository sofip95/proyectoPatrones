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
    
public abstract class ProductoDecorator implements Producto {
    protected Producto producto;

    public ProductoDecorator(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return producto.toString();
    }

    @Override
    public int getId() {
        return producto.getId();
    }

    @Override
    public void setId(int id) {
        producto.setId(id);
    }

    @Override
    public String getNombre() {
        return producto.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        producto.setNombre(nombre);
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion();
    }

    @Override
    public void setDescripcion(String descripcion) {
        producto.setDescripcion(descripcion);
    }

    @Override
    public String getFechaCaducidad() {
        return producto.getFechaCaducidad();
    }

    @Override
    public void setFechaCaducidad(String fechaCaducidad) {
        producto.setFechaCaducidad(fechaCaducidad);
    }

    @Override
    public int getCantidad() {
        return producto.getCantidad();
    }

    @Override
    public void setCantidad(int cantidad) {
        producto.setCantidad(cantidad);
    }

    @Override
    public float getPrecio() {
        return producto.getPrecio();
    }

    @Override
    public void setPrecio(float precio) {
        producto.setPrecio(precio);
    }

    @Override
    public String getCategoria() {
        return producto.getCategoria();
    }

    @Override
    public void setCategoria(String categoria) {
        producto.setCategoria(categoria);
    }
}
    
