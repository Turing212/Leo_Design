package LeoDesign.account;

import LeoDesign.storage.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountExtractor implements ResultSetExtractor {
    @Override
    public Account extract(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        account.setEmail(resultSet.getString("email"));
        account.setPassword(resultSet.getString("pass"));
        account.setNome(resultSet.getString("nome"));
        account.setCognome(resultSet.getString("cognome"));
        account.setTelefono(resultSet.getString("telefono"));
        account.setIndirizzo(resultSet.getString("indirizzo"));
        account.setProvincia(resultSet.getString("provincia"));
        account.setCitta(resultSet.getString("citta"));
        account.setCAP(resultSet.getString("CAP"));
        account.setAdmin(resultSet.getBoolean("account_admin"));
        return account;
    }
}
