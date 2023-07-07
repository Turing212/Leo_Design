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

<jsp:include page="../partials/footer.jsp"/>

<!-- End Footer -->
</body>

</html>