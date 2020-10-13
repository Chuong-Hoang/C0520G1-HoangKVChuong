package vn.codegym.furama.service.main_service.main_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.main_model.UserRole;
import vn.codegym.furama.repository.main_repo.UserRoleRepository;
import vn.codegym.furama.service.main_service.UserRoleService;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository xRepository;
    @Override
    public List<UserRole> findAll() {
        return xRepository.findAll();
    }

    @Override
    public UserRole findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(UserRole obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }
}
