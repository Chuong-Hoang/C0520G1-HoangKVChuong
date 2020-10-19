package vn.codegym.chuong.service.student_service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.student_model.Hobby;
import vn.codegym.chuong.repository.student_repo.HobbyRepository;
import vn.codegym.chuong.service.student_service.HobbyService;

import java.util.List;

@Service
public class HobbyServiceImpl implements HobbyService {
    @Autowired
    private HobbyRepository xRepository;

    @Override
    public List<Hobby> findAll() {
        return xRepository.findAll();
    }

    @Override
    public Hobby findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Hobby obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }
}
