package LeoDesign.model.carrello;

import LeoDesign.model.storage.TableQuery;

public class CarrelloQuery extends TableQuery {
    public CarrelloQuery(String table) {
        super(table);
    }
    String articoli() { return String.format("SELECT * FROM carrello INNER JOIN prodotto ON prodotto.idProdotto = carrello.prodotto WHERE carrello.email=?; ", this.table); }
    String findProduct() { return String.format("SELECT * FROM %s WHERE email=? AND prodotto=?;", this.table); }
}
