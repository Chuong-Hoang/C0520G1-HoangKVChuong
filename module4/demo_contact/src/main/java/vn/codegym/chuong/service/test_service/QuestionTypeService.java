package vn.codegym.chuong.service.test_service;

import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.test_model.QuestionType;
import vn.codegym.chuong.model.test_model.TestUser;

import java.util.List;

@Service
public interface QuestionTypeService {
    List<QuestionType> findAll();

    QuestionType findById(long id);

    void save(QuestionType obj);

    void remove(long id);
}
