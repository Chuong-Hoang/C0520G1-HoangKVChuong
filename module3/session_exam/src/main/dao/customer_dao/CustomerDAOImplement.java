package main.dao.customer_dao;

import main.common.DBConnection;
import main.model.customer_model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImplement implements CustomerDAO {
    /* ....................... Table and Column ......................*/
    private static final String TABLE_NAME = " `customer` ";

    private static final String COL_NAME_1 = "customer_id";
    private static final String COL_NAME_2 = "customer_name";
    private static final String COL_NAME_3 = "customer_birthday";
    private static final String COL_NAME_4 = "customer_gender";
    private static final String COL_NAME_5 = "customer_id_card";
    private static final String COL_NAME_6 = "customer_phone";
    private static final String COL_NAME_7 = "customer_email";
    private static final String COL_NAME_8 = "customer_address";
    private static final String COL_NAME_9 = "customer_type_id";

    private static final String cm = ",";
    private static final String eq = " = ?";
    /* .......................... Table end .........................*/

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

    private static final String INSERT_INTO = "INSERT INTO " + TABLE_NAME + "(" + COL_NAME_1 + cm + COL_NAME_2 + cm + COL_NAME_3 + cm + COL_NAME_4 + cm +
            COL_NAME_5 + cm + COL_NAME_6 + cm + COL_NAME_7 + cm + COL_NAME_8 + cm + COL_NAME_9 + ")" +
            " VALUES (?,?,?,?,?,?,?,?,?);";

    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String UPDATE_SET = "UPDATE " + TABLE_NAME + " SET " + COL_NAME_1 + eq + cm +
            COL_NAME_2 + eq + cm + COL_NAME_3 + eq + cm + COL_NAME_4 + eq + cm +
            COL_NAME_5 + eq + cm + COL_NAME_6 + eq + cm + COL_NAME_7 + eq + cm +
            COL_NAME_8 + eq + cm + COL_NAME_9 + eq +
            " WHERE " + COL_NAME_1 + eq;

    private static final String DELETE_FROM = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String SELECT_BY_NAME = "SELECT * FROM " + TABLE_NAME + " WHERE `customer_name` like ?";

    @Override
    public void create(Customer el) throws SQLException {
        // 1.Open new connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                // 2.Create a statement with connection object, and setting
                statement = connection.prepareStatement(INSERT_INTO);
                statement.setString(1, el.getCustomerId());
                statement.setString(2, el.getCustomerName());
                statement.setString(3, el.getCustomerBirthday());
                statement.setString(4, el.getCustomerGender());
                statement.setString(5, el.getCustomerIdCard());
                statement.setString(6, el.getCustomerPhone());
                statement.setString(7, el.getCustomerEmail());
                statement.setString(8, el.getCustomerAddress());
                statement.setInt(9, Integer.parseInt(el.getCustomerTypeId()));

                // 3.Execute the query sql using statement
                statement.executeUpdate();

                // 4.Process the result (if needed)
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // 5.Close the connection
            DBConnection.close();
        }
    }

    @Override
    public boolean update(String id, Customer el) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowUpdated = false;

        try {
            if (connection != null) {
                statement = connection.prepareStatement(UPDATE_SET);
                statement.setString(1, el.getCustomerId());
                statement.setString(2, el.getCustomerName());
                statement.setString(3, el.getCustomerBirthday());
                statement.setString(4, el.getCustomerGender());
                statement.setString(5, el.getCustomerIdCard());
                statement.setString(6, el.getCustomerPhone());
                statement.setString(7, el.getCustomerEmail());
                statement.setString(8, el.getCustomerAddress());
                statement.setInt(9, Integer.parseInt(el.getCustomerTypeId()));
                statement.setString(10, id);

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
    public boolean delete(String id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowAffected = false;

        try {
            if(connection != null) {
                statement = connection.prepareStatement(DELETE_FROM);
                statement.setString(1, id);
                rowAffected = statement.executeUpdate() > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return rowAffected;
    }


    @Override
    public List<Customer> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> eList = new ArrayList<>();
        Customer el = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new Customer();
                    el.setCustomerId(resultSet.getString(COL_NAME_1));
                    el.setCustomerName(resultSet.getString(COL_NAME_2));
                    el.setCustomerBirthday(resultSet.getString(COL_NAME_3));
                    el.setCustomerGender(resultSet.getString(COL_NAME_4));
                    el.setCustomerIdCard(resultSet.getString(COL_NAME_5));
                    el.setCustomerPhone(resultSet.getString(COL_NAME_6));
                    el.setCustomerEmail(resultSet.getString(COL_NAME_7));
                    el.setCustomerAddress(resultSet.getString(COL_NAME_8));
                    el.setCustomerTypeId(String.valueOf(resultSet.getInt(COL_NAME_9)));

                    eList.add(el);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eList;
    }


    @Override
    public Customer findById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Customer el = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_ID);
                statement.setString(1, id);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    el = new Customer();
                    el.setCustomerId(resultSet.getString(COL_NAME_1));
                    el.setCustomerName(resultSet.getString(COL_NAME_2));
                    el.setCustomerBirthday(resultSet.getString(COL_NAME_3));
                    el.setCustomerGender(resultSet.getString(COL_NAME_4));
                    el.setCustomerIdCard(resultSet.getString(COL_NAME_5));
                    el.setCustomerPhone(resultSet.getString(COL_NAME_6));
                    el.setCustomerEmail(resultSet.getString(COL_NAME_7));
                    el.setCustomerAddress(resultSet.getString(COL_NAME_8));
                    el.setCustomerTypeId(String.valueOf(resultSet.getInt(COL_NAME_9)));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return el;
    }


    @Override
    public List<Customer> findByName(String str) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> eList = new ArrayList<>();
        Customer el = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_NAME);
                statement.setString(1, "%" + str + "%");
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new Customer();
                    el.setCustomerId(resultSet.getString(COL_NAME_1));
                    el.setCustomerName(resultSet.getString(COL_NAME_2));
                    el.setCustomerBirthday(resultSet.getString(COL_NAME_3));
                    el.setCustomerGender(resultSet.getString(COL_NAME_4));
                    el.setCustomerIdCard(resultSet.getString(COL_NAME_5));
                    el.setCustomerPhone(resultSet.getString(COL_NAME_6));
                    el.setCustomerEmail(resultSet.getString(COL_NAME_7));
                    el.setCustomerAddress(resultSet.getString(COL_NAME_8));
                    el.setCustomerTypeId(String.valueOf(resultSet.getInt(COL_NAME_9)));

                    eList.add(el);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return eList;
    }
}
