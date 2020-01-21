/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorCliente;
import Gestores.GestorVenta;
import Models.Cliente;
import Models.Venta;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "listaVentasClienteServlet", urlPatterns = {"/listaVentasClienteServlet"})
public class listaVentasClienteServlet extends HttpServlet {
    GestorCliente gestC = new GestorCliente();
    ArrayList<Cliente> listaC = new ArrayList<>(gestC.TodosClientes());

       

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
        
        request.setAttribute("listaC", listaC);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaVentaCliente.jsp");
        rd.forward(request, response);
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
        GestorVenta gest = new GestorVenta();
        ArrayList<Venta> listaV = new ArrayList<>();
        listaV = gest.PorIdClientet(Integer.parseInt(request.getParameter("txtCliente")));
        request.setAttribute("listaV", listaV);
        request.setAttribute("listaC", listaC);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaVentaCliente.jsp");
        rd.forward(request, response);
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
