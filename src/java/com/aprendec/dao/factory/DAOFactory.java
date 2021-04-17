package com.aprendec.dao.factory;

import com.aprendec.dao.ProductoDAO;
import com.aprendec.dao.StudentDAO;

/**
 *
 * Fabrica especifica de DAOs
 */
public abstract class DAOFactory {

    // Definimos unas constantes por cada base de datos
    public static final int MYSQL = 1;
    public static final int SQLSERVER = 2;

    // Existirá un método get por cada DAO que exista en el sistema
    public abstract ProductoDAO getProductoDAO();
    
    // Existirá un método get por cada DAO que exista en el sistema
    public abstract StudentDAO getStudentDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return new MySqlDAOFactory();
            case SQLSERVER:
                return new SqlServerDAOFactory();
            default:
                return null;
        }
    }
}