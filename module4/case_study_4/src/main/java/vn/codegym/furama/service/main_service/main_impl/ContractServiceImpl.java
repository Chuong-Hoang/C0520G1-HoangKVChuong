package vn.codegym.furama.service.main_service.main_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.main_model.Contract;
import vn.codegym.furama.model.main_model.Employee;
import vn.codegym.furama.repository.main_repo.ContractRepository;
import vn.codegym.furama.repository.main_repo.EmployeeRepository;
import vn.codegym.furama.service.main_service.ContractService;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository xRepository;
    @Override
    public List<Contract> findAll() {
        return xRepository.findAll();
    }

    @Override
    public Contract findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }

    @Override
    public long count() {
        return xRepository.count();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return xRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findByDate(Pageable pageable, String str) {
        return xRepository.findByContractStartDateContainingOrContractEndDateContaining(pageable, str, str);
    }

}
