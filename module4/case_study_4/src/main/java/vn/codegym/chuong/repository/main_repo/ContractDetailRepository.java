package vn.codegym.chuong.repository.main_repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.main_model.ContractDetail;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Long> {
    Page<ContractDetail> findByAttachService_AttachServiceNameContaining(Pageable pageable, String name);
}
