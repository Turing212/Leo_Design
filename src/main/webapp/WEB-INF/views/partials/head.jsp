<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover">
<title>${param.title}</title>
<meta name="description" content="Ecommerce arredamento">
<link rel="icon" type="image/png" href="/assets/img/logo.png">
<meta name="format-detection" content="telephone-no">
<link rel="stylesheet" type="text/css" href="/assets/css/common.css">
<link rel="stylesheet" type="text/css" href="/assets/css/library.css">
<link rel="stylesheet" type="text/css" href="/assets/css/reset.css">
<link rel="stylesheet" href="/assets/css/footer.css">
<link rel="stylesheet" href="/assets/css/sidebar.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" charset="utf-8"></script>
<c:if test="${not empty param.styles}">
    <c:forTokens delims="," items="${param.styles}" var="style">
        <link rel="stylesheet" href="${context}/css/${style}">
    </c:forTokens>
</c:if>
<script src="assets/js/library.js" defer></script>
<c:if test="${not empty param.script}">
    <c:forTokens delims="," items="${param.script}" var="script">
        <script src="${context}/js/${script}" defer></script>
    </c:forTokens>
</c:if>