package LeoDesign.controller;

import LeoDesign.controller.http.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AccountServlet", value = "/accounts/*")
public class AccountServlet extends Controller {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path;
        if(request.getPathInfo() != null) path = request.getPathInfo();
        else path = "/";
        System.out.println(path);

        switch (path) {
            case "/": { //mostra gli account nel database (solo per admin)

                request.getRequestDispatcher(view("crm/accounts")).forward(request, response);
                break;
            }
            case "/create": { //aggiungi un account admin al database (solo per admin)
                request.getRequestDispatcher(view("crm/account")).forward(request, response);
                break;
            }
            case "/show": { //Aggiorna account (admin)
                request.getRequestDispatcher(view("/WEB-INF/views/crm/account")).forward(request, response);
                break;
            }
            case "/secret": { //login admin (pagina)
                System.out.println("Mannaggia la puttana");
                request.getRequestDispatcher(view("/WEB-INF/views/crm/secret.jsp")).forward(request, response);
                break;
            }
            case "/signup": { // registrazione cliente
                    request.getRequestDispatcher(view("site/signUp")).forward(request, response);
                break;
            }
            case "/signin": { //login cliente (pagina)
                    request.getRequestDispatcher(view("site/signIn")).forward(request, response);
                break;
            }
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
