package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ProductDAO;

import java.io.IOException;

@WebServlet(name = "SingleProduct", value = "/SingleProduct")
public class SingleProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO service = new ProductDAO();
        Prodotto p = service.doRetrieveById("dffgvbdgse");

        request.setAttribute("prodotto", p);
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/shop-single.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
