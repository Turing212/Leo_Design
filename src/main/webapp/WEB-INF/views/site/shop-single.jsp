<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Shop single"/>
        <jsp:param name="styles" value="product.css"/>
        <jsp:param name="script" value="sidebar.js,gifHover.js"/>
    </jsp:include>

</head>

<body>

<header>
    <!-- Start Menu Bar -->

    <jsp:include page="../partials/header.jsp"/>

    <!-- End Menu Bar -->
</header>

<!-- Start Product -->

<div class="prodotto display-flex justify-content-around ">
    <div class="galleria">
        <figure class="galleria__elemento galleria__elemento--1">
            <img src="${prodotto.immagine1}" alt="Immagine della galleria 1" class="galleria__immagine"/>
        </figure>
        <figure class="galleria__elemento galleria__elemento--2">
            <img src="${prodotto.immagine2}" alt="Immagine della galleria 2" class="galleria__immagine"/>
        </figure>
        <figure class="galleria__elemento galleria__elemento--3">
            <img src="${prodotto.immagine3}" alt="Immagine della galleria 3" class="galleria__immagine"/>
        </figure>

    </div>

    <div class="modulo">
        <h1>${prodotto.nome}</h1>
        <p>${prodotto.descrizione} </p>
        <h2>€ ${prodotto.prezzo}</h2>
        <form action="#" class="align-items-center">
            <div class="aggiungi">
                <select class="quantita" name="quantita" id="quantita">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                </select>
                <button class="button">Aggiungere al carrello</button>
            </div>
        </form>


    </div>
</div>



<!-- End Product -->


<!-- Start Footer -->
<footer class="footer">
    <div class="display-inline-flex">
        <div class=" ">
            <h1 class="border-bottom" >Leo Design</h1>
            <ul class="list-unstyled">
                <li>

                    <h2>Via Giovanni Paolo II, 132, 84084 Fisciano SA <img src="assets/img/location.gif" width="50px" height="50px"> </h2>
                </li>

                <li>
                    <i class="fa fa-envelope fa-fw"></i>
                    <a class="text-decoration-none" href="mailto:a.leo85@studenti.unisa.it">a.leo85@studenti.unisa.it</a>
                </li>
            </ul>
        </div>

        <div>
            <h1 class="border-bottom" >Prodotti</h1>
            <ul class="list-unstyled">
                <li><a class="text-decoration-none" href="#">Mobili</a></li>
                <li><a class="text-decoration-none" href="#">Cucine</a></li>
                <li><a class="text-decoration-none" href="#">Soggiorno</a></li>
                <li><a class="text-decoration-none" href="#">Mobili e soluzioni per il bagno</a></li>
                <li><a class="text-decoration-none" href="#">Camere da letto</a></li>
            </ul>
        </div>

        <div >
            <h1 class="border-bottom" >Ulteriori info</h1>
            <ul class="list-unstyled">
                <li><a class="text-decoration-none" href="#">Home</a></li>
                <li><a class="text-decoration-none" href="#">Carrello</a></li>
                <li><a class="text-decoration-none" href="#">About Us</a></li>
                <li><a class="text-decoration-none" href="#">Contact</a></li>
            </ul>
        </div>

    </div>


</footer>

<!-- End Footer -->

<!-- Start Script -->
<script src="assets/js/gifHover.js"></script>
<script src="assets/js/sidebar.js"></script>
<!-- End Script -->
</body>

</html>
