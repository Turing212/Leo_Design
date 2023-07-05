package LeoDesign.model.prodotto;

import LeoDesign.model.storage.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdottoExtractor implements ResultSetExtractor {
    @Override
    public Prodotto extract(ResultSet resultSet) throws SQLException {
        Prodotto prodotto = new Prodotto();
        prodotto.setIdProdotto(resultSet.getInt("idProdotto"));
        prodotto.setNome(resultSet.getString("nome"));
        prodotto.setDescrizione(resultSet.getString("descrizione"));
        prodotto.setPrezzo(resultSet.getFloat("prezzo"));
        prodotto.setPeso(resultSet.getFloat("peso"));
        prodotto.setImmagine1(resultSet.getString("immagine1"));
        prodotto.setImmagine2(resultSet.getString("immagine2"));
        prodotto.setImmagine3(resultSet.getString("immagine3"));
        return prodotto;
    }
}
