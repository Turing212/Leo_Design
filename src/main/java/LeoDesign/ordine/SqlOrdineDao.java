package LeoDesign.ordine;

import LeoDesign.carrello.Carrello;
import LeoDesign.carrello.CarrelloItem;
import LeoDesign.categoria.Categoria;
import LeoDesign.categoria.CategoriaExtractor;
import LeoDesign.magazzino.Magazzino;
import LeoDesign.magazzino.MagazzinoExtractor;
import LeoDesign.prodotto.Prodotto;
import LeoDesign.prodotto.ProdottoExtractor;
import LeoDesign.storage.Manager;
import LeoDesign.storage.Paginator;

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
    public List<Ordine> fetchOrdini(Paginator paginator) throws Exception {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectOrdini())) {
                ps.setInt(1, paginator.getOffset());
                ps.setInt(2, paginator.getLimit());
                ResultSet set = ps.executeQuery();
                OrdineExtractor ordineExtractor = new OrdineExtractor();
                List<Ordine> ordini = new ArrayList<>();
                while (set.next()) {
                    ordini.add(ordineExtractor.extract(set));
                }
                return ordini;
            }
        }
    }

    @Override
    public List<Ordine> fetchOrdiniWithProdotti(int idAccount, Paginator paginator) throws Exception {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectOrdiniWithProdotti())) {
                ps.setInt(1, idAccount);
                ps.setInt(2, paginator.getOffset());
                ps.setInt(3, paginator.getLimit());
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
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectOrdine())) {
                ps.setInt(1, id);
                ResultSet set = ps.executeQuery();
                OrdineExtractor ordineExtractor = new OrdineExtractor();
                Ordine ordine = null;
                if (set.next()) {
                    ordine = ordineExtractor.extract(set);
                }
                return Optional.ofNullable(ordine);
            }
        }
    }

    @Override
    public boolean createOrdine(Ordine ordine) throws Exception {
        try(Connection conn = source.getConnection()){
            conn.setAutoCommit(false);
            try(
                    PreparedStatement ps = conn.prepareStatement(QUERY.createOrdine());
                    PreparedStatement ps2 = conn.prepareStatement(QUERY.insertCarrello())
            ) {
                int rows = ps.executeUpdate();
                int total = rows;
                for(CarrelloItem item : ordine.getCarrello().getItems()) {
                    ps2.setInt(1, item.getProdotto().getIdProdotto());
                    ps2.setInt(2, ordine.getIDordine());
                    ps2.setInt(3, item.getQuantita());
                    total += ps2.executeUpdate();
                }
                if(total == (rows + ordine.entrate())) {
                    conn.commit();
                    conn.setAutoCommit(true);
                    return true;
                } else {
                    conn.rollback();
                    conn.setAutoCommit(true);
                    return false;
                }
            }
        }
    }

    @Override
    public boolean updateOrdine(String stato, int id) throws Exception {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.updateOrdine())) {
                ps.setString(1, stato);
                ps.setInt(2, id);
                int rows = ps.executeUpdate();
                return rows == 1;

            }
        }
    }
}
