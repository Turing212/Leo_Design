package LeoDesign.model.magazzino;

import LeoDesign.model.components.Paginator;

import java.sql.SQLException;
import java.util.List;

public interface MagazzinoDao {

    List<Magazzino> fetchMagazzini(Paginator paginator) throws SQLException;
    Magazzino fetchMagazzino(int id) throws SQLException;
    boolean createMagazzino(Magazzino magazzino)throws SQLException;
    boolean updateMagazzino(Magazzino magazzino)throws SQLException;
    boolean deleteMagazzino(int id) throws SQLException;
}
