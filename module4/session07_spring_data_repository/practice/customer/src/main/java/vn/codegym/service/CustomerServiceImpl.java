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
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findOne(int id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void save(Customer el) {
        customerRepository.save(el);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }
}
