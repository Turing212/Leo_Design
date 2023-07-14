package LeoDesign.model.ordine;


import LeoDesign.controller.http.InvalidRequestException;
import LeoDesign.model.carrello.CarrelloItem;
import LeoDesign.model.prodotto.SqlProdottoDao;
import LeoDesign.model.storage.ConnManager;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class createOrderDao {
    private static final OrdineQuery QUERY = new OrdineQuery("Ordine");

    public boolean createPurchase(Ordine ordineCustomer) throws SQLException, InvalidRequestException {
        List<CarrelloItem> notAvailable = isAllAvailable(ordineCustomer); //ritorna una lista vuota se sono tutti disponibili
        if(notAvailable.size() > 0){
            List<String> nomi = new ArrayList<>();
            for(CarrelloItem i: notAvailable){
                nomi.add(i.getProdotto().getNome());
            }
            throw new InvalidRequestException("I seguenti prodotti non possono essere acquistati, controlla la disponibilità.",
                    nomi, HttpServletResponse.SC_FORBIDDEN);
        }
        try (Connection con = ConnManager.getConnection()) {
            if(ordineCustomer.getCarrello() != null){
                try(PreparedStatement ps = con.prepareStatement(QUERY.createOrdine())){
                    ps.setString(1 ,ordineCustomer.getInserimento());
                    ps.setString(2 ,ordineCustomer.getStato());
                    ps.setDouble(3, ordineCustomer.getTotale());
                    ps.setString(4, ordineCustomer.getCarrello().getEmail());

                    int row = ps.executeUpdate();
                    return true;
                }
            }else if(ordineCustomer.getGuessCart() != null){
                try(PreparedStatement ps = con.prepareStatement(QUERY.insertGuestOrder())){
                    ps.setString(1,ordineCustomer.getInserimento());
                    ps.setString(2,ordineCustomer.getStato());
                    ps.setDouble(3, ordineCustomer.getTotale());

                    int row = ps.executeUpdate();
                    return true;
                }
            }else {
                return false;
            }
        }
    }

    private boolean insertContent(Ordine ordine) throws SQLException{
        try (Connection con = ConnManager.getConnection()) {
            List<CarrelloItem> lista = null;
            if(ordine.getCarrello() != null){
                lista = ordine.getItems();
            }else {
                lista = ordine.getGuessItems();
            }
            for(CarrelloItem i: lista){
                try(PreparedStatement ps = con.prepareStatement(QUERY.insertCarrello())){
                    ps.setInt(1,ordine.getIDordine());
                    ps.setInt(2, i.getProdotto().getIdProdotto());
                    ps.setInt(3, i.getQuantita());
                    if (ps.executeUpdate() != 1) {
                        throw new RuntimeException();
                    }
                    SqlProdottoDao service = new SqlProdottoDao();
                    int idProd = i.getProdotto().getIdProdotto();
                    service.updateProductQuantity(idProd, ( service.getProductAvailability(idProd)-i.getQuantita() ) );
                }
            }
            return true;
        }
    }

    public List<CarrelloItem> isAllAvailable(Ordine ordine) throws SQLException{
        List<CarrelloItem> lista = null;
        if(ordine.getCarrello() != null){
            lista = ordine.getItems();
        }else {
            lista = ordine.getGuessItems();
        }
        SqlProdottoDao service = new SqlProdottoDao();
        List<CarrelloItem> notAvailable = new ArrayList<>();
        for(CarrelloItem i: lista){
            if((service.getProductAvailability(i.getProdotto().getIdProdotto()) - i.getQuantita()) < 0){
                notAvailable.add(i);
            }
        }
        return notAvailable;
    }

}
