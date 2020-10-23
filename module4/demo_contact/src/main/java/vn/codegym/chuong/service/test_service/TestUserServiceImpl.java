package vn.codegym.chuong.service.test_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.student_model.Student;
import vn.codegym.chuong.model.test_model.TestUser;
import vn.codegym.chuong.repository.student_repo.StudentRepository;
import vn.codegym.chuong.repository.test_repo.TestUserRepository;

import java.util.List;

@Service
public class TestUserServiceImpl implements TestUserService {
    @Autowired
    private TestUserRepository xRepository;

    @Override
    public List<TestUser> findAll() {
        return xRepository.findAll();
    }

    @Override
    public TestUser findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(TestUser obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }
}
