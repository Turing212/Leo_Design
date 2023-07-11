package LeoDesign.model.carrello;

import LeoDesign.model.categoria.CategoriaQuery;
import LeoDesign.model.prodotto.Prodotto;
import LeoDesign.model.prodotto.SqlProdottoDao;
import LeoDesign.model.storage.ConnManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlCarrelloDao implements CarrelloDao{
    private static final CarrelloQuery QUERY = new CarrelloQuery("carrello");
    @Override
    public int numeroArticoli(String email) throws SQLException {
        try(Connection con = ConnManager.getConnection()){
            try(PreparedStatement ps = con.prepareStatement(QUERY.numeroArticoli())) {
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                int nArticoli = 0;
                if(rs.next()){
                    nArticoli = rs.getInt("quantita");
                }
                return nArticoli;
            }
        }
    }
    @Override
    public boolean addProduct(int idProd, String email, int quantity) throws SQLException{
        try(Connection con = ConnManager.getConnection()){

            try(PreparedStatement ps = con.prepareStatement(QUERY.addProduct())) {
                ps.setString(1, email);
                ps.setInt(2,idProd);
                ps.setInt(3,quantity);
                if(ps.executeUpdate() != 1){
                    return false;
                }
                return true;
            }
        }
    }
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
    public boolean updateNumeroArticoli(String email) throws SQLException{
        try(Connection con = ConnManager.getConnection()){
            try(PreparedStatement ps = con.prepareStatement(QUERY.updateNumeroArticoli())) {
                ps.setInt(1, sumOfQuantity(email));
                ps.setString(2,email);
                if(ps.executeUpdate() != 1){
                    return false;
                }
                return true;
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
    @Override
    public boolean updateQuantity(int idProd, String email, int quantity) throws SQLException {
        try(Connection con = ConnManager.getConnection()){
            try(PreparedStatement ps = con.prepareStatement(QUERY.updateQuantity())) {
                ps.setInt(1, quantity);
                ps.setString(2, email);
                ps.setInt(3, idProd);
                if(ps.executeUpdate() != 1){
                    return false;
                }
                return true;
            }
        }
    }
    public int sumOfQuantity(String email) throws SQLException{
        try(Connection con = ConnManager.getConnection()){
            try(PreparedStatement ps = con.prepareStatement(QUERY.sumOfProduct())) {
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                int quantity = 0;
                if(rs.next()){
                    quantity = rs.getInt(1);
                }
                return quantity;
            }
        }
    }

}
