package LeoDesign.ordine;

import LeoDesign.account.Account;
import LeoDesign.carrello.Carrello;

import java.time.LocalDate;


public class Ordine {
    private int IDordine;
    private LocalDate inserimento;
    private String stato;
    private double totale;
    private Account account;
    private Carrello carrello;


    public Ordine() {
        super();
    }

    public int getIDordine() {
        return IDordine;
    }

    public void setIDordine(int IDordine) {
        this.IDordine = IDordine;
    }

    public LocalDate getInserimento() {
        return inserimento;
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
}
