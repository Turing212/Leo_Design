package LeoDesign.Carta;

import LeoDesign.account.AccountExtractor;
import LeoDesign.magazzino.Magazzino;
import LeoDesign.magazzino.MagazzinoExtractor;
import LeoDesign.magazzino.MagazzinoQuery;
import LeoDesign.ordine.OrdineExtractor;
import LeoDesign.storage.Manager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SqlCartaDao extends Manager implements CartaDao {
    private static final CartaQuery QUERY = new CartaQuery("CartaDiCredito");
    public SqlCartaDao(DataSource source) {
        super(source);
    }

    @Override
    public Optional<Carta> fetchCarta(int id) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectCarta())) {
                ps.setInt(1, id);
                ResultSet set = ps.executeQuery();

                Carta carta = null;
                if (set.next()) {
                    CartaExtractor cartaExtractor = new CartaExtractor();
                    OrdineExtractor ordineExtractor = new OrdineExtractor();
                    carta = cartaExtractor.extract(set);
                    carta.setOrdine(ordineExtractor.extract(set));
                }
                return Optional.ofNullable(carta);
            }
        }
    }

    @Override
    public boolean createCarta(Carta carta) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.insertCarta())) {
                ps.setString(1, carta.getNumero());
                ps.setInt(2, carta.getOrdine().getIDordine());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean updateCarta(Carta carta) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.updateCarta())) {
                ps.setString(1, carta.getNumero());
                ps.setInt(2, carta.getOrdine().getIDordine());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean deleteCarta(int id) throws SQLException {
        try(Connection conn = source.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.deleteCarta())) {
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }
}
