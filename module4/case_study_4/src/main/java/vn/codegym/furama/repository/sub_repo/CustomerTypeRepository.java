package vn.codegym.furama.repository.sub_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.sub_model.CustomerType;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
