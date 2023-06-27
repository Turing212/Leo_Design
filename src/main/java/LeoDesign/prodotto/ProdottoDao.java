package LeoDesign.prodotto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProdottoDao {
    List<Prodotto> fetchProdotti(int start, int end) throws SQLException;
    Optional<Prodotto> fetchProdotto(int id) throws SQLException;
    boolean createProdotto(Prodotto prodotto)throws SQLException;
    boolean updateProdotto(Prodotto prodotto)throws SQLException;
    boolean deleteProdotto(int id) throws SQLException;
}
