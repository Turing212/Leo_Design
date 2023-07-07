<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<footer class="footer">
    <div class="display-inline-flex">
        <div>
            <img src="${context}/assets/img/logo.png">
        </div>
        <div>
            <h1 class="border-bottom" >Leo Design</h1>
            <ul class="list-unstyled">
                <li><a class="text-decoration-none" href="${context}/footer/show">Mostra tutti i prodotti</a></li>
                <li><a class="text-decoration-none" href="${context}">Home</a></li>
                <li><a class="text-decoration-none" href="#">Carrello</a></li>
                <li><a class="text-decoration-none" href="#">About Us</a></li>
                <li><a class="text-decoration-none" href="#">Contact</a></li>
            </ul>
        </div>
        <div>
            <h1 class="border-bottom">Ulteriori info</h1>
            <ul class="list-unstyled">
                <li>

                    <h2>Via Giovanni Paolo II, 132, 84084 Fisciano SA <img src="${context}/assets/img/location.gif" width="50px" height="50px"> </h2>
                </li>

                <li>
                    <i class="fa fa-envelope fa-fw"></i>
                    <a class="text-decoration-none" href="mailto:a.leo85@studenti.unisa.it">a.leo85@studenti.unisa.it</a>
                </li>
            </ul>
        </div>
    </div>


</footer>