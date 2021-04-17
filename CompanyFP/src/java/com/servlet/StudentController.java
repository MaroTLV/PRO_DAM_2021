package com.servlet;

import com.dao.StudentDAO;
import com.dao.beans.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

    private StudentDAO studentDAO;

    public StudentController() {
        studentDAO = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String action = request.getParameter("action");
        List<Student> studentList = new ArrayList<Student>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        response.setContentType("application/json");
                
        if (Boolean.valueOf(user)) {
           request.getRequestDispatcher("/login/login.jsp").forward(request, response); 
        } else {
            request.getRequestDispatcher("mainintranet.jsp").forward(request, response);
        }
        
        if (action != null) {

            try {
                //HashMap<String, Object> JSONROOT = new HashMap<String, Object>();//++++++

                if (action.equals("list")) {
                    // Fetch Data from Student Table
                    studentList = studentDAO.getAllStudents();
                    //int startPageIndex = Integer.parseInt(request.getParameter("jtStartIndex"));//+++++
                    // int recordsPerPage = Integer.parseInt(request.getParameter("jtPageSize"));//++++
                    // studentList = dao.getAllStudents(startPageIndex, recordsPerPage);//++++++
                    int userCount = studentDAO.getStudentCount();//++++

                    // Return in the format required by jTable plugin
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", studentList);
                    JSONROOT.put("TotalRecordCount", userCount);//+++++

                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);

                    response.getWriter().print(jsonArray);
                } else if (action.equals("create") || action.equals("update")) {
                    Student student = new Student();
                    if (request.getParameter("studentId") != null) {
                        int studentId = Integer.parseInt(request.getParameter("studentId"));
                        student.setStudentId(studentId);
                    }

                    if (request.getParameter("name") != null) {
                        String name = request.getParameter("name");
                        student.setName(name);
                    }

                    if (request.getParameter("department") != null) {
                        String department = request.getParameter("department");
                        student.setClase(department);
                    }

                    if (request.getParameter("emailId") != null) {
                        String emailId = request.getParameter("emailId");
                        student.setMatricula(emailId);
                    }

                    if (action.equals("create")) {
                        // Create new record
                        studentDAO.addStudent(student);
                    } else if (action.equals("update")) {
                        // Update existing record
                        studentDAO.updateStudent(student);
                    }

                    // Return in the format required by jTable plugin
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Record", student);

                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);
                    response.getWriter().print(jsonArray);
                } else if (action.equals("delete")) {
                    // Delete record
                    if (request.getParameter("studentId") != null) {
                        int studentId = Integer.parseInt(request.getParameter("studentId"));
                        studentDAO.deleteStudent(studentId);

                        // Return in the format required by jTable plugin
                        JSONROOT.put("Result", "OK");

                        // Convert Java Object to Json
                        String jsonArray = gson.toJson(JSONROOT);
                        response.getWriter().print(jsonArray);
                    }
                }
            } catch (Exception ex) {
                JSONROOT.put("Result", "ERROR");
                JSONROOT.put("Message", ex.getMessage());
                String error = gson.toJson(JSONROOT);
                response.getWriter().print(error);
            }
        }
    }
}
