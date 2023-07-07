<%@ page import="java.util.regex.Pattern" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>

    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="${categoria}"/>
        <jsp:param name="styles" value="shop.css,product.css"/>
        <jsp:param name="script" value="sidebar.js,gifHover.js"/>
    </jsp:include>
</head>

<body>

<header>

    <jsp:include page="../partials/header.jsp"/>

</header>

<!-- Start shop -->
<div class="shop ">
    <c:forEach items="${listaProdotti}" var="prodotto">
        <a href="${context}/prodotto?idProdotto=${prodotto.idProdotto}">
            <div  class="single-product display-flex justify-content-around ">
                <img src="${context}/${prodotto.immagine1}">

                <div class="modulo">
                    <h1>${prodotto.nome}</h1>
                    <p>${prodotto.descrizione}</p>
                    <h2>€ ${prodotto.prezzo}</h2>
                </div>
            </div>
        </a>
    </c:forEach>
</div>

<!-- End shop -->

<!-- start pagination -->
<div class="pagination">
    <a href="#">&laquo;</a>
    <a href="NameServlet?page=1">1</a>
    <a href="NameServlet?page=2">2</a>
    <a href="NameServlet?page=3">3</a>
    <a href="#">&raquo;</a>
</div>
<!-- end pagination -->

<!-- Start Footer -->
<footer class="footer">
    <div class="display-inline-flex">
        <div class=" ">
            <h1 class="border-bottom" >Leo Design</h1>
            <ul class="list-unstyled">
                <li>

                    <h2>Via Giovanni Paolo II, 132, 84084 Fisciano SA <img src="${context}/assets/img/location.gif" width="50px" height="50px"> </h2>
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
