package LeoDesign.model.magazzino;

import LeoDesign.model.storage.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazzinoExtractor implements ResultSetExtractor {
    @Override
    public Magazzino extract(ResultSet resultSet) throws SQLException {
        Magazzino magazzino = new Magazzino();
        magazzino.setIDmagazzino(resultSet.getInt("idMagazzino"));
        magazzino.setNomeMagazzino(resultSet.getString("nome_magazzino"));
        return magazzino;
    }
}
