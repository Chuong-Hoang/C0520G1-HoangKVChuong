package vn.codegym.chuong.repository.sub_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.sub_model.Division;

public interface DivisionRepository extends JpaRepository<Division, Long> {
}
