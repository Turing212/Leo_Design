package LeoDesign.account;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AccountDao {

    List<Account> fetchAccounts(int start, int end) throws SQLException;
    Optional<Account> fetchAccount(String email) throws SQLException;
    boolean createAccount(Account account)throws SQLException;
    boolean updateAccount(Account account)throws SQLException;
    boolean deleteAccount(String email) throws SQLException;
}
