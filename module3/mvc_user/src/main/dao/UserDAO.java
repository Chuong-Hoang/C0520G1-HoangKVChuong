package main.dao;

import main.model.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();

    void save(User user);

    User findById(int id);

    List<User> findByName(String nameString);

    void update(int id, User user);

    void remove(int id);

    int getNextId();
}
