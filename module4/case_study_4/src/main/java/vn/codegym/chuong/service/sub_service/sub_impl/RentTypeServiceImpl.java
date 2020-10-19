package vn.codegym.chuong.service.sub_service.sub_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.sub_model.RentType;
import vn.codegym.chuong.repository.sub_repo.RentTypeRepository;
import vn.codegym.chuong.service.sub_service.RentTypeService;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(long id) {
        return rentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RentType obj) {
        rentTypeRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        rentTypeRepository.deleteById(id);
    }
}
