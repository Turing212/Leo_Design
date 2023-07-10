package LeoDesign.model.carrello;

import java.util.List;

public interface CarrelloDao <E extends Exception> {
    List<CarrelloItem> articoliByUserEmail(String email) throws E;
    int productExists(String email, int idProd) throws E;
}
