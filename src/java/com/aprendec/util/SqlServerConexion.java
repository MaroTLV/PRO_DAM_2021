/*
 * Clase conexión a base de datos SQL Server
 */
package com.aprendec.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlServerConexion {

    static {
        try {
            // CARGAR EL CONTROLADOR DE BD
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println("[SqlServerConexion] Error al cargar el driver de conexión");
            e.printStackTrace();
        }
    }

    public static Connection obtenerConexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:sqlserver://XXKOKOXXT-PC:1433;databasename=ReealoDB2019", "sa", "sql");
        } catch (Exception e) {
            System.out.println("[SqlServerConexion] Error al obtener la conexión");
            e.printStackTrace();
        }
        return con;
    }
    
}