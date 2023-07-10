package LeoDesign.model.account;

import LeoDesign.model.carrello.GuessCart;


public class GuestAccount {

    private GuessCart cart;

    public GuestAccount(){
        cart = new GuessCart();
    }

    public GuessCart getCart(){
        return this.cart;
    }

}
