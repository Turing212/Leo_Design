package LeoDesign.controller.http;


import LeoDesign.Alert;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class InvalidRequestException extends Exception {

    private final List<String> errors;
    private final int errorCode;

    public InvalidRequestException(String message, List<String> errors, int errorCode) {
        super(message);
        this.errors = errors;
        this.errorCode = errorCode;
    }

    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        switch(errorCode){
            case HttpServletResponse.SC_BAD_REQUEST:
                request.setAttribute("alert", new Alert(errors,"danger"));
                String backPath = (String) request.getAttribute("back");
                response.setStatus(errorCode);
                request.getRequestDispatcher(backPath).forward(request, response);
                break;
            default:
                request.setAttribute("message",super.getMessage());
                request.setAttribute("alert", new Alert(errors,"danger"));
                response.setStatus(errorCode);
                request.getRequestDispatcher("/WEB-INF/views/errors/otherError.jsp").forward(request, response);
        }
    }

    public List<String> getErrors(){
        return errors;
    }

}
