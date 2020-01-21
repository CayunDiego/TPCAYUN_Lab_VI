/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Models.Reporte;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class GestorReportes {
    ConexionDB conex = new ConexionDB();
    
    public ArrayList<Reporte> reporte1(){
        ArrayList<Reporte> lista = new ArrayList<>();
        try {
            
            conex.conectar();
            Statement st = conex.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reporte1");
            while (rs.next()) {
                Reporte r = new Reporte();
                
                r.setNombre(rs.getString("nombre"));
                r.setApellido(rs.getString("apellido"));
                r.setSaldo(rs.getFloat("saldo"));
                r.setEstado(rs.getString("estado"));
                r.setSumCompra(rs.getFloat("sumCompras"));
                r.setSumPago(rs.getFloat("sumPagos"));
                lista.add(r);
            }
            rs.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
        return lista;
    }
    
    
    public ArrayList<Reporte> reporte2(){
        ArrayList<Reporte> lista = new ArrayList<>();
        try {
            
            conex.conectar();
            Statement st = conex.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reporte2");
            while (rs.next()) {
                Reporte r = new Reporte();
                r.setNombre(rs.getString("nombre"));
                r.setApellido(rs.getString("apellido"));
                r.setMontoPago(rs.getFloat("monto_pago"));
                r.setFecha(rs.getDate("fecha"));
                lista.add(r);
            }
            rs.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
        return lista;
    }

    public ArrayList<Reporte> reporte3(int idCliente){
        ArrayList<Reporte> lista = new ArrayList<>();
        try {
            
            conex.conectar();
            Statement st = conex.getConexion().createStatement();
            ResultSet rs = st.executeQuery("select * from dbo.ListadoOperacionesReporte3("+ idCliente +")");
            while (rs.next()) {
                Reporte r = new Reporte();
                r.setSaldo(rs.getFloat("saldo"));
                r.setEstado(rs.getString("operacion"));
                r.setFecha(rs.getDate("fecha"));
                lista.add(r);
            }
            rs.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
        return lista;
    }
    
    public ArrayList<Reporte> reporte4(int idRubro){
        ArrayList<Reporte> lista = new ArrayList<>();
        try {
            
            conex.conectar();
            Statement st = conex.getConexion().createStatement();
            ResultSet rs = st.executeQuery("select * from dbo.ListadoReporte4("+idRubro+")");
            while (rs.next()) {
                Reporte r = new Reporte();
                r.setNomArticulo(rs.getString("articulo"));
                r.setCantVeces(rs.getInt("cantV"));
                r.setCantVend(rs.getInt("totalV"));
                r.setCantClient(rs.getInt("cantC"));
                lista.add(r);
            }
            rs.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
        return lista;
    }
				
}
