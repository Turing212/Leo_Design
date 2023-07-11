package LeoDesign.controller.http;




import LeoDesign.model.account.AccountSession;
import LeoDesign.model.account.GuestAccount;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;


public abstract class Controller extends HttpServlet implements Etichette, ErrorHandler{


    protected String getPath(HttpServletRequest req){
        return req.getPathInfo() != null ? req.getPathInfo() : "/";
    }

    protected String view(String viewPath){
        String basePath = getServletContext().getInitParameter("basePath");
        String engine = getServletContext().getInitParameter("engine");
        return basePath + viewPath + engine;
    }

    protected void validate(RequestValidator validator) throws InvalidRequestException{
        if(validator.hasErrors()){
            throw new InvalidRequestException("Validation Error", validator.getErrors(), HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    protected AccountSession getAccountSession(HttpSession session){
        return (AccountSession) session.getAttribute("accountSession");
    }

    protected GuestAccount getGuestAccount(HttpSession session){
        return (GuestAccount) session.getAttribute("accountGuest");
    }


}
