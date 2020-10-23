package vn.codegym.chuong.service.test_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.student_model.Student;
import vn.codegym.chuong.model.test_model.QuestionType;
import vn.codegym.chuong.repository.student_repo.StudentRepository;
import vn.codegym.chuong.repository.test_repo.QuestionTypeRepository;

import java.util.List;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {
    @Autowired
    private QuestionTypeRepository xRepository;

    @Override
    public List<QuestionType> findAll() {
        return xRepository.findAll();
    }

    @Override
    public QuestionType findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(QuestionType obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }

}
