package LeoDesign.account;

import LeoDesign.storage.TableQuery;

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
        return String.format("INSERT INTO %s (email, password,nome,cognome,telefono,indirizzo,provincia,citta,CAP,admin) VALUES(?,?,?,?,?,?,?,?,?,?);", table);
    }
    String updateAccount() {
        return String.format("UPDATE FROM %s SET telefono=? ,indirizzo=? ,provincia=? ,citta=? ,CAP=?  WHERE email=?;", table);
    }
    String deleteAccount() {
        return String.format("DELETE FROM %s WHERE email=?;", table);
    }
}
