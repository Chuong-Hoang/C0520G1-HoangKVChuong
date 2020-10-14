package vn.codegym.furama.service.main_service.main_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.main_model.Contract;
import vn.codegym.furama.model.main_model.ContractDetail;
import vn.codegym.furama.repository.main_repo.ContractDetailRepository;
import vn.codegym.furama.repository.main_repo.ContractRepository;
import vn.codegym.furama.service.main_service.ContractDetailService;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository xRepository;
    @Override
    public List<ContractDetail> findAll() {
        return xRepository.findAll();
    }

    @Override
    public ContractDetail findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail obj) {
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
    public Page<ContractDetail> findAll(Pageable pageable) {
        return xRepository.findAll(pageable);
    }

    // find by ContractId or AttachServiceId
    @Override
    public Page<ContractDetail> findByAttachServiceName(Pageable pageable, String name) {
        return xRepository.findByAttachService_AttachServiceNameContaining(pageable, name);
    }

}
