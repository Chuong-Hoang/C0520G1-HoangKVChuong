package vn.codegym.service;

import org.springframework.stereotype.Service;
import vn.codegym.model.Student;

import java.util.List;
@Service
public interface StudentService {
    List<Student> findAll();

    void save(Student t);

    Student findById(int id);

    void update(Student t);

    void remove(int id);
}
