package LeoDesign.model.categoria;

import LeoDesign.model.prodotto.Prodotto;

import java.util.List;

public class Categoria {
    private int id;
    private String titolo;
    private List<Prodotto> prodotti;
    public Categoria() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }
}
