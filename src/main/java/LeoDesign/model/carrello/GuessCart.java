package LeoDesign.model.carrello;



import LeoDesign.model.prodotto.Prodotto;
import LeoDesign.model.prodotto.SqlProdottoDao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuessCart {
    private List<CarrelloItem> items;

    public GuessCart(){
        this.items = new ArrayList<>();
    }

    public void addItem(Prodotto prodotto, int quantity){
        for(CarrelloItem i: this.items){
            if(i.getProdotto().getIdProdotto() == prodotto.getIdProdotto()){
                i.setQuantita(i.getQuantita()+quantity);
                return;
            }
        }
        this.items.add(new CarrelloItem(prodotto, quantity));
    }
    public void updateProductsQuantity() throws SQLException {
        SqlProdottoDao service = new SqlProdottoDao();
        for(CarrelloItem i: this.items){
            i.setQuantita(service.getProductQuantity(i.getProdotto().getIdProdotto()));
        }
    }
    public boolean itemIsPresent(int idProd){
        for(CarrelloItem i: this.items){
            if(i.getProdotto().getIdProdotto() == idProd){
                return true;
            }
        }
        return false;
    }


    public void removeItem(int idProd, int quantity){
        CarrelloItem toRemove = null;
       for(CarrelloItem i: this.items){
           if(i.getProdotto().getIdProdotto() == idProd){
               if((i.getQuantita()-quantity) <= 0){
                   toRemove = i;
                   break;
               }else{
                   i.setQuantita(i.getQuantita()-quantity);
                   break;
               }
           }
       }
       if(toRemove!=null){
           this.items.remove(toRemove);
       }
    }

    public List<CarrelloItem> getItems(){
        return this.items;
    }

    public int getNumArticoli(){
        int num = 0;
        for(CarrelloItem i: this.items){
            num += i.getQuantita();
        }
        return num;
    }

    public int getQuantityOfProf(int idProd){
        for(CarrelloItem i: this.items){
            if(i.getProdotto().getIdProdotto() == idProd){
                return i.getQuantita();
            }
        }
        return 0;
    }

    public double getTotalOfProd(int idProd){
        for(CarrelloItem i: this.items){
            if(i.getProdotto().getIdProdotto() == idProd){
                return i.totale();
            }
        }
        return 0;
    }

    private static double roundDouble(double d, int places) {

        BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public double total(){
        double total = 0;
        for(CarrelloItem i: this.items){
            total += i.totale();
        }
        return roundDouble(total, 2);
    }

    public void clearCart(){
        this.items = new ArrayList<>();
    }

}
