package vn.codegym.furama.service.sub_service;

import org.springframework.stereotype.Service;
import vn.codegym.furama.model.sub_model.RentType;

import java.util.List;

@Service
public interface RentTypeService {
    List<RentType> findAll();

    RentType findById(long id);

    void save(RentType obj);

    void remove(long id);
}
