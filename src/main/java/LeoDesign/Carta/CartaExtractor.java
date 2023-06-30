package LeoDesign.Carta;

import LeoDesign.storage.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartaExtractor implements ResultSetExtractor {
    @Override
    public Carta extract(ResultSet resultSet) throws SQLException {
        Carta carta = new Carta();
        carta.setIdPagamento(resultSet.getInt("idPagamento"));
        carta.setNumero(resultSet.getString("numero_carta"));
        return carta;
    }
}
