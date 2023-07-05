package LeoDesign.model.categoria;

import LeoDesign.model.storage.TableQuery;

public class CategoriaQuery extends TableQuery {
    public CategoriaQuery(String table) {
        super(table);
    }

    String selectCategorie() { return String.format("SELECT * FROM %s;", this.table); }
    String selectCategoria() { return String.format("SELECT * FROM %s WHERE idCategoria=?;", this.table); }
    String insertCategoria() { return String.format("INSERT INTO %s (titolo) VALUES(?);", this.table); }
    String updateCategoria() { return String.format("UPDATE FROM %s SET titolo=? WHERE idCategoria=?;", this.table); }
    String selectCategoriaWithProdotti(){ return "SELECT * FROM categoria INNER JOIN prodotto ON categoria.idCategoria = prodotto.categoria_fk WHERE categoria.idCategoria=?"; }

}
