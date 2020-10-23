package vn.codegym.chuong.service.test_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.test_model.Question;
import vn.codegym.chuong.model.test_model.TestUser;
import vn.codegym.chuong.repository.test_repo.QuestionRepository;
import vn.codegym.chuong.repository.test_repo.TestUserRepository;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository xRepository;

    @Override
    public List<Question> findAll() {
        return xRepository.findAll();
    }

    @Override
    public Question findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Question obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }

    @Override
    public List<Question> findByTitle(String title) {
        return xRepository.findByTitleContaining(title);
    }
}
