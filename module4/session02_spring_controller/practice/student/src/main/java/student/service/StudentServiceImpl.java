package student.service;

import student.model.Student;
import student.repository.StudentRepository;
import student.repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public void save(Student el) {
        this.studentRepository.save(el);
    }

    @Override
    public Student findById(String id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public void update(String id, Student el) {
        this.studentRepository.update(id, el);
    }

    @Override
    public void remove(String id) {
        this.studentRepository.remove(id);
    }
}
