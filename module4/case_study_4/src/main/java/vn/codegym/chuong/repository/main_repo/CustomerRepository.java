package vn.codegym.chuong.repository.main_repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.main_model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findByCustomerNameContaining(Pageable pageable, String name);
    Page<Customer> findByCustomerType_CustomerTypeId(Pageable pageable, Long id);
}
