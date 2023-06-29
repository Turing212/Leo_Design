package LeoDesign.prodotto;

import LeoDesign.categoria.CategoriaExtractor;

import LeoDesign.magazzino.MagazzinoExtractor;
import LeoDesign.storage.Manager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlProdottoDao extends Manager implements ProdottoDao {
    private static final ProdottoQuery QUERY = new ProdottoQuery("Prodotto");
    public SqlProdottoDao(DataSource source) {
        super(source);
    }

    @Override
    public List<Prodotto> fetchProdotti(int start, int end) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectProdotti())) {
                ps.setInt(1, start);
                ps.setInt(2, end);
                ResultSet set = ps.executeQuery();
                ProdottoExtractor prodottoExtractor = new ProdottoExtractor();
                CategoriaExtractor categoriaExtractor = new CategoriaExtractor();
                MagazzinoExtractor magazzinoExtractor = new MagazzinoExtractor();
                List<Prodotto> prodotti = new ArrayList<>();
                while (set.next()){
                    Prodotto prodotto = prodottoExtractor.extract(set);
                    prodotto.setCategoria(categoriaExtractor.extract(set));
                    prodotto.setMagazzino(magazzinoExtractor.extract(set));
                    prodotti.add(prodotto);
                }
                set.close();
                return prodotti;
            }
        }
    }

    @Override
    public Optional<Prodotto> fetchProdotto(int id) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectProdotto())) {
                ps.setInt(1, id);
                ResultSet set = ps.executeQuery();
                Prodotto prodotto = null;
                if (set.next()) {
                    ProdottoExtractor prodottoExtractor = new ProdottoExtractor();
                    CategoriaExtractor categoriaExtractor = new CategoriaExtractor();
                    MagazzinoExtractor magazzinoExtractor = new MagazzinoExtractor();
                    prodotto = prodottoExtractor.extract(set);
                    prodotto.setCategoria(categoriaExtractor.extract(set));
                    prodotto.setMagazzino(magazzinoExtractor.extract(set));
                }
                return Optional.ofNullable(prodotto);
            }
        }
    }

    @Override
    public boolean createProdotto(Prodotto prodotto) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.insertProdotto())) {
                ps.setString(1, prodotto.getNome());
                ps.setString(2, prodotto.getDescrizione());
                ps.setFloat(3, prodotto.getPrezzo());
                ps.setFloat(4,prodotto.getPeso());
                ps.setString(5, prodotto.getImmagine1());
                ps.setString(6, prodotto.getImmagine2());
                ps.setString(7, prodotto.getImmagine3());
                ps.setInt(8, prodotto.getMagazzino().getIDmagazzino());
                ps.setInt(9, prodotto.getCategoria().getId());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean updateProdotto(Prodotto prodotto) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.updateProdotto())) {
                ps.setString(1, prodotto.getNome());
                ps.setString(2, prodotto.getDescrizione());
                ps.setFloat(3, prodotto.getPrezzo());
                ps.setFloat(4,prodotto.getPeso());
                ps.setString(5, prodotto.getImmagine1());
                ps.setString(6, prodotto.getImmagine2());
                ps.setString(7, prodotto.getImmagine3());
                ps.setInt(8, prodotto.getMagazzino().getIDmagazzino());
                ps.setInt(9, prodotto.getCategoria().getId());
                ps.setInt(10, prodotto.getIdProdotto());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean deleteProdotto(int id) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.deleteProdotto())) {
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }
}
