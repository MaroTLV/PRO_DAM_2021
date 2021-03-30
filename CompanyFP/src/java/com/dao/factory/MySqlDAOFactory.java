package com.dao.factory;

import com.dao.StudentDAO;

public class MySqlDAOFactory extends DAOFactory {

    public MySqlDAOFactory() {
    }
    
    // Estamos aplicando la 2da forma de polimorfismo.
    // Una clase puede ser enmascarada con la interface que implementa
    @Override
    public StudentDAO getStudentDAO() {
        return new StudentDAO();
    }

}