package LeoDesign.model.categoria;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CategoriaDao {
    List<Categoria> fetchCategorie() throws SQLException;
    Categoria fetchCategoriaById(int id) throws SQLException;
    boolean createCategoria(Categoria categoria) throws SQLException;
    boolean updateCategoria(Categoria categoria) throws SQLException;
    Optional<Categoria> fetchCategoriaWithProdotti(int categoriaId) throws SQLException;
}
