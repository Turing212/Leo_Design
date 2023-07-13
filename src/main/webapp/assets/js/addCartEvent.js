
function addCart(context){
    console.log(context+"/carrello/add")
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function (){
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("add").innerHTML = "Aggiunto";
            document.getElementById("add").style.background = "#04be23";
            setTimeout(restoreButton, 3000);
        }
    };

    xmlhttp.open("POST", context+"/carrello/add", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    var prodotto = document.getElementById("idProdotto");
    var quantita = document.getElementById("quantita");
    xmlhttp.send("idProdotto=" + prodotto.value + "&quantita=" + quantita.value);
}
function restoreButton(){
    document.getElementById("add").innerHTML = "Aggiungi al carrello";
    document.getElementById("add").style.background = "linear-gradient(145deg, #505050, #272727)";
}