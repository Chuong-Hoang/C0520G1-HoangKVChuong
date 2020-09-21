package student.service;

import student.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void save(Student el);

    Student findById(String id);

    void update(String id, Student el);

    void remove(String id);
}
