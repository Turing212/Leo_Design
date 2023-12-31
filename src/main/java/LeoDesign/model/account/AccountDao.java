package LeoDesign.model.account;

import LeoDesign.model.components.Paginator;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AccountDao {

    List<Account> fetchAccounts(Paginator paginator) throws SQLException;
    Optional<Account> fetchAccount(String email) throws SQLException;
    Optional<Account> findAccountByEmailPwd(String email, String password, boolean admin) throws SQLException;
    boolean createAccount(Account account)throws SQLException;
    boolean updateAccount(Account account)throws SQLException;
    boolean deleteAccount(String email) throws SQLException;
}
