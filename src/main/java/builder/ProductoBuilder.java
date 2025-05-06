package builder;

import model.Producto;

public class ProductoBuilder {
	
	private int id;
    private String nombre;
    private String descripcion;
    private String fechaCaducidad;
    private int cantidad;
    private float precio;
    
    public void reset() {
    	this.id = 0;
    	this.nombre = "";
    	this.descripcion = "";
    	this.fechaCaducidad = "";
    	this.cantidad = 0;
    	this.precio = 0;
	}

	public ProductoBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public ProductoBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ProductoBuilder setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public ProductoBuilder setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
		return this;
	}

	public ProductoBuilder setCantidad(int cantidad) {
		this.cantidad = cantidad;
		return this;
	}

	public ProductoBuilder setPrecio(float precio) {
		this.precio = precio;
		return this;
	}
    
    public Producto getProducto() {
    	Producto producto = new Producto(id, nombre, descripcion, fechaCaducidad, cantidad, precio);
    	reset();
    	return producto;
    }
}
