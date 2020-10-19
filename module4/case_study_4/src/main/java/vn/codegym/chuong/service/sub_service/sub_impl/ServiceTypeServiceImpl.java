package vn.codegym.chuong.service.sub_service.sub_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.sub_model.ServiceType;
import vn.codegym.chuong.repository.sub_repo.ServiceTypeRepository;
import vn.codegym.chuong.service.sub_service.ServiceTypeService;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(long id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceType obj) {
        serviceTypeRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        serviceTypeRepository.deleteById(id);
    }
}
