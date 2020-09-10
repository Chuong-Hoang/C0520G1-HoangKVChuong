package main.dao.product_dao;

import main.common.DBConnection;
import main.model.product_model.ExProduct;
import main.model.product_model.ImProduct;
import main.model.product_model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImplement implements ProductDAO {
    /* ....................... Table and Column ......................*/
    private static final String TABLE_NAME = " `product` ";

    private static final String COL_NAME_1 = "product_id";
    private static final String COL_NAME_2 = "product_code";
    private static final String COL_NAME_3 = "product_name";
    private static final String COL_NAME_4 = "product_price";
    private static final String COL_NAME_5 = "product_quantity";
    private static final String COL_NAME_6 = "product_producer";

    private static final String COL_NAME_7 = "imported_price";
    private static final String COL_NAME_8 = "import_province";
    private static final String COL_NAME_9 = "import_tax";

    private static final String COL_NAME_10 = "exported_price";
    private static final String COL_NAME_11 = "buying_country";

    private static final String cm = ",";
    private static final String eq = " = ?";
    /* ....................... Table end ......................*/
//    String title_id = "Product ID";//id
//    String title_a = "Product Code";//a
//    String title_b = "Product Name";//b
//    String title_c = "Product Price";//c
//    String title_d = "Product Quantity";//d
//    String title_e = "Product Producer";//e
//
//    String title_f = "Imported Price";//f
//    String title_g = "Import Province";//g
//    String title_h = "Import Tax";//h
//
//    String title_i = "Exported Price";//i (only ex)
//    String title_j = "Buying Country";//j (only ex)

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

    private static final String ADD_NEW = "INSERT INTO " + TABLE_NAME + "(" + COL_NAME_1 + cm + COL_NAME_2 + cm +
            COL_NAME_3 + cm + COL_NAME_4 + cm + COL_NAME_5 + cm + COL_NAME_6;

    private static final String NEW_IMPORT = cm + COL_NAME_7 + cm + COL_NAME_8 + cm + COL_NAME_9
            + ")" + " VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String NEW_EXPORT = cm + COL_NAME_10 + cm + COL_NAME_11
            + ")" + " VALUES (?,?,?,?,?,?,?,?)";

    private static final String INSERT_IMPORT_PRODUCT = ADD_NEW + NEW_IMPORT;

    private static final String INSERT_EXPORT_PRODUCT = ADD_NEW + NEW_EXPORT;

    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String UPDATE_SQL = "UPDATE " + TABLE_NAME + " SET " + COL_NAME_1 + eq + cm +
            COL_NAME_2 + eq + cm + COL_NAME_3 + eq + cm + COL_NAME_4 + eq + cm +
            COL_NAME_5 + eq + cm + COL_NAME_6 + eq;

    private static final String SET_IMPORT = cm + COL_NAME_7 + eq + cm + COL_NAME_8 + eq + cm + COL_NAME_9;

    private static final String SET_EXPORT = cm + COL_NAME_10 + eq + cm + COL_NAME_11;


    private static final String WHERE_ID_EQUAL = " WHERE " + COL_NAME_1 + eq;

    private static final String UPDATE_IMPORT_PRODUCT = UPDATE_SQL + SET_IMPORT + WHERE_ID_EQUAL;

    private static final String UPDATE_EXPORT_PRODUCT = UPDATE_SQL + SET_EXPORT + WHERE_ID_EQUAL;

    private static final String DELETE_FROM = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String SELECT_BY_NAME = "SELECT * FROM " + TABLE_NAME + " WHERE `product_name` like ?";


    @Override // FIND ALL
    public List<Product> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> eList = new ArrayList<>();
        Product el = null;

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
                    String e = resultSet.getString(COL_NAME_6);


                    if (resultSet.getString(COL_NAME_7) != null) {
                        String f = resultSet.getString(COL_NAME_7);
                        String g = resultSet.getString(COL_NAME_8);
                        String h = resultSet.getString(COL_NAME_9);

                        el = new ImProduct(id, a, b, c, d, e, f, g, h);

                    } else {
                        String i = resultSet.getString(COL_NAME_10);
                        String j = resultSet.getString(COL_NAME_11);
                        el = new ExProduct(id, a, b, c, d, e, i, j);

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
    public Product findById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product el = null;

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
                    String e = resultSet.getString(COL_NAME_6);


                    if (resultSet.getDouble(COL_NAME_7) != 0) {
                        String f = resultSet.getString(COL_NAME_7);
                        String g = resultSet.getString(COL_NAME_8);
                        String h = resultSet.getString(COL_NAME_9);

                        el = new ImProduct(id, a, b, c, d, e, f, g, h);

                    } else {
                        String i = resultSet.getString(COL_NAME_10);
                        String j = resultSet.getString(COL_NAME_11);
                        el = new ExProduct(id, a, b, c, d, e, i, j);
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
    public List<Product> findByName(String str) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> eList = new ArrayList<>();
        Product el = null;

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
                    String e = resultSet.getString(COL_NAME_6);

                    if (resultSet.getDouble(COL_NAME_7) != 0) {
                        String f = resultSet.getString(COL_NAME_7);
                        String g = resultSet.getString(COL_NAME_8);
                        String h = resultSet.getString(COL_NAME_9);

                        el = new ImProduct(id, a, b, c, d, e, f, g, h);

                    } else {
                        String i = resultSet.getString(COL_NAME_10);
                        String j = resultSet.getString(COL_NAME_11);
                        el = new ExProduct(id, a, b, c, d, e, i, j);
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
    public void create(Product el) throws SQLException {
        // 1.Open new connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        String id = el.getId();
        String a = el.getProductCode();
        String b = el.getProductName();
        String c = el.getProductPrice();
        String d = el.getProductQuantity();
        String e = el.getProductProducer();
        String f = null;
        String g = null;
        String h = null;
        String i = null;
        String j = null;
        if (el instanceof ImProduct) {
            f = ((ImProduct) el).getImportedPrice();
            g = ((ImProduct) el).getImportProvince();
            h = ((ImProduct) el).getImportTax();

        } else if (el instanceof ExProduct) {
            i = ((ExProduct) el).getExportedPrice();
            j = ((ExProduct) el).getBuyingCountry();
        }

        try {
            if (connection != null) {
                // 2.Create a statement with connection object, and setting
                if (el instanceof ImProduct) {
                    statement = connection.prepareStatement(INSERT_IMPORT_PRODUCT);

                    statement.setInt(1, Integer.parseInt(id));
                    statement.setString(2, a);
                    statement.setString(3, b);
                    statement.setDouble(4, Double.parseDouble(c));
                    statement.setInt(5, Integer.parseInt(d));
                    statement.setString(6, e);

                    statement.setDouble(7, Double.parseDouble(f));
                    statement.setString(8, g);
                    statement.setDouble(9,  Double.parseDouble(h));

                } else {
                    statement = connection.prepareStatement(INSERT_EXPORT_PRODUCT);

                    statement.setInt(1, Integer.parseInt(id));
                    statement.setString(2, a);
                    statement.setString(3, b);
                    statement.setDouble(4, Double.parseDouble(c));
                    statement.setInt(5, Integer.parseInt(d));
                    statement.setString(6, e);

                    statement.setDouble(7, Double.parseDouble(i));
                    statement.setString(8, j);
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
    public boolean update(String id, Product el) throws SQLException {
        boolean rowUpdated = false;
        // 1.Open new connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        String idNew = el.getId();
        String a = el.getProductCode();
        String b = el.getProductName();
        String c = el.getProductPrice();
        String d = el.getProductQuantity();
        String e = el.getProductProducer();
        String f = null;
        String g = null;
        String h = null;
        String i = null;
        String j = null;
        if (el instanceof ImProduct) {
            f = ((ImProduct) el).getImportedPrice();
            g = ((ImProduct) el).getImportProvince();
            h = ((ImProduct) el).getImportTax();

        } else if (el instanceof ExProduct) {
            i = ((ExProduct) el).getExportedPrice();
            j = ((ExProduct) el).getBuyingCountry();
        }

        try {
            if (connection != null) {
                // 2.Create a statement with connection object, and setting
                if (el instanceof ImProduct) {
                    statement = connection.prepareStatement(UPDATE_IMPORT_PRODUCT);
                    statement.setInt(1, Integer.parseInt(idNew));
                    statement.setString(2, a);
                    statement.setString(3, b);
                    statement.setDouble(4, Double.parseDouble(c));
                    statement.setInt(5, Integer.parseInt(d));
                    statement.setString(6, e);

                    statement.setDouble(7, Double.parseDouble(f));
                    statement.setString(8, g);
                    statement.setDouble(9,  Double.parseDouble(h));

                    // where service_id = id
                    statement.setString(10, id);
                } else if (el instanceof ExProduct) {
                    statement = connection.prepareStatement(UPDATE_EXPORT_PRODUCT);
                    statement.setInt(1, Integer.parseInt(idNew));
                    statement.setString(2, a);
                    statement.setString(3, b);
                    statement.setDouble(4, Double.parseDouble(c));
                    statement.setInt(5, Integer.parseInt(d));
                    statement.setString(6, e);

                    statement.setDouble(7, Double.parseDouble(i));
                    statement.setString(8, j);

                    // where service_id = id
                    statement.setString(9, id);
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
