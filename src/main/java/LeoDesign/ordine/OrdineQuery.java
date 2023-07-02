package LeoDesign.ordine;

import LeoDesign.storage.TableQuery;

public class OrdineQuery extends TableQuery {
    public OrdineQuery(String table) {
        super(table);
    }
    String selectOrdini() { return String.format("SELECT * FROM %s LIMIT ?, ?;", this.table); }
    String selectOrdine() { return String.format("SELECT * FROM %s WHERE idOrdine=?;", this.table); }
    String createOrdine() { return String.format("INSERT INTO %s (idOrdine, data_inserimento, stato_ordine, totale, cliente) VALUES(?,?,?,?,?);", this.table); }
    String insertCarrello() { return String.format("INSERT INTO Composizione (prodotto, ordine, quantita) VALUES(?,?,?);", this.table); }
    String updateOrdine() { return String.format("UPDATE FROM %s SET stato_ordine=? WHERE idOrdine=?;", this.table); }
    String selectOrdiniWithProdotti(){ return "SELECT * FROM Composizione AS PO " +
            "INNER JOIN ordine ON PO.ordine = ordine.idOrdine " +
            "INNER JOIN prodotto ON PO.prodotto = prodotto.idProdotto " +
            "LEFT JOIN magazzino ON prodotto.magazzino = magazzino.idMagazzino" +
            "LEFT JOIN categoria ON prodotto.categoria = categoria.idCategoria" +
            "WHERE ordine.cliente = ?" +
            "LIMIT ?, ?;"; }
}
