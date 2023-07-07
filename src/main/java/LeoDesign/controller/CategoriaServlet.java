package LeoDesign.controller;

import LeoDesign.controller.http.Controller;
import LeoDesign.controller.http.Etichette;
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
import java.util.regex.Pattern;

@WebServlet(name = "CategoriaServlet", value = "/categoria/*")
public class CategoriaServlet extends Controller{
    SqlCategoriaDao serviceCategory;
    @Override
    public void init() throws ServletException {
        super.init();
        serviceCategory = new SqlCategoriaDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getPath(request);
        Categoria categoria = null;

        switch (path) {
            case "/Armadi-e-guardaroba":

                try {
                    categoria = serviceCategory.fetchCategoriaWithProdotti(2);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute(LISTA_PRODOTTI, categoria.getProdotti());
                request.setAttribute(NOME_CATEGORIA, categoria.getTitolo());
                request.getRequestDispatcher(view("site/shop")).forward(request, response);
                break;
            case "/Tavoli-e-scrivania":
                try {
                    categoria = serviceCategory.fetchCategoriaWithProdotti(3);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute(LISTA_PRODOTTI, categoria.getProdotti());
                request.setAttribute(NOME_CATEGORIA, categoria.getTitolo());
                request.getRequestDispatcher(view("site/shop")).forward(request, response);
                break;
            case "/Divani":
                try {
                    categoria = serviceCategory.fetchCategoriaWithProdotti(5);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute(LISTA_PRODOTTI, categoria.getProdotti());
                request.setAttribute(NOME_CATEGORIA, categoria.getTitolo());
                request.getRequestDispatcher(view("site/shop")).forward(request, response);
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
