<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
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
                <div class="item"><a href="${context}"><i ></i>Home</a> </div>
                <div class="item">
                    <a class="sub-btn"><i ></i>Catalogo <i class="dropdown"> &gt; </i></a>
                    <div class="sub-menu">
                        <a class="sub-btn sub-item">Mobili</a>
                        <div class="sub-menu">
                            <a href="${context}/categoria/Armadi-e-guardaroba" class="sub-btn sub-sub-item">Armadi e guardaroba</a>
                            <a href="${context}/categoria/Tavoli-e-scrivania" class="sub-btn sub-sub-item">Tavoli e scrivania</a>
                            <a href="#" class="sub-btn sub-sub-item">Sedie</a>
                            <a href="${context}/categoria/Divani" class="sub-btn sub-sub-item">Divani</a>
                            <a href="${context}/categoria/Cassettiere" class="sub-btn sub-sub-item">Cassettiere</a>
                            <a href="${context}/categoria/Letti" class="sub-btn sub-sub-item">Letti</a>
                            <a href="#" class="sub-btn sub-sub-item">Mobili per bagno</a>
                        </div>
                        <a class="sub-btn sub-item">Cucine </a>
                        <div class="sub-menu">
                            <a href="${context}/categoria/Mobili-da-cucina" class="sub-btn sub-sub-item">Mobili da cucina</a>
                            <a href="${context}/categoria/Mobili-da-cucina" class="sub-btn sub-sub-item">Ante frontali per cassetti da cucina</a>
                            <a href="${context}/categoria/Mobili-da-cucina" class="sub-btn sub-sub-item">Piani di lavoro per cucina</a>
                            <a href="${context}/categoria/Mobili-da-cucina" class="sub-btn sub-sub-item">Isola cucina</a>
                            <a href="${context}/categoria/Mobili-da-cucina" class="sub-btn sub-sub-item">Mensole cucina</a>
                            <a href="${context}/categoria/Mobili-da-cucina" class="sub-btn sub-sub-item">Lavelli</a>
                            <a href="${context}/categoria/Mobili-da-cucina" class="sub-btn sub-sub-item">Illuminazione cucina</a>
                        </div>
                        <a class="sub-btn sub-item">Soggiorno </a>
                        <div class="sub-menu">
                            <a href="${context}/categoria/Divani" class="sub-btn sub-sub-item">Divani</a>
                            <a href="#" class="sub-btn sub-sub-item">Tavolini</a>
                            <a href="${context}/categoria/Pareti-attrezzate" class="sub-btn sub-sub-item">Pareti attrezzate</a>
                            <a href="#" class="sub-btn sub-sub-item">Decorazioni</a>
                        </div>
                        <a class="sub-btn sub-item">Mobili e soluzioni per il bagno </a>
                        <div class="sub-menu">
                            <a href="#" class="sub-btn sub-sub-item">Mobili da lavabo</a>
                            <a href="#" class="sub-btn sub-sub-item">Mobili per bagno</a>
                            <a href="#" class="sub-btn sub-sub-item">Accessori per bagno</a>
                            <a href="#" class="sub-btn sub-sub-item">Specchi per bagno</a>
                            <a href="#" class="sub-btn sub-sub-item">Lavabi bagno</a>
                            <a href="#" class="sub-btn sub-sub-item">Docce</a>
                        </div>
                        <a class="sub-btn sub-item">Camere da letto </a>
                        <div class="sub-menu">
                            <a href="#" class="sub-btn sub-sub-item">Materassi</a>
                            <a href="${context}/categoria/Strutture-letto" class="sub-btn sub-sub-item">Letti</a>
                            <a href="${context}/categoria/Strutture-letto" class="sub-btn sub-sub-item">Strutture letto</a>
                            <a href="#" class="sub-btn sub-sub-item">Comodini</a>
                            <a href="${context}/categoria/Armadi-e-guardaroba" class="sub-btn sub-sub-item">Armadi e guardaroba</a>
                            <a href="${context}/categoria/Strutture-letto" class="sub-btn sub-sub-item">Basi e reti a doghe</a>
                        </div>
                    </div>
                </div>
                <div class="item"><a href=""><i ></i>Carrello</a> </div>
                <div class="item"><a href=""><i ></i>About us</a> </div>
                <div class="item"><a href=""><i ></i>Contattaci</a> </div>
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