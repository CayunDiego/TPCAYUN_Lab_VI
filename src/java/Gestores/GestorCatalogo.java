/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Models.Articulo;
import Models.Catalogo;
import Models.DetalleCatalogo;
import Models.Rubro;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class GestorCatalogo {
     ConexionDB conex = new ConexionDB();
     
      public void agregarCatalogo(String listaArt, Date fechaIni, Date fechaFin, String descripcion){
        try {
            conex.conectar();
            //PreparedStatement st = conex.getConexion().prepareStatement(sql);
            CallableStatement cst = conex.getConexion().prepareCall("{call altaCatalogo (?,?,?,?)}");
            cst.setString(1, listaArt);
           // cst.setString(2, fecha.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            //cst.setString(2, fechaIni.toString());
            cst.setDate(2, fechaIni);
            cst.setDate(3, fechaFin);
            cst.setString(4, descripcion);
            //st.executeUpdate();
            cst.execute();
            cst.close();
        } catch (SQLException ex) {

            Logger.getLogger(GestorVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
    }   
      

      
       public ArrayList<Catalogo> getCatalogoVigente(){
        return ObtenerCatalogo("SELECT c.id_catalogo, c.fecha_inicio, "
                + "c.fecha_fin, c.descripcion "
                + "FROM Catalogos c "
                + "WHERE c.fecha_fin >= GETDATE()");
    }
    
  
    
    private ArrayList<Catalogo> ObtenerCatalogo(String query){
        ArrayList<Catalogo> lista = new ArrayList<>();
        try { 
            conex.conectar();
            Statement st = conex.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                Catalogo c = new Catalogo();
                c.setIdCatalogo(rs.getInt("id_catalogo"));
                c.setFechaIni(rs.getDate("fecha_inicio"));
                c.setFechaFin(rs.getDate("fecha_fin"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setDetalles(ObtenerDetalles(c.getIdCatalogo()));
                lista.add(c);
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
          
    private ArrayList<DetalleCatalogo> ObtenerDetalles(int idCatalogo){
        ArrayList<DetalleCatalogo> listaDetalle = new ArrayList<>();
        try {
            //Siempre voy a querer mis detalles por Catalogo! no solo.
            String sql = "SELECT a.imagen, a.articulo, a.precio, a.stock,"
                    + " a.descripcion, r.rubro FROM Catalogos c JOIN "
                    + "DetallesCatalogo d ON c.id_catalogo=d.id_catalogo "
                    + "JOIN Articulos a ON a.id_articulo=d.id_articulo "
                    + "JOIN Rubros R ON a.id_rubro=r.id_rubro "
                    + "WHERE c.id_catalogo =  " + idCatalogo;
            
            Statement st2 = conex.getConexion().createStatement();
            ResultSet rs2 = st2.executeQuery(sql);
            
            while (rs2.next()) {
                DetalleCatalogo dc = new DetalleCatalogo();
                Articulo a = new Articulo();
                Rubro r = new Rubro();
                a.setImagen(rs2.getString("imagen"));
                a.setNombre(rs2.getString("articulo"));
                a.setPrecio(rs2.getFloat("precio"));
                a.setStock(rs2.getInt("stock"));
                //a.set(rs2.getString("descripcion"));
                r.setNombre(rs2.getString("rubro"));
                a.setRubro(r);
                dc.setArticulo(a);
                listaDetalle.add(dc);
            }
            rs2.close();
            st2.close();  
        } catch (SQLException ex) {
            Logger.getLogger(GestorVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
        return listaDetalle;
    }
    


    
     public ArrayList<Catalogo> getCatalogoVigenteRubroId(int id){
        return ObtenerCatalogo2("SELECT c.id_catalogo, c.fecha_inicio, "
                + "c.fecha_fin, c.descripcion "
                + "FROM Catalogos c "
                + "WHERE c.fecha_fin >= GETDATE()",id);
    }
    
  
    
    private ArrayList<Catalogo> ObtenerCatalogo2(String query, int idRubro){
        ArrayList<Catalogo> lista = new ArrayList<>();
        try { 
            conex.conectar();
            Statement st = conex.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                Catalogo c = new Catalogo();
                c.setIdCatalogo(rs.getInt("id_catalogo"));
                c.setFechaIni(rs.getDate("fecha_inicio"));
                c.setFechaFin(rs.getDate("fecha_fin"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setDetalles(ObtenerDetalles2(c.getIdCatalogo(), idRubro));
                lista.add(c);
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
    
    

            
    private ArrayList<DetalleCatalogo> ObtenerDetalles2(int idCatalogo, int idRubro){
        ArrayList<DetalleCatalogo> listaDetalle = new ArrayList<>();
        try {
            //Siempre voy a querer mis detalles por Catalogo! no solo.
            String sql = "SELECT a.imagen, a.articulo, a.precio, a.stock,"
                    + " a.descripcion, r.rubro FROM Catalogos c JOIN "
                    + "DetallesCatalogo d ON c.id_catalogo=d.id_catalogo "
                    + "JOIN Articulos a ON a.id_articulo=d.id_articulo JOIN "
                    + "Rubros R ON a.id_rubro=r.id_rubro "
                    + "WHERE c.id_catalogo = "+idCatalogo + "  and r.id_rubro = " + idRubro;
            
            Statement st2 = conex.getConexion().createStatement();
            ResultSet rs2 = st2.executeQuery(sql);
            
            while (rs2.next()) {
                DetalleCatalogo dc = new DetalleCatalogo();
                Articulo a = new Articulo();
                Rubro r = new Rubro();
                a.setImagen(rs2.getString("imagen"));
                a.setNombre(rs2.getString("articulo"));
                a.setPrecio(rs2.getFloat("precio"));
                a.setStock(rs2.getInt("stock"));
                //a.set(rs2.getString("descripcion"));
                r.setNombre(rs2.getString("rubro"));
                a.setRubro(r);
                dc.setArticulo(a);
                listaDetalle.add(dc);
            }
            rs2.close();
            st2.close();  
        } catch (SQLException ex) {
            Logger.getLogger(GestorVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
        return listaDetalle;
    }
}
