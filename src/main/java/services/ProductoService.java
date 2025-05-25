/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import decorators.AseoDecorator;
import decorators.ComidaDecorator;
import decorators.ElectronicaDecorator;
import exception.InvalidProductoDataException;
import interfaces.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import repositories.ProductoRepository;
import strategies.SearchById;
import strategies.SearchByName;
import strategies.SearchStrategy;
import validators.ProductoValidator;

/**
 *
 * @author Victus
 */
public class ProductoService {

    private ProductoRepository productoRepository = new ProductoRepository();

    private SearchStrategy searchStrategy;

    public Producto getProductoById(int id) throws SQLException {
        searchStrategy = new SearchById();
        Producto producto = searchStrategy.search(String.valueOf(id));
        if (producto != null) {
            producto = applyDecorator(producto);
        }
        return producto;
    }

    public Producto getProductoByName(String nombre) throws SQLException {
        searchStrategy = new SearchByName();
        Producto producto = searchStrategy.search(nombre);
        if (producto != null) {
            producto = applyDecorator(producto);
        }
        return producto;
    }

    public ArrayList<Producto> getAllProductos() throws SQLException {
        ArrayList<Producto> productos = productoRepository.findAll();
        ArrayList<Producto> decoratedProductos = new ArrayList<>();
        for (Producto producto : productos) {
            decoratedProductos.add(applyDecorator(producto));
        }
        return decoratedProductos;
    }

    public void createProducto(int id, String nombre, String descripcion, String fechaCaducidad, int cantidad, float precio, String categoria) throws SQLException, InvalidProductoDataException {
        if (!ProductoValidator.validateNombre(nombre) || !ProductoValidator.validateDescripcion(descripcion) || !ProductoValidator.validateFechaCaducidad(fechaCaducidad) || !ProductoValidator.validateCantidad(cantidad) || !ProductoValidator.validatePrecio(precio) || !ProductoValidator.validateCategoria(categoria)) {
            throw new InvalidProductoDataException("Datos inválidos");
        }
        Producto producto = new builder.ProductoBuilder()
                .setId(id)
                .setNombre(nombre)
                .setDescripcion(descripcion)
                .setFechaCaducidad(fechaCaducidad)
                .setCantidad(cantidad)
                .setPrecio(precio)
                .setCategoria(categoria)
                .getProducto();
        producto = applyDecorator(producto);
        productoRepository.save(producto);
    }

    public boolean updateProducto(int id, String nombre, String descripcion, String fechaCaducidad, int cantidad, float precio, String categoria) throws SQLException, InvalidProductoDataException {
        if (!ProductoValidator.validateNombre(nombre) || !ProductoValidator.validateDescripcion(descripcion) || !ProductoValidator.validateFechaCaducidad(fechaCaducidad) || !ProductoValidator.validateCantidad(cantidad) || !ProductoValidator.validatePrecio(precio) || !ProductoValidator.validateCategoria(categoria)) {
            throw new InvalidProductoDataException("Datos inválidos");
        }

        Producto existingProducto = productoRepository.findById(id);
        if (existingProducto == null) {
            throw new InvalidProductoDataException("Producto no encontrado");
        }

        Producto updatedProducto = new builder.ProductoBuilder()
                .setId(id)
                .setNombre(nombre)
                .setDescripcion(descripcion)
                .setFechaCaducidad(fechaCaducidad)
                .setCantidad(cantidad)
                .setPrecio(precio)
                .setCategoria(categoria)
                .getProducto();
        updatedProducto = applyDecorator(updatedProducto);
        productoRepository.update(updatedProducto);
        return true;
    }

    public boolean deleteProducto(int id) throws SQLException, InvalidProductoDataException {
        Producto existingProducto = productoRepository.findById(id);
        if (existingProducto == null) {
            throw new InvalidProductoDataException("Producto no encontrado");
        }

        productoRepository.delete(id);
        return true;
    }

    private Producto applyDecorator(Producto producto) {
        String categoria = producto.getCategoria().toLowerCase();
        switch (categoria) {
            case "aseo":
                return new AseoDecorator(producto);
            case "comida":
                return new ComidaDecorator(producto);
            case "electronica":
                return new ElectronicaDecorator(producto);
            default:
                return producto;
        }
    }
    
      public DefaultTableModel llenarTabla() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Id", "Nombre", "Cantidad", "Categoría", "Descripción", "Fecha Caducidad", "Precio"});

        try {
            for (int i = 0; i < getAllProductos().size(); i++) {
                Producto aux = getAllProductos().get(i);
                modelo.addRow(new Object[]{
                    aux.getId(),
                    aux.getNombre(),
                    aux.getCantidad(),
                    aux.getCategoria(),
                    aux.getDescripcion(),
                    aux.getFechaCaducidad(),
                    aux.getPrecio()
                });
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar productos: " + ex.getMessage());
            throw ex;
        }

        return modelo;
    }
}

