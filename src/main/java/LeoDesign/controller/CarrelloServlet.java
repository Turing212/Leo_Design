package LeoDesign.controller;

import LeoDesign.controller.http.Controller;
import LeoDesign.model.account.AccountSession;
import LeoDesign.model.account.GuestAccount;
import LeoDesign.model.carrello.Carrello;
import LeoDesign.model.carrello.GuessCart;
import LeoDesign.model.carrello.SqlCarrelloDao;
import LeoDesign.model.prodotto.SqlProdottoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

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
                        request.setAttribute("carrello", carrello);
                        request.getRequestDispatcher(view("account/carrello")).forward(request,response);
                    }else if(session != null && session.getAttribute("accountGuest") != null){
                        GuestAccount accountGuest = getGuestAccount(session);
                        GuessCart carrello = accountGuest.getCart();
                        carrello.updateProductsQuantity();
                        request.setAttribute("carrello", carrello);
                        request.getRequestDispatcher(view("account/carrello")).forward(request,response);
                    }else{
                        response.sendRedirect("../account/signin");
                    }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
