/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorCliente;
import Models.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
@WebServlet(name = "agregarCliente", urlPatterns = {"/agregarCliente"})
public class agregarClienteServlet extends HttpServlet {
    GestorCliente gest = new GestorCliente();
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
            }

        if (request.getParameter("id") == null) {
            response.sendRedirect("/TPCAYUN/agregarCliente.jsp");
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            Cliente c = gest.PorIdClientes(id);
            request.setAttribute("id", c.getIdCliente());
            request.setAttribute("nombre", c.getNombre());
            request.setAttribute("apellido", c.getApellido());
            request.setAttribute("doc", c.getNumDocumento());
            request.setAttribute("domicilio", c.getDomicilio());
            request.setAttribute("telefono", c.getTelefono());
            //request.setAttribute("saldo", c.getSaldo());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregarCliente.jsp");
            rd.forward(request, response);
            }    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
            }
        
        
        int id;
        if (request.getParameter("txtId").equals("")) {
            id = 0;
        } else {
            id = Integer.parseInt(request.getParameter("txtId"));
        }
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int numDoc= Integer.parseInt(request.getParameter("txtDoc"));
        String domicilio = request.getParameter("txtDomicilio");
        long telefono = Long.parseLong(request.getParameter("txtTelefono"));
        Float saldo = Float.parseFloat(request.getParameter("txtSaldo"));
        Cliente c = new Cliente(id, nombre, apellido, numDoc ,domicilio, telefono, saldo);
        if(id == 0){
            gest.agregarCliente(c);
        }
        else {
            if (gest.editar(c)) {
                System.out.println("Se EDITÓ correctamente"); 
            }
            else{System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"); }
        }
        response.sendRedirect("/TPCAYUN/listaCienteServlet");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
