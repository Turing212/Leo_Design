
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp"/>
</head>
<body>

<div class="grid-x justify-content-center align-items-center">
    <c:if test="${not empty alert}">
        <%@include file="../partials/alert.jsp"%>
    </c:if>
</div>
<h1>PROFILO</h1>
</body>
</html>
