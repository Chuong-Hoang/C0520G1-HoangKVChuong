package main.dao.contract_dao;

import main.common.DBConnection;
import main.dao.contract_dao.ContractDAO;
import main.model.contract_model.Contract;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractDAOImplement implements ContractDAO {
    /* ....................... Table and Column ......................*/
    private static final String TABLE_NAME = " `contract` ";

    private static final String COL_NAME_1 = "contract_id";
    private static final String COL_NAME_2 = "contract_start_date";
    private static final String COL_NAME_3 = "contract_end_date";
    private static final String COL_NAME_4 = "contract_deposit";
    private static final String COL_NAME_5 = "contract_total_money";
    private static final String COL_NAME_6 = "employee_id";
    private static final String COL_NAME_7 = "customer_id";
    private static final String COL_NAME_8 = "service_id";

    private static final String cm = ",";
    private static final String eq = " = ?";
    /* .......................... Table end .........................*/

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

    private static final String INSERT_INTO = "INSERT INTO " + TABLE_NAME + "(" + COL_NAME_1 + cm +
            COL_NAME_2 + cm + COL_NAME_3 + cm + COL_NAME_4 + cm +
            COL_NAME_5 + cm + COL_NAME_6 + cm + COL_NAME_7 + cm + COL_NAME_8 + ")" +
            " VALUES (?,?,?,?,?,?,?,?);";

    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String UPDATE_SET = "UPDATE " + TABLE_NAME + " SET " + COL_NAME_1 + eq + cm +
            COL_NAME_2 + eq + cm + COL_NAME_3 + eq + cm + COL_NAME_4 + eq + cm +
            COL_NAME_5 + eq + cm + COL_NAME_6 + eq + cm + COL_NAME_7 + eq + cm +
            COL_NAME_8 + eq +
            " WHERE " + COL_NAME_1 + eq;

    private static final String DELETE_FROM = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String SELECT_BY_DATE = "SELECT * FROM " + TABLE_NAME + " WHERE `contract_start_date` like ?";

    @Override
    public void create(Contract el) throws SQLException {
        // 1.Open new connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                // 2.Create a statement with connection object, and setting
                statement = connection.prepareStatement(INSERT_INTO);
                statement.setInt(1, Integer.parseInt(el.getContractId()));
                statement.setDate(2, Date.valueOf(el.getContractStartDate()));
                statement.setDate(3, Date.valueOf(el.getContractEndDate()));
                statement.setDouble(4, Double.parseDouble(el.getContractDeposit()));
                statement.setDouble(5, Double.parseDouble(el.getContractTotalMoney()));
                statement.setInt(6, Integer.parseInt(el.getContractEmployeeId()));
                statement.setString(7, el.getContractCustomerId());
                statement.setString(8, el.getContractServiceId());

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
    public boolean update(String id, Contract el) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowUpdated = false;

        try {
            if (connection != null) {
                statement = connection.prepareStatement(UPDATE_SET);
                statement.setInt(1, Integer.parseInt(el.getContractId()));
                statement.setDate(2, Date.valueOf(el.getContractStartDate()));
                statement.setDate(3, Date.valueOf(el.getContractEndDate()));
                statement.setDouble(4, Double.parseDouble(el.getContractDeposit()));
                statement.setDouble(5, Double.parseDouble(el.getContractTotalMoney()));
                statement.setInt(6, Integer.parseInt(el.getContractEmployeeId()));
                statement.setString(7, el.getContractCustomerId());
                statement.setString(8, el.getContractServiceId());

                statement.setInt(9, Integer.parseInt(id));

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
                statement.setInt(1, Integer.parseInt(id));
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
    public List<Contract> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Contract> eList = new ArrayList<>();
        Contract el = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new Contract();
                    el.setContractId(String.valueOf(resultSet.getInt(COL_NAME_1)));
                    el.setContractStartDate(resultSet.getString(COL_NAME_2));
                    el.setContractEndDate(resultSet.getString(COL_NAME_3));
                    el.setContractDeposit(resultSet.getString(COL_NAME_4));
                    el.setContractTotalMoney(resultSet.getString(COL_NAME_5));
                    el.setContractEmployeeId(resultSet.getString(COL_NAME_6));
                    el.setContractCustomerId(resultSet.getString(COL_NAME_7));
                    el.setContractServiceId(resultSet.getString(COL_NAME_8));

                    eList.add(el);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eList;
    }


    @Override
    public Contract findById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Contract el = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_ID);
                statement.setInt(1, Integer.parseInt(id));
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    el = new Contract();
                    el.setContractId(String.valueOf(resultSet.getInt(COL_NAME_1)));
                    el.setContractStartDate(resultSet.getString(COL_NAME_2));
                    el.setContractEndDate(resultSet.getString(COL_NAME_3));
                    el.setContractDeposit(resultSet.getString(COL_NAME_4));
                    el.setContractTotalMoney(resultSet.getString(COL_NAME_5));
                    el.setContractEmployeeId(resultSet.getString(COL_NAME_6));
                    el.setContractCustomerId(resultSet.getString(COL_NAME_7));
                    el.setContractServiceId(resultSet.getString(COL_NAME_8));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return el;
    }


    @Override
    public List<Contract> findByDate(String str) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Contract> eList = new ArrayList<>();
        Contract el = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_DATE);
                statement.setString(1, "%" + str + "%");
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new Contract();
                    el.setContractId(String.valueOf(resultSet.getInt(COL_NAME_1)));
                    el.setContractStartDate(resultSet.getString(COL_NAME_2));
                    el.setContractEndDate(resultSet.getString(COL_NAME_3));
                    el.setContractDeposit(resultSet.getString(COL_NAME_4));
                    el.setContractTotalMoney(resultSet.getString(COL_NAME_5));
                    el.setContractEmployeeId(resultSet.getString(COL_NAME_6));
                    el.setContractCustomerId(resultSet.getString(COL_NAME_7));
                    el.setContractServiceId(resultSet.getString(COL_NAME_8));

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
