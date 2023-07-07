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

<jsp:include page="../partials/footer.jsp"/>

<!-- End Footer -->

</body>

</html>
