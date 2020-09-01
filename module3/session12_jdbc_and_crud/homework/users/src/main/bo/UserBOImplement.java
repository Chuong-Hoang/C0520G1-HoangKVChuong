package main.bo;

import main.dao.UserDAO;
import main.dao.UserDAOImplement;
import main.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserBOImplement implements UserBO{
    UserDAO userDAO = new UserDAOImplement();

    @Override
    public void create(User user) throws SQLException {
        this.userDAO.create(user);
    }

    @Override
    public User findById(int id) {
        return this.userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {
        return this.userDAO.findAll();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return this.userDAO.delete(id);
    }

    @Override
    public boolean update(User user) throws SQLException {
        return this.userDAO.update(user);
    }

    @Override
    public List<User> findByName(String nameString) {
        return this.userDAO.findByName(nameString);
    }
}
