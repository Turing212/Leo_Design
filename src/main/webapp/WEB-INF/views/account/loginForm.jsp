<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<div class="login-signup" id="container">
    <div class="form-container sign-up-container">
        <form action="${context}/accounts/signup" method="post">
            <h1>Crea Account</h1>
            <span>o usa la tua email per la registrazione</span>
            <input type="text" placeholder="Nome" id="nome"/>
            <input type="email" placeholder="Email" id="signupEmail"/>
            <input type="password" placeholder="Password" id="signupPass"/>
            <button type="submit">Registrati</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="${context}/accounts/signin" method="post">
            <h1>Accedi</h1>

            <span>o usa il tuo account</span>
            <input type="email" placeholder="Email" id="signinEmail" name="signinEmail"/>
            <input type="password" placeholder="Password" id="signinPass" name="signinPass"/>
            <button type="submit">Accedi</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Bentornato!</h1>
                <p>Per restare connesso effettua il login con i tuoi dati personali</p>
                <button class="ghost" id="signIn">Accedi</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Benvenuto!</h1>
                <p>Inserisci i tuoi dati personali</p>
                <button class="ghost" id="signUp">Registrati</button>
            </div>
        </div>
    </div>
</div>
