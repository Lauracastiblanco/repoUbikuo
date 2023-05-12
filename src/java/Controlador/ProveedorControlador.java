package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ModeloDAO.ProveedorDAO;
import ModeloVO.ProveedorVO;
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
@WebServlet(urlPatterns = {"/Proveedor"})
public class ProveedorControlador extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        { 
        //1.recibir datos vistas 
        String  id_prov = request.getParameter("id_prov");
        String  pronombre = request.getParameter("pronombre");
        String  prodireccion = request.getParameter("prodireccion");
        String  protelefono = request.getParameter("protelefono");
        String  proestado = request.getParameter("proestado");
        String  prodescripcion = request.getParameter("prodescripcion");
        String  procorreo = request.getParameter("procorreo");
        String  prorepresentante = request.getParameter("prorepresentante");                        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        ProveedorVO provVO = new ProveedorVO(id_prov,pronombre,prodireccion,protelefono,proestado,prodescripcion,procorreo,prorepresentante);
        
        ProveedorDAO provDAO = new ProveedorDAO(provVO);
        
        switch(opcion)
        {
            case 1:
                if(provDAO.agregarRegistro())
                {
                    request.setAttribute("mensajeExito", "Proveedor registrado correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "Proveedor no registrado correctamente");
                    
                }
                request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
            break;
            case 2:
                if(provDAO.actualizarRegistro())
                {
                    request.setAttribute("mensajeExito", "El Proveedor actualizado correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "El Proveedor no actualizado correctamente");
                    
                }
                request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
            break;
            case 3:
                provVO = provDAO.consultarPorId(id_prov);
                if (provVO != null){
                 request.setAttribute("¡Proveedor encontrado!", provVO);
                 request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
                }
                else
                {
                request.setAttribute("mensajeError", "El Proveedor no ha sido encontrado!");
                }
                request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
                break;
        
                case 4:
                provVO = provDAO.consultarPorId(id_prov);
                if (provVO != null){
                 request.setAttribute("¡Proveedor encontrado!", provVO);
                 request.getRequestDispatcher("actualizarProveedor2.jsp").forward(request, response);
                }else
                {
                request.setAttribute("mensajeError", "El Proveedor no ha sido encontrado!");
                }
                request.getRequestDispatcher("consultarProveedor.jsp").forward(request, response);
                
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


    
