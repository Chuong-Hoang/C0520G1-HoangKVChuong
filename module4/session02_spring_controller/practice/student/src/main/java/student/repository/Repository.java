package student.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    void save(T el);

    T findById(String id);

    void update(String id, T el);

    void remove(String id);
}
