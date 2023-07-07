package LeoDesign.controller;

import LeoDesign.controller.http.Controller;
import LeoDesign.model.categoria.Categoria;
import LeoDesign.model.prodotto.Prodotto;
import LeoDesign.model.prodotto.SqlProdottoDao;
import LeoDesign.model.storage.Paginator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FooterServlet", value = "/footer/*")
public class FooterServlet extends Controller {
    SqlProdottoDao serviceProduct;
    @Override
    public void init() throws ServletException {
        super.init();
        serviceProduct = new SqlProdottoDao();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                Paginator paginator = new Paginator(1,4);
                paginator.setOffset(0);
                try {
                    List<Prodotto> prodotti = serviceProduct.fetchProdotti(paginator);
                    request.setAttribute(LISTA_PRODOTTI, prodotti);
                    request.getRequestDispatcher(view("site/shop")).forward(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
