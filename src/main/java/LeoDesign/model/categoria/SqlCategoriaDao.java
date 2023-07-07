package LeoDesign.model.categoria;

import LeoDesign.model.storage.ConnManager;
import LeoDesign.model.prodotto.ProdottoExtractor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlCategoriaDao implements CategoriaDao{
    private static final CategoriaQuery QUERY = new CategoriaQuery("categoria");


    @Override
    public List<Categoria> fetchCategorie() throws SQLException {
        try(Connection conn = ConnManager.getConnection()){
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
    public Categoria fetchCategoriaById(int id) throws SQLException {
        try(Connection conn = ConnManager.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectCategoria())) {
                ps.setInt(1,id);
                ResultSet set = ps.executeQuery();
                Categoria categoria = null;
                while (set.next()){
                    CategoriaExtractor categoriaExtractor = new CategoriaExtractor();
                     categoria = categoriaExtractor.extract(set);

                }
                set.close();
                return categoria;
            }
        }
    }

    @Override
    public boolean createCategoria(Categoria categoria) throws SQLException {
        try(Connection conn = ConnManager.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.insertCategoria())) {
                ps.setString(1, categoria.getTitolo());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean updateCategoria(Categoria categoria) throws SQLException {
        try(Connection conn = ConnManager.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.updateCategoria())) {
                ps.setString(1, categoria.getTitolo());
                ps.setInt(2, categoria.getId());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public Categoria fetchCategoriaWithProdotti(int categoriaId) throws SQLException {
        try(Connection conn = ConnManager.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectCategoriaWithProdotti())) {
                ps.setInt(1,categoriaId);
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
                return categoria;
            }
        }
    }
}
