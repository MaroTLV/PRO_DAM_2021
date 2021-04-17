package com.dao;

import com.dao.beans.Student;
import com.util.MySqlConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private Connection dbConnection;
    private PreparedStatement pStmt;

    public StudentDAO() {
        dbConnection = MySqlConexion.obtenerConexion();
    }

    public void addStudent(Student student)throws SQLException {
        String insertQuery = "INSERT INTO STUDENT(STUDENTID, NAME, "
                + "CLASE, MATRICULA) VALUES (?,?,?,?)";
        try {
            pStmt = dbConnection.prepareStatement(insertQuery);
            pStmt.setInt(1, student.getStudentId());
            pStmt.setString(2, student.getName());
            pStmt.setString(3, student.getClase());
            pStmt.setString(4, student.getMatricula());
            pStmt.executeUpdate();
        } catch (SQLException e) {            
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public void deleteStudent(int userId) {
        String deleteQuery = "DELETE FROM STUDENT WHERE STUDENTID = ?";
        try {
            pStmt = dbConnection.prepareStatement(deleteQuery);
            pStmt.setInt(1, userId);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateStudent(Student student) {
        String updateQuery = "UPDATE STUDENT SET NAME = ?, "
                + "CLASE = ?, MATRICULA = ? WHERE STUDENTID = ?";
        try {
            pStmt = dbConnection.prepareStatement(updateQuery);
            pStmt.setString(1, student.getName());
            pStmt.setString(2, student.getClase());
            pStmt.setString(3, student.getMatricula());
            pStmt.setInt(4, student.getStudentId());
            pStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();

        String query = "SELECT * FROM STUDENT ORDER BY STUDENTID";
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Student student = new Student();

                student.setStudentId(rs.getInt("STUDENTID"));
                student.setName(rs.getString("NAME"));
                student.setClase(rs.getString("CLASE"));
                student.setMatricula(rs.getString("MATRICULA"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return students;
    }

    public int getStudentCount() {
        int count = 0;
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS COUNT FROM STUDENT");
            while (rs.next()) {
                count = rs.getInt("COUNT");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return count;
    }
}
