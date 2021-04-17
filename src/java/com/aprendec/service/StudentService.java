package com.aprendec.service;

import com.aprendec.dao.ProductoDAO;
import com.aprendec.dao.StudentDAO;
import com.aprendec.dao.beans.ProductoDTO;
import com.aprendec.dao.beans.Student;
import com.aprendec.dao.factory.DAOFactory;
import com.aprendec.util.Constantes;
import java.util.List;

public class StudentService {

    // Referenciamos la fábrica específica de daos y le indicamos nuestro origen de datos (MSSQL)
    DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);

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