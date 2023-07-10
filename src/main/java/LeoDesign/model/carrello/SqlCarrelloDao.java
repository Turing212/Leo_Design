package LeoDesign.model.carrello;

import LeoDesign.model.categoria.CategoriaQuery;
import LeoDesign.model.prodotto.Prodotto;
import LeoDesign.model.prodotto.SqlProdottoDao;
import LeoDesign.model.storage.ConnManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlCarrelloDao implements CarrelloDao{
    private static final CarrelloQuery QUERY = new CarrelloQuery("carrello");

    @Override
    public List<CarrelloItem> articoliByUserEmail(String email) throws Exception {
        try(Connection con = ConnManager.getConnection()){
            try(PreparedStatement ps = con.prepareStatement(QUERY.articoli())) {
                ps.setString(1,email);
                ResultSet set = ps.executeQuery();
                List<CarrelloItem> lista = new ArrayList<>();
                SqlProdottoDao service = new SqlProdottoDao();
                while(set.next()){
                    Optional<Prodotto> prodotto = service.fetchProdotto(set.getInt("IDProdotto"));
                    int quantita = set.getInt("quantita");
                    if(prodotto.isPresent()){
                        CarrelloItem item = new CarrelloItem(prodotto.get(),quantita);
                        lista.add(item);
                    }else{
                        return null;
                    }
                }
                return lista;
            }
        }
    }

    @Override
    public int productExists(String email, int idProd) throws Exception {
        try(Connection con = ConnManager.getConnection()){
            try(PreparedStatement ps = con.prepareStatement(QUERY.findProduct())) {
                ps.setString(1, email);
                ps.setInt(2, idProd);
                ResultSet rs = ps.executeQuery();
                int quantity = 0;
                if(rs.next()){
                    quantity = rs.getInt("quantita");
                }
                return quantity;
            }
        }
    }
}
