package vn.codegym.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
