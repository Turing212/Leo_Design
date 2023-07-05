package LeoDesign.model.prodotto;

import LeoDesign.model.storage.TableQuery;

public class ProdottoQuery extends TableQuery {
    public ProdottoQuery(String table) {
        super(table);
    }
    String selectProdotti() {
        return String.format("SELECT * FROM %s LIMIT ?, ?;", this.table);
    }

    String selectProdotto() {
        return String.format("SELECT * FROM %s WHERE idProdotto=?;", table);
    }
    String insertProdotto() {
        return String.format("INSERT INTO %s (nome, descrizione, prezzo, peso, immagine1, immagine2, immagine3, magazzino, categoria) VALUES(?,?,?,?,?,?,?,?,?);", table);
    }
    String updateProdotto() {
        return String.format("UPDATE FROM %s SET nome=?, descrizione=?, prezzo=?, peso=?, immagine1=?, immagine2=?, immagine3=? magazzino=?, categoria=?  WHERE idProdotto=?;", table);
    }
    String deleteProdotto() {
        return String.format("DELETE FROM %s WHERE idProdotto=?;", table);
    }
}