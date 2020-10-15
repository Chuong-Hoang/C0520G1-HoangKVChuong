package vn.codegym.furama.repository.main_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.security_model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String name);
}
