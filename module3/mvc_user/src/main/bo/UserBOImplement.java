package main.bo;

import main.dao.UserDAO;
import main.dao.UserDAOImplement;
import main.model.User;

import java.util.List;

public class UserBOImplement implements UserBO {
    UserDAO userDAO = new UserDAOImplement();
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);

    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findByName(String nameString) {
        return userDAO.findByName(nameString);
    }

    @Override
    public void update(int id, User user) {
        userDAO.update(id, user);
    }

    @Override
    public void remove(int id) {
        userDAO.remove(id);
    }

    @Override
    public int getNextId() {
        return userDAO.getNextId();
    }
}