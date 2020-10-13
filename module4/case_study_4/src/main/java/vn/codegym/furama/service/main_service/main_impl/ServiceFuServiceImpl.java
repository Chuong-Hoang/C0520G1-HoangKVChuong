package vn.codegym.furama.service.main_service.main_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama.model.main_model.Service;
import vn.codegym.furama.repository.main_repo.ServiceFuRepository;
import vn.codegym.furama.service.main_service.ServiceFuService;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceFuServiceImpl implements ServiceFuService {
    @Autowired
    private ServiceFuRepository serviceFuRepository;

    @Override
    public List<Service> findAll() {
        return serviceFuRepository.findAll();
    }

    @Override
    public Service findById(long id) {
        return serviceFuRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service obj) {
        serviceFuRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        serviceFuRepository.deleteById(id);
    }

    @Override
    public long count() {
        return serviceFuRepository.count();
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceFuRepository.findAll(pageable);
    }

    @Override
    public Page<Service> findByServiceNameContaining(Pageable pageable, String name) {
        return serviceFuRepository.findByServiceNameContaining(pageable, name);
    }
}
