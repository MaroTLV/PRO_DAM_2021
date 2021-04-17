package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            // Store the database URL in a string
            //String serverName = "127.0.0.1";
            //String portNumber = "1521";
            //String sid = "XE";
            String dbUrl = "jdbc:mysql://localhost:3306/test";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // set the url, username and password for the database
                connection = DriverManager.getConnection(dbUrl, "root", "6789");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
