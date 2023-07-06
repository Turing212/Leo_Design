package LeoDesign.controller;

import LeoDesign.controller.http.Controller;
import LeoDesign.controller.http.InvalidRequestException;
import LeoDesign.model.categoria.Categoria;
import LeoDesign.model.categoria.SqlCategoriaDao;
import LeoDesign.model.prodotto.Prodotto;
import LeoDesign.model.prodotto.SqlProdottoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "CategoriaServlet", value = "/categoria/*")
public class CategoriaServlet extends Controller {
    SqlCategoriaDao serviceCategory;
    @Override
    public void init() throws ServletException {
        super.init();
        serviceCategory = new SqlCategoriaDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getPath(request);
        Optional<Categoria> categoria = null;

        switch (path) {
            case "/Armadi-e-guardaroba":

                try {
                    categoria = serviceCategory.fetchCategoriaWithProdotti(2);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("lista", categoria.get().getProdotti());

                break;
            case "/Tavoli-e-scrivania":

                break;
            case "/Divani":

                break;
            case "/Cassettiere":

                break;
            case "/Letti":

                break;
            case "/Mobili-da-cucina":

                break;

            case "/Strutture-letto":

                break;
            case "/Pareti-attrezzate":

                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Prodotto non trovato");
        }
        request.getRequestDispatcher(view("site/shop")).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
