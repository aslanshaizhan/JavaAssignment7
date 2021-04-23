package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private static Connection connect;
    public static Connection getConnect(){
        try{
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forum",
                    "postgres","root");
        }catch(Exception e){
            e.printStackTrace();
        }
        return connect;
    }
}
