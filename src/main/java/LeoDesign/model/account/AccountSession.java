package LeoDesign.model.account;

import LeoDesign.model.carrello.SqlCarrelloDao;
import java.sql.SQLException;

public class AccountSession {

    private final String email, nome, cognome;

    private final boolean isAdmin;

    public AccountSession(Account account){
        this.nome = account.getNome();
        this.cognome = account.getCognome();
        this.email = account.getEmail();
        this.isAdmin = account.isAdmin();
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean haveItemInCart(int idProd) throws Exception {
        return new SqlCarrelloDao().productExists(this.email,idProd) > 0;
    }

}
