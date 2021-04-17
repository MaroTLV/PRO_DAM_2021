package com.service;

import com.dao.UserDAO;
import com.dao.beans.Student;
import com.dao.beans.User;
import com.dao.factory.DAOFactory;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    // Referenciamos la fábrica específica de daos y le indicamos nuestro origen de datos (MSSQL)
    DAOFactory fabrica = DAOFactory.getDAOFactory();

    // Le pedimos a la fábrica específica el o los daos que necesitemos
    UserDAO objUserDAO = fabrica.getUserDAO();

    

    public User getUser(String email, String password) {
        return objUserDAO.getUser(email, password);
    }

    public List<User> login(String nombre) {
        return objUserDAO.getAllUser();
    }

    public void registrarUser(User user) throws SQLException {
        objUserDAO.addUser(user);
    }

    public void updateUser(User user) {
        objUserDAO.updateUser(user);
    }

    public void deleteUser(String emailId) {
        objUserDAO.deleteUser(emailId);
    }
    
}