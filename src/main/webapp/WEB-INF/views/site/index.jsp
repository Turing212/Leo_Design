<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>

    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Leo Design"/>
        <jsp:param name="styles" value="gallery.css,card.css"/>
        <jsp:param name="script" value="sidebar.js,gallery.js,gifHover.js"/>
    </jsp:include>

</head>

<body>

<header>

    <!-- Start Menu Bar -->

    <jsp:include page="../partials/header.jsp"/>

    <!-- End Menu Bar -->

</header>

<!-- Start Gallery -->
<div class="slider-wrapper">
    <button class="slide-arrow" id="slide-arrow-prev">
        &#8249;
    </button>
    <button class="slide-arrow" id="slide-arrow-next">
        &#8250;
    </button>
    <div class="slides-container" id="slides-container">
        <c:forEach items="${listaProdotti}" var="prodotto">
        <div class="slide display-inline-flex">
            <div>

                <h1> ${prodotto.nome} </h1>
                <p>${prodotto.descrizione} </p>
                <a href="${context}/prodotto?idProdotto=${prodotto.idProdotto}">
                    <button class="button" >Acquista ora</button>
                </a>
            </div>
            <img src="${prodotto.immagine2}">
        </div>
        </c:forEach>

    </div>
</div>

<!--End Gallery -->

<!-- Start Banner Cards -->
<div class="banner">
    <h1> Prodotti in evidenza</h1>
</div>

<!--End Banner Cards -->


<!-- Start Product Card -->
<div class="cards display-flex justify-content-between align-items-stretch">

    <c:forEach begin="0" end="3" items="${listaProdotti}" var="prodotto">

        <div class="justify-content-between display-inline-flex">
            <div class="card">
                <a href="${context}/prodotto?idProdotto=${prodotto.idProdotto}">
                    <div class="card-img"> <img width="90%" src="${prodotto.immagine1}"></div>
                    <div class="card-info">
                        <div class="card-text">
                            <h1 class="text-title">${prodotto.nome}</h1>
                            <p class="text-subtitle">€ ${prodotto.prezzo}</p>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </c:forEach>


</div>

<!-- End Product Card -->

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
</body>

</html>