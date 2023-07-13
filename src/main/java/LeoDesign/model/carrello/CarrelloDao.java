package LeoDesign.model.carrello;

import java.util.List;

public interface CarrelloDao <E extends Exception> {
    int numeroArticoli(String email) throws E;
    boolean addProduct(int idProd, String email, int quantity) throws E;
    boolean removeProduct(int idProd, String email) throws E;
    List<CarrelloItem> articoliByUserEmail(String email) throws E;
    boolean updateNumeroArticoli(String email) throws E;
    int productExists(String email, int idProd) throws E;
    boolean updateQuantity(int idProd, String email, int quantity) throws E;
}
