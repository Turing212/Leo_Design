<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <jsp:include page="../partials/head.jsp">
    <jsp:param name="title" value="login"/>
    <jsp:param name="styles" value="login.css,product.css"/>
    <jsp:param name="script" value="sidebar.js,gifHover.js,login.js"/>
  </jsp:include>
</head>
<body>
<header>
  <jsp:include page="../partials/header.jsp"/>
</header>

<!-- Start login -->

<jsp:include page="../account/loginForm.jsp"/>

<!-- End login -->

<jsp:include page="../partials/footer.jsp"/>
</body>
</html>

