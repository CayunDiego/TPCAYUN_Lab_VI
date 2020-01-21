/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorCliente;
import Gestores.GestorReportes;
import Gestores.GestorRubro;
import Models.Cliente;
import Models.Reporte;
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
@WebServlet(name = "listarReportes", urlPatterns = {"/listarReportes"})
public class listarReportes extends HttpServlet {
        GestorReportes g = new GestorReportes();
        ArrayList<Reporte> listaR = new ArrayList<>();
        int numReporte;
        GestorRubro gestRubro = new GestorRubro();
        ArrayList<Rubro> rub= new ArrayList<>();
        
        
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
        
            numReporte= Integer.parseInt(request.getParameter("r"));
            request.setAttribute("num",numReporte );
            if(numReporte==1){
                request.setAttribute("num",request.getParameter("r") );
                listaR = g.reporte1();
                request.setAttribute("listaR", listaR);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaReporte1.jsp");
                rd.forward(request, response);
            }
            if(numReporte==2){
                request.setAttribute("num",request.getParameter("r") );
                listaR = g.reporte2();
                request.setAttribute("listaR", listaR);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaReporte2.jsp");
                rd.forward(request, response);
            }
            
            if(numReporte==3){
                GestorCliente gestC = new GestorCliente();
                ArrayList<Cliente> listaC= new ArrayList<>();
                listaC = gestC.TodosClientes();
                request.setAttribute("listaC", listaC);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaReporte3.jsp");
                rd.forward(request, response);
            }
            if(numReporte==4){
                rub = gestRubro.ObtenerTodos();
                
                request.setAttribute("rub", rub);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaReporte4.jsp");
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
            if(numReporte==3){
                
                if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
            }
                
                GestorCliente gestC = new GestorCliente();
                ArrayList<Cliente> listaC= new ArrayList<>();
                listaC = gestC.TodosClientes();
                request.setAttribute("cliente",gestC.PorIdClientes(Integer.parseInt(request.getParameter("txtClien"))));
                request.setAttribute("listaC", listaC);
                listaR = g.reporte3(Integer.parseInt(request.getParameter("txtClien")));
                request.setAttribute("listaR", listaR);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaReporte3.jsp");
                rd.forward(request, response);
            }
            if(numReporte==4){
                
                
                request.setAttribute("rub", rub);
                request.setAttribute("num",request.getParameter("r") );
                request.setAttribute("rubro",gestRubro.RubroPorId(Integer.parseInt(request.getParameter("txtRubro"))));
               
                listaR = g.reporte4(Integer.parseInt(request.getParameter("txtRubro")));
                request.setAttribute("listaR", listaR);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaReporte4.jsp");
                rd.forward(request, response);
            }
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
