package LeoDesign.Carta;

import LeoDesign.storage.TableQuery;

public class CartaQuery extends TableQuery {
    public CartaQuery(String table) {
        super(table);
    }
    String selectCarta() {
        return String.format("SELECT * FROM %s WHERE idPagamento=?;", table);
    }
    String insertCarta() {
        return String.format("INSERT INTO %s (numero_carta, ordine) VALUES(?, ?);", table);
    }
    String updateCarta() {
        return String.format("UPDATE FROM %s SET numero_carta=? WHERE idPagamento=?;", table);
    }
    String deleteCarta() {
        return String.format("DELETE FROM %s WHERE idPagamento=?;", table);
    }
}
