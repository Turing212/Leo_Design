package LeoDesign.model.carrello;

import LeoDesign.model.prodotto.Prodotto;

import java.util.List;

public class Carrello {
    private List<CarrelloItem> items;

    public Carrello(List<CarrelloItem> items) {
        this.items = items;
    }

    public List<CarrelloItem> getItems() {
        return items;
    }

    public void setItems(List<CarrelloItem> items) {
        this.items = items;
    }

    public double totale() {
        double totale = 0.0;
        for (CarrelloItem item: items){
            totale += item.totale();
        }
        return totale;
    }
    public boolean addProdotto(Prodotto prodotto, int quantita) {
        return items.add(new CarrelloItem(prodotto, quantita));
    }
}
