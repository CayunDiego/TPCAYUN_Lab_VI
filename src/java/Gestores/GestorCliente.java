/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Models.Cliente;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class GestorCliente {
    ConexionDB conex = new ConexionDB();
    
    public ArrayList<Cliente> TodosClientes(){
        return ObtenerCliente("SELECT * FROM obtenerClientes");
    }
    
    public Cliente PorIdClientes(int id){
        return ObtenerCliente("SELECT * FROM obtenerClientePorId("+id+")").get(0);
    }
    
    public ArrayList<Cliente> ConDeuda(){
        return ObtenerCliente("SELECT * FROM clientesConDeudas");
    }
    
    private ArrayList<Cliente> ObtenerCliente(String query){
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            conex.conectar();
            Statement st = conex.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);
          
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setDomicilio(rs.getString("domicilio"));
                c.setTelefono(rs.getLong("telefono"));
                c.setSaldo(rs.getFloat("saldo"));
                lista.add(c); 
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
        return lista;
    }
    
    public void agregarCliente(Cliente nuevo){
        try {
            conex.conectar();
            CallableStatement cst = conex.getConexion().prepareCall("{call altaCliente (?,?,?,?,?,?)}");
            cst.setString(1, nuevo.getNombre());
            cst.setString(2, nuevo.getApellido());
            cst.setInt(3, nuevo.getNumDocumento());
            cst.setString(4, nuevo.getDomicilio());
            cst.setLong(5, nuevo.getTelefono());
            cst.setFloat(6, nuevo.getSaldo());
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
            CallableStatement cst = conex.getConexion().prepareCall("{call bajaCliente (?)}");
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
    
    public Boolean editar(Cliente editar){
        boolean flag= false;
        try {
            conex.conectar();
            CallableStatement cst = conex.getConexion().prepareCall("{call modificarCliente (?,?,?,?,?,?,?)}");
            cst.setString(1, editar.getNombre());
            cst.setString(2, editar.getApellido());
            cst.setInt(3, editar.getNumDocumento());
            cst.setString(4, editar.getDomicilio());
            cst.setLong(5, editar.getTelefono());
            cst.setFloat(6, editar.getSaldo());
            cst.setInt(7, editar.getIdCliente());
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

    
    //ACTUALIZACION DE IMPORTE DE TODOS LOS CLIENTES ELEGIDOS.
    public void actualizarImporteTodos(ArrayList<Cliente> lista,float porcentaje, Date fecha ){
        
        conex.conectar();
        for (Cliente c : lista) {
            actualizarImporte(c.getIdCliente(), porcentaje, fecha);
        }
        conex.desconectar();
    }
    
    public void actualizarImporteAlgunos(String[] results,float porcentaje, Date fecha ){
        
        conex.conectar();
        for (String r : results) {
            actualizarImporte(Integer.parseInt(r), porcentaje, fecha);
        }
        conex.desconectar();
    }
    
	
    
    //ACTUALIZACION DE IMPORTE POR CLIENTE.
    private void actualizarImporte(int idCliente, float porcentaje, Date fecha){
        try {
            CallableStatement cst = conex.getConexion().prepareCall("{call altaSaldoInflacion (?,?,?)}");
            cst.setInt(3, idCliente);
            cst.setFloat(2, porcentaje);
            cst.setString(1, fecha.toString());
            cst.execute();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
