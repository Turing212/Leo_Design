package LeoDesign.model.magazzino;

import LeoDesign.model.storage.ConnManager;
import LeoDesign.model.components.Paginator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlMagazzinoDao implements MagazzinoDao {
    private static final MagazzinoQuery QUERY = new MagazzinoQuery("Magazzino");

    @Override
    public List<Magazzino> fetchMagazzini(Paginator paginator) throws SQLException {
        try(Connection conn = ConnManager.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectMagazzini())) {
                ps.setInt(1, paginator.getOffset());
                ps.setInt(2, paginator.getLimit());
                ResultSet set = ps.executeQuery();
                MagazzinoExtractor magazzinoExtractor = new MagazzinoExtractor();
                List<Magazzino> magazzini = new ArrayList<>();
                while (set.next()){
                    Magazzino magazzino = magazzinoExtractor.extract(set);
                    magazzini.add(magazzino);
                }
                set.close();
                return magazzini;
            }
        }
    }

    @Override
    public Magazzino fetchMagazzino(int id) throws SQLException {
        try(Connection conn = ConnManager.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.selectMagazzino())) {
                ps.setInt(1, id);
                ResultSet set = ps.executeQuery();
                MagazzinoExtractor magazzinoExtractor = new MagazzinoExtractor();
                Magazzino magazzino = null;
                if (set.next()) {
                    magazzino = magazzinoExtractor.extract(set);
                }
                return magazzino;
            }
        }
    }

    @Override
    public boolean createMagazzino(Magazzino magazzino) throws SQLException {
        try(Connection conn = ConnManager.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.insertMagazzino())) {
                ps.setInt(1, magazzino.getIDmagazzino());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean updateMagazzino(Magazzino magazzino) throws SQLException {
        try(Connection conn = ConnManager.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.updateMagazzino())) {
                ps.setString(1, magazzino.getNomeMagazzino());
                ps.setInt(2, magazzino.getIDmagazzino());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean deleteMagazzino(int id) throws SQLException {
        try(Connection conn = ConnManager.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(QUERY.deleteMagazzino())) {
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }
}
