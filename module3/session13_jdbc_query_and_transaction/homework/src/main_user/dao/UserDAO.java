package main_user.dao;

import main_user.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    // sql manipulation
    public void create(User user) throws SQLException;

    public User findById(int id);

    public List<User> findAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(User user) throws SQLException;

    List<User> findByName(String nameString);

    // Test conn.commit() and conn.rollback() -->Transaction
    public void addUserTransactionPractice(User user, int[] permissions);

    // Not using transaction
    public void insertUpdateWithoutTransaction();

    // Using transaction
    public void insertUpdateTransaction();

    // Homework2: Using transaction
    // addUserTransaction()
    public  void addUserTransaction();

}
