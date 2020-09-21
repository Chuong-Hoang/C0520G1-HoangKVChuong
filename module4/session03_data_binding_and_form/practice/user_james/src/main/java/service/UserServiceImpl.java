package service;

import model.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User el) {
        userRepository.save(el);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void update(String id, User el) {
        userRepository.update(id, el);
    }

    @Override
    public void remove(String id) {
        userRepository.remove(id);
    }
}
