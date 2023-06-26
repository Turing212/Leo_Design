package LeoDesign.carrello;

import java.util.List;

public class Carrello {
    private List<CarrelloItem> items;

    public Carrello(List<CarrelloItem> items) {
        this.items = items;
    }

    public double totale() {
        double totale = 0.0;
        for (CarrelloItem item: items){
            totale += item.totale();
        }
        return totale;
    }
}
