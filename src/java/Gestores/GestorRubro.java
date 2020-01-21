/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

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
public class GestorRubro {
    ConexionDB conex = new ConexionDB();
    
    public ArrayList<Rubro> ObtenerTodos(){
        return ObtenerRubro("SELECT * FROM Rubros");
    }
    
    public Rubro RubroPorId(int id){
        return ObtenerRubro("SELECT * FROM obtenerRubroPorId("+id+")").get(0);
    }
    
    private ArrayList<Rubro> ObtenerRubro(String query){
        ArrayList<Rubro> lista = new ArrayList<>();
        try {
            conex.conectar();
            Statement st = conex.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Rubro r = new Rubro();
                r.setIdRubro(rs.getInt("id_rubro"));
                r.setNombre(rs.getString("rubro"));
                lista.add(r);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorRubro.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
        return lista;
    }
    
    public void eliminar(int id){
        try {
            conex.conectar();
            String query = "{call bajaRubros (?)}";
            CallableStatement cst = conex.getConexion().prepareCall(query);
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
      
    public void agregar(Rubro nuevo){
        try {
            conex.conectar();
            String query = "{call altaRubro (?)}";
            CallableStatement cst = conex.getConexion().prepareCall(query);
            cst.setString(1, nuevo.getNombre());
            cst.execute();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorRubro.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
    }
    
    public void editar(Rubro editar){
        try {
            conex.conectar();
            String query = "{call modificarRubro (?,?)}";
            CallableStatement cst = conex.getConexion().prepareCall(query);
            cst.setString(1, editar.getNombre());
            cst.setInt(2, editar.getIdRubro());
            cst.executeUpdate();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorRubro.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
    }
}
