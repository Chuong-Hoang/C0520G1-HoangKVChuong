package vn.codegym.chuong.service.main_service.main_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.main_model.Employee;
import vn.codegym.chuong.repository.main_repo.EmployeeRepository;
import vn.codegym.chuong.service.main_service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository xRepository;
    @Override
    public List<Employee> findAll() {
        return xRepository.findAll();
    }

    @Override
    public Employee findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee obj) {
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
    public Page<Employee> findAll(Pageable pageable) {
        return xRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findByEmployeeName(Pageable pageable, String name) {
        return xRepository.findByEmployeeNameContaining(pageable, name);
    }
}
