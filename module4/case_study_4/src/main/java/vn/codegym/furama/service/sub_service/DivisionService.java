package vn.codegym.furama.service.sub_service;

import org.springframework.stereotype.Service;
import vn.codegym.furama.model.sub_model.Division;
import vn.codegym.furama.model.sub_model.RentType;

import java.util.List;

@Service
public interface DivisionService {
    List<Division> findAll();

    Division findById(long id);

    void save(Division obj);

    void remove(long id);
}
