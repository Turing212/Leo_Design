package LeoDesign.categoria;
import LeoDesign.storage.ResultSetExtractor;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CategoriaExtractor implements ResultSetExtractor {
    @Override
    public Categoria extract(ResultSet resultSet) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getInt("idCategoria"));
        categoria.setTitolo(resultSet.getString("titolo"));
        return categoria;
    }
}
