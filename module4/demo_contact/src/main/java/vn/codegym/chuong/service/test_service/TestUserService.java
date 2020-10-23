package vn.codegym.chuong.service.test_service;

import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.student_model.Student;
import vn.codegym.chuong.model.test_model.TestUser;

import java.util.List;

@Service
public interface TestUserService {
    List<TestUser> findAll();

    TestUser findById(long id);

    void save(TestUser obj);

    void remove(long id);
}
