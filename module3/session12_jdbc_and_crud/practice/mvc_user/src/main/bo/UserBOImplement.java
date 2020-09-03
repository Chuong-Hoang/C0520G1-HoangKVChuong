package main.bo;

import main.dao.UserDAO;
import main.dao.UserDAOImplement;
import main.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserBOImplement implements UserBO {

    UserDAO userDAO = new UserDAOImplement();

    @Override
    public void insertUser(User user) throws SQLException {
        this.userDAO.insertUser(user);

    }

    @Override
    public User selectUser(int id) {
        return this.userDAO.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return this.userDAO.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return this.userDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return this.userDAO.updateUser(user);
    }

    @Override
    public List<User> findByName(String nameString) {
        return userDAO.findByName(nameString);
    }

}