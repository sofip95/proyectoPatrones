package repositories;

import com.mycompany.inventario.DataConfig;
import interfaces.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import builder.ProductoBuilder;

/**
 *
 * @author sofia
 */
public class ProductoRepository {
    
    public Producto findById(int id) throws SQLException {
        String query = "SELECT * FROM producto WHERE id = " + id;
        
        try (Connection connection = DataConfig.getInstance().getConnection(); 
             Statement statement = connection.createStatement(); 
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                ProductoBuilder builder = new ProductoBuilder();
                builder.setId(resultSet.getInt("id"))
                       .setNombre(resultSet.getString("nombre"))
                       .setDescripcion(resultSet.getString("descripcion"))
                       .setFechaCaducidad(resultSet.getString("fechaCaducidad"))
                       .setCantidad(resultSet.getInt("cantidad"))
                       .setPrecio(resultSet.getFloat("precio"))
                       .setCategoria(resultSet.getString("categoria"));
                return builder.getProducto();
            } else {
                return null;
            }
        }
    }

    public void save(Producto producto) throws SQLException {
        String query = "INSERT INTO producto(id, nombre, descripcion, fechaCaducidad, cantidad, precio, categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DataConfig.getInstance().getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, producto.getId());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setString(3, producto.getDescripcion());
            preparedStatement.setString(4, producto.getFechaCaducidad());
            preparedStatement.setInt(5, producto.getCantidad());
            preparedStatement.setFloat(6, producto.getPrecio());
            preparedStatement.setString(7, producto.getCategoria());
            preparedStatement.executeUpdate();
        }
    }

    public void update(Producto producto) throws SQLException {
        String query = "UPDATE producto SET nombre = ?, descripcion = ?, fechaCaducidad = ?, cantidad = ?, precio = ?, categoria = ? WHERE id = ?";
        try (Connection connection = DataConfig.getInstance().getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setString(2, producto.getDescripcion());
            preparedStatement.setString(3, producto.getFechaCaducidad());
            preparedStatement.setInt(4, producto.getCantidad());
            preparedStatement.setFloat(5, producto.getPrecio());
            preparedStatement.setString(6, producto.getCategoria());
            preparedStatement.setInt(7, producto.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM producto WHERE id = " + id;
        try (Connection connection = DataConfig.getInstance().getConnection(); 
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }
    
    public ArrayList<Producto> findAll() throws SQLException {
        ArrayList<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM producto";
        try (Connection connection = DataConfig.getInstance().getConnection(); 
             Statement statement = connection.createStatement(); 
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                ProductoBuilder builder = new ProductoBuilder();
                builder.setId(resultSet.getInt("id"))
                       .setNombre(resultSet.getString("nombre"))
                       .setDescripcion(resultSet.getString("descripcion"))
                       .setFechaCaducidad(resultSet.getString("fechaCaducidad"))
                       .setCantidad(resultSet.getInt("cantidad"))
                       .setPrecio(resultSet.getFloat("precio"))
                       .setCategoria(resultSet.getString("categoria"));
                productos.add(builder.getProducto());
            }
        }
        return productos;
    }

    public Producto findByName(String nombre) throws SQLException {
        Producto producto = null;
        String query = "SELECT * FROM producto WHERE nombre = ?";
        try (Connection connection = DataConfig.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nombre);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ProductoBuilder builder = new ProductoBuilder();
                    builder.setId(resultSet.getInt("id"))
                           .setNombre(resultSet.getString("nombre"))
                           .setDescripcion(resultSet.getString("descripcion"))
                           .setFechaCaducidad(resultSet.getString("fechaCaducidad"))
                           .setCantidad(resultSet.getInt("cantidad"))
                           .setPrecio(resultSet.getFloat("precio"))
                           .setCategoria(resultSet.getString("categoria"));
                    producto = builder.getProducto();
                }
            }
        }
        return producto;
    }
}
