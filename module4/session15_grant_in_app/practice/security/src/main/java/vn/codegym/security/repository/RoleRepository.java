package vn.codegym.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.security.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
