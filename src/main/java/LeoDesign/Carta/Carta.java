package LeoDesign.Carta;

import LeoDesign.ordine.Ordine;

public class Carta {
    private int idPagamento;
    private String numero;
    private Ordine ordine;
    public Carta() {
        super();
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }
}
