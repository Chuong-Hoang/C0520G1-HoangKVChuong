package main.dao.service_dao;

import main.common.DBConnection;
import main.model.service_model.House;
import main.model.service_model.Room;
import main.model.service_model.Service;
import main.model.service_model.Villa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImplement implements ServiceDAO {
    /* ....................... Table and Column ......................*/
    private static final String TABLE_NAME = " `service` ";

    private static final String COL_NAME_1 = "service_id";
    private static final String COL_NAME_2 = "service_name";
    private static final String COL_NAME_3 = "service_area";
    private static final String COL_NAME_4 = "service_cost";
    private static final String COL_NAME_5 = "service_max_people";
    private static final String COL_NAME_6 = "rent_type_id";
    private static final String COL_NAME_7 = "service_type_id";

    private static final String COL_NAME_8 = "standard_room";
    private static final String COL_NAME_9 = "description_other_convenience";
    private static final String COL_NAME_10 = "pool_area";
    private static final String COL_NAME_11 = "number_of_floors";

    private static final String cm = ",";
    private static final String eq = " = ?";
    /* ....................... Table end ......................*/


    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

    private static final String ADD_NEW = "INSERT INTO " + TABLE_NAME + "(" + COL_NAME_1 + cm + COL_NAME_2 + cm +
            COL_NAME_3 + cm + COL_NAME_4 + cm + COL_NAME_5 + cm + COL_NAME_6 + cm + COL_NAME_7;

    private static final String NEW_VILLA = cm + COL_NAME_8 + cm + COL_NAME_9 + cm + COL_NAME_10 + cm + COL_NAME_11
            + ")" + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    private static final String NEW_HOUSE = cm + COL_NAME_8 + cm + COL_NAME_9 + cm + COL_NAME_11
            + ")" + " VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final String NEW_ROOM = ")" + " VALUES (?,?,?,?,?,?,?)";

    private static final String INSERT_NEW_VILLA = ADD_NEW + NEW_VILLA;

    private static final String INSERT_NEW_HOUSE = ADD_NEW + NEW_HOUSE;

    private static final String INSERT_NEW_ROOM = ADD_NEW + NEW_ROOM;

    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String UPDATE_SQL = "UPDATE " + TABLE_NAME + " SET " + COL_NAME_1 + eq + cm +
            COL_NAME_2 + eq + cm + COL_NAME_3 + eq + cm + COL_NAME_4 + eq + cm +
            COL_NAME_5 + eq + cm + COL_NAME_6 + eq + cm + COL_NAME_7 + eq;

    private static final String SET_VILLA = cm + COL_NAME_8 + eq + cm + COL_NAME_9 + eq + cm +
            COL_NAME_10 + eq + cm + COL_NAME_11 + eq;

    private static final String SET_HOUSE = cm + COL_NAME_8 + eq + cm + COL_NAME_9 + eq + cm +
            COL_NAME_11 + eq;

    private static final String SET_ROOM = "";

    private static final String WHERE_ID_EQUAL = " WHERE " + COL_NAME_1 + eq;

    private static final String UPDATE_SET_VILLA = UPDATE_SQL + SET_VILLA + WHERE_ID_EQUAL;

    private static final String UPDATE_SET_HOUSE = UPDATE_SQL + SET_HOUSE + WHERE_ID_EQUAL;

    private static final String UPDATE_SET_ROOM = UPDATE_SQL + SET_ROOM + WHERE_ID_EQUAL;

    private static final String DELETE_FROM = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String SELECT_BY_NAME = "SELECT * FROM " + TABLE_NAME + " WHERE `service_name` like ?";


    @Override // FIND ALL
    public List<Service> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Service> eList = new ArrayList<>();
        Service el = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {

                    String id = resultSet.getString(COL_NAME_1);
                    String a = resultSet.getString(COL_NAME_2);
                    String b = resultSet.getString(COL_NAME_3);
                    String c = resultSet.getString(COL_NAME_4);
                    String d = resultSet.getString(COL_NAME_5);
                    String e = String.valueOf(resultSet.getInt(COL_NAME_6));
                    String f = String.valueOf(resultSet.getString(COL_NAME_7));

                    if (f.compareTo("1") == 0) {
                        String g = resultSet.getString(COL_NAME_8);
                        String h = resultSet.getString(COL_NAME_9);
                        String i = resultSet.getString(COL_NAME_10);
                        String j = resultSet.getString(COL_NAME_11);
                        el = new Villa(id, a, b, c, d, e, f, g, h, i, j);

                    } else if (f.compareTo("2") == 0) {
                        String g = resultSet.getString(COL_NAME_8);
                        String h = resultSet.getString(COL_NAME_9);
                        String j = resultSet.getString(COL_NAME_11);
                        el = new House(id, a, b, c, d, e, f, g, h, j); // not 'i' here

                    } else {
                        el = new Room(id, a, b, c, d, e, f); // room
                    }

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

    @Override  // FIND BY ID
    public Service findById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Service el = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_ID);
                statement.setString(1, id);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    //--> not use: String id = resultSet.getString(col_name_1);
                    String a = resultSet.getString(COL_NAME_2);
                    String b = resultSet.getString(COL_NAME_3);
                    String c = resultSet.getString(COL_NAME_4);
                    String d = resultSet.getString(COL_NAME_5);
                    String e = String.valueOf(resultSet.getInt(COL_NAME_6));
                    String f = String.valueOf(resultSet.getString(COL_NAME_7));

                    if (f.compareTo("1") == 0) {
                        String g = resultSet.getString(COL_NAME_8);
                        String h = resultSet.getString(COL_NAME_9);
                        String i = resultSet.getString(COL_NAME_10);
                        String j = resultSet.getString(COL_NAME_11);
                        el = new Villa(id, a, b, c, d, e, f, g, h, i, j);

                    } else if (f.compareTo("2") == 0) {
                        String g = resultSet.getString(COL_NAME_8);
                        String h = resultSet.getString(COL_NAME_9);
                        String j = resultSet.getString(COL_NAME_11);
                        el = new House(id, a, b, c, d, e, f, g, h, j); // not 'i' here

                    } else {
                        el = new Room(id, a, b, c, d, e, f); // room
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return el;
    }

    @Override  // FIND BY NAME
    public List<Service> findByName(String str) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Service> eList = new ArrayList<>();
        Service el = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_NAME);
                statement.setString(1, "%" + str + "%");
                resultSet = statement.executeQuery();

                while (resultSet.next()) {

                    String id = resultSet.getString(COL_NAME_1);
                    String a = resultSet.getString(COL_NAME_2);
                    String b = resultSet.getString(COL_NAME_3);
                    String c = resultSet.getString(COL_NAME_4);
                    String d = resultSet.getString(COL_NAME_5);
                    String e = String.valueOf(resultSet.getInt(COL_NAME_6));
                    String f = String.valueOf(resultSet.getString(COL_NAME_7));

                    if (f.compareTo("1") == 0) {
                        String g = resultSet.getString(COL_NAME_8);
                        String h = resultSet.getString(COL_NAME_9);
                        String i = resultSet.getString(COL_NAME_10);
                        String j = resultSet.getString(COL_NAME_11);
                        el = new Villa(id, a, b, c, d, e, f, g, h, i, j);

                    } else if (f.compareTo("2") == 0) {
                        String g = resultSet.getString(COL_NAME_8);
                        String h = resultSet.getString(COL_NAME_9);
                        String j = resultSet.getString(COL_NAME_11);
                        el = new House(id, a, b, c, d, e, f, g, h, j); // not 'i' here

                    } else {
                        el = new Room(id, a, b, c, d, e, f); // room
                    }

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

    @Override // CREATE
    public void create(Service el) throws SQLException {
        // 1.Open new connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String id = el.getServiceId();
        String a = el.getServiceName();
        String b = el.getServiceArea();
        String c = el.getServiceCost();
        String d = el.getServiceMaxPeople();
        String e = el.getRentTypeId();
        String f = el.getServiceTypeId();
        String g = null;
        String h = null;
        String i = null;
        String j = null;
        if (el instanceof Villa) {
            g = ((Villa) el).getStandardRoom();
            h = ((Villa) el).getDescriptionOtherConvenience();
            i = ((Villa) el).getPoolArea();
            j = ((Villa) el).getNumberOfFloors();
        } else if (el instanceof House) {
            g = ((House) el).getStandardRoom();
            h = ((House) el).getDescriptionOtherConvenience();
            j = ((House) el).getNumberOfFloors();
        }

        try {
            if (connection != null) {
                // 2.Create a statement with connection object, and setting
                if (el instanceof Villa) {
                    statement = connection.prepareStatement(INSERT_NEW_VILLA);
                    statement.setString(1, id);
                    statement.setString(2, a);
                    statement.setInt(3, Integer.parseInt(b));
                    statement.setDouble(4, Double.parseDouble(c));
                    statement.setInt(5, Integer.parseInt(d));
                    statement.setInt(6, Integer.parseInt(e));
                    statement.setInt(7, Integer.parseInt(f));
                    statement.setString(8, g);
                    statement.setString(9, h);
                    statement.setDouble(10, Double.parseDouble(i));
                    statement.setInt(11, Integer.parseInt(j));
                } else if (el instanceof House) {
                    statement = connection.prepareStatement(INSERT_NEW_HOUSE);
                    statement.setString(1, id);
                    statement.setString(2, a);
                    statement.setInt(3, Integer.parseInt(b));
                    statement.setDouble(4, Double.parseDouble(c));
                    statement.setInt(5, Integer.parseInt(d));
                    statement.setInt(6, Integer.parseInt(e));
                    statement.setInt(7, Integer.parseInt(f));
                    statement.setString(8, g);
                    statement.setString(9, h);
                    statement.setInt(10, Integer.parseInt(j));
                } else {
                    statement = connection.prepareStatement(INSERT_NEW_ROOM);
                    statement.setString(1, id);
                    statement.setString(2, a);
                    statement.setInt(3, Integer.parseInt(b));
                    statement.setDouble(4, Double.parseDouble(c));
                    statement.setInt(5, Integer.parseInt(d));
                    statement.setInt(6, Integer.parseInt(e));
                    statement.setInt(7, Integer.parseInt(f));
                }

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


    @Override  // UPDATE
    public boolean update(String id, Service el) throws SQLException {
       boolean rowUpdated = false;
        // 1.Open new connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String idNew = el.getServiceId();
        String a = el.getServiceName();
        String b = el.getServiceArea();
        String c = el.getServiceCost();
        String d = el.getServiceMaxPeople();
        String e = el.getRentTypeId();
        String f = el.getServiceTypeId();
        String g = null;
        String h = null;
        String i = null;
        String j = null;
        if (el instanceof Villa) {
            g = ((Villa) el).getStandardRoom();
            h = ((Villa) el).getDescriptionOtherConvenience();
            i = ((Villa) el).getPoolArea();
            j = ((Villa) el).getNumberOfFloors();
        } else if (el instanceof House) {
            g = ((House) el).getStandardRoom();
            h = ((House) el).getDescriptionOtherConvenience();
            j = ((House) el).getNumberOfFloors();
        }

        try {
            if (connection != null) {
                // 2.Create a statement with connection object, and setting
                if (el instanceof Villa) {
                    statement = connection.prepareStatement(UPDATE_SET_VILLA);
                    statement.setString(1, idNew);
                    statement.setString(2, a);
                    statement.setInt(3, Integer.parseInt(b));
                    statement.setDouble(4, Double.parseDouble(c));
                    statement.setInt(5, Integer.parseInt(d));
                    statement.setInt(6, Integer.parseInt(e));
                    statement.setInt(7, Integer.parseInt(f));
                    statement.setString(8, g);
                    statement.setString(9, h);
                    statement.setDouble(10, Double.parseDouble(i));
                    statement.setInt(11, Integer.parseInt(j));

                    // where service_id = id
                    statement.setString(12, id);
                } else if (el instanceof House) {
                    statement = connection.prepareStatement(UPDATE_SET_HOUSE);
                    statement.setString(1, idNew);
                    statement.setString(2, a);
                    statement.setInt(3, Integer.parseInt(b));
                    statement.setDouble(4, Double.parseDouble(c));
                    statement.setInt(5, Integer.parseInt(d));
                    statement.setInt(6, Integer.parseInt(e));
                    statement.setInt(7, Integer.parseInt(f));
                    statement.setString(8, g);
                    statement.setString(9, h);
                    statement.setInt(10, Integer.parseInt(j));

                    // where service_id = id
                    statement.setString(11, id);
                } else {
                    statement = connection.prepareStatement(UPDATE_SET_ROOM);
                    statement.setString(1, idNew);
                    statement.setString(2, a);
                    statement.setInt(3, Integer.parseInt(b));
                    statement.setDouble(4, Double.parseDouble(c));
                    statement.setInt(5, Integer.parseInt(d));
                    statement.setInt(6, Integer.parseInt(e));
                    statement.setInt(7, Integer.parseInt(f));

                    // where service_id = id
                    statement.setString(8, id);
                }

                // 3.Execute the query sql using statement
                rowUpdated = statement.executeUpdate() > 0;

                // 4.Process the result (if needed)
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // 5.Close the connection
            DBConnection.close();
        }
        return rowUpdated;
    }

    @Override  // DELETE
    public boolean delete(String id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowAffected = false;

        try {
            if (connection != null) {
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
}
