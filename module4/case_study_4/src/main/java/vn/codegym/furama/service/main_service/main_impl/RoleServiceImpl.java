package vn.codegym.furama.service.main_service.main_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.security_model.Role;
import vn.codegym.furama.repository.main_repo.RoleRepository;
import vn.codegym.furama.service.main_service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository xRepository;
    @Override
    public List<Role> findAll() {
        return xRepository.findAll();
    }

    @Override
    public Role findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Role obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }

    @Override
    public Role findByRoleName(String name) {
        return xRepository.findByRoleName(name);
    }
}
