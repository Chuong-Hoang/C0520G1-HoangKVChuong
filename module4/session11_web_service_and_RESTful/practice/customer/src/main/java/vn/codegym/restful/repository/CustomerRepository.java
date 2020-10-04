package vn.codegym.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.restful.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
