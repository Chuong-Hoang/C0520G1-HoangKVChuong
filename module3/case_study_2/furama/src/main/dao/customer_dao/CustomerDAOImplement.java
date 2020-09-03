package main.dao.customer_dao;

import main.model.Customer;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImplement implements CustomerDAO {
    private static final String SELECT_ALL_CUSTOMERS = "select * from customers";
//    private static final String INSERT_INTO = "insert into users(name, email, country) values (?,?,?);";
//    private static final String SELECT_BY_ID = "select * from users where id = ?;";
//    private static final String UPDATE_SET = "update users set name = ?, email = ?, country = ? where id = ?;";
//    private static final String DELETE_FROM = "delete from users where id = ?;";
//    private static final String SELECT_COUNTRY_OR_NAME = "select * from users where (country = ?) or (name like ?)";
//
//    // Not using transaction
//    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
//    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY = ? WHERE NAME = ?";
//    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
//            + "("
//            + " ID serial,"
//            + " NAME varchar(100) NOT NULL,"
//            + " SALARY numeric(15, 2) NOT NULL,"
//            + " CREATED_DATE timestamp,"
//            + " PRIMARY KEY (ID)"
//            + ")";
//    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";


    @Override
    public void create(Customer customer) throws SQLException {
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public List<Customer> findByName(String nameString) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> customers = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
                resultSet = statement.executeQuery();
                Customer customer = null;

                while (resultSet.next()) {
                    customer = new Customer();
                    customer.setCustomerId(resultSet.getInt("customer_id"));
                    customer.setCustomerName(resultSet.getString("customer_name"));
                    customer.setCustomerBirthday(resultSet.getString("birthday"));
                    customer.setCustomerGender(resultSet.getString("birthday"));
                    customer.setCustomerIdCard(resultSet.getString("id_number"));
                    customer.setCustomerPhone(resultSet.getString("phone"));
                    customer.setCustomerEmail(resultSet.getString("email"));
                    customer.setCustomerAddress(resultSet.getString("address"));

                    //............... ******** ..................................
                    customer.setCustomerType(String.valueOf(resultSet.getString("class_id")));

                    customers.add(customer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return customers;
    }
}
