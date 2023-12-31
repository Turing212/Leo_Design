<%@ page import="java.util.regex.Pattern" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Shop single"/>
        <jsp:param name="styles" value="product.css"/>
        <jsp:param name="script" value="sidebar.js,gifHover.js,addCartEvent.js"/>
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
        <div class="align-items-center">
            <input type="hidden" name="idProdotto" id="idProdotto" value="${prodotto.idProdotto}">
            <c:if test="${not empty fullUrl}">
                <input type="hidden" name="urlSource" value="${fullUrl}">
            </c:if>
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
                <button type="button" class="button" name="add" id="add" onclick="addCart('${context}')">Aggiungere al carrello</button>
            </div>
        </div>


    </div>
</div>



<!-- End Product -->

<!-- Start Footer -->

<jsp:include page="../partials/footer.jsp"/>

<!-- End Footer -->

</body>

</html>
