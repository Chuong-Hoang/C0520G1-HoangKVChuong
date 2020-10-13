package vn.codegym.furama.service.sub_service;

import org.springframework.stereotype.Service;
import vn.codegym.furama.model.sub_model.ServiceType;

import java.util.List;

@Service
public interface ServiceTypeService {
    List<ServiceType> findAll();

    ServiceType findById(long id);

    void save(ServiceType obj);

    void remove(long id);
}
