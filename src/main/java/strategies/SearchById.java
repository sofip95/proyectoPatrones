package strategies;

import interfaces.Producto;
import java.sql.SQLException;
import repositories.ProductoRepository;

public class SearchById implements SearchStrategy {
    private ProductoRepository productoRepository;

    public SearchById() {
        this.productoRepository = new ProductoRepository();
    }

    @Override
    public Producto search(String criteria) throws SQLException {
        int id;
        try {
            id = Integer.parseInt(criteria);
        } catch (NumberFormatException e) {
            return null;
        }
        return productoRepository.findById(id);
    }
}
