package vn.codegym.furama.service.main_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.main_model.ContractDetail;

import java.util.List;

@Service
public interface ContractDetailService {
    List<ContractDetail> findAll();

    ContractDetail findById(long id);

    void save(ContractDetail obj);

    void remove(long id);

    long count();

    // findAll() paging and sorting
    Page<ContractDetail> findAll(Pageable pageable);

    // find by ContractId or AttachServiceId
    Page<ContractDetail> findByAttachServiceName(Pageable pageable, String name);
}
