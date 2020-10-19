package vn.codegym.chuong.service.student_service;

import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.student_model.Division;

import java.util.List;

@Service
public interface DivisionService {
    List<Division> findAll();

    Division findById(long id);

    void save(Division obj);

    void remove(long id);
}
