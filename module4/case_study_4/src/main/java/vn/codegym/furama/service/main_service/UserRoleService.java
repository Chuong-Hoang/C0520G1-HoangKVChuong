package vn.codegym.furama.service.main_service;

import org.springframework.stereotype.Service;
import vn.codegym.furama.model.main_model.UserRole;

import java.util.List;

@Service
public interface UserRoleService {
    List<UserRole> findAll();

    UserRole findById(long id);

    void save(UserRole obj);

    void remove(long id);
}
