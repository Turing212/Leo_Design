package LeoDesign.controller;


import LeoDesign.controller.http.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "HomeServlet", value = "/index.html", loadOnStartup = 0)
public class HomeServlet extends Controller {

    //SqlCarrelloDAO serviceCart;

    @Override
    public void init() throws ServletException {
        super.init();
        //serviceCart = new SqlCarrelloDAO();
        //getServletContext().setAttribute("filter",1);//default
       // getServletContext().setAttribute("numItems",0);//default
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



            request.getRequestDispatcher(view("site/index")).forward(request, response);

    }
}
