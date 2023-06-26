package LeoDesign.prodotto;

import LeoDesign.categoria.Categoria;
import LeoDesign.magazzino.Magazzino;

public class Prodotto {
    private int idProdotto;
    private String nome;
    private String descrizione;
    private float prezzo;
    private float peso;
    private String immagine1;
    private String immagine2;
    private String immagine3;
    private Magazzino magazzino;
    private Categoria categoria;


    public Prodotto() {
        super();
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getImmagine1() {
        return immagine1;
    }

    public void setImmagine1(String immagine1) {
        this.immagine1 = immagine1;
    }

    public String getImmagine2() {
        return immagine2;
    }

    public void setImmagine2(String immagine2) {
        this.immagine2 = immagine2;
    }

    public String getImmagine3() {
        return immagine3;
    }

    public void setImmagine3(String immagine3) {
        this.immagine3 = immagine3;
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
