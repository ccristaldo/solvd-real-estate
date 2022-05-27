package dao;

import java.util.List;

public interface IDAOBase<T,K> {
    T getById(K id);
    List<T> getAll();
    void save(T o);
    void update(T o);
    void delete(K id);
}
