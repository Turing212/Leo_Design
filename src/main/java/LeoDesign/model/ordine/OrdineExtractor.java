package LeoDesign.model.ordine;

import LeoDesign.model.storage.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdineExtractor implements ResultSetExtractor {
    @Override
    public Ordine extract(ResultSet resultSet) throws SQLException {
        Ordine ordine = new Ordine();
        ordine.setIDordine(resultSet.getInt("idOrdine"));
        ordine.setStato(resultSet.getString("stato_ordine"));
        ordine.setInserimento(resultSet.getDate("data_inserimento").toLocalDate());
        ordine.setTotale(resultSet.getDouble("totale"));
        return ordine;
    }
}
