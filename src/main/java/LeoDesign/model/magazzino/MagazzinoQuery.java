package LeoDesign.model.magazzino;

import LeoDesign.model.storage.TableQuery;

public class MagazzinoQuery extends TableQuery {
    public MagazzinoQuery(String table) {
        super(table);
    }
    String selectMagazzini() {
        return String.format("SELECT * FROM %s LIMIT ?, ?;", this.table);
    }

    String selectMagazzino() {
        return String.format("SELECT * FROM %s WHERE idMagazzino=?;", table);
    }
    String insertMagazzino() {
        return String.format("INSERT INTO %s (nome_magazzino) VALUES(?);", table);
    }
    String updateMagazzino() {
        return String.format("UPDATE FROM %s SET nome_magazzino=? WHERE idMagazzino=?;", table);
    }
    String deleteMagazzino() {
        return String.format("DELETE FROM %s WHERE idMagazzino=?;", table);
    }
}
