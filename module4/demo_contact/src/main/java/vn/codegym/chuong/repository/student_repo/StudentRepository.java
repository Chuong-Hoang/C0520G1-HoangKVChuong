package vn.codegym.chuong.repository.student_repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.student_model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findAllByStatusTrue(Pageable pageable);
    Page<Student> findContactByNameContainingOrAddressContainingOrEmailContainingOrderByName(Pageable pageable, String name, String address, String email);

    // search on many fields
    Page<Student> findByNameContaining(Pageable pageable, String str);
    Page<Student> findByBirthdayContaining(Pageable pageable, String str);
    Page<Student> findByAddressContaining(Pageable pageable, String str);
}
