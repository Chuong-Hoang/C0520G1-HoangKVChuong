package vn.codegym.chuong.repository.test_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.test_model.QuestionType;

public interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {
}
