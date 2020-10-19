package vn.codegym.chuong.service.main_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.main_model.Contract;

import java.util.List;

@Service
public interface ContractService {
    List<Contract> findAll();

    Contract findById(long id);

    void save(Contract obj);

    void remove(long id);

    long count();

    // findAll() paging and sorting
    Page<Contract> findAll(Pageable pageable);

    // find by StartDate or EndDate
    Page<Contract> findByDate(Pageable pageable, String str);
}
