package vn.codegym.chuong.repository.security_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.security_model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String name);
}
