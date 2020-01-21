/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorArticulo;
import Gestores.GestorCatalogo;
import Models.Articulo;
import Models.Catalogo;
import Models.DetalleCatalogo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "agregarCatalogoServlet", urlPatterns = {"/agregarCatalogoServlet"})
public class agregarCatalogoServlet extends HttpServlet {
    Catalogo venta = new Catalogo();
    DetalleCatalogo detalle = new DetalleCatalogo();
    GestorArticulo gestA = new GestorArticulo();
    ArrayList<Articulo> listaA = new ArrayList<>(gestA.ObtenerDisponibles());
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
        
            Articulo a = new Articulo();
            if(request.getParameter("id")!=null){
                a = gestA.PorIdArticulos(Integer.parseInt(request.getParameter("id")));
                listaProvi.add(a);
                eliminarElemento(Integer.parseInt(request.getParameter("id")),listaA);
            }
            if(request.getParameter("ideEliminar")!=null){
                a = gestA.PorIdArticulos(Integer.parseInt(request.getParameter("ideEliminar")));
                listaA.add(a);
                eliminarElemento(Integer.parseInt(request.getParameter("ideEliminar")),listaProvi);
            }

            request.setAttribute("listaA", listaA);

            request.setAttribute("listaProvi", listaProvi);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregarCatalogo.jsp");
            rd.forward(request, response);
    }

    public void eliminarElemento(int id, ArrayList<Articulo> lista){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getIdArticulo()==id)
                lista.remove(i);
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
        GestorCatalogo gestCat = new GestorCatalogo();
        //int id = Integer.parseInt(request.getParameter("txtCliente"));
        //LocalDateTime fecha = LocalDateTime.now();
        //GestorVenta gestV = new GestorVenta();
        
        //genero mi lista(string) de articulos que tiene el aspecto 1;2;3
        for (int i = 0; i < listaProvi.size() -1 ; i++) {
            listaCompleta+= listaProvi.get(i).getIdArticulo()+";";
        }
            listaCompleta+= listaProvi.get(listaProvi.size()-1).getIdArticulo();
      
            
        Date fecha =new Date(2019, 1, 1);
        gestCat.agregarCatalogo(listaCompleta, fecha , fecha, "no tengo descripción");
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
