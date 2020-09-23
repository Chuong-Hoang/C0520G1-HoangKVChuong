package vn.codegym.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(String id);

    void save(T el);

    void update(String id, T el);

    void remove(String id);
}
