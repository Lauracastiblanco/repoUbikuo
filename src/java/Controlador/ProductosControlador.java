/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.productosDAO;
import ModeloVO.productosVO;
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
@WebServlet(urlPatterns = {"/Productos"})
public class ProductosControlador extends HttpServlet {

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
                String id_prod = request.getParameter("id_prod");
                String prodnombre = request.getParameter("prodnombre");
                String prodprecio = request.getParameter("prodprecio");
                String prod_id_categoria = request.getParameter("prod_id_categoria");
                String prodestado = request.getParameter("prodestado");
                String prodstock_disp = request.getParameter("prodstock_disp");
                String prod_descripcion = request.getParameter("prod_descripcion");
                String prod_id_prov = request.getParameter("prod_id_prov");
                int opcion = Integer.parseInt(request.getParameter("opcion"));
                productosVO prodVO = new productosVO(id_prod, prodnombre, prodprecio, prod_id_categoria, prodestado, prodstock_disp, prod_descripcion, prod_id_prov);

                productosDAO prodDAO = new productosDAO(prodVO);

                switch (opcion) {
                    case 1:
                        if (prodDAO.agregarRegistro()) {
                            request.setAttribute("mensajeExito", "Producto registrado correctamente");
                        } else {
                            request.setAttribute("mensajeError", "Producto no registrado correctamente");

                        }
                        request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
                        break;
                    case 2:
                        if (prodDAO.actualizarRegistro()) {
                            request.setAttribute("mensajeExito", "El Producto actualizado correctamente");
                        } else {
                            request.setAttribute("mensajeError", "El Producto no actualizado correctamente");

                        }
                        request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
                        break;
                    case 3:
                        prodVO = prodDAO.consultarPorId(id_prod);
                        if (prodVO != null) {
                            request.setAttribute("¡Producto encontrado!", prodVO);
                            request.getRequestDispatcher("consultarProducto2.jsp").forward(request, response);
                        } else {
                            request.setAttribute("mensajeError", "El Producto no ha sido encontrado!");
                        }
                        request.getRequestDispatcher("consultarProducto.jsp").forward(request, response);
                        break;

                    case 4:
                        prodVO = prodDAO.consultarPorId(id_prod);
                        if (prodVO != null) {
                            request.setAttribute("¡Producto encontrado!", prodVO);
                            request.getRequestDispatcher("actualizarProducto2.jsp").forward(request, response);
                        } else {
                            request.setAttribute("mensajeError", "El Producto no ha sido encontrado!");
                        }
                        request.getRequestDispatcher("consultarProducto.jsp").forward(request, response);

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



    
