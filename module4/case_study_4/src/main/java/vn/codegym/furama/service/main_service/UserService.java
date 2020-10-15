package vn.codegym.furama.service.main_service;

import org.springframework.stereotype.Service;
import vn.codegym.furama.model.security_model.User;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();

    User findById(long id);

    void save(User obj);

    void remove(long id);

    // find by name
    User findByUserName(String name);
}
