package vn.codegym.furama.service.main_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.main_model.Employee;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(long id);

    void save(Employee obj);

    void remove(long id);

    long count();

    // findAll() paging and sorting
    Page<Employee> findAll(Pageable pageable);

    // find by name
    Page<Employee> findByEmployeeName(Pageable pageable, String name);
}
