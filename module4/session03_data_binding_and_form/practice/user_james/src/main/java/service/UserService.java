package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User el);

    User findById(String id);

    void update(String id, User el);

    void remove(String id);
}
