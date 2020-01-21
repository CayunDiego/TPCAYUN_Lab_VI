/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorArticulo;
import Gestores.GestorCliente;
import Gestores.GestorVenta;
import Models.Articulo;
import Models.Cliente;
import Models.DetalleVenta;
import Models.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
@WebServlet(name = "AgregarVentaServlet", urlPatterns = {"/AgregarVentaServlet"})
public class AgregarVentaServlet extends HttpServlet {
    Venta venta = new Venta();
    DetalleVenta detalle = new DetalleVenta();
    GestorArticulo gestA = new GestorArticulo();
    GestorCliente gestC = new GestorCliente();
    ArrayList<Articulo> listaA = new ArrayList<>();
    ArrayList<Cliente> listaC = new ArrayList<>();
    ArrayList<Articulo> listaProvi = new ArrayList<>();
    ArrayList<Integer> listaCant = new ArrayList<>();
    
    
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

        
            listaA = gestA.ObtenerDisponibles();
           
            if(request.getParameter("id")!=null){
                Articulo a = new Articulo();
                a = gestA.PorIdArticulos(Integer.parseInt(request.getParameter("id")));
                a.setCant(Integer.parseInt(request.getParameter("can")));
                listaProvi.add(a);
                //listaCant.add();
            }
            if(request.getParameter("ideEliminar")!=null){
                eliminarElemento(Integer.parseInt(request.getParameter("ideEliminar")));
            }
            
            
            listaC = gestC.TodosClientes();
            request.setAttribute("listaA", listaA);
            request.setAttribute("listaC", listaC);
            
            request.setAttribute("listaProvi", listaProvi);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/AgregarVenta.jsp");
            rd.forward(request, response);
    }

    public void eliminarElemento(int id){
        for (int i = 0; i < listaProvi.size(); i++) {
            if(listaProvi.get(i).getIdArticulo()==id)
                listaProvi.remove(i);
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
        
        String listaCompleta="";
        int id = Integer.parseInt(request.getParameter("txtCliente"));
        Date fecha = new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
        GestorVenta gestV = new GestorVenta();
        
        for (int i = 0; i < listaProvi.size() ; i++) {
            listaCompleta+= listaProvi.get(i).getIdArticulo()+",1;";
        }
        gestV.agregarVenta(id, listaCompleta, fecha);
        response.sendRedirect("/TPCAYUN/index.jsp");
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
