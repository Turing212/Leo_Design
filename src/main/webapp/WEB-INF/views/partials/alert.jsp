<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<div class="notification ${alert.type}" id="alertContainer">
    <ol>
        <c:forEach var="msg" items="${alert.messages}">
            <li>${msg}</li>
        </c:forEach>
    </ol>
    <span id="notification-close" class="close">
        <img src="${context}/assets/icons/close.png" width="10" height="10">
    </span>
</div>