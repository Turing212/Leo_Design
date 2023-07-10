<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Leo Design"/>
        <jsp:param name="script" value="sidebar.js"/>
    </jsp:include>
</head>
<body>
<header>

    <div id="headerContainer" class="display-flex justify-content-between align-items-stretch">

        <!-- Start sidebar -->
        <div>
            <div class="menu-btn">
                <img src="${context}/assets/img/menu-start.png" class="toggle">
            </div>

            <div class="side-bar">
                <div  class="close-btn">
                    <img src="${context}/assets/img/menu-end.png" class="toggle">
                </div>
                <div class="menu">
                    <div class="item"><a href="${context}"><i ></i>Gestione Clienti</a></div>
                    <div class="item"><a href=""><i ></i>Gestione Prodotti</a> </div>
                    <div class="item"><a href=""><i ></i>Gestione Ordini</a> </div>
                    <div class="item"><a href=""><i ></i>Gestione Categorie</a> </div>
                    <div class="item"><a href=""><i ></i>Gestione Magazzini</a> </div>
                    <div class="item"><a href=""><i ></i>Logout</a> </div>
                </div>
            </div>
        </div>

        <!-- End sidebar -->

        <div class="common-margin">
            <form action="HomeControllerSearchBar" id="searchBarForm" class="display-inline-flex justify-content-between common-margin">
                <input placeholder="Cerca" class="search" id="searchBarText" type="text">
                <button type="submit" value="Submit" class="button">
                    <img id="search-png" onmouseover="search()"  width="40em" height="40em" src="${context}/assets/img/search.png" alt="cerca">
                    <img id="search-gif" onmouseout="search()" style="display: none;" width="40em" height="40em" src="${context}/assets/img/search.gif" alt="cerca">
                </button>
            </form>
        </div>

        <div id="logCarrelloContainer" class="display-inline-flex justify-content-between common-margin">
            <div id="loginContainer" class="common-margin">
                <button class="button">
                    <a href="login.jsp">
                        <img id="avatar-png" onmouseover="avatar()" width="40em" height="40em" src="${context}/assets/img/avatar.png" alt="login/register">
                        <img id="avatar-gif" onmouseout="avatar()" style="display: none;" width="40em" height="40em" src="${context}/assets/img/avatar.gif" alt="login/register">
                    </a>
                </button>
            </div>
            <div id="carrelloContainer" class="common-margin">
                <button class="button">
                    <a href="carrello.jsp">
                        <img id="carrello-png" onmouseover="carrello()"  width="40em" height="40em" src="${context}/assets/img/carrello.png" alt="carrello">
                        <img id="carrello-gif" onmouseout="carrello()" style="display: none;" width="40em" height="40em" src="${context}/assets/img/carrello.gif" alt="carrello">
                    </a>
                </button>
            </div>
        </div>

    </div>
</header>
</body>
</html>
