/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class ConexionDB {
    private static final String PASS = "agosto09";
    private static final String USER = "sa";
    private static final String URL = "jdbc:sqlserver://CAYUN\\SQLEXPRESS;databaseName=CuentaCorrienteDBV3";
    private Connection con;
    
    
    public ConexionDB(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void conectar(){
        try {
           con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconectar(){
        try {
            if(con != null && !con.isClosed())
                con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar conexión");
        }
    }

    public Connection getConexion() {
        return con;
    }
}
