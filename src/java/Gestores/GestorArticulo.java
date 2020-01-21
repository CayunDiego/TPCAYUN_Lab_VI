/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Models.Articulo;
import Models.Cliente;
import Models.Rubro;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
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
public class GestorArticulo {
    ConexionDB conex = new ConexionDB();
    
    public ArrayList<Articulo> ObtenerTodos(){
        return ObtenerArticulo("SELECT * FROM obtenerArticulos");
    }
    
    public Articulo PorIdArticulos(int id){
        return ObtenerArticulo("SELECT * FROM obtenerAticulosPorId("+id+")").get(0);
    }
    
    public ArrayList<Articulo> ObtenerDisponibles(){
        return ObtenerArticulo("SELECT * FROM articulosEnStock ");
    }
    
    
    private ArrayList<Articulo> ObtenerArticulo(String query){
        ArrayList<Articulo> lista = new ArrayList<>();
        try { 
            conex.conectar();
            Statement st = conex.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Articulo a = new Articulo();
                Rubro r = new Rubro();
                a.setIdArticulo(rs.getInt("id_articulo"));
                a.setNombre(rs.getString("articulo"));
                a.setPrecio(rs.getFloat("precio"));
                a.setStock(rs.getInt("stock"));
                a.setImagen(rs.getString("imagen"));
                r.setIdRubro(rs.getInt("id_rubro"));
                r.setNombre(rs.getString("rubro"));
                a.setDescripcion(rs.getString("descripcion"));
                a.setRubro(r);
                lista.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.conectar();
        }
        return lista;
    }
    
    public void agregar(Articulo nuevo){
        try {
            conex.conectar();
            CallableStatement cst = conex.getConexion().prepareCall("{call altaArticulo (?,?,?,?,?,?)}");
            cst.setString(1, nuevo.getNombre());
            cst.setFloat(2, nuevo.getPrecio());
            cst.setInt(3, nuevo.getStock());
            cst.setString(4, nuevo.getImagen());
            cst.setInt(5, nuevo.getRubro().getIdRubro());
            cst.setString(6, nuevo.getDescripcion());
            cst.execute();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
    }
    
    public void eliminar(int id){
        try {
            conex.conectar();
            CallableStatement cst = conex.getConexion().prepareCall("{call bajaArticulo (?)}");
            cst.setInt(1, id);
            cst.executeUpdate();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
    }
    
    public Boolean editar(Articulo editar){
        boolean flag= false;
        try {
            conex.conectar();
            CallableStatement cst = conex.getConexion().prepareCall("{call modificarArticulo (?,?,?,?,?,?)}");
            cst.setString(1, editar.getNombre());
            cst.setFloat(2, editar.getPrecio());
            cst.setInt(3, editar.getStock());
            cst.setString(4, editar.getImagen());
            cst.setInt(5, editar.getRubro().getIdRubro());
            cst.setString(6, editar.getDescripcion());
            cst.setInt(7, editar.getIdArticulo());
            cst.executeUpdate();
            cst.close();
            flag= true;
        } catch (SQLException ex) {
            flag= false;
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
        return flag;
    }
    
}
