package vn.codegym.chuong.service.test_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.test_model.Question;
import vn.codegym.chuong.model.test_model.QuestionType;

import java.util.List;

@Service
public interface QuestionService {
    List<Question> findAll();

    Question findById(long id);

    void save(Question obj);

    void remove(long id);

    List<Question> findByTitle(String title);
}
