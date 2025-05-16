package strategies;

import interfaces.Producto;
import java.sql.SQLException;
import repositories.ProductoRepository;

public class SearchByName implements SearchStrategy {
    private ProductoRepository productoRepository;

    public SearchByName() {
        this.productoRepository = new ProductoRepository();
    }

    @Override
    public Producto search(String criteria) throws SQLException {
        return productoRepository.findByName(criteria);
    }
}
