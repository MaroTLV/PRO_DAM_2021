package com.dao.factory;

import com.dao.StudentDAO;

/**
 *
 * Fabrica especifica de DAOs
 */
public abstract class DAOFactory {

    // Existirá un método get por cada DAO que exista en el sistema
    public abstract StudentDAO getStudentDAO();

    public static DAOFactory getDAOFactory() {
       return new MySqlDAOFactory();
    }
}