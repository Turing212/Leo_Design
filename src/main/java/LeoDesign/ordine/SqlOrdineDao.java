package LeoDesign.ordine;

import LeoDesign.carrello.Carrello;
import LeoDesign.categoria.Categoria;
import LeoDesign.categoria.CategoriaExtractor;
import LeoDesign.magazzino.Magazzino;
import LeoDesign.magazzino.MagazzinoExtractor;
import LeoDesign.prodotto.Prodotto;
import LeoDesign.prodotto.ProdottoExtractor;
import LeoDesign.storage.Manager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class SqlOrdineDao extends Manager implements OrdineDao{
    private static final OrdineQuery QUERY = new OrdineQuery("Ordine");
    public SqlOrdineDao(DataSource source) {
        super(source);
    }

    @Override
    public List<Ordine> fetchOrdini() throws Exception {
        return null;
    }

    @Override
    public List<Ordine> fetchOrdiniWithProdotti(int idAccount) throws Exception {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectOrdiniWithProdotti())) {
                ps.setInt(1, idAccount);
                ResultSet set = ps.executeQuery();
                Map<Integer, Ordine> ordineMap = new LinkedHashMap<>();
                OrdineExtractor ordineExtractor = new OrdineExtractor();
                ProdottoExtractor prodottoExtractor = new ProdottoExtractor();
                CategoriaExtractor categoriaExtractor = new CategoriaExtractor();
                MagazzinoExtractor magazzinoExtractor = new MagazzinoExtractor();
                while (set.next()){
                    int idOrdine = set.getInt("ordine.idOrdine");
                    if(!ordineMap.containsKey(idOrdine)){
                        Ordine ordine = ordineExtractor.extract(set);
                        ordine.setCarrello(new Carrello(new ArrayList<>()));
                        ordineMap.put(idOrdine, ordine);
                    }
                    Prodotto prodotto = prodottoExtractor.extract(set);
                    Categoria categoria = categoriaExtractor.extract(set);
                    Magazzino magazzino = magazzinoExtractor.extract(set);
                    prodotto.setCategoria(categoria);
                    prodotto.setMagazzino(magazzino);
                    ordineMap.get(idOrdine).getCarrello().addProdotto(prodotto, set.getInt("PO.quantita"));
                }
                return new ArrayList<>(ordineMap.values());
            }
        }
    }

    @Override
    public Optional<Ordine> fetchOrdine(int id) throws Exception {
        return Optional.empty();
    }

    @Override
    public boolean createOrdine(Ordine ordine) throws Exception {
        return false;
    }
}
