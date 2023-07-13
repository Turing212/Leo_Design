
function addCart(context){
    console.log(context+"/carrello/add")
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function (){
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("add").innerHTML = "Aggiunto";
        }
    };

    xmlhttp.open("POST", context+"/carrello/add", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    var prodotto = document.getElementById("idProdotto");
    var quantita = document.getElementById("quantita");
    xmlhttp.send("idProdotto=" + prodotto.value + "&quantita=" + quantita.value);
}