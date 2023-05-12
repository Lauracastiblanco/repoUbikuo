/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.CategoriaDAO;
import ModeloVO.CategoriaVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luisa
 */
@WebServlet(name = "CategoriaControlador", urlPatterns = {"/Categoria"})
public class CategoriaControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        String  id_cat = request.getParameter("id_cat");
        String  catnombre = request.getParameter("catnombre");
        String  catestado = request.getParameter("catestado");
        String  catdescripcion = request.getParameter("catdescripcion");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        CategoriaVO catVO = new CategoriaVO(id_cat, catnombre, catestado, catdescripcion);
        
        CategoriaDAO catDAO = new CategoriaDAO(catVO);
        
        switch(opcion)
        {
            case 1:
                if(catDAO.agregarRegistro())
                {
                    request.setAttribute("mensajeExito", "Categoria registrada correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "Categoria no registrada correctamente");
                    
                }
                request.getRequestDispatcher("registrarCategoria.jsp").forward(request, response);
            break;
            
            case 2:
                if(catDAO.actualizarRegistro())
                {
                    request.setAttribute("mensajeExito", "La Categoria se ha actualizado correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "La Categoria no actualizado correctamente");
                    
                }
                request.getRequestDispatcher("actualizarCategoria.jsp").forward(request, response);
            break;
            case 3:
                catVO = catDAO.consultarPorId(id_cat);
                if (catVO != null){
                 request.setAttribute("¡Categoria encontrada!", catVO);
                 request.getRequestDispatcher("consultarCategoria.jsp").forward(request, response);
                }
                else
                {
                request.setAttribute("mensajeError", "La Categoria no ha sido encontrado!");
                }
                request.getRequestDispatcher("consultarCategoria.jsp").forward(request, response);
                break;
        
                case 4:
                catVO = catDAO.consultarPorId(id_cat);
                if (catVO != null){
                 request.setAttribute("¡La Categoria encontrado!", catVO);
                 request.getRequestDispatcher("actualizarCategoria.jsp").forward(request, response);
                }else
                {
                request.setAttribute("mensajeError", "La Categoria no ha sido encontrada!");
                }
                request.getRequestDispatcher("consultarCategoria.jsp").forward(request, response);
                
                break;
                
     }
    }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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