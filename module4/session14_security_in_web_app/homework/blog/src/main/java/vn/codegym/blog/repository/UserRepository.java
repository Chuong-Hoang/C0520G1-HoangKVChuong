package vn.codegym.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
