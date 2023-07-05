package LeoDesign.model.Carta;

import java.sql.SQLException;
import java.util.Optional;

public interface CartaDao {
    Optional<Carta> fetchCarta(int id) throws SQLException;
    boolean createCarta(Carta carta) throws SQLException;
    boolean updateCarta(Carta carta) throws SQLException;
    boolean deleteCarta(int id) throws SQLException;
}
