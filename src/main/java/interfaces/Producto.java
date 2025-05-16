/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author sofia
 */
public interface Producto {
    public String toString();

    public int getId() ;

    public void setId(int id) ;

    public String getNombre();

    public void setNombre(String nombre) ;

    public String getDescripcion() ;

    public void setDescripcion(String descripcion) ;

    public String getFechaCaducidad() ;

    public void setFechaCaducidad(String fechaCaducidad) ;

    public int getCantidad() ;

    public void setCantidad(int cantidad) ;

    public float getPrecio() ;

    public void setPrecio(float precio);

    public String getCategoria() ;

    public void setCategoria(String categoria) ;
}
