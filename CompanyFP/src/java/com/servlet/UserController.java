package com.servlet;

import com.dao.StudentDAO;
import com.dao.UserDAO;
import com.dao.beans.Student;
import com.dao.beans.User;
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

public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

    private UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();
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
        
        /*if (Boolean.valueOf(user)) {
           request.getRequestDispatcher("/login/login.jsp").forward(request, response); 
        } else {
            request.getRequestDispatcher("mainintranet.jsp").forward(request, response);
        }*/
        
        if (action != null) {

            try {
                //HashMap<String, Object> JSONROOT = new HashMap<String, Object>();//++++++

                if (action.equals("exit")) {
                    request.getRequestDispatcher("index.html").forward(request, response); 
                    
                } else if (action.equals("login")) {
                    User userVO = new User();
                    

                    userVO = userDAO.getUser(request.getParameter("emailId"), request.getParameter("password"));
                    if (userVO != null) {
                        request.getRequestDispatcher("mainintranet.jsp").forward(request, response); 
                        
                    } else {
                        request.getRequestDispatcher("/login/login.jsp").forward(request, response); 
                    
                    }
                    

                } else if (action.equals("create")) {
                    User userVO = new User();
                    userVO.setEmailId(request.getParameter("email"));                    
                    userVO.setName(request.getParameter("name"));
                    userVO.setPassword(request.getParameter("password"));
                    
                    // Create new record
                    try {
                        userDAO.addUser(userVO);
                        request.getRequestDispatcher("/mainintranet.jsp").forward(request, response); 
                    } catch (Exception ex) {
                        response.setContentType("text/html");
                        request.setAttribute("error", "Usuario duplicado");
                        request.getRequestDispatcher("/login/sign-up.jsp").forward(request, response); 
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
