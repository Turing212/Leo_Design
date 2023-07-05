package LeoDesign.model.categoria;

import LeoDesign.model.storage.Manager;
import LeoDesign.model.prodotto.ProdottoExtractor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlCategoriaDao extends Manager implements CategoriaDao{
    private static final CategoriaQuery QUERY = new CategoriaQuery("categoria");
    public SqlCategoriaDao(DataSource source) {
        super(source);
    }

    @Override
    public List<Categoria> fetchCategorie() throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectCategorie())) {
                ResultSet set = ps.executeQuery();
                List<Categoria> categorie = new ArrayList<>();
                while (set.next()){
                    CategoriaExtractor categoriaExtractor = new CategoriaExtractor();
                    Categoria categoria = categoriaExtractor.extract(set);
                    categorie.add(categoria);
                }
                set.close();
                return categorie;
            }
        }
    }

    @Override
    public boolean createCategoria(Categoria categoria) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.insertCategoria())) {
                ps.setString(1, categoria.getTitolo());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean updateCategoria(Categoria categoria) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.updateCategoria())) {
                ps.setString(1, categoria.getTitolo());
                ps.setInt(2, categoria.getId());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public Optional<Categoria> fetchCategoriaWithProdotti(int categoriaId) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectCategoriaWithProdotti())) {
                ResultSet set = ps.executeQuery();
                CategoriaExtractor categoriaExtractor = new CategoriaExtractor();
                Categoria categoria = null;
                if (set.next()) {
                    categoria = categoriaExtractor.extract(set);
                    categoria.setProdotti(new ArrayList<>());
                    ProdottoExtractor prodottoExtractor = new ProdottoExtractor();
                    categoria.getProdotti().add(prodottoExtractor.extract(set));
                    while (set.next()){
                        categoria.getProdotti().add(prodottoExtractor.extract(set));
                    }

                }
                return Optional.ofNullable(categoria);
            }
        }
    }
}
