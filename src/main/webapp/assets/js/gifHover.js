/*$("#button").click(function() { 
    // assumes element with id='button'
    $("#newpost").toggle();
});
*/

function menu() {
  var x = document.getElementById("menu-start-png");
  var y = document.getElementById("menu-gif");
  var z = document.getElementById("menu-end-png");
  if (x.style.display === "none") {
    x.style.display = "block";
    y.style.display = "none";
  } else {
    x.style.display = "none";
    y.style.display = "block";
  }
}

function search() {
  var x = document.getElementById("search-png");
  var y = document.getElementById("search-gif");
  if (x.style.display === "none") {
    x.style.display = "block";
    y.style.display = "none";
  } else {
    x.style.display = "none";
    y.style.display = "block";
  }
}

function carrello() {
    var x = document.getElementById("carrello-png");
    var y = document.getElementById("carrello-gif");
    if (x.style.display === "none") {
      x.style.display = "block";
      y.style.display = "none";
    } else {
      x.style.display = "none";
      y.style.display = "block";
    }
}

function avatar() {
  var x = document.getElementById("avatar-png");
  var y = document.getElementById("avatar-gif");
  if (x.style.display === "none") {
    x.style.display = "block";
    y.style.display = "none";
  } else {
    x.style.display = "none";
    y.style.display = "block";
  }
}