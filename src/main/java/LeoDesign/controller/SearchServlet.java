package LeoDesign.controller;

import LeoDesign.controller.http.Controller;
import LeoDesign.model.components.Paginator;
import LeoDesign.model.prodotto.Prodotto;
import LeoDesign.model.prodotto.SqlProdottoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends Controller {
    SqlProdottoDao service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new SqlProdottoDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        Paginator paginator = new Paginator(1,5);
        try {
            List<Prodotto> prodotti = service.doRetrieveByKeyword(paginator, query);
            request.setAttribute(LISTA_PRODOTTI, prodotti);
            request.getRequestDispatcher(view("site/shop")).forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
