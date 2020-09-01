package main.dao;

import main.model.User;

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
}
