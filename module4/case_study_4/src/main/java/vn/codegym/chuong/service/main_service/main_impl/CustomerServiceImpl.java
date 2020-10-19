package vn.codegym.chuong.service.main_service.main_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.main_model.Customer;
import vn.codegym.chuong.repository.main_repo.CustomerRepository;
import vn.codegym.chuong.service.main_service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer obj) {
        customerRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByCustomerName(Pageable pageable, String name) {
        return customerRepository.findByCustomerNameContaining(pageable, name);
    }

    @Override
    public Page<Customer> findByCustomerType(Pageable pageable, Long id) {
        return customerRepository.findByCustomerType_CustomerTypeId(pageable, id);
    }
}
