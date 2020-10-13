package vn.codegym.furama.service.sub_service;

import org.springframework.stereotype.Service;
import vn.codegym.furama.model.sub_model.EducationDegree;
import vn.codegym.furama.model.sub_model.Position;

import java.util.List;

@Service
public interface EducationDegreeService {
    List<EducationDegree> findAll();

    EducationDegree findById(long id);

    void save(EducationDegree obj);

    void remove(long id);
}
