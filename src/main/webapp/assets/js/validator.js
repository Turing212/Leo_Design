function validazione(){
    // recupero il valore della email indicata nel form
    var email=document.getElementById("signupEmail");
    var pass=document.getElementById("signupPass");
    validazioneEmail(email);
    validazionePass(pass);
}
function validazionePass(pass)
{


    // se non ho inserito nulla nel campo
    if(pass==""){alert("La password non e' stata inserita"); return false;}
    // verifico se è un indirizzo valido
    if (!/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(email))
    {
        alert("La password non e' corretta");
    }
    return false;
}
function validazioneEmail(email)
{

    // se non ho inserito nulla nel campo
    if(email==""){alert("L'email non e' stata inserita"); return false;}
    // verifico se è un indirizzo valido
    if (!/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(email))
    {
        alert("L'email inserita non e' corretta");
    }
    return false;
}