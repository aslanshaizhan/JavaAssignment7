package dao;

import model.CommentBean;
import model.DB;
import model.PostBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao{

    public int addComment(CommentBean commentBean) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO comments" +
                "  (id, login, comment) VALUES " +
                " (?, ?, ?);";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/forum", "postgres", "root");

             // Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, commentBean.getLogin());
            preparedStatement.setString(3, commentBean.getComment());

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

    public static List<CommentBean> view(){
        List<CommentBean> list = new ArrayList<CommentBean>();

        try{
            Connection connect = DB.getConnect();
            PreparedStatement ps = connect.prepareStatement("select * from 'comments'");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                CommentBean commentBean = new CommentBean();
                commentBean.setId(resultSet.getInt("id"));
                commentBean.setLogin(resultSet.getString("login"));
                commentBean.setComment(resultSet.getString("comment"));
                list.add(commentBean);
            }
            connect.close();
        }catch(Exception e){System.out.println(e);}
        return list;
    }
}
