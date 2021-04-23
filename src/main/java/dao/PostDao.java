package dao;

import model.DB;
import model.PostBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao{

    public int createPost(PostBean postBean) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO posts" +
                "  (id, title, description) VALUES " +
                " (?, ?, ?);";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/forum", "postgres", "root");

             // Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, postBean.getTitle());
            preparedStatement.setString(3, postBean.getDescription());

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

    public static List<PostBean> view(){
        List<PostBean> list = new ArrayList<PostBean>();

        try{
            Connection connect = DB.getConnect();
            PreparedStatement ps = connect.prepareStatement("select * from 'posts'");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                PostBean postBean = new PostBean();
                postBean.setId(resultSet.getInt("id"));
                postBean.setTitle(resultSet.getString("title"));
                postBean.setDescription(resultSet.getString("description"));
                list.add(postBean);
            }
            connect.close();
        }catch(Exception e){System.out.println(e);}
        return list;
    }
}
