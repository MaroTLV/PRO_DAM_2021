package com.service;

import com.dao.StudentDAO;
import com.dao.beans.Student;
import com.dao.factory.DAOFactory;
import java.util.List;

public class StudentService {

    // Referenciamos la fábrica específica de daos y le indicamos nuestro origen de datos (MSSQL)
    DAOFactory fabrica = DAOFactory.getDAOFactory();

    // Le pedimos a la fábrica específica el o los daos que necesitemos
    StudentDAO objStudentDAO = fabrica.getStudentDAO();

    // Operaciones
    /*public String obtenerCodProd() {
        return objStudentDAO.obtenerCodProd();
    }

    public ProductoDTO obtenerProducto(String codigo) {
        return objStudentDAO.obtenerProducto(codigo);
    }*/

    public List<Student> getAllStudents(String nombre) {
        return objStudentDAO.getAllStudents();
    }

    /*public int registrarProducto(ProductoDTO productoDTO) {
        return objStudentDAO.registrarProducto(productoDTO);
    }

    public int actualizarProducto(ProductoDTO productoDTO) {
        return objStudentDAO.actualizarProducto(productoDTO);
    }

    public int eliminarProducto(String codigo) {
        return objStudentDAO.eliminarProducto(codigo);
    }*/
    
}