<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover">
<title>${param.title}</title>
<meta name="description" content="Ecommerce arredamento">
<link rel="icon" type="image/png" href="${context}/assets/img/logo.png">
<meta name="format-detection" content="telephone-no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone-no">
<meta name="apple-mobile-web-app-title" content="LeoDesign">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<link rel="stylesheet" type="text/css" href="${context}/assets/css/common.css">
<link rel="stylesheet" type="text/css" href="${context}/assets/css/library.css">
<link rel="stylesheet" type="text/css" href="${context}/assets/css/reset.css">
<link rel="stylesheet" href="${context}/assets/css/footer.css">
<link rel="stylesheet" href="${context}/assets/css/sidebar.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" charset="utf-8"></script>
<c:if test="${not empty param.styles}">
    <c:forTokens delims="," items="${param.styles}" var="style">
        <link rel="stylesheet" href="${context}/assets/css/${style}">
    </c:forTokens>
</c:if>
<c:if test="${not empty param.script}">
    <c:forTokens delims="," items="${param.script}" var="script">
        <script src="${context}/assets/js/${script}" defer></script>
    </c:forTokens>
</c:if>