package service.implemented;

import dao.IDAOApt;
import dao.implemented.AptDAOImplemented;
import service.IAptService;
import model.apt.Apt;

import java.sql.Connection;
import java.util.List;

public class AptImplemented implements IAptService {

    private Connection conn;

    public AptImplemented(){}

    public AptImplemented(Connection conn){
        this.conn = conn;
    }

    @Override
    public void create(Apt a) {
        IDAOApt aptDAO = new AptDAOImplemented(conn);
        aptDAO.save(a);
    }

    @Override
    public void getById(int id) {


    }

    @Override
    public List<Apt> getAll() {
        return null;
    }

    @Override
    public void update(Apt a) {

    }

    @Override
    public void delete(int id) {

    }
}
