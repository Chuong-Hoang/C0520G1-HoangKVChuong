package main.dao.contract_detail_dao;

import main.common.DBConnection;
import main.model.contract_detail_model.ContractDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailDAOImplement implements ContractDetailDAO {
    /* ....................... Table and Column ......................*/
    private static final String TABLE_NAME = " `contract_detail` ";

    private static final String COL_NAME_1 = "contract_detail_id";
    private static final String COL_NAME_2 = "contract_id";
    private static final String COL_NAME_3 = "attach_service_id";
    private static final String COL_NAME_4 = "quantity";


    private static final String cm = ",";
    private static final String eq = " = ?";
    /* .......................... Table end .........................*/

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

    private static final String INSERT_INTO = "INSERT INTO " + TABLE_NAME + "(" + COL_NAME_1 + cm +
            COL_NAME_2 + cm + COL_NAME_3 + cm + COL_NAME_4 + ")" +
            " VALUES (?, ?, ?, ?);";

    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String UPDATE_SET = "UPDATE " + TABLE_NAME + " SET " + COL_NAME_1 + eq + cm +
            COL_NAME_2 + eq + cm + COL_NAME_3 + eq + cm + COL_NAME_4 + eq + " WHERE " + COL_NAME_1 + eq;

    private static final String DELETE_FROM = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String SELECT_BY_CONTRACT_ID = "SELECT * FROM " + TABLE_NAME + " WHERE `contract_id` = ?";

    @Override
    public void create(ContractDetail el) throws SQLException {
        // 1.Open new connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                // 2.Create a statement with connection object, and setting
                statement = connection.prepareStatement(INSERT_INTO);
                statement.setInt(1, Integer.parseInt(el.getContractDetailId()));
                statement.setInt(2, Integer.parseInt(el.getContractId()));
                statement.setInt(3, Integer.parseInt(el.getAttachServiceId()));
                statement.setInt(4, Integer.parseInt(el.getQuantity()));

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
    public boolean update(String id, ContractDetail el) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowUpdated = false;

        try {
            if (connection != null) {
                statement = connection.prepareStatement(UPDATE_SET);
                statement.setInt(1, Integer.parseInt(el.getContractDetailId()));
                statement.setInt(2, Integer.parseInt(el.getContractId()));
                statement.setInt(3, Integer.parseInt(el.getAttachServiceId()));
                statement.setInt(4, Integer.parseInt(el.getQuantity()));

                statement.setString(5, id);

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
    public List<ContractDetail> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ContractDetail> eList = new ArrayList<>();
        ContractDetail el = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new ContractDetail();
                    el.setContractDetailId(String.valueOf(resultSet.getInt(COL_NAME_1)));
                    el.setContractId(String.valueOf(resultSet.getInt(COL_NAME_2)));
                    el.setAttachServiceId(String.valueOf(resultSet.getInt(COL_NAME_3)));
                    el.setQuantity(String.valueOf(resultSet.getInt(COL_NAME_4)));

                    eList.add(el);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eList;
    }


    @Override
    public ContractDetail findById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ContractDetail el = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_ID);
                statement.setString(1, id);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    el = new ContractDetail();
                    el.setContractDetailId(String.valueOf(resultSet.getInt(COL_NAME_1)));
                    el.setContractId(String.valueOf(resultSet.getInt(COL_NAME_2)));
                    el.setAttachServiceId(String.valueOf(resultSet.getInt(COL_NAME_3)));
                    el.setQuantity(String.valueOf(resultSet.getInt(COL_NAME_4)));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return el;
    }


    @Override
    public List<ContractDetail> findByContractId(String str) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ContractDetail> eList = new ArrayList<>();
        ContractDetail el = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_CONTRACT_ID);
                statement.setInt(1, Integer.parseInt(str));
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new ContractDetail();
                    el.setContractDetailId(String.valueOf(resultSet.getInt(COL_NAME_1)));
                    el.setContractId(String.valueOf(resultSet.getInt(COL_NAME_2)));
                    el.setAttachServiceId(String.valueOf(resultSet.getInt(COL_NAME_3)));
                    el.setQuantity(String.valueOf(resultSet.getInt(COL_NAME_4)));

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
