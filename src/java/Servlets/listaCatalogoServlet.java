/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorCatalogo;
import Gestores.GestorRubro;
import Models.Catalogo;
import Models.Rubro;
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
@WebServlet(name = "listaCatalogoServlet", urlPatterns = {"/listaCatalogoServlet"})
public class listaCatalogoServlet extends HttpServlet {
    GestorCatalogo gest = new GestorCatalogo();
    GestorRubro gestR = new GestorRubro();
    ArrayList<Rubro> listaR = new ArrayList<>(gestR.ObtenerTodos());
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
            
            request.setAttribute("listaR", listaR);
            
            ArrayList<Catalogo> listaC = new ArrayList<>();
            listaC = gest.getCatalogoVigente();
            
            request.setAttribute("listaC", listaC);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaCatalogo.jsp");
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
            int idRubro = Integer.parseInt(request.getParameter("txtRubro"));
            ArrayList<Catalogo> listaC = new ArrayList<>();
            listaC = gest.getCatalogoVigenteRubroId(idRubro);
             request.setAttribute("listaR", listaR);
            request.setAttribute("listaC", listaC);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaCatalogo.jsp");
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
