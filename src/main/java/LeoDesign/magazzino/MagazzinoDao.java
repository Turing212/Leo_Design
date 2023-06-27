package LeoDesign.magazzino;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface MagazzinoDao {

    List<Magazzino> fetchMagazzini(int start, int end) throws SQLException;
    Optional<Magazzino> fetchMagazzino(int id) throws SQLException;
    boolean createMagazzino(Magazzino magazzino)throws SQLException;
    boolean updateMagazzino(Magazzino magazzino)throws SQLException;
    boolean deleteMagazzino(int id) throws SQLException;
}
