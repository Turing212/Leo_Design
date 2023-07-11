package LeoDesign.controller;

import LeoDesign.controller.http.Controller;
import LeoDesign.controller.http.InvalidRequestException;
import LeoDesign.model.account.Account;
import LeoDesign.model.account.AccountSession;
import LeoDesign.model.account.AccountValidator;
import LeoDesign.model.account.SqlAccountDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;


@WebServlet(name = "AccountServlet", value = "/accounts/*")
public class AccountServlet extends Controller {
    private SqlAccountDao service;

    @Override
    public void init() throws ServletException{
        super.init();
        service = new SqlAccountDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path;
        if(request.getPathInfo() != null) path = request.getPathInfo();
        else path = "/";
        System.out.println(path);

        switch (path) {
            case "/": //mostra gli account nel database (solo per admin)

                request.getRequestDispatcher(view("crm/accounts")).forward(request, response);
                break;

            case "/create":  //aggiungi un account admin al database (solo per admin)
                request.getRequestDispatcher(view("crm/account")).forward(request, response);
                break;

            case "/show":  //Aggiorna account (admin)
                request.getRequestDispatcher(view("/WEB-INF/views/crm/account")).forward(request, response);
                break;

            case "/secret":  //login admin (pagina)
                request.getRequestDispatcher(view("/WEB-INF/views/crm/secret.jsp")).forward(request, response);
                break;

            case "/signin-signup":  //login o registrazione cliente (pagina)
                HttpSession session = request.getSession(false);
                if(session != null && session.getAttribute("accountSession") != null){
                    response.sendRedirect("/account/profile");
                }else{
                    request.getRequestDispatcher(view("site/signin-signup")).forward(request, response);
                }
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovata");
            }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path;
            if (request.getPathInfo() != null) path = request.getPathInfo();
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
                case "/signin": //login cliente (cerca nel db)
                    HttpSession session = request.getSession(false);
                    if (session != null) {
                        session.invalidate();
                    }
                    request.setAttribute("back", view("site/signin-signup"));
                    try {
                        validate(AccountValidator.validateSignin(request));
                    } catch (InvalidRequestException e) {
                        e.printStackTrace();
                    }
                    Account tmpAccount = new Account();
                    tmpAccount.setEmail(request.getParameter("signinEmail"));//attenzione
                    tmpAccount.setPassword(request.getParameter("signinPass"));//attenzione
                    Optional<Account> optAccount = null;

                    optAccount = service.findAccountByEmailPwd(tmpAccount.getEmail(), tmpAccount.getPassword(), false);

                    if (optAccount.isPresent()) {
                        AccountSession accountSession = new AccountSession(optAccount.get());
                        request.getSession(true).setAttribute("accountSession", accountSession);
                        response.sendRedirect("../index.html");
                    } else {
                        throw new InvalidRequestException("Credenziali non valide",
                                Arrays.asList("Credenziali non valide"), HttpServletResponse.SC_BAD_REQUEST);
                    }
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Operazione non consentita");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
    }
}
