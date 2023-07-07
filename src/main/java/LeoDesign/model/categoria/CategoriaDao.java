package LeoDesign.model.categoria;

import java.sql.SQLException;
import java.util.List;

public interface CategoriaDao {
    List<Categoria> fetchCategorie() throws SQLException;
    Categoria fetchCategoriaById(int id) throws SQLException;
    boolean createCategoria(Categoria categoria) throws SQLException;
    boolean updateCategoria(Categoria categoria) throws SQLException;
    Categoria fetchCategoriaWithProdotti(int categoriaId) throws SQLException;
}
