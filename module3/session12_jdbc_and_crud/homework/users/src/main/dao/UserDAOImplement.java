package main.dao;

import main.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplement implements UserDAO {
    private static final String SELECT_ALL = "select * from users";
    private static final String INSERT_INTO = "insert into users(name, email, country) values (?,?,?);";
    private static final String SELECT_BY_ID = "select * from users where id = ?;";
    private static final String UPDATE_SQL = "update users set name = ?, email = ?, country = ? where id = ?;";
    private static final String DELETE_FROM = "delete from users where id = ?;";
    private static final String SELECT_COUNTRY_OR_NAME = "select * from users where (country = ?) or (name like ?)";

    @Override
    public void create(User user) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(INSERT_INTO);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());

                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }

    @Override
    public User findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(SELECT_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    user = new User();
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setCountry(resultSet.getString("country"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL);
                resultSet = statement.executeQuery();
                User user = null;

                while (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setCountry(resultSet.getString("country"));

                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return users;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        boolean isDeleted = false;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_FROM);
                statement.setInt(1, id);
                isDeleted = statement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return isDeleted;
    }

    @Override
    public boolean update(User user) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowUpdated = false;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(UPDATE_SQL);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
                statement.setInt(4, user.getId());

                rowUpdated = statement.executeUpdate() > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return rowUpdated;
    }

    @Override
    public List<User> findByName(String str) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_COUNTRY_OR_NAME);
                statement.setString(1, str);
                statement.setString(2, "'$%%" + str + "$%%'");
                resultSet = statement.executeQuery();
                User user = null;

                while (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setCountry(resultSet.getString("country"));

                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return users;
    }
}
