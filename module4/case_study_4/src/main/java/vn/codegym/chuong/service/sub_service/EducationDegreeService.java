package vn.codegym.chuong.service.sub_service;

import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.sub_model.EducationDegree;

import java.util.List;

@Service
public interface EducationDegreeService {
    List<EducationDegree> findAll();

    EducationDegree findById(long id);

    void save(EducationDegree obj);

    void remove(long id);
}
