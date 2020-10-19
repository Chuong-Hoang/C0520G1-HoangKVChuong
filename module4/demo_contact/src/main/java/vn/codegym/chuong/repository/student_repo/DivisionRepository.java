package vn.codegym.chuong.repository.student_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.student_model.Division;

public interface DivisionRepository extends JpaRepository<Division, Long> {
}
