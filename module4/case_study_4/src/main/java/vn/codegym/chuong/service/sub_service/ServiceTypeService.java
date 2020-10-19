package vn.codegym.chuong.service.sub_service;

import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.sub_model.ServiceType;

import java.util.List;

@Service
public interface ServiceTypeService {
    List<ServiceType> findAll();

    ServiceType findById(long id);

    void save(ServiceType obj);

    void remove(long id);
}
