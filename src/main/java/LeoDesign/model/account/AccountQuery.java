package LeoDesign.model.account;

import LeoDesign.model.storage.TableQuery;

class AccountQuery extends TableQuery {
    AccountQuery(String table) {
        super(table);
    }

    String selectAccounts() {
        return String.format("SELECT * FROM %s LIMIT ?, ?;", this.table);
    }

    String selectAccount() {
        return String.format("SELECT * FROM %s WHERE email=?;", table);
    }
    String insertAccount() {
        return String.format("INSERT INTO %s (email, pass,nome,cognome,telefono,indirizzo,provincia,citta,CAP,account_admin) VALUES(?,?,?,?,?,?,?,?,?,?);", table);
    }
    String updateAccount() {
        return String.format("UPDATE FROM %s SET telefono=? ,indirizzo=? ,provincia=? ,citta=? ,CAP=?  WHERE email=?;", table);
    }
    String deleteAccount() {
        return String.format("DELETE FROM %s WHERE email=?;", table);
    }
}
