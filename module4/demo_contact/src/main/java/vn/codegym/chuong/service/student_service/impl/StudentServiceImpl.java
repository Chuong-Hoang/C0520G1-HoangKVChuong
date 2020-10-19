package vn.codegym.chuong.service.student_service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.student_model.Student;
import vn.codegym.chuong.repository.student_repo.StudentRepository;
import vn.codegym.chuong.service.student_service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository xRepository;

    @Override
    public List<Student> findAll() {
        return xRepository.findAll();
    }

    @Override
    public Student findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }

    @Override
    public long count() {
        return xRepository.count();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return xRepository.findAll(pageable);
    }

    // find by 3 field
    @Override
    public Page<Student> findByNameAddressEmail(Pageable pageable, String text) {
        return xRepository.findContactByNameContainingOrAddressContainingOrEmailContainingOrderByName(pageable, text, text, text);
    }

    // find status true
    @Override
    public Page<Student> findAllByStatusTrue(Pageable pageable) {
        return xRepository.findAllByStatusTrue(pageable);
    }

    // find on many fields
    @Override
    public Page<Student> findByNameContaining(Pageable pageable, String str) {
        return xRepository.findByNameContaining(pageable, str);
    }

    @Override
    public Page<Student> findByBirthdayContaining(Pageable pageable, String str) {
        return xRepository.findByBirthdayContaining(pageable, str);
    }

    @Override
    public Page<Student> findByAddressContaining(Pageable pageable, String str) {
        return xRepository.findByAddressContaining(pageable, str);
    }
}
