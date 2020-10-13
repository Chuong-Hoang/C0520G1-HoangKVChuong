package vn.codegym.furama.service.sub_service;

import org.springframework.stereotype.Service;
import vn.codegym.furama.model.sub_model.CustomerType;

import java.util.List;

@Service
public interface CustomerTypeService {
    List<CustomerType> findAll();

    CustomerType findById(long id);

    void save(CustomerType obj);

    void remove(long id);
}
