package LeoDesign.ordine;

import LeoDesign.storage.TableQuery;

public class OrdineQuery extends TableQuery {
    public OrdineQuery(String table) {
        super(table);
    }
    String selectOrdini() { return String.format("SELECT * FROM %s;", this.table); }
    String selectOrdine() { return String.format("SELECT * FROM %s WHERE idOrdine=?;", this.table); }
    String insertOrdine() { return String.format("INSERT INTO %s (idOrdine, data, stato, totale) VALUES(?,?,?,?);", this.table); }
    String updateOrdine() { return String.format("UPDATE FROM %s SET stato=? WHERE idOrdine=?;", this.table); }
    String selectOrdiniWithProdotti(){ return "SELECT * FROM Prodotto_Ordine AS PO " +
            "INNER JOIN ordine ON PO.ordine_fk = ordine.idOrdine " +
            "INNER JOIN prodotto ON PO.prodotto_fk = prodotto.idProdotto " +
            "LEFT JOIN magazzino ON prodotto.magazzino_fk = magazzino.idMagazzino" +
            "LEFT JOIN categoria ON prodotto.categoria_fk = categoria.idCategoria" +
            "WHERE ordine.account_fk = ?"; }
}
