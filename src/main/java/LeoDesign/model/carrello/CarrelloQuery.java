package LeoDesign.model.carrello;

import LeoDesign.model.storage.TableQuery;

public class CarrelloQuery extends TableQuery {
    public CarrelloQuery(String table) {
        super(table);
    }
    String numeroArticoli() { return String.format("SELECT quantita FROM %s WHERE carrello.email=?; ", this.table); }

    String articoli() { return String.format("SELECT * FROM %s INNER JOIN prodotto ON prodotto.idProdotto = carrello.prodotto WHERE carrello.email=?; ", this.table); }
    String findProduct() { return String.format("SELECT * FROM %s WHERE email=? AND prodotto=?;", this.table); }
    String addProduct() { return String.format("INSERT INTO %s (email, prodotto, quantita) VALUES(?,?,?);", this.table); }
    String removeProduct() { return String.format("DELETE FROM %s WHERE email=? AND prodotto=?;", this.table); }
    String updateNumeroArticoli() { return String.format("UPDATE %s SET quantita=? WHERE email=?;", this.table); }
    String updateQuantity() { return String.format("UPDATE %s SET quantita=? WHERE email=? AND prodotto=?;", this.table); }
    String sumOfProduct() { return String.format("SELECT SUM(quantita) FROM %s WHERE email=?", this.table); }
    String clearDBCart() { return String.format("DELETE FROM %s WHERE email=?;", this.table); }
}
