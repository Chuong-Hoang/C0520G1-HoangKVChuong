package vn.codegym.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(int id);

    void save(T el);

    void update(int id, T el);

    void remove(int id);
}
