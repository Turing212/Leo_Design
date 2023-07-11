package LeoDesign.model.account;


import LeoDesign.controller.http.RequestValidator;
import jakarta.servlet.http.HttpServletRequest;

import java.util.regex.Pattern;

public class AccountValidator {
    public static RequestValidator validateForm(HttpServletRequest request) {
        RequestValidator validator = new RequestValidator(request);
        validator.assertMatch("nome", Pattern.compile("^[a-zA-Z ]{1,40}$"), "Nome compreso tra i 1 e 40 caratteri");
        validator.assertMatch("cognome", Pattern.compile("^[a-zA-Z ]{1,40}$"), "Cognome compreso tra i 1 e 40 caratteri");
        validator.assertEmail("email","Formato email errato");
        validator.assertEmail("repEmail","Formato email ripetuta errato");
        validator.equalEmail("email","repEmail","Le email non corrispondono");
        validator.assertPassword("password", "Formato password errato");
        validator.assertPassword("repPassword", "Formato password ripetuta errato");
        validator.equalPassword("password","repPassword", "Le password non corrispondono");
        return validator;
    }

    public static RequestValidator validateUpdate(HttpServletRequest request, boolean password){
        RequestValidator validator = new RequestValidator(request);
        validator.assertMatch("nome", Pattern.compile("^[a-zA-Z ]{1,40}$"), "Nome compreso tra i 1 e 40 caratteri");
        validator.assertMatch("cognome", Pattern.compile("^[a-zA-Z ]{1,40}$"), "Cognome compreso tra i 1 e 40 caratteri");
        validator.assertEmail("email","Formato email errato");
        if(password){
            validator.assertPassword("precPwd", "Formato password precedente errato");
            validator.assertPassword("newPwd", "Formato nuova password errato");
        }
        return validator;
    }

    public static RequestValidator validateNewAdminForm(HttpServletRequest request){
        RequestValidator validator = new RequestValidator(request);
        validator.assertMatch("nome", Pattern.compile("^[a-zA-Z ]{1,40}$"), "Nome compreso tra i 1 e 40 caratteri");
        validator.assertMatch("cognome", Pattern.compile("^[a-zA-Z ]{1,40}$"), "Cognome compreso tra i 1 e 40 caratteri");
        validator.assertEmail("email","Formato email errato");
        validator.assertPassword("password", "Formato password errato");
        return validator;
    }

    public static RequestValidator validateSignin(HttpServletRequest request) {
        RequestValidator validator = new RequestValidator(request);
        validator.assertEmail("signinEmail","Formato email errato");
        return validator;
    }
}
