package LeoDesign.controller;

import LeoDesign.controller.http.Controller;
import LeoDesign.controller.http.InvalidRequestException;
import LeoDesign.model.account.Account;
import LeoDesign.model.account.AccountSession;
import LeoDesign.model.account.GuestAccount;
import LeoDesign.model.account.SqlAccountDao;
import LeoDesign.model.carrello.Carrello;
import LeoDesign.model.carrello.SqlCarrelloDao;
import LeoDesign.model.ordine.Ordine;
import LeoDesign.model.ordine.SqlOrdineDao;
import LeoDesign.model.ordine.createOrderDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet(name = "OrdineServlet", value = "/ordine/*")
public class OrdineServlet extends Controller {
    private SqlOrdineDao serviceOrder;
    private SqlAccountDao serviceAccount;
    private SqlCarrelloDao serviceCart;
    private createOrderDao serviceCreate;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceOrder = new SqlOrdineDao();
        serviceAccount = new SqlAccountDao();
        serviceCart = new SqlCarrelloDao();
        serviceCreate = new createOrderDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String path = getPath(request);
            switch(path){
                case "/create": //create order(client)
                    HttpSession session = request.getSession(false);
                    if(session != null && session.getAttribute("accountSession") != null){
                        AccountSession accountSession = getAccountSession(session);
                        Optional<Account> account = serviceAccount.fetchAccount(accountSession.getEmail());
                        if(account.isPresent()){
                            Carrello cart = new Carrello(serviceCart.articoliByUserEmail(accountSession.getEmail()));
                            cart.setUser(account.get());
                            cart.setEmail(accountSession.getEmail());
                            Ordine ordineCustomer = new Ordine();
                            ordineCustomer.setCarrello(cart);
                            ordineCustomer.setTotale(cart.totale());
                            ordineCustomer.setStato("IN ELABORAZIONE");
                            ordineCustomer.setInserimento(LocalDate.now());
                            synchronized (serviceCreate){
                                if(serviceCreate.createPurchase(ordineCustomer)){
                                    serviceCart.clearDBCart(accountSession.getEmail());
                                    session.setAttribute("numItems",0);
                                    request.getRequestDispatcher(view("customer/guestOrder")).forward(request,response);
                                }else{
                                    internalError();
                                }
                            }
                        }else {
                            notFound();
                        }
                    }else if(session != null && session.getAttribute("accountGuest") != null){
                        GuestAccount accountGuest = getGuestAccount(session);
                        Ordine ordineGuest = new Ordine();
                        ordineGuest.setGuessCart(accountGuest.getCart());
                        ordineGuest.setTotale(accountGuest.getCart().total());
                        ordineGuest.setStato("IN ELABORAZIONE");
                        ordineGuest.setInserimento(LocalDate.now());
                        synchronized (serviceCreate){
                            if(serviceCreate.createPurchase(ordineGuest)){
                                accountGuest.getCart().clearCart();
                                session.setAttribute("accountGuest",accountGuest);
                                request.getRequestDispatcher(view("customer/guestOrder")).forward(request,response);
                            }else {
                                internalError();
                            }
                        }
                    }else {
                        notAllowed();
                    }
                    break;
            }
        }catch (SQLException ex){
            log(ex.getMessage());
        }catch (InvalidRequestException e){
            log(e.getMessage());
            e.handle(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
