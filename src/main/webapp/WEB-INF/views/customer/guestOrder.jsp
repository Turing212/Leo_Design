<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Leo Design"/>
        <jsp:param name="styles" value="carrello.css"/>
        <jsp:param name="script" value="gifHover.js,sidebar.js"/>
    </jsp:include>
</head>
<header>
    <%@include file="../partials/header.jsp"%>
</header>
<body>
    <div class="carrello">
    <div class="display-flex justify-content-center align-items-center">
        <h1>Ordine effettuato con successo.</h1>
    </div>
    </div>

</div>

</body>
</html>
