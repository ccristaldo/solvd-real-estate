package dao.implemented;

import dao.IDAOApt;
import model.apt.Apt;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.MainMenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AptDAOImplemented implements IDAOApt {

    private static final Logger LOGGER = LogManager.getLogger(AptDAOImplemented.class);


    final String INSERT = "INSERT INTO `apt`(`address`, `zone`, `operation`, `cost`, `dimension`, `rooms`, `active`) VALUES (?,?,?,?,?,?,?); ";


    private Connection conn;

    public AptDAOImplemented(Connection conn){
        this.conn = conn;
    }

    public void closeRsPs(ResultSet rs, PreparedStatement ps){
        if (rs != null){
            try{
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                //new CustomSQLException("Unable to close Result Set", e);
            }
        }
        if (ps != null){
            try{
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
               // new CustomSQLException("Unable to close Prepared Statement", e);
            }
        }
    }
    @Override
    public Apt getById(Integer id) {
        return null;
    }

    @Override
    public List<Apt> getAll() {
        return null;
    }

    @Override
    public void save(Apt o) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, o.getAddress());
            ps.setString(2, o.getZone().name());
            ps.setString(3, o.getOperation().name());
            ps.setDouble(4, o.getCost());
            ps.setInt(5, o.getDimension());
            ps.setInt(6, o.getRooms());
            ps.setBoolean(7, o.isActive());

            if (ps.executeUpdate() == 0){
                LOGGER.log(Level.ERROR, "Error processing SQL Statement");
               // throw new CustomSQLException("Error processing SQL Statement");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "ESQL Error");
            //throw new CustomSQLException("SQL Error", e);
        } finally {
            closeRsPs(rs, ps);
        }
    }

    @Override
    public void update(Apt o) {

    }

    @Override
    public void delete(Integer id) {

    }
}
