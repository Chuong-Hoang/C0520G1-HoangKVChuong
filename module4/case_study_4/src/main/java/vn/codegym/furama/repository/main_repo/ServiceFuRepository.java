package vn.codegym.furama.repository.main_repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.main_model.Service;

public interface ServiceFuRepository extends JpaRepository<Service, Long> {
    Page<Service> findByServiceNameContaining(Pageable pageable, String name);
}
