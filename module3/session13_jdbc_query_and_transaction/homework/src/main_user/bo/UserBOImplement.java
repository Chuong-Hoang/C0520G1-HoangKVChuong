package main_user.bo;

import main_user.dao.UserDAO;
import main_user.dao.UserDAOImplement;
import main_user.model.User;

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

    // Test conn.commit() and conn.rollback() -->Transaction
    @Override
    public void addUserTransactionPractice(User user, int[] permissions) {
        this.userDAO.addUserTransactionPractice(user, permissions);
    }

    @Override // --> Not using transaction
    public void insertUpdateWithoutTransaction() {
        this.userDAO.insertUpdateWithoutTransaction();
    }

    @Override // --> Using transaction
    public void insertUpdateTransaction() {
        this.userDAO.insertUpdateTransaction();
    }

    // Homework2: Using transaction
    // addUserTransaction()
    @Override
    public void addUserTransaction() {
        this.userDAO.addUserTransaction();
    }
}
