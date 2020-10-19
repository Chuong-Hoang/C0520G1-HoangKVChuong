package vn.codegym.chuong.service.student_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.student_model.Student;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();

    Student findById(long id);

    void save(Student obj);

    void remove(long id);

    long count();

    // findAll() paging and sorting
    Page<Student> findAll(Pageable pageable);

    // find by 3 fields
    Page<Student> findByNameAddressEmail(Pageable pageable, String text);

    // find status true
    Page<Student> findAllByStatusTrue(Pageable pageable);

    // search on each field
    Page<Student> findByNameContaining(Pageable pageable, String str);
    Page<Student> findByBirthdayContaining(Pageable pageable, String str);
    Page<Student> findByAddressContaining(Pageable pageable, String str);
}
