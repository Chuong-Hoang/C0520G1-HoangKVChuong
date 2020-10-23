package vn.codegym.chuong.repository.test_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.test_model.TestUser;

public interface TestUserRepository extends JpaRepository<TestUser, Long> {
}
