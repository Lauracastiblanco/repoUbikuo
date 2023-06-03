/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ModeloVO.ClienteVO;
import ModeloVO.cotizacionVO;
import ModeloVO.productosVO;
import ModeloVO.usuarioVO;
import ModeloDAO.ClienteDAO;
import ModeloDAO.cotizacionDAO;
import ModeloDAO.productosDAO;

/**
 *
 * @author diego
 */
@WebServlet(name = "ControladorCotizacion", urlPatterns = {"/cotizacion"})
public class ControladorCotizacion extends HttpServlet {

    ClienteDAO cdao = new ClienteDAO();
    ClienteVO cvo = new ClienteVO();
    productosVO prVO = new productosVO();
    productosDAO prDAO = new productosDAO();
    cotizacionVO ctVO = new cotizacionVO();
    cotizacionDAO cDAO = new cotizacionDAO();
    usuarioVO usuVO = new usuarioVO();
    cotizacionDAO ctDAO = new cotizacionDAO();
    List<cotizacionVO> listaprod = new ArrayList<>();
    int item, subtotal, dc_cantidad, cod, idcotizacion;
    double dc_precio, total;
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

                request.setAttribute("pr", prVO);

                break;
            case "agregarproducto":
                ctVO = new cotizacionVO();
                item++;

                producto = request.getParameter("nomproducto");
                String cantidadInput = request.getParameter("cantidad");

                // Validar que el campo de cantidad no esté vacío
                if (cantidadInput.isEmpty()) {
                    String mensajeError = "El campo de cantidad es requerido.";
                    request.setAttribute("mensajeError", mensajeError);
                    request.setAttribute("Total", total);
                    request.setAttribute("c", cvo);
                    request.setAttribute("pr", prVO);
                    request.setAttribute("lista", listaprod);
                } else {
                    try {
                        dc_cantidad = Integer.parseInt(cantidadInput);
                        dc_precio = Double.parseDouble(request.getParameter("precio"));

                        subtotal = (int) (dc_cantidad * dc_precio);
                        ctVO.setItem(item);
                        cod = Integer.parseInt(prVO.getId_prod());
                        ctVO.setDc_id_producto(cod);
                        ctVO.setNombreproductoL(producto);
                        ctVO.setCantidad(dc_cantidad);
                        ctVO.setPrecio(dc_precio);
                        ctVO.setSubtotal(subtotal);
                        ctVO.setTotal(total);

                        listaprod.add(ctVO);

                        // Calcular el nuevo total
                        total = 0.0;
                        for (int i = 0; i < listaprod.size(); i++) {
                            total += listaprod.get(i).getSubtotal();
                        }

                        request.setAttribute("Total", total);
                        request.setAttribute("c", cvo);
                        request.setAttribute("pr", prVO);
                        request.setAttribute("lista", listaprod);
                    } catch (NumberFormatException e) {
                        // Manejar el error de conversión de cadena a número
                        e.printStackTrace();
                        // Aquí puedes agregar cualquier lógica adicional, como mostrar un mensaje de error al usuario
                    }
                }

                break;

           case "generarcotizacion":
    if (listaprod.isEmpty()) {
        String mensajeError = "No se puede generar una cotización sin productos. Agregue al menos un producto antes de generar la cotización.";
        request.setAttribute("mensajeError", mensajeError);
    } else {
        // Resto del código para guardar la cotización
        ctVO.setId_cot_cliente(Integer.parseInt(cvo.getId_cliente()));
        ctVO.setCot_id_usuario(1);
        ctVO.setTotal(total);
        ctVO.setCotestado("pendiente");
        ctDAO.guardarCotizacion(ctVO);
        //guardar detalles
        idcotizacion=ctDAO.idCotizacion();
        if(listaprod.size()>0){
            for (int i = 0; i < listaprod.size(); i++) {
                ctVO=new cotizacionVO();
                ctVO.setId(idcotizacion);
                ctVO.setDc_id_producto(listaprod.get(i).getDc_id_producto());
                ctVO.setCantidad(listaprod.get(i).getCantidad());
                ctVO.setPrecio(listaprod.get(i).getPrecio());
                ctDAO.GuardarDetalleCotizacion(ctVO);
            }
        }
        request.setAttribute("RegistroExitoso", "Cotización generada con éxito");
    }
    break;

            default:
                ctVO = new cotizacionVO();
                listaprod.clear();
                item = 0;
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
