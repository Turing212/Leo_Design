package LeoDesign.controller;

import LeoDesign.controller.http.Controller;
import LeoDesign.model.account.AccountSession;
import LeoDesign.model.account.GuestAccount;
import LeoDesign.model.carrello.Carrello;
import LeoDesign.model.carrello.GuessCart;
import LeoDesign.model.carrello.SqlCarrelloDao;
import LeoDesign.model.prodotto.Prodotto;
import LeoDesign.model.prodotto.SqlProdottoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "CarrelloServlet", value = "/carrello/*")
public class CarrelloServlet extends Controller {
    SqlCarrelloDao serviceCart;
    SqlProdottoDao serviceProduct;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceCart = new SqlCarrelloDao();
        serviceProduct = new SqlProdottoDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/":
                    HttpSession session = request.getSession(false);
                    if (session != null && session.getAttribute("accountSession") != null) {
                        AccountSession accountSession = getAccountSession(session);
                        Carrello carrello = new Carrello(serviceCart.articoliByUserEmail(accountSession.getEmail()));
                        carrello.setEmail(accountSession.getEmail());
                        request.setAttribute(CARRELLO, carrello);
                        request.getRequestDispatcher(view("account/carrello")).forward(request,response);
                    }else if(session != null && session.getAttribute("accountGuest") != null){
                        GuestAccount accountGuest = getGuestAccount(session);
                        GuessCart carrello = accountGuest.getCart();
                        carrello.updateProductsQuantity();
                        request.setAttribute(CARRELLO, carrello);

                        request.getRequestDispatcher(view("account/carrello")).forward(request,response);
                    }else{
                        request.getRequestDispatcher(view("account/carrello")).forward(request,response);
                    }
                break;
                default:
                    notFound();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String path = getPath(request);
        switch (path) {
            case "/add": {
                HttpSession session = request.getSession(false);
                if (session != null && session.getAttribute("accountSession") != null) {
                    int quantity = Integer.parseInt(request.getParameter("quantita"));
                    int productId = Integer.parseInt(request.getParameter("idProdotto"));
                    if (quantity > 0 && productId > 0) {
                        AccountSession accountSession = getAccountSession(session);
                        int precQuantity = 0;

                        precQuantity = serviceCart.productExists(accountSession.getEmail(), productId);

                        if (precQuantity > 0) {
                            serviceCart.updateQuantity(productId, accountSession.getEmail(), (precQuantity + quantity));
                        } else {
                            serviceCart.addProduct(productId, accountSession.getEmail(), quantity);
                        }
                        serviceCart.updateNumeroArticoli(accountSession.getEmail());
                        if (request.getParameterMap().containsKey("urlSource")) {
                            String back = request.getParameter("urlSource");
                            response.sendRedirect(back);
                        } else {
                            response.sendRedirect("../index.html");
                        }
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovato");
                    }
                } else if (session != null) {
                    int quantity = Integer.parseInt(request.getParameter("quantita"));
                    int productId = Integer.parseInt(request.getParameter("idProdotto"));
                    if (quantity > 0 && productId > 0) {
                        GuestAccount accountGuest = null;
                        if (session.getAttribute("accountGuest") != null) {
                            accountGuest = getGuestAccount(session);
                        } else {
                            accountGuest = new GuestAccount();
                        }
                        Optional<Prodotto> prodotto = serviceProduct.fetchProdotto(productId);
                        if (prodotto.isPresent()) {
                            accountGuest.getCart().addItem(prodotto.get(), quantity);
                            session.setAttribute("accountGuest", accountGuest);
                            if (request.getParameterMap().containsKey("urlSource")) {
                                String back = request.getParameter("urlSource");
                                response.sendRedirect(back);
                            } else {
                                response.sendRedirect("../index.html");
                            }
                        } else {
                            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovato");
                        }
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovato");
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Operazione non consentita");
                }
                break;
        }
            case "/remove": {
                HttpSession session = request.getSession(false);
                if (session != null && session.getAttribute("accountSession") != null) {
                    int quantity = Integer.parseInt(request.getParameter("quantita"));
                    int productId = Integer.parseInt(request.getParameter("idProdotto"));
                    if(quantity > 0 && productId > 0){
                        AccountSession accountSession = getAccountSession(session);
                        int precQuantity = serviceCart.productExists(accountSession.getEmail(),productId);
                        if(precQuantity > 0){
                            if((precQuantity-quantity) <= 0){
                                serviceCart.removeProduct(productId, accountSession.getEmail());
                            }else {
                                serviceCart.updateQuantity(productId, accountSession.getEmail(), (precQuantity-quantity));
                            }
                        }
                        serviceCart.updateNumeroArticoli(accountSession.getEmail());
                        if(request.getParameterMap().containsKey("isCart")){
                            response.sendRedirect("../carrello");
                        }else{
                            response.sendRedirect("../index.html");
                        }
                    }else {
                        notFound();
                    }
                }else if(session != null && session.getAttribute("accountGuest") != null){
                    int quantity = Integer.parseInt(request.getParameter("quantita"));
                    int productId = Integer.parseInt(request.getParameter("idProdotto"));
                    if(quantity > 0 && productId > 0){
                        GuestAccount accountGuest = getGuestAccount(session);
                        accountGuest.getCart().removeItem(productId, quantity);
                        session.setAttribute("accountGuest",accountGuest);
                        if(request.getParameterMap().containsKey("isCart")){
                            response.sendRedirect("../carrello");
                        }else{
                            response.sendRedirect("../index.html");
                        }
                    }else {
                        notFound();
                    }
                }else {
                    notAllowed();
                }








                break;
            }
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovato");
        }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
