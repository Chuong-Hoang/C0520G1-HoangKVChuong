package vn.codegym.chuong.service.main_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.main_model.Customer;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> findAll();

    Customer findById(long id);

    void save(Customer obj);

    void remove(long id);

    long count();

    // findAll() paging and sorting
    Page<Customer> findAll(Pageable pageable);

    // find by name
    Page<Customer> findByCustomerName(Pageable pageable, String name);

    // find by CustomerType
    Page<Customer> findByCustomerType(Pageable pageable, Long id);
}
