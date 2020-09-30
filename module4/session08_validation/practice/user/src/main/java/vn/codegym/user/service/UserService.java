package vn.codegym.user.service;

import vn.codegym.user.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    void save(User el);

   void remove(int id);
}
