<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${pages > 1}">
    <c:forEach var="page" begin="1" end="${pages}">
        <li>
            <a href="./${param.resource}?page=${page}">${page}</a>
        </li>
    </c:forEach>
</c:if>

