/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorArticulo;
import Gestores.GestorRubro;
import Models.Articulo;
import Models.Rubro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Diego
 */
@WebServlet(name = "agregarArticuloServlet", urlPatterns = {"/agregarArticuloServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5,
        location = "E:\\1- Archivos\\DP\\Dropbox1\\Dropbox\\2 - UTN\\2 AÑO\\2-2 Lab de Comp IV JAVA\\TPFINAL\\TPCAYUN\\web\\Assets\\Images\\")



public class agregarArticuloServlet extends HttpServlet {
    GestorArticulo gest = new GestorArticulo();
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
        
        GestorRubro gestR = new GestorRubro();
        ArrayList<Rubro> listaR = new ArrayList<>();
        listaR=gestR.ObtenerTodos();
        request.setAttribute("listaR", listaR);
        if (request.getParameter("id") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregarArticulo.jsp");
            rd.forward(request, response);
        }
        else{
            int id = Integer.parseInt(request.getParameter("id"));
            Articulo a = new Articulo();
            a = gest.PorIdArticulos(id);
            request.setAttribute("id", a.getIdArticulo());
            request.setAttribute("nombre", a.getNombre());
            request.setAttribute("precio", a.getPrecio());
            request.setAttribute("stock", a.getStock());
            request.setAttribute("foto", a.getImagen());
            request.setAttribute("descripcion", a.getDescripcion());
           
            request.setAttribute("c.getIdRubro()", a.getRubro().getIdRubro());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregarArticulo.jsp");
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
        
        
        int id=0;
        if (request.getParameter("txtId").equals("")) {
            id = 0;
        } else {
            id = Integer.parseInt(request.getParameter("txtId"));
        }
        String nombre = request.getParameter("txtNombre");
        Float precio = Float.parseFloat(request.getParameter("txtPrecio"));
        int stock = Integer.parseInt(request.getParameter("txtStock"));
        String imagen = request.getParameter("txtFoto");
        int idRubro = Integer.parseInt(request.getParameter("txtRubro"));
        String descripcion = request.getParameter("txtDescripcion");
        Rubro r = new Rubro();
        r.setIdRubro(idRubro);
        //PARA LA FOTO 
        String nombreArchivo ="";
        for (Part part : request.getParts()) {
            String fileName = getFileName(part);
            if (!fileName.isEmpty()){ //Si la parte es un archivo
                part.write(fileName);// el parĂ¡metro es el nombre NUEVO
                nombreArchivo = fileName;
            }
        }

        Articulo a = new Articulo(id, nombre, precio, stock, nombreArchivo, r, descripcion, 0);

        if(id == 0){
            gest.agregar(a);
        }
        else {
            gest.editar(a);
        }
        
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(agregarArticuloServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("/TPCAYUN/listarArticulosServlet");
    }
    

     private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
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
