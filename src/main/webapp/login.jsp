<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Leo Design</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="assets/css/common.css">
    <link rel="stylesheet" type="text/css" href="assets/css/home.css">
    <link rel="stylesheet" href="assets/css/footer.css">
    <link rel="stylesheet" href="assets/css/sidebar.css">
    <link rel="stylesheet" href="assets/css/product.css">
    <link rel="stylesheet" href="assets/css/login.css">
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
                    <div class="item"><a href="${context}/index.html"><i ></i>Home</a> </div>
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
                    <img id="search-png" onmouseover="search()" width="40em" height="40em" src="assets/img/search.png" alt="cerca">
                    <img id="search-gif" onmouseout="search()" style="display: none;" width="40em" height="40em" src="assets/img/search.gif" alt="cerca">
                </button>
            </form>
        </div>

        <div id="logCarrelloContainer" class="display-inline-flex justify-content-between common-margin">
            <div id="loginContainer" class="common-margin">
                <button class="button">
                    <a href="login.html">
                        <img id="avatar-png" onmouseover="avatar()" width="40em" height="40em" src="assets/img/avatar.png" alt="login/register">
                        <img id="avatar-gif" onmouseout="avatar()" style="display: none;" width="40em" height="40em" src="assets/img/avatar.gif" alt="login/register">
                    </a>
                </button>
            </div>
            <div id="carrelloContainer" class="common-margin">
                <button class="button">
                    <a href="carrello.html">
                        <img id="carrello-png" onmouseover="carrello()" width="40em" height="40em" src="assets/img/carrello.png" alt="carrello">
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

<!-- Start login -->

<div class="login-signup" id="container">
    <div class="form-container sign-up-container">
        <form action="#">
            <h1>Crea Account</h1>
            <span>o usa la tua email per la registrazione</span>
            <input type="text" placeholder="Nome" />
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="Password" />
            <button>Registrati</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="#">
            <h1>Accedi</h1>

            <span>o usa il tuo account</span>
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="Password" />
            <!-- <a href="#">hai dimenticato la password?</a> -->
            <button>Accedi</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Bentornato!</h1>
                <p>Per restare connesso effettua il login con i tuoi dati personali</p>
                <button class="ghost" id="signIn">Accedi</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Benvenuto!</h1>
                <p>Inserisci i tuoi dati personali</p>
                <button class="ghost" id="signUp">Registrati</button>
            </div>
        </div>
    </div>
</div>

<!-- End login -->


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
<script src="assets/js/gifHover.js"></script>
<script src="assets/js/sidebar.js"></script>
<script src="assets/js/login.js"></script>
<!-- End Script -->
</body>

</html>
