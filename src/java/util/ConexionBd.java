/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alexander
 */
public class ConexionBd {
    private String driver, user, password, urlBd, port, nameDB;
    private Connection conexion;
    public static Statement st=null;
    public static ResultSet rt=null;
    
    public ConexionBd(){
        driver="com.mysql.jdbc.Driver";
        user="root";
        password="";
        nameDB="ubikuo_final";
        port="3306";
        urlBd="jdbc:mysql://localhost:" + port+ "/" +nameDB; 
      
       
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlBd, user, password);
            System.out.println("¡Conexion OK!");
        } catch (Exception e) {
            System.out.println("Error al conectarse " + e.toString());
        }      
    }
    public Connection obtenerConexion(){
        
        return conexion;
    }
    public Connection cerrarConexion() throws SQLException{
        
        conexion.close();
        conexion = null;
        return conexion;
    }
    public static void main(String[] args) {
        new ConexionBd();
    }
}
