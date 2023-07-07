package LeoDesign.controller.http;




import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;


public abstract class Controller extends HttpServlet implements Etichette{


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

    protected String getUploadPath(){
        return System.getenv("CATALINA_HOME") + File.separator + "uploads" + File.separator;
    }

    protected int parsePage(HttpServletRequest request){
        return Integer.parseInt(request.getParameter("page"));
    }


}
