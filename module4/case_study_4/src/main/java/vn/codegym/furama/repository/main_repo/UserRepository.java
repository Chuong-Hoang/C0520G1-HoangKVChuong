package vn.codegym.furama.repository.main_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.main_model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
