package vn.codegym.chuong.service.main_service.main_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.main_model.AttachService;
import vn.codegym.chuong.repository.main_repo.AttachServiceFuRepository;
import vn.codegym.chuong.service.main_service.AttachServiceFuService;

import java.util.List;

@Service
public class AttachServiceFuServiceImpl implements AttachServiceFuService {
    @Autowired
    private AttachServiceFuRepository xRepository;
    @Override
    public List<AttachService> findAll() {
        return xRepository.findAll();
    }

    @Override
    public AttachService findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(AttachService obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }
}
