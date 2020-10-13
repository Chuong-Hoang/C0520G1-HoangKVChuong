package vn.codegym.furama.repository.main_repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.main_model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByEmployeeNameContaining(Pageable pageable, String name);
}
