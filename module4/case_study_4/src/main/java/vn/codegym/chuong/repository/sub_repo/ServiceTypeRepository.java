package vn.codegym.chuong.repository.sub_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.sub_model.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
