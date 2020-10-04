package vn.codegym.user.service;

import vn.codegym.user.exception.DuplicateEmailException;
import vn.codegym.user.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    void save(User el) throws DuplicateEmailException;

   void remove(int id);

   // check email exists
    User findUserByEmail(String email);
}
