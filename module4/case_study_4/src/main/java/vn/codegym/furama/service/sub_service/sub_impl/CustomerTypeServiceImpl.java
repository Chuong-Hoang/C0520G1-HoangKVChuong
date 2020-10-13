package vn.codegym.furama.service.sub_service.sub_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.sub_model.CustomerType;
import vn.codegym.furama.repository.sub_repo.CustomerTypeRepository;
import vn.codegym.furama.service.sub_service.CustomerTypeService;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(long id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CustomerType obj) {
        customerTypeRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        customerTypeRepository.deleteById(id);
    }
}
