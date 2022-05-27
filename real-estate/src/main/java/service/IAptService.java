package service;

import model.apt.Apt;

import java.util.List;

public interface IAptService {
    void create(Apt a);
    void getById(int id);
    List<Apt> getAll();
    void update(Apt a);
    void delete(int id);
}

