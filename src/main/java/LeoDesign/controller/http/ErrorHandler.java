package LeoDesign.controller.http;

import LeoDesign.model.account.AccountSession;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.List;

public interface ErrorHandler {

    default void authenticate(HttpSession session) throws InvalidRequestException{
        if(session == null || session.getAttribute("accountSession") == null){
            throw new InvalidRequestException("Errore autenticazione", Arrays.asList("Non sei autenticato"),
                    HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    default void authorize(HttpSession session) throws InvalidRequestException{
        authenticate(session);
        AccountSession accountSession = (AccountSession) session.getAttribute("accountSession");
        if(!accountSession.isAdmin()){
            throw new InvalidRequestException("Errore autorizzazione", Arrays.asList("Azione non consentita"),
                    HttpServletResponse.SC_FORBIDDEN);
        }
    }

    default void internalError() throws InvalidRequestException{
        List<String> errors = Arrays.asList("Un errore imprevisto è accaduto","Riprova più tardi");
        throw new InvalidRequestException("Errore interno",errors, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    default void notFound() throws InvalidRequestException{
        throw new InvalidRequestException("Errore interno", Arrays.asList("Risorsa non trovata"),
                HttpServletResponse.SC_NOT_FOUND);
    }

    default void notAllowed() throws InvalidRequestException{
        throw new InvalidRequestException("Operazione non consentita",Arrays.asList("Operazione non permessa"),
                HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

}
