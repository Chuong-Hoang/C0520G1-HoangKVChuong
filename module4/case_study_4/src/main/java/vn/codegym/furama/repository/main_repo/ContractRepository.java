package vn.codegym.furama.repository.main_repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.main_model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Page<Contract> findByContractStartDateContainingOrContractEndDateContaining(Pageable pageable, String d1, String d2);
}
