/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class GestorUsuario {
    ConexionDB conex = new ConexionDB();
    
    private Usuario ObtenerUser(){
        Usuario u = new Usuario();
        try {
            conex.conectar();
            Statement st = conex.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Usuarios");
          
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("user_name"));
                u.setPass(rs.getString("password"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conex.desconectar();
        }
        return u;
    }
    
    public boolean ExisteUsuario(Usuario usuario) {
        boolean existe = false;
        try {
           conex.conectar();
            String sql = "SELECT * FROM Usuarios WHERE user_name = ? AND password = ?";
            PreparedStatement st = conex.getConexion().prepareStatement(sql);
            
            st.setString(1, usuario.getUserName());
            st.setString(2, usuario.getPass());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                existe = true;
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            conex.desconectar();
        }

        return existe;
    }
}
