/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorCliente;
import Gestores.GestorPago;
import Models.Cliente;
import Models.Pago;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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
@WebServlet(name = "listaClienteDeudaServlet", urlPatterns = {"/listaClienteDeudaServlet"})
public class listaClienteDeudaServlet extends HttpServlet {
    GestorCliente gest = new GestorCliente();
    ArrayList<Cliente> listaC = new ArrayList<>();

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
        
            listaC = gest.ConDeuda();
            
            if (request.getParameter("id") == null) {
            request.setAttribute("listaC", listaC);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaClientesDeuda.jsp");
            rd.forward(request, response); 
            }
            else{
            Cliente c = new Cliente();
            c = gest.PorIdClientes(Integer.parseInt(request.getParameter("id")));
            GestorPago gestP = new GestorPago();
            Date fecha = new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
            Pago p = new Pago(0, c.getSaldo(), fecha , c);
            gestP.agregar(p);
            listaC = gest.ConDeuda();
            request.setAttribute("listaC", listaC);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaClientesDeuda.jsp");
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
