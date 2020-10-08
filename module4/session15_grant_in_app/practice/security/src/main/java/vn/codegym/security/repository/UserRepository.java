package vn.codegym.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.security.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
