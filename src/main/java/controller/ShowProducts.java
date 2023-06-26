package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ProductDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowProducts", value = "/ShowProducts")
public class ShowProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO service = new ProductDAO();
        List<Prodotto> prodotti = new ArrayList<>();

        prodotti.add(service.doRetrieveById("dffgvbdgse"));
        prodotti.add(service.doRetrieveById("hyghfrthbc"));
        prodotti.add(service.doRetrieveById("bdfsfseyjf"));
        prodotti.add(service.doRetrieveById("fbferghnfg"));
        prodotti.add(service.doRetrieveById("uikyujhmgy"));
        prodotti.add(service.doRetrieveById("qwerwecdfw"));
        prodotti.add(service.doRetrieveById("bngnudrgtd"));
        prodotti.add(service.doRetrieveById("bndghnmyue"));

        request.setAttribute("prodotti", prodotti);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
