/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ClienteDAO;
import ModeloDAO.cotizacionDAO;
import ModeloDAO.productosDAO;
import ModeloVO.ClienteVO;
import ModeloVO.cotizacionVO;
import ModeloVO.productosVO;
import ModeloVO.usuarioVO;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
@WebServlet(name = "Controladorcotizacion", urlPatterns = {"/cotizacion"})
public class Controladorcotizacion extends HttpServlet {

    ClienteDAO cdao = new ClienteDAO();
    ClienteVO cvo = new ClienteVO();
    productosVO prVO = new productosVO();
    productosDAO prDAO = new productosDAO();
    cotizacionVO ctVO = new cotizacionVO();
    cotizacionDAO cDAO = new cotizacionDAO();
    usuarioVO usuVO = new usuarioVO();
    cotizacionDAO ctDAO = new cotizacionDAO();
    List<cotizacionVO> listaprod = new ArrayList<>();
    int idProducto,idcotizacion;
    String nombreProducto;
    int cantidad;
    double precioUnitario, subtotal,total;
    String numeroserie;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        String producto, idproducto;

        switch (accion) {
            case "buscarcliente":
                String documento = request.getParameter("cot_id_cliente");
                cvo.setId_cliente(documento);
                cvo = cdao.buscar(documento);
                request.setAttribute("c", cvo);

                break;

            case "buscarproducto":
                String id = request.getParameter("dc_id_prod");
                prVO = prDAO.listarid(id);
                request.setAttribute("c", cvo);
                request.setAttribute("lista", listaprod);

                request.setAttribute("pr", prVO);

                break;
            case "agregarproducto":

                 ctVO = new cotizacionVO(); // Crear una nueva instancia en cada iteración
                    idProducto = Integer.parseInt(request.getParameter("id_prod"));
                    nombreProducto = request.getParameter("prod_descripcion");
                    precioUnitario = Double.parseDouble(request.getParameter("prodprecio"));
                    cantidad = Integer.parseInt(request.getParameter("dpro_cantidad"));
                    subtotal = precioUnitario * cantidad;
                    ctVO.setDc_id_producto(idProducto);
                    ctVO.setNombreproductoL(nombreProducto);
                    ctVO.setPrecio(precioUnitario);
                    ctVO.setCantidad(cantidad);
                    ctVO.setSubtotal(subtotal);
                    for (int i = 0; i <listaprod.size(); i++) {
                    total=total+listaprod.get(i).getSubtotal();
                }
                  request.setAttribute("Total", total);
                    listaprod.add(ctVO);
                    
                    request.setAttribute("listaProductos", listaprod);
                    break;

            case "generarcotizacion":
                //guardar cotizacion

                ctVO.setId_cot_cliente(Integer.parseInt(cvo.getId_cliente()));
                ctVO.setCot_id_usuario(1);
                ctVO.setTotal(total);
                ctVO.setCotestado("pendiente");
                ctDAO.guardarCotizacion(ctVO);
                
                //guardar detalles

                idcotizacion = ctDAO.idCotizacion();
                if (listaprod.size() > 0) {
                    for (int i = 0; i < listaprod.size(); i++) {
                        ctVO = new cotizacionVO();
                        ctVO.setId(idcotizacion);
                        ctVO.setDc_id_producto(listaprod.get(i).getDc_id_producto());
                        ctVO.setCantidad(listaprod.get(i).getCantidad());
                        ctVO.setPrecio(listaprod.get(i).getPrecio());

                        ctDAO.GuardarDetalleCotizacion(ctVO);

                    }
                }
                break;
            default:
                ctVO = new cotizacionVO();
                listaprod = new ArrayList<>();
               
                total = 0.0;

        }

        request.getRequestDispatcher("CrearCotizacion1.jsp").forward(request, response);

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