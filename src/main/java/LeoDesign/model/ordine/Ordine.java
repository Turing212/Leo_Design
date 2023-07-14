package LeoDesign.model.ordine;

import LeoDesign.model.account.Account;
import LeoDesign.model.carrello.Carrello;
import LeoDesign.model.carrello.CarrelloItem;
import LeoDesign.model.carrello.GuessCart;

import java.time.LocalDate;
import java.util.List;


public class Ordine {
    private int IDordine;
    private LocalDate inserimento;
    private String stato;
    private double totale;
    private Account account;
    private Carrello carrello;
    private GuessCart guessCart;


    public Ordine() {
        super();
    }

    public int getIDordine() {
        return IDordine;
    }

    public void setIDordine(int IDordine) {
        this.IDordine = IDordine;
    }

    public String getInserimento() {
        return this.inserimento.toString();
    }

    public void setInserimento(LocalDate inserimento) {
        this.inserimento = inserimento;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public GuessCart getGuessCart() {
        return guessCart;
    }

    public void setGuessCart(GuessCart guessCart) {
        this.guessCart = guessCart;
    }
    public List<CarrelloItem> getItems() {
        return this.carrello.getItems();
    }
    public List<CarrelloItem> getGuessItems(){
        return this.guessCart.getItems();
    }

    public int entrate(){
        return carrello.getItems().size();
    }
}
