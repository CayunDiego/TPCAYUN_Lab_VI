/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Models.Articulo;
import Models.Cliente;
import Models.DetalleVenta;
import Models.Venta;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;

/**
 *
 * @author Diego
 */
public class GestorVenta {
    ConexionDB conex = new ConexionDB();
    
    public void agregarVenta(int idCliente, String listaArt, Date fecha){
        try {
            conex.conectar();
            //String sql= "EXEC altaVenta(?,?,?)";
            //PreparedStatement st = conex.getConexion().prepareStatement(sql);
            CallableStatement cst = conex.getConexion().prepareCall("{call altaVenta (?,?,?)}");
            System.out.println("despues del prepare");
            cst.setString(1, listaArt);
            cst.setDate(2, fecha);
            cst.setInt(3, idCliente);
            //st.executeUpdate();
            cst.execute();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    
    public ArrayList<Venta> TodasLasVentas(){
        return ObtenerVenta("SELECT v.id_venta, v.fecha, c.nombre, c.apellido, v.monto_total "
                + "FROM Ventas v JOIN Clientes c ON v.id_cliente = c.id_cliente");
    }
    
    
    
    public ArrayList<Venta> PorIdClientet(int id){
        return ObtenerVenta("SELECT v.id_venta, v.fecha, c.nombre, c.apellido, v.monto_total "
                + "FROM Ventas v JOIN Clientes c ON v.id_cliente = c.id_cliente "
                + "WHERE c.id_cliente = "+id);
    }
  
    
    private ArrayList<Venta> ObtenerVenta(String query){
        ArrayList<Venta> lista = new ArrayList<>();
        try { 
            conex.conectar();
            Statement st = conex.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                Venta v = new Venta();
                Cliente c = new Cliente();
                DetalleVenta dv = new DetalleVenta();
                v.setIdVenta(rs.getInt("id_venta"));
                v.setFecha(rs.getDate("fecha"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                v.setCliente(c);
                v.setMontoTotal(rs.getFloat("monto_total"));
                v.setDetalles(ObtenerDetalles(v.getIdVenta()));
                lista.add(v);
            }
            rs.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorVenta.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        finally{
            conex.desconectar();
        }  
        return lista;
    }
    

    
    private ArrayList<DetalleVenta> ObtenerDetalles(int idVenta){
        ArrayList<DetalleVenta> listaDetalle = new ArrayList<>();
        try {
            //Siempre voy a querer mis detalles por Venta! no solo.
            String sql = "SELECT a.articulo, a.imagen, "
                    + "dv.cantidad, dv.precio_unitario "
                    + "FROM Ventas v JOIN DetallesVenta dv ON"
                    + " v.id_venta=dv.id_venta JOIN Articulos a ON"
                    + " a.id_articulo =dv.id_articulo "
                    + "WHERE v.id_venta = " + idVenta;
            
            Statement st2 = conex.getConexion().createStatement();
            ResultSet rs2 = st2.executeQuery(sql);
            
            while (rs2.next()) {
                Articulo a = new Articulo();
                DetalleVenta dv = new DetalleVenta();
                a.setNombre(rs2.getString("articulo"));
                a.setImagen(rs2.getString("imagen"));
                dv.setArticulo(a);
                dv.setCantidad(rs2.getInt("cantidad"));
                dv.setPrecioUnitario(rs2.getFloat("precio_unitario"));
                listaDetalle.add(dv);
            }
            rs2.close();
            st2.close();  
        } catch (SQLException ex) {
            Logger.getLogger(GestorVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            
        }
        return listaDetalle;
    }
                 
}