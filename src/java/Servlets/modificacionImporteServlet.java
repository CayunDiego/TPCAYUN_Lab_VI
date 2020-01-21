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
@WebServlet(name = "modificacionImporteServlet", urlPatterns = {"/modificacionImporteServlet"})
public class modificacionImporteServlet extends HttpServlet {
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
        request.setAttribute("listaC", listaC);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificacionImporte.jsp");
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
        
        float interes = Float.parseFloat(request.getParameter("txtInteres"));
        ArrayList<Cliente> listaPro = new ArrayList<>();
        String[] results = new String[500];
        if(request.getParameterValues("aplicarImp")!=null){
            results = request.getParameterValues("aplicarImp");
            for (int i = 0; i < results.length; i++) {
                System.out.println(results[i]);
            }
        }
        Date fecha = new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
        
        
        if(results[0].equals("0")){
            gest.actualizarImporteTodos(listaC, interes, fecha);
        }
        else{
            gest.actualizarImporteAlgunos(results, interes, fecha);
        }
        
        
        
        response.sendRedirect("/TPCAYUN/index.jsp");
    }
      
        //if(request.getParameterValues("todos").equals("todos")){

        //gest.actualizarImporteTodos(listaC, interes, fecha);
        //response.sendRedirect("/TPCAYUN/index.jsp");
       // }

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
