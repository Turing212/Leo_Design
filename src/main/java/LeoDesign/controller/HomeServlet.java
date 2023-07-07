package LeoDesign.controller;


import LeoDesign.controller.http.Controller;
import LeoDesign.controller.http.Etichette;
import LeoDesign.model.prodotto.Prodotto;
import LeoDesign.model.prodotto.SqlProdottoDao;
import LeoDesign.model.storage.Paginator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "HomeServlet", value = "/index.html", loadOnStartup = 0)
public class HomeServlet extends Controller{

    //SqlCarrelloDAO serviceCart;
    SqlProdottoDao serviceProduct;
    @Override
    public void init() throws ServletException {
        super.init();
        //serviceCart = new SqlCarrelloDAO();
        serviceProduct = new SqlProdottoDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Paginator paginator = new Paginator(1,8);
        paginator.setOffset(0);
        try {
            List<Prodotto> prodotti = serviceProduct.fetchProdotti(paginator);
            request.setAttribute(LISTA_PRODOTTI, prodotti);
            request.getRequestDispatcher(view("site/index")).forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
