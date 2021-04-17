package com.dao;

import com.dao.beans.User;
import com.util.MySqlConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection dbConnection;
    private PreparedStatement pStmt;

    public UserDAO() {
        dbConnection = MySqlConexion.obtenerConexion();
    }

    public void addUser(User user) throws SQLException {
        String insertQuery = "INSERT INTO USER(EMAIL_ID, PASSWORD, NAME, "
                + "ROLE) VALUES (?,?,?,?)";
        try {
            pStmt = dbConnection.prepareStatement(insertQuery);
            pStmt.setString(1, user.getEmailId());
            pStmt.setString(2, user.getPassword());
            pStmt.setString(3, user.getName());
            pStmt.setString(4, user.getRole());
            pStmt.executeUpdate();
        } catch (SQLException e) {            
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public void deleteUser(String emailId) {
        String deleteQuery = "DELETE FROM USER WHERE EMAIL_ID = ?";
        try {
            pStmt = dbConnection.prepareStatement(deleteQuery);
            pStmt.setString(1, emailId);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateUser(User user) {
        String updateQuery = "UPDATE USER SET NAME = ?, PASSOWRD = ?, "
                + "ROLE = ? WHERE EMAIL_ID = ?";
        try {
            pStmt = dbConnection.prepareStatement(updateQuery);
            pStmt.setString(1, user.getName());
            pStmt.setString(2, user.getPassword());
            pStmt.setString(3, user.getRole());
            pStmt.setString(4, user.getEmailId());
            pStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public User getUser(String emailId, String password) {
        String selectQuery = "SELECT * FROM USER WHERE EMAIL_ID = ? AND PASSWORD = ?";
        User userBD = null;
        try {
            pStmt = dbConnection.prepareStatement(selectQuery);
            pStmt.setString(1, emailId);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
            
            while (rs.next()) {
                userBD = new User();

                userBD.setPassword(rs.getString("PASSWORD"));
                userBD.setEmailId(rs.getString("EMAIL_ID"));
                userBD.setName(rs.getString("NAME"));
                userBD.setRole(rs.getString("ROLE"));    
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return userBD;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();

        String query = "SELECT * FROM USER ORDER BY USER_ID";
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setPassword(rs.getString("PASSWORD"));
                user.setEmailId(rs.getString("EMAIL_ID"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));                
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }
}
