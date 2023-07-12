package LeoDesign.model.account;


import LeoDesign.controller.http.RequestValidator;
import jakarta.servlet.http.HttpServletRequest;

import java.util.regex.Pattern;

public class AccountValidator {
    public static RequestValidator validateForm(HttpServletRequest request) {
        RequestValidator validator = new RequestValidator(request);
        validator.assertMatch("nome", Pattern.compile("^[a-zA-Z ]{1,40}$"), "Nome compreso tra i 1 e 40 caratteri");
        validator.assertMatch("cognome", Pattern.compile("^[a-zA-Z ]{1,40}$"), "Cognome compreso tra i 1 e 40 caratteri");
        validator.assertEmail("signupEmail","Formato email errato");
        validator.assertPassword("signupPass", "Formato password errato");
        return validator;
    }

    public static RequestValidator validateSignin(HttpServletRequest request) {
        RequestValidator validator = new RequestValidator(request);
        validator.assertEmail("signinEmail","Formato email errato");
        return validator;
    }
}
