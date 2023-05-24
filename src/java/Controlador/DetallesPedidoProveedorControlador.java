/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.DetallesPedidoProveedorDAO;
import ModeloVO.DetallesPedidoProveedorVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander
 */
@WebServlet(name = "DetallesPedidoProveedorControlador", urlPatterns = {"/DetallesPedidoProveedor"})
public class DetallesPedidoProveedorControlador extends HttpServlet {

    ;
            DetallesPedidoProveedorDAO detProvDAO = new DetallesPedidoProveedorDAO();
    DetallesPedidoProveedorVO detProvVO = new DetallesPedidoProveedorVO();
    String idProducto;
    String nombreProducto;
    int cantidad;
    double precioUnitario, subtotal;
    List<DetallesPedidoProveedorVO> listaProductos = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int opcion = Integer.parseInt(request.getParameter("opcion"));
            switch (opcion) {
                case 1:
                    detProvVO = new DetallesPedidoProveedorVO(); // Crear una nueva instancia en cada iteración
                    idProducto = request.getParameter("id_prod");
                    nombreProducto = request.getParameter("prod_descripcion");
                    precioUnitario = Double.parseDouble(request.getParameter("prodprecio"));
                    cantidad = Integer.parseInt(request.getParameter("dpro_cantidad"));
                    subtotal = precioUnitario * cantidad;
                    detProvVO.setDpro_id_producto(idProducto);
                    detProvVO.setDpro_preciocompra(precioUnitario);
                    detProvVO.setDpro_cantidad(cantidad);
                    detProvVO.setDpro_subtotal(subtotal);
                    listaProductos.add(detProvVO);
                    request.setAttribute("listaProductos", listaProductos);
                    break;

            }
            request.getRequestDispatcher("PedidoPorveedor.jsp").forward(request, response);

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
