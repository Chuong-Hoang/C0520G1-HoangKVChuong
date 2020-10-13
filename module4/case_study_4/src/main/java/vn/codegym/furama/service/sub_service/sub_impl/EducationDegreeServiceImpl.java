package vn.codegym.furama.service.sub_service.sub_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.sub_model.EducationDegree;
import vn.codegym.furama.repository.sub_repo.EductionDegreeRepository;
import vn.codegym.furama.service.sub_service.EducationDegreeService;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EductionDegreeRepository xRepository;
    @Override
    public List<EducationDegree> findAll() {
        return xRepository.findAll();
    }

    @Override
    public EducationDegree findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(EducationDegree obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }
}
