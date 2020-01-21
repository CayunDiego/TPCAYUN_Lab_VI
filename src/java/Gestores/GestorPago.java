/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Models.Pago;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class GestorPago {
     ConexionDB conex = new ConexionDB();
     
     public void agregar(Pago nuevo){
        try {
   
            conex.conectar();
            CallableStatement cst = conex.getConexion().prepareCall("{call altaPago (?,?,?)}");
            cst.setFloat(1, nuevo.getMontoPago());  
            cst.setDate(2, nuevo.getFecha());
            cst.setInt(3, nuevo.getCliente().getIdCliente());
            cst.execute();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
    }
}
