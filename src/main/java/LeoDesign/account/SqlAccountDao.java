package LeoDesign.account;

import LeoDesign.storage.Manager;
import LeoDesign.storage.Paginator;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlAccountDao extends Manager implements AccountDao{

    private static final AccountQuery QUERY = new AccountQuery("Cliente");
    public SqlAccountDao(DataSource source) {
        super(source);
    }

    @Override
    public List<Account> fetchAccounts(Paginator paginator) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectAccounts())) {
                ps.setInt(1, paginator.getOffset());
                ps.setInt(2, paginator.getLimit());
                ResultSet set = ps.executeQuery();
                List<Account> accounts = new ArrayList<>();
                while (set.next()){
                    AccountExtractor accountExtractor = new AccountExtractor();
                    Account account = accountExtractor.extract(set);
                    accounts.add(account);
                }
                set.close();
                return accounts;
            }
        }
    }

    @Override
    public Optional<Account> fetchAccount(String email) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectAccount())) {
                ps.setString(1, email);
                ResultSet set = ps.executeQuery();
                Account account = null;
                if (set.next()) {
                    AccountExtractor accountExtractor = new AccountExtractor();
                    account = accountExtractor.extract(set);
                }
                return Optional.ofNullable(account);
            }
        }
    }

    @Override
    public boolean createAccount(Account account) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.insertAccount())) {
                ps.setString(1, account.getEmail());
                ps.setString(2, account.getPassword());
                ps.setString(3, account.getNome());
                ps.setString(4, account.getCognome());
                ps.setString(5, "");
                ps.setString(6, "");
                ps.setString(7, "");
                ps.setString(8, "");
                ps.setString(9, "");
                ps.setBoolean(10, account.isAdmin());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean updateAccount(Account account) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.updateAccount())) {
                ps.setString(1, account.getTelefono());
                ps.setString(2, account.getIndirizzo());
                ps.setString(3, account.getProvincia());
                ps.setString(4, account.getCitta());
                ps.setString(5, account.getCAP());
                ps.setString(6, account.getEmail());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean deleteAccount(String email) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.deleteAccount())) {
                ps.setString(1, email);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }
}
