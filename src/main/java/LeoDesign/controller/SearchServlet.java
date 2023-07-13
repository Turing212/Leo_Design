package LeoDesign.controller;

import LeoDesign.controller.http.CommonValidator;
import LeoDesign.controller.http.Controller;
import LeoDesign.controller.http.InvalidRequestException;
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
            validate(CommonValidator.validateKeyword(request));
            List<Prodotto> prodotti = service.doRetrieveByKeyword(paginator, query);
            request.setAttribute(LISTA_PRODOTTI, prodotti);
            request.getRequestDispatcher(view("site/shop")).forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
    }

}
