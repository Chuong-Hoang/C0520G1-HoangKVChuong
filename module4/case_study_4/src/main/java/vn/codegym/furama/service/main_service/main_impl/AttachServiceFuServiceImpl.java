package vn.codegym.furama.service.main_service.main_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.main_model.AttachServiceFu;
import vn.codegym.furama.model.main_model.User;
import vn.codegym.furama.repository.main_repo.AttachServiceFuRepository;
import vn.codegym.furama.repository.main_repo.UserRepository;
import vn.codegym.furama.service.main_service.AttachServiceFuService;

import java.util.List;

@Service
public class AttachServiceFuServiceImpl implements AttachServiceFuService {
    @Autowired
    private AttachServiceFuRepository xRepository;
    @Override
    public List<AttachServiceFu> findAll() {
        return xRepository.findAll();
    }

    @Override
    public AttachServiceFu findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(AttachServiceFu obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }
}
