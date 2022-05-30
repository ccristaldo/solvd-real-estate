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
        IDAOApt aptDAO = new AptDAOImplemented(conn);
        aptDAO.getById(id);

    }

    @Override
    public List<Apt> getAll() {
        IDAOApt aptDAO = new AptDAOImplemented(conn);
        return aptDAO.getAll();
    }

    @Override
    public void update(int id) {
        IDAOApt aptDAO = new AptDAOImplemented(conn);
        aptDAO.update(id);
    }

    @Override
    public void delete(int id) {
        IDAOApt aptDAO = new AptDAOImplemented(conn);
        aptDAO.delete(id);
    }
}
