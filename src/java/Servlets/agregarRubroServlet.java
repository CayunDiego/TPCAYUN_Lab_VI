/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorRubro;
import Models.Rubro;
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
@WebServlet(name = "agregarRubroServlet", urlPatterns = {"/agregarRubroServlet"})
public class agregarRubroServlet extends HttpServlet {
    GestorRubro gest = new GestorRubro();
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
        
        if(request.getParameter("id") == null){
            response.sendRedirect("/TPCAYUN/agregarRubro.jsp");
        }
        else{
            int id = Integer.parseInt(request.getParameter("id"));
            Rubro r = new Rubro();
            r = gest.RubroPorId(id);
            request.setAttribute("id", r.getIdRubro());
            request.setAttribute("nombre", r.getNombre());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregarRubro.jsp");
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
        Rubro r = new Rubro(id, nombre);
        
        if(id == 0){
              gest.agregar(r);
        }
        else {
             gest.editar(r);
        }
        response.sendRedirect("/TPCAYUN/listaRubrosServlet");
   
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
