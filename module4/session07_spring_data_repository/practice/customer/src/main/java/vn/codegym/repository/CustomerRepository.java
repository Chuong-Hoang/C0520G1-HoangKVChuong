package vn.codegym.repository;

import org.springframework.data.repository.CrudRepository;
import vn.codegym.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
