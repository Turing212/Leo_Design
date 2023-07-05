package LeoDesign.model.carrello;

import LeoDesign.model.prodotto.Prodotto;

public class CarrelloItem {
    private final Prodotto prodotto;
    private final int quantita;

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

    public double totale() {
        return prodotto.getPrezzo()*quantita;
    }
}
