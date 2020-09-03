package main_user.dao;

import main_user.model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplement implements UserDAO {
    private static final String SELECT_ALL = "select * from users";
    private static final String INSERT_INTO = "insert into users(name, email, country) values (?,?,?);";
    private static final String SELECT_BY_ID = "select * from users where id = ?;";
    private static final String UPDATE_SET = "update users set name = ?, email = ?, country = ? where id = ?;";
    private static final String DELETE_FROM = "delete from users where id = ?;";
    private static final String SELECT_COUNTRY_OR_NAME = "select * from users where (country = ?) or (name like ?)";

    // Not using transaction
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY = ? WHERE NAME = ?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp,"
            + " PRIMARY KEY (ID)"
            + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";


    @Override
    public void create(User user) throws SQLException {
        // 1.Open new connection
        Connection connection = DBConnection.getConnection();
        CallableStatement callableStatement = null;
        String sql_call = "{CALL insert_user(?,?,?)}";
        try {
            if (connection != null) {
                // 2.Create a statement with connection object, and setting
                callableStatement = connection.prepareCall(sql_call);
                callableStatement.setString(1, user.getName());
                callableStatement.setString(2, user.getEmail());
                callableStatement.setString(3, user.getCountry());

                // 3.Execute the query sql using statement
                callableStatement.executeUpdate();

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
    public User findById(int id) {
        // 1.Open new connection
        Connection connection = DBConnection.getConnection();
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        User user = null;
        String sqlCall = "{CALL get_user_by_id(?)}";
        try {
            if (connection != null) {
                // 2.Create statement with connection object, and setting
                callableStatement = connection.prepareCall(sqlCall);
                callableStatement.setInt(1, id);

                // 3.Execute the query sql using statement
                resultSet = callableStatement.executeQuery();

                // 4.Process the result (if needed)
                 if (resultSet.next()) {
                    user = new User();
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setCountry(resultSet.getString("country"));
//                    user.setId(id);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // 5.Close the connection
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
        String select_all = "{CALL select_all_users()}";
        if (connection != null) {
            try {
                statement = connection.prepareStatement(select_all);
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
        String delete_sql = "{CALL delete_user(?)}";
        if (connection != null) {
            try {
                statement = connection.prepareStatement(delete_sql);
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
        String update_sql = "{CALL update_user(?,?,?,?)}";
        try {
            if (connection != null) {
                statement = connection.prepareStatement(update_sql);
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
                statement.setString(2, "%" + str + "%");
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

    // Test conn.commit() and conn.rollback()
    @Override
    public void addUserTransactionPractice(User user, int[] permissions) {
        Connection conn = null;
        // for insert a new user
        PreparedStatement pstmt = null;
        // for assign permission to user
        PreparedStatement pstmtAssignment = null;
        // for getting user id
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            // set auto commit to false
            conn.setAutoCommit(false);
            // Insert user
            String INSERT_USERS_SQL = "insert into users(name, email, country) values (?,?,?)";
            //
            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();
            // get user id
            rs = pstmt.getGeneratedKeys();
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt(1);
            }

            // in case the insert operation successes, assign permission to user
            if (rowAffected == 1) {
                // assign permission to user
                String sqlPivot = "INSERT INTO user_permission(user_id,permission_id) VALUES (?,?)";
                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permissionId : permissions) {
                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, permissionId);

                    pstmtAssignment.executeUpdate();
                }
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException ex) {
            // roll back the transaction
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (pstmtAssignment != null) pstmtAssignment.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);

            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            // Run list of insert commands
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            //Run list of update commands
            // below line caused error, test transaction
            // SQLException: No value specified for parameter 1.
            psUpdate.setBigDecimal(2, new BigDecimal(999.99));
            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");
            psUpdate.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUpdateTransaction() {
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);

            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            /* Start transaction block */
            connection.setAutoCommit(false); //-->default = true

            // Run list of insert commands
            psInsert.setString(1, "Huy");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Chuong");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            //Run list of update commands
            // below line caused error, test transaction
            // java.sql.SQLException: No value specified for parameter 1.
            psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Huy");
            psUpdate.execute();

            // End transaction block, commit change now
            connection.commit();

            // Good practice to set it back to default value
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUserTransaction() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        String insert_sql = "{CALL insert_user(?,?,?)}";

        User user1 = new User("Test 1", "test1@transaction.com", "Transact1");
        User user2 = new User("Test 2", "test2@transaction.com", "Transact2");
        User user3 = new User("Test 3", "test3@transaction.com", "Transact3");

        try {
            connection = DBConnection.getConnection();
            //setAutocommit()
            connection.setAutoCommit(false);

            //Run list of commands
            callableStatement = connection.prepareCall(insert_sql);

            // Add user1
            callableStatement.setString(1, user1.getName());
            callableStatement.setString(2, user1.getEmail());
            callableStatement.setString(3, user1.getCountry());
            callableStatement.executeQuery();

            // Add user2
            callableStatement.setString(1, user2.getName());
            callableStatement.setString(2, user2.getEmail());
            callableStatement.setString(3, user2.getCountry());
            callableStatement.executeQuery();

            // Add user3
            callableStatement.setString(1, user3.getName());
            callableStatement.setString(2, user3.getEmail());
            callableStatement.setString(3, user3.getCountry());

            //if using below line, program will fail and throw an exception as below
            //callableStatement.setString(4, user3.getCountry());
            //java.sql.SQLException: Parameter index out of range (4 > number of parameters, which is 3).
            callableStatement.executeQuery();


            //Commit process
            connection.commit();
            //Set autocommit to true
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
