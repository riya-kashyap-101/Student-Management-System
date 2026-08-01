package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/studentdb";
    private static final String USER = "postgres";
    private static final String PASS="1912";

    public static Connection getConnection() {
         try{
             return DriverManager.getConnection(URL,USER,PASS);
         } catch (SQLException e) {
             e.printStackTrace();
             return null;
         }

    }


}
