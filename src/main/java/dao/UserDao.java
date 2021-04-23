package dao;

import model.DB;
import model.UserBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public int registerUser(UserBean userBean) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users" +
                "  (id, firstname, lastname, email, phoneNumber, password) VALUES " +
                " (?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/forum", "postgres", "root");

             // Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, userBean.getFirstName());
            preparedStatement.setString(3, userBean.getLastName());
            preparedStatement.setString(4, userBean.getEmail());
            preparedStatement.setString(5, userBean.getPhoneNumber());
            preparedStatement.setString(6, userBean.getPassword());

            System.out.println(preparedStatement);
            // Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public static List<UserBean> view(){
        List<UserBean> list = new ArrayList<UserBean>();

        try{
            Connection connect = DB.getConnect();
            PreparedStatement ps = connect.prepareStatement("select * from 'users'");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                UserBean userBean = new UserBean();
                userBean.setId(resultSet.getInt("id"));
                userBean.setFirstName(resultSet.getString("fisrtname"));
                userBean.setLastName(resultSet.getString("lastname"));
                userBean.setEmail(resultSet.getString("email"));
                userBean.setPhoneNumber(resultSet.getString("phoneNumber"));
                userBean.setPassword(resultSet.getString("password"));
                list.add(userBean);
            }
            connect.close();
        }catch(Exception e){System.out.println(e);}
        return list;
    }
}
