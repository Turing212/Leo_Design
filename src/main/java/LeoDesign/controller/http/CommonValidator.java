package LeoDesign.controller.http;

import jakarta.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class CommonValidator {

    public static RequestValidator validatePage(HttpServletRequest request){
        RequestValidator validator = new RequestValidator(request);
        validator.assertInt("page","Il numero di pagina deve essere in un formato valido");
        return validator;
    }

    public static RequestValidator validateId(HttpServletRequest request){
        RequestValidator validator = new RequestValidator(request);
        validator.assertInt("id","Id deve essere in un formato valido");
        return validator;
    }

    public static RequestValidator validateKeyword(HttpServletRequest request){
        RequestValidator validator = new RequestValidator(request);
        validator.assertMatch("keyword", Pattern.compile("^[a-zA-Z0-9-'& ]{1,60}$"), "Ricerca compreso tra i 1 e 60 caratteri");
        return validator;
    }


}
