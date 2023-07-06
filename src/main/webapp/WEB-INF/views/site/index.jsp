<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Leo Design</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="assets/css/common.css">
    <link rel="stylesheet" type="text/css" href="assets/css/home.css">
    <link rel="stylesheet" href="assets/css/gallery.css">
    <link rel="stylesheet" href="assets/css/card.css">
    <link rel="stylesheet" href="assets/css/footer.css">
    <link rel="stylesheet" href="assets/css/sidebar.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" charset="utf-8"></script>

</head>

<body>

<header>

    <!-- Start Menu Bar -->
    <div id="headerContainer" class="display-flex justify-content-between align-items-stretch">

        <!-- Start sidebar -->
        <div>
            <div class="menu-btn">
                <img src="assets/img/menu-start.png" class="toggle">
            </div>

            <div class="side-bar">
                <div  class="close-btn">
                    <img src="assets/img/menu-end.png" class="toggle">
                </div>
                <div class="menu">
                    <div class="item"><a href="home.jsp"><i ></i>Home</a> </div>
                    <div class="item">
                        <a href="#" class="sub-btn"><i ></i>Catalogo <i class="dropdown"> &gt; </i></a>
                        <div class="sub-menu">
                            <a href="#" class="sub-btn sub-item">Mobili</a>
                            <div class="sub-menu">
                                <a href="#" class="sub-btn sub-sub-item">Mobili, credenze, schedari</a>
                                <a href="#" class="sub-btn sub-sub-item">Armadi e guardaroba</a>
                                <a href="#" class="sub-btn sub-sub-item">Tavoli e scrivania</a>
                                <a href="#" class="sub-btn sub-sub-item">Sedie</a>
                                <a href="#" class="sub-btn sub-sub-item">Divani</a>
                                <a href="#" class="sub-btn sub-sub-item">Cassettiere</a>
                                <a href="#" class="sub-btn sub-sub-item">Letti</a>
                                <a href="#" class="sub-btn sub-sub-item">Mobili per bagno</a>
                            </div>
                            <a href="#" class="sub-btn sub-item">Cucine </a>
                            <div class="sub-menu">
                                <a href="#" class="sub-btn sub-sub-item">Mobili da cucina</a>
                                <a href="#" class="sub-btn sub-sub-item">Ante frontali per cassetti da cucina</a>
                                <a href="#" class="sub-btn sub-sub-item">Piani di lavoro per cucina</a>
                                <a href="#" class="sub-btn sub-sub-item">Isola cucina</a>
                                <a href="#" class="sub-btn sub-sub-item">Mensole cucina</a>
                                <a href="#" class="sub-btn sub-sub-item">Lavelli</a>
                                <a href="#" class="sub-btn sub-sub-item">Illuminazione cucina</a>
                            </div>
                            <a href="#" class="sub-btn sub-item">Soggiorno </a>
                            <div class="sub-menu">
                                <a href="#" class="sub-btn sub-sub-item">Divani</a>
                                <a href="#" class="sub-btn sub-sub-item">Tavolini</a>
                                <a href="#" class="sub-btn sub-sub-item">Pareti attrezzate</a>
                                <a href="#" class="sub-btn sub-sub-item">Decorazioni</a>
                            </div>
                            <a href="#" class="sub-btn sub-item">Mobili e soluzioni per il bagno </a>
                            <div class="sub-menu">
                                <a href="#" class="sub-btn sub-sub-item">Mobili da lavabo</a>
                                <a href="#" class="sub-btn sub-sub-item">Mobili per bagno</a>
                                <a href="#" class="sub-btn sub-sub-item">Accessori per bagno</a>
                                <a href="#" class="sub-btn sub-sub-item">Specchi per bagno</a>
                                <a href="#" class="sub-btn sub-sub-item">Lavabi bagno</a>
                                <a href="#" class="sub-btn sub-sub-item">Docce</a>
                            </div>
                            <a href="#" class="sub-btn sub-item">Camere da letto </a>
                            <div class="sub-menu">
                                <a href="#" class="sub-btn sub-sub-item">Materassi</a>
                                <a href="#" class="sub-btn sub-sub-item">Letti</a>
                                <a href="#" class="sub-btn sub-sub-item">Strutture letto</a>
                                <a href="#" class="sub-btn sub-sub-item">Comodini</a>
                                <a href="#" class="sub-btn sub-sub-item">Armadi</a>
                                <a href="#" class="sub-btn sub-sub-item">Basi e reti a doghe</a>
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
                    <img id="search-png" onmouseover="search()"  width="40em" height="40em" src="assets/img/search.png" alt="cerca">
                    <img id="search-gif" onmouseout="search()" style="display: none;" width="40em" height="40em" src="assets/img/search.gif" alt="cerca">
                </button>
            </form>
        </div>

        <div id="logCarrelloContainer" class="display-inline-flex justify-content-between common-margin">
            <div id="loginContainer" class="common-margin">
                <button class="button">
                    <a href="login.jsp">
                        <img id="avatar-png" onmouseover="avatar()" width="40em" height="40em" src="assets/img/avatar.png" alt="login/register">
                        <img id="avatar-gif" onmouseout="avatar()" style="display: none;" width="40em" height="40em" src="assets/img/avatar.gif" alt="login/register">
                    </a>
                </button>
            </div>
            <div id="carrelloContainer" class="common-margin">
                <button class="button">
                    <a href="carrello.jsp">
                        <img id="carrello-png" onmouseover="carrello()"  width="40em" height="40em" src="assets/img/carrello.png" alt="carrello">
                        <img id="carrello-gif" onmouseout="carrello()" style="display: none;" width="40em" height="40em" src="assets/img/carrello.gif" alt="carrello">
                    </a>
                </button>
            </div>
        </div>

    </div>

    <!-- End Menu Bar -->

    <!-- Start SubMenu Bar -->
    <!-- <div class="horizontal-menu display-flex justify-content-between">

         <button> <a href="#" class="sub-btn sub-sub-item"></a> Mobili </button>

         <button> <a href="#" class="sub-btn sub-item"></a> Cucine </button>

         <button> <a href="#" class="sub-btn sub-item"></a> Soggiorno </button>

         <button> <a href="#" class="sub-btn sub-item"></a> Mobili e soluzioni per il bagno </button>

         <button> <a href="#" class="sub-btn sub-item"></a> Camere da letto </button>

     </div> -->

    <!-- End SubMenu Bar -->
</header>

<!-- Start Gallery -->
<div class="slider-wrapper">
    <button class="slide-arrow" id="slide-arrow-prev">
        &#8249;
    </button>
    <button class="slide-arrow" id="slide-arrow-next">
        &#8250;
    </button>
    <div class="slides-container" id="slides-container">
        <c:forEach items="${listaProdotti}" var="prodotti">
        <div class="slide display-inline-flex">
            <div>

                <h1> ${prodotti.nome} </h1>
                <p>${prodotti.descrizione} </p>
                <a href="#lampada">
                    <button class="button" >Acquista ora</button>
                </a>
            </div>
            <img src="${prodotti.immagine2}">
        </div>
        </c:forEach>

    </div>
</div>

<!--End Gallery -->

<!-- Start Banner Cards -->
<div class="banner">
    <h1> Prodotti in evidenza</h1>
</div>

<!--End Banner Cards -->


<!-- Start Product Card -->
<div class="cards display-flex justify-content-between align-items-stretch">

    <c:forEach begin="0" end="3" items="${listaProdotti}" var="prodotti">
        <div class="justify-content-between display-inline-flex">
            <div class="card">
                <a href="shop-single.html">
                    <div class="card-img"> <img width="90%" src="${prodotti.immagine1}"></div>
                    <div class="card-info">
                        <div class="card-text">
                            <h1 class="text-title">${prodotti.nome}</h1>
                            <p class="text-subtitle">€ ${prodotti.prezzo}</p>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </c:forEach>


</div>

<!-- End Product Card -->

<!-- Start Footer -->
<footer class="footer">
    <div class="display-inline-flex">
        <div class=" ">
            <h1 class="border-bottom" >Leo Design</h1>
            <ul class="list-unstyled">
                <li>

                    <h2>Via Giovanni Paolo II, 132, 84084 Fisciano SA <img src="assets/img/location.gif" width="50px" height="50px"> </h2>
                </li>

                <li>
                    <i class="fa fa-envelope fa-fw"></i>
                    <a class="text-decoration-none" href="mailto:a.leo85@studenti.unisa.it">a.leo85@studenti.unisa.it</a>
                </li>
            </ul>
        </div>

        <div>
            <h1 class="border-bottom" >Prodotti</h1>
            <ul class="list-unstyled">
                <li><a class="text-decoration-none" href="#">Mobili</a></li>
                <li><a class="text-decoration-none" href="#">Cucine</a></li>
                <li><a class="text-decoration-none" href="#">Soggiorno</a></li>
                <li><a class="text-decoration-none" href="#">Mobili e soluzioni per il bagno</a></li>
                <li><a class="text-decoration-none" href="#">Camere da letto</a></li>
            </ul>
        </div>

        <div >
            <h1 class="border-bottom" >Ulteriori info</h1>
            <ul class="list-unstyled">
                <li><a class="text-decoration-none" href="#">Home</a></li>
                <li><a class="text-decoration-none" href="#">Carrello</a></li>
                <li><a class="text-decoration-none" href="#">About Us</a></li>
                <li><a class="text-decoration-none" href="#">Contact</a></li>
            </ul>
        </div>

    </div>


</footer>

<!-- End Footer -->

<!-- Start Script -->
<script src="assets/js/gallery.js"></script>
<script src="assets/js/gifHover.js"></script>
<script src="assets/js/sidebar.js"></script>
<!-- End Script -->
</body>

</html>