package vn.codegym.chuong.service.main_service.main_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.security_model.User;
import vn.codegym.chuong.repository.main_repo.UserRepository;
import vn.codegym.chuong.service.main_service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository xRepository;
    @Override
    public List<User> findAll() {
        return xRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }

    @Override
    public User findByUserName(String name) {
        return xRepository.findByUserName(name);
    }
}
