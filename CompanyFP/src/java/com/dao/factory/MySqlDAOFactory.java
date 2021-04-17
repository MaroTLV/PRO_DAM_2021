package com.dao.factory;

import com.dao.StudentDAO;
import com.dao.UserDAO;

public class MySqlDAOFactory extends DAOFactory {

    public MySqlDAOFactory() {
    }
    
    // Estamos aplicando la 2da forma de polimorfismo.
    // Una clase puede ser enmascarada con la interface que implementa
    @Override
    public StudentDAO getStudentDAO() {
        return new StudentDAO();
    }
    
    @Override
    public UserDAO getUserDAO() {
        return new UserDAO();
    }

}