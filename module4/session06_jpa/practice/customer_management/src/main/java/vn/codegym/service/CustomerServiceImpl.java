package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer el) {
        customerRepository.save(el);
    }

    @Override
    public void update(int id, Customer el) {
        customerRepository.update(id, el);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}
