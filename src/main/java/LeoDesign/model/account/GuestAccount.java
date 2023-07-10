package LeoDesign.model.account;

import LeoDesign.model.carrello.GuessCart;
import Model.Carrello.Carrello;
import Model.Carrello.GuessCart;

import java.util.List;

public class GuestAccount {

    private GuessCart cart;

    public GuestAccount(){
        cart = new GuessCart();
    }

    public GuessCart getCart(){
        return this.cart;
    }

}
