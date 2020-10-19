package vn.codegym.chuong.service.sub_service.sub_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.sub_model.Division;
import vn.codegym.chuong.repository.sub_repo.DivisionRepository;
import vn.codegym.chuong.service.sub_service.DivisionService;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository xRepository;

    @Override
    public List<Division> findAll() {
        return xRepository.findAll();
    }

    @Override
    public Division findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Division obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }
}
