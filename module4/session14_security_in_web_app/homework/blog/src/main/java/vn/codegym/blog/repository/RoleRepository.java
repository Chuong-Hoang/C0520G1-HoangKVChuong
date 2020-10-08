package vn.codegym.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.blog.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
