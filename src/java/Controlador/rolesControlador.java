/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.rolesDAO;
import ModeloVO.rolesVO;
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
@WebServlet(name = "rolesControlador", urlPatterns = {"/roles"})
public class rolesControlador extends HttpServlet {

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
        String  id_Rol = request.getParameter("id_Rol");
        String  rolnombre = request.getParameter("rolnombre");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        rolesVO rolVO = new rolesVO(id_Rol, rolnombre );
        
        rolesDAO rolDAO = new rolesDAO(rolVO);
        
        switch(opcion)
        {
            case 1:
                if(rolDAO.agregarRegistro())
                {
                    request.setAttribute("mensajeExito", "Rol registrado correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "Rol no registrado correctamente");
                    
                }
                request.getRequestDispatcher("Roles.jsp").forward(request, response);
            break;
            
            case 2:
                if(rolDAO.actualizarRegistro())
                {
                    request.setAttribute("mensajeExito", "El rol se ha actualizado correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "El rol no actualizado correctamente");
                    
                }
                request.getRequestDispatcher("registrarRoles.jsp").forward(request, response);
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
