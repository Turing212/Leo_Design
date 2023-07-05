<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Login Admin"/>
        <jsp:param name="styles" value="product.css,login.css"/>
        <jsp:param name="script" value="sidebar.js,login.js"/>
    </jsp:include>
</head>
<body>
<form action="./accounts/secret" method="post">
    <!-- Start login -->

    <div class="login-signup" id="container">
        <div class="form-container sign-up-container">
            <form action="#">
                <h1>Crea Account Admin</h1>
                <span>o usa la tua email per la registrazione</span>
                <input type="text" placeholder="Nome" />
                <input type="email" placeholder="Email" />
                <input type="password" placeholder="Password" />
                <button type="submit">Registrati</button>
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form action="#">
                <h1>Accedi da Admin</h1>

                <span>o usa il tuo account</span>
                <input type="email" placeholder="Email" />
                <input type="password" placeholder="Password" />
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

    <!-- End login -->

</form>
</body>
</html>
