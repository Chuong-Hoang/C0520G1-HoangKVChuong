package vn.codegym.chuong.service.main_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.chuong.model.main_model.Service;

import java.util.List;

@org.springframework.stereotype.Service
public interface ServiceFuService {
    List<Service> findAll();

    Service findById(long id);

    void save(Service obj);

    void remove(long id);

    long count();

    // findAll() paging and sorting
    Page<Service> findAll(Pageable pageable);

    // find by serviceName
    Page<Service> findByServiceNameContaining(Pageable pageable, String name);

}
