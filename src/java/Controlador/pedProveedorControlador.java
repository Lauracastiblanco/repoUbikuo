/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.DetallesPedidoProveedorDAO;
import ModeloDAO.pedidoProveedorDAO;
import ModeloVO.DetallesPedidoProveedorVO;
import ModeloVO.pedidoProveedorVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander
 */
@WebServlet(name = "pedProveedorPedido", urlPatterns = {"/ProveedorPedido"})
public class pedProveedorControlador extends HttpServlet {

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
            int ped_id_proveedor = Integer.parseInt(request.getParameter("ped_id_proveedor"));
            int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
            int opcion = Integer.parseInt(request.getParameter("opcion"));
            //---------------------------- Detalles
            String pronombre = request.getParameter("pronombre");
            String prorepresentante = request.getParameter("prorepresentante");
            String procorreo = request.getParameter("procorreo");
            String prodireccion = request.getParameter("prodireccion");

            // Pasar los datos a la vista
            request.setAttribute("ped_id_proveedor", ped_id_proveedor);
            request.setAttribute("id_usuario", id_usuario);
            request.setAttribute("pronombre", pronombre);
            request.setAttribute("prorepresentante", prorepresentante);
            request.setAttribute("procorreo", procorreo);
            request.setAttribute("prodireccion", prodireccion);

            pedidoProveedorVO pedProvVO = new pedidoProveedorVO(ped_id_proveedor, id_usuario);
            pedidoProveedorDAO pedProvDAO = new pedidoProveedorDAO(pedProvVO);

            switch (opcion) {
                case 1:
                    if (pedProvDAO.agregarRegistro()) { // agregar registro
                        // Redirigir a la siguiente página
                        request.getRequestDispatcher("PedidoProveedor.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensajeError", "El usuario no se registró correctamente");
                        request.getRequestDispatcher("consultarPedProveedor.jsp").forward(request, response);
                    }
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
