/*
 * Clase conexión a base de datos MySQL
 */
package com.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySqlConexion {
    
    final static String PROPERTIES_FILE = "config.properties";
    
    /**
     * Load file properties
     */
    private static Properties properties = inicializaFicheroProperties();

    /**
     * Method to inizialite file properties
     * @return Properties
     */
    private static Properties inicializaFicheroProperties() {
        Properties prop = new Properties();
        try {
            prop.load(MySqlConexion.class.getResourceAsStream(PROPERTIES_FILE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
    
       
    static {
        try {
            // CARGAR EL CONTROLADOR DE BD
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("[MySqlConexion] Error al cargar el driver de conexión");
            e.printStackTrace();
        }
    }

    public static Connection obtenerConexion() {
        Connection con = null;
        try {
            //con = DriverManager.getConnection("jdbc:mysql://192.168.1.39:3306/companyfp_bd?serverTimezone=UTC", "sugar", "sugar");
            
            con = DriverManager.getConnection(
                            "jdbc:mysql://" + 
                            properties.getProperty("IP") + ":" + properties.getProperty("PUERTO") + "/" +
                            properties.getProperty("DB_NAME")+"?serverTimezone=UTC", properties.getProperty("USER_BD"), properties.getProperty("USER_PWD"));
        } catch (Exception e) {
            System.out.println("[MySqlConexion] Error al obtener la conexión: ");
            e.printStackTrace();
        }
        return con;
    }
    
}


