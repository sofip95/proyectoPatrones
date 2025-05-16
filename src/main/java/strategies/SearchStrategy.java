package strategies;

import interfaces.Producto;
import java.sql.SQLException;

public interface SearchStrategy {
    Producto search(String criteria) throws SQLException;
}
