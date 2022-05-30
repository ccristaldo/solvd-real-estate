package dao.implemented;

import controller.apt.AptController;
import controller.functionalInterfaces.IFiltering;
import controller.functionalInterfaces.IPrinting;
import dao.IDAOApt;
import enums.Operation;
import enums.Zones;
import exceptions.CustomSQLException;
import exceptions.GeneralException;
import model.apt.Apt;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AptDAOImplemented implements IDAOApt {

    //TODO: order by getFields (Reflection)
    private static final Logger LOGGER = LogManager.getLogger(AptDAOImplemented.class);
    final String GETALL = "SELECT * FROM apt";
    final String INSERT = "INSERT INTO `apt`(`address`, `zone`, `operation`, `cost`, `dimension`, `rooms`, `active`) VALUES (?,?,?,?,?,?,?); ";
    final String GETONE = "SELECT * FROM apt WHERE id = ?";
    final String UPDATE = "UPDATE apt SET address =?, zone=?, operation= ?, cost=?, dimension=?, rooms=?, active=? WHERE id=?";

    AptController aptController = new AptController();

    Scanner sn = new Scanner(System.in);
    private Connection conn;

    public AptDAOImplemented(Connection conn){
        this.conn = conn;
    }

    public List<Apt> sortingActives(List<Apt> unsortedList){

        IFiltering<Apt> f = (uList) -> uList.stream().filter(apt -> apt.isActive()).collect(Collectors.toList());

        return f.filtering(unsortedList);
    }

    public void printer(Object o){
        IPrinting iPrinting = Object::toString;
        LOGGER.log(Level.INFO, iPrinting.printer(o) );
    }

    public void closeRsPs(ResultSet rs, PreparedStatement ps) throws CustomSQLException{
        if (rs != null){
            try{
                rs.close();
            } catch (SQLException e) {
                throw new CustomSQLException("Unable to close Result Set", e);
            }
        }
        if (ps != null){
            try{
                ps.close();
            } catch (SQLException e) {
               throw new CustomSQLException("Unable to close Prepared Statement", e);
            }
        }
    }

    public Apt mapper(ResultSet rs) throws SQLException {

        Apt temp = new Apt();

        temp.setId(rs.getInt(1));
        temp.setAddress(rs.getString(2));
        temp.setZone(Zones.valueOf(rs.getString(3)));
        temp.setOperation(Operation.valueOf(rs.getString(4)));
        temp.setCost(rs.getDouble(5));
        temp.setDimension(rs.getInt(6));
        temp.setRooms(rs.getInt(7));
        temp.setActive(rs.getBoolean(8));

        return temp;
    }
    @Override
    public Apt getById(Integer id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Apt a = null;
        try{
            ps = conn.prepareStatement(GETONE);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                a = mapper(rs);
            }else{
                throw new CustomSQLException("Return value is null");
            }
        } catch (SQLException e) {
            throw new CustomSQLException("Error while executing SQL", e);
        }finally{
            closeRsPs(rs, ps);
        }

        printer(a);

        return a;

    }

    @Override
    public List<Apt> getAll() {

        int option;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Apt> aptList = new ArrayList<>();
        List<Apt> output = new ArrayList<>();
        try{
            ps = conn.prepareStatement(GETALL);
            rs = ps.executeQuery();

            while(rs.next()){
               // if (rs.getBoolean(8)){
                    aptList.add(mapper(rs));
               // }
            }

        } catch (SQLException e) {
            throw new GeneralException("Error while executing SQL");
        }finally{
            closeRsPs(rs, ps);
        }

        LOGGER.log(Level.INFO, "Select: \n 1 - All Apartments \n 2 - Only actives");
        option = sn.nextInt();
        while (option != 1 && option != 2){
            LOGGER.log(Level.WARN, "Wrong input. Try again\n" + "Select: \n 1 - All Apartments \n 2 - Only actives");
            option = sn.nextInt();
        }

        if (option == 1){
            aptList.forEach(this::printer);
            return aptList;
        }else{
            output = sortingActives(aptList);
            output.forEach(this::printer);
            return output;
        }

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
               throw new CustomSQLException("Error processing SQL Statement");
            }
        } catch (SQLException e) {
            throw new CustomSQLException("SQL Error", e);
        } finally {
            closeRsPs(rs, ps);
        }
    }

    @Override
    public void update(Integer id) {

        //"UPDATE apt SET
        // address =?, zone=?, operation= ?, cost=?, dimension=?, rooms=?, active=? WHERE id=?";
        Apt o = aptController.loadApt();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, o.getAddress());
            ps.setString(2, o.getZone().name());
            ps.setString(3, o.getOperation().name());
            ps.setDouble(4, o.getCost());
            ps.setInt(5, o.getDimension());
            ps.setInt(6, o.getRooms());
            ps.setBoolean(7, o.isActive());
            ps.setInt(8, id);


            if (ps.executeUpdate() == 0){
                throw new CustomSQLException("Error processing SQL Statement");
            }
        } catch (SQLException e) {
            throw new CustomSQLException("SQL Error", e);
        } finally {
            closeRsPs(rs, ps);
        }
    }

    @Override
    public void delete(Integer id) {

        LOGGER.log(Level.OFF, "Apartment selected for deletion:\n");

        getById(id).setActive(false);

    }
}
