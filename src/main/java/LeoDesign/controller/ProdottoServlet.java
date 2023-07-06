package LeoDesign.controller;

import LeoDesign.controller.http.Controller;
import LeoDesign.model.prodotto.Prodotto;
import LeoDesign.model.prodotto.SqlProdottoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "ProdottoServlet", value = "/prodotto/*")
public class ProdottoServlet extends Controller {
    SqlProdottoDao serviceProduct;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceProduct = new SqlProdottoDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
        try {
            Optional<Prodotto> prodotto = serviceProduct.fetchProdotto(idProdotto);
            if(prodotto.isPresent()){
                request.setAttribute("prodotto", prodotto.get());
                request.getRequestDispatcher(view("site/shop-single")).forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
