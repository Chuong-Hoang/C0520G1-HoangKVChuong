package vn.codegym.chuong.repository.main_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.security_model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String name);
}
