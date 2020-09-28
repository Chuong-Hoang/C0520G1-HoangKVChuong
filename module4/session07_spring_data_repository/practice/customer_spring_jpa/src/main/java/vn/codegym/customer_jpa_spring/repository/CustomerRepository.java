package vn.codegym.customer_jpa_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.customer_jpa_spring.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public void deleteByIdIn(List<Integer> ids);
}
