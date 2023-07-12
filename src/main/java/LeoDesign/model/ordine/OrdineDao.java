package LeoDesign.model.ordine;

import LeoDesign.model.components.Paginator;

import java.util.List;
import java.util.Optional;

public interface OrdineDao<E extends Exception>{
    List<Ordine> fetchOrdini(Paginator paginator) throws E;
    List<Ordine> fetchOrdiniWithProdotti(int idAccount, Paginator paginator) throws E;
    Optional<Ordine> fetchOrdine(int id) throws E;
    boolean createOrdine(Ordine ordine) throws E;
    boolean updateOrdine(String stato, int id) throws E;
}
