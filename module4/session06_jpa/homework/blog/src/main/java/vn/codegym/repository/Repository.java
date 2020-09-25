package vn.codegym.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(int id);

    void save(T obj);

    void update(T obj);

    void remove(int id);
}
