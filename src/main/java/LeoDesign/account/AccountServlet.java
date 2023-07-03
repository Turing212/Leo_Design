package LeoDesign.account;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AccountServlet", value = "/accounts/*")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path;
        if(request.getPathInfo() != null) path = request.getPathInfo();
        else path = "/";

        switch (path) {
            case "/":
                break;
            case "/create":
                break;
            case "/show":
                break;
            case "/secret":     //login admin (pagina)
                break;
            case "/signin":     //login cliente (pagina)
                break;
            case "/signup":
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovata");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path;
        if(request.getPathInfo() != null) path = request.getPathInfo();
        else path = "/";
        switch (path) {
            case "/secret":     //login admin (ricerca nel db)
                break;
            case "/create":
                break;
            case "/update":
                break;
            case "/logout":
                break;
            case "/signup":     //registrazione cliente
                break;
            case "/signin":     //login cliente (ricerca nel db)
                break;
            default:
                response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Operazione non consentita");
        }
    }
}
