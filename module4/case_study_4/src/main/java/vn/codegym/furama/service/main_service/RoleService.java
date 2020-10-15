package vn.codegym.furama.service.main_service;

import org.springframework.stereotype.Service;
import vn.codegym.furama.model.security_model.Role;

import java.util.List;

@Service
public interface RoleService {
    List<Role> findAll();

    Role findById(long id);

    void save(Role obj);

    void remove(long id);

    // find by name
    Role findByRoleName(String name);
}
