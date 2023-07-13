<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Carrello"/>
        <jsp:param name="styles" value="carrello.css,product.css"/>
        <jsp:param name="script" value="sidebar.js,gifHover.js"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="../partials/header.jsp"/>
</header>

<!-- Start carrello -->
<div class="carrello">
<c:choose>
    <c:when test="${carrello.items.size() > 0}">
        <c:forEach items="${carrello.items}" var="item">

                    <div class="single-product display-flex justify-content-around ">
                        <a class="art" href="${context}/prodotto?idProdotto=${item.prodotto.idProdotto}">
                        <img src="${context}/${item.prodotto.immagine1}">
                        </a>
                        <div class="modulo">
                            <h1>${item.prodotto.nome} </h1>
                            <p>${item.prodotto.descrizione} </p>
                            <form action="${context}/carrello/remove"method="post">
                                <input type="hidden" name="isCart" value="cart">
                                <input type="hidden" name="quantita" value="${item.quantita}">
                                <button style="all: unset" type="submit" name="idProdotto" value="${item.prodotto.idProdotto}"><a>Rimuovi</a></button>
                            </form>
                        </div>
                        <div class="modulo">
                            <h2>${item.prodotto.prezzo}</h2>
                            <p>Quantita: ${item.quantita}</p>
                        </div>
                    </div>

        </c:forEach>
    </div>

    <div class="totale-ordine display-flex justify-content-between align-items-center ">
        <h1>Totale importo: <span>${carrello.totale()}</span></h1>
        <a href="pagamento.html"><button class="button">Procedi all'ordine</button></a>
    </div>
    </c:when>
    <c:otherwise>
        <div class="display-flex justify-content-center align-items-center ">
            <h1>Carrello vuoto</h1>
        </div>
    </c:otherwise>
</c:choose>
<!-- End carrello -->
</body>
</html>
