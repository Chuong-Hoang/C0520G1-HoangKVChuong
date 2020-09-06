package main.dao.employee_dao;

import main.common.DBConnection;
import main.model.employee_model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplement implements EmployeeDAO {
    /* ....................... Table and Column ......................*/
    private static final String TABLE_NAME = " `employee` ";

    private static final String COL_NAME_1 = "employee_id";
    private static final String COL_NAME_2 = "employee_name";
    private static final String COL_NAME_3 = "employee_birthday";
    private static final String COL_NAME_4 = "employee_id_card";
    private static final String COL_NAME_5 = "employee_salary";
    private static final String COL_NAME_6 = "employee_phone";
    private static final String COL_NAME_7 = "employee_email";
    private static final String COL_NAME_8 = "employee_address";
    private static final String COL_NAME_9 = "position_id";
    private static final String COL_NAME_10 = "education_degree_id";
    private static final String COL_NAME_11 = "division_id";

    private static final String cm = ",";
    private static final String eq = " = ?";
    /* ....................... Table end ......................*/

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

    private static final String INSERT_INTO = "INSERT INTO " + TABLE_NAME + "(" + COL_NAME_1 + cm + COL_NAME_2 + cm +
            COL_NAME_3 + cm + COL_NAME_4 + cm + COL_NAME_5 + cm + COL_NAME_6 + cm + COL_NAME_7 + cm +
            COL_NAME_8 + cm + COL_NAME_9 + cm + COL_NAME_10 + cm + COL_NAME_11 + ")" +
            "values (?,?,?,?,?,?,?,?,?,?,?);";

    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String UPDATE_SET = "UPDATE " + TABLE_NAME + " SET " + COL_NAME_1 + eq + cm +
            COL_NAME_2 + eq + cm + COL_NAME_3 + eq + cm + COL_NAME_4 + eq + cm +
            COL_NAME_5 + eq + cm + COL_NAME_6 + eq + cm + COL_NAME_7 + eq + cm +
            COL_NAME_8 + eq + cm + COL_NAME_9 + eq + cm + COL_NAME_10 + eq + cm +
            COL_NAME_11 + eq + " WHERE " + COL_NAME_1 + eq;

    private static final String DELETE_FROM = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String SELECT_BY_NAME = "SELECT * FROM " + TABLE_NAME + " WHERE `employee_name` like ?";


    @Override
    public void create(Employee el) throws SQLException {
        // 1.Open new connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                // 2.Create a statement with connection object, and setting
                statement = connection.prepareStatement(INSERT_INTO);
                statement.setString(1, el.getEmployeeId());
                statement.setString(2, el.getEmployeeName());
                statement.setString(3, el.getEmployeeBirthday());
                statement.setString(4, el.getEmployeeIdCard());
                statement.setString(5, el.getEmployeeSalary());
                statement.setString(6, el.getEmployeePhone());
                statement.setString(7, el.getEmployeeEmail());
                statement.setString(8, el.getEmployeeAddress());
                statement.setInt(9, Integer.parseInt(el.getPositionId()));
                statement.setInt(10, Integer.parseInt(el.getEducationDegreeId()));
                statement.setInt(11, Integer.parseInt(el.getDivisionId()));

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
    public boolean update(String id, Employee el) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowUpdated = false;

        try {
            if (connection != null) {
                statement = connection.prepareStatement(UPDATE_SET);
                statement.setString(1, el.getEmployeeId());
                statement.setString(2, el.getEmployeeName());
                statement.setString(3, el.getEmployeeBirthday());
                statement.setString(4, el.getEmployeeIdCard());
                statement.setString(5, el.getEmployeeSalary());
                statement.setString(6, el.getEmployeePhone());
                statement.setString(7, el.getEmployeeEmail());
                statement.setString(8, el.getEmployeeAddress());
                statement.setInt(9, Integer.parseInt(el.getPositionId()));
                statement.setInt(10, Integer.parseInt(el.getEducationDegreeId()));
                statement.setInt(11, Integer.parseInt(el.getDivisionId()));
                statement.setString(12, id);

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
    public List<Employee> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> eList = new ArrayList<>();
        Employee el = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new Employee();
                    el.setEmployeeId(resultSet.getString(COL_NAME_1));
                    el.setEmployeeName(resultSet.getString(COL_NAME_2));
                    el.setEmployeeBirthday(resultSet.getString(COL_NAME_3));
                    el.setEmployeeIdCard(resultSet.getString(COL_NAME_4));
                    el.setEmployeeSalary(resultSet.getString(COL_NAME_5));
                    el.setEmployeePhone(resultSet.getString(COL_NAME_6));
                    el.setEmployeeEmail(resultSet.getString(COL_NAME_7));
                    el.setEmployeeAddress(resultSet.getString(COL_NAME_8));
                    el.setPositionId(String.valueOf(resultSet.getInt(COL_NAME_9)));
                    el.setEducationDegreeId(String.valueOf(resultSet.getInt(COL_NAME_10)));
                    el.setDivisionId(String.valueOf(resultSet.getInt(COL_NAME_11)));

                    eList.add(el);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eList;
    }

    @Override
    public Employee findById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Employee el = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_ID);
                statement.setString(1, id);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    el = new Employee();
                    el.setEmployeeId(resultSet.getString(COL_NAME_1));
                    el.setEmployeeName(resultSet.getString(COL_NAME_2));
                    el.setEmployeeBirthday(resultSet.getString(COL_NAME_3));
                    el.setEmployeeIdCard(resultSet.getString(COL_NAME_4));
                    el.setEmployeeSalary(resultSet.getString(COL_NAME_5));
                    el.setEmployeePhone(resultSet.getString(COL_NAME_6));
                    el.setEmployeeEmail(resultSet.getString(COL_NAME_7));
                    el.setEmployeeAddress(resultSet.getString(COL_NAME_8));
                    el.setPositionId(String.valueOf(resultSet.getInt(COL_NAME_9)));
                    el.setEducationDegreeId(String.valueOf(resultSet.getInt(COL_NAME_10)));
                    el.setDivisionId(String.valueOf(resultSet.getInt(COL_NAME_11)));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return el;
    }


    @Override
    public List<Employee> findByName(String str) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> eList = new ArrayList<>();
        Employee el = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_NAME);
                statement.setString(1, "%" + str + "%");
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new Employee();
                    el.setEmployeeId(resultSet.getString(COL_NAME_1));
                    el.setEmployeeName(resultSet.getString(COL_NAME_2));
                    el.setEmployeeBirthday(resultSet.getString(COL_NAME_3));
                    el.setEmployeeIdCard(resultSet.getString(COL_NAME_4));
                    el.setEmployeeSalary(resultSet.getString(COL_NAME_5));
                    el.setEmployeePhone(resultSet.getString(COL_NAME_6));
                    el.setEmployeeEmail(resultSet.getString(COL_NAME_7));
                    el.setEmployeeAddress(resultSet.getString(COL_NAME_8));
                    el.setPositionId(String.valueOf(resultSet.getInt(COL_NAME_9)));
                    el.setEducationDegreeId(String.valueOf(resultSet.getInt(COL_NAME_10)));
                    el.setDivisionId(String.valueOf(resultSet.getInt(COL_NAME_11)));

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
