package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {

            String dbUrl = "jdbc:mysql://192.168.1.38:3306/bdplatform?serverTimezone=UTC";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // set the url, username and password for the database
                connection = DriverManager.getConnection(dbUrl, "sugar", "sugar");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}