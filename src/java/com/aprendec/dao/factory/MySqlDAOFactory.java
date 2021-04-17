package com.aprendec.dao.factory;

import com.aprendec.dao.MySqlProductoDAO;
import com.aprendec.dao.ProductoDAO;
import com.aprendec.dao.StudentDAO;

public class MySqlDAOFactory extends DAOFactory {

    public MySqlDAOFactory() {
    }

    // Estamos aplicando la 2da forma de polimorfismo.
    // Una clase puede ser enmascarada con la interface que implementa
    @Override
    public ProductoDAO getProductoDAO() {
        return new MySqlProductoDAO();
    }
    
    // Estamos aplicando la 2da forma de polimorfismo.
    // Una clase puede ser enmascarada con la interface que implementa
    @Override
    public StudentDAO getStudentDAO() {
        return new StudentDAO();
    }

}