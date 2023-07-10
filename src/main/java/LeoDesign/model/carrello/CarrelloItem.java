package LeoDesign.model.carrello;

import LeoDesign.model.prodotto.Prodotto;

public class CarrelloItem {
    private final Prodotto prodotto;
    private int quantita;

    public CarrelloItem(Prodotto prodotto, int quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double totale() {
        return prodotto.getPrezzo()*quantita;
    }
}
