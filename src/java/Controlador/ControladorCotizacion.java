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
                    request.getSession().removeAttribute("lista");
                    request.getSession().removeAttribute("item");
                    request.getSession().removeAttribute("Total");
                    request.setAttribute("RegistroExitoso", "Cotización generada con éxito");
                }
                break;
            case "cancelar":
                listaprod.clear(); // Limpiar la lista de productos
                item = 0; // Restablecer el contador de ítems
                total = 0.0; // Restablecer el total
                request.getSession().removeAttribute("lista"); // Eliminar la lista de productos de la sesión
                request.getSession().removeAttribute("item"); // Eliminar el contador de ítems de la sesión
                request.getSession().removeAttribute("Total"); // Eliminar el total de la sesión

                break;
            case "eliminarproducto":
    item = Integer.parseInt(request.getParameter("item"));

    // Buscar el producto en la lista y eliminarlo
    cotizacionVO productoEliminado = null;
    for (cotizacionVO productos : listaprod) {
        if (productos.getItem() == item) {
            productoEliminado = productos;
            break;
        }
    }

    if (productoEliminado != null) {
        listaprod.remove(productoEliminado);

        // Actualizar los ítems
        for (int i = 0; i < listaprod.size(); i++) {
            listaprod.get(i).setItem(i + 1);
        }

        // Calcular el nuevo total
        total = calcularTotal(listaprod);

        request.setAttribute("Total", total);
        request.setAttribute("c", cvo);
        request.setAttribute("pr", prVO);
        request.setAttribute("lista", listaprod);

        String tablaHTML = generarTablaHTML(listaprod);

        // Enviar la respuesta al cliente
        response.setContentType("text/html");
        response.getWriter().write(tablaHTML);
    } else {
        // No se encontró el producto en la lista
        response.getWriter().write("No se pudo encontrar el producto a eliminar");
    }

    break;

            default:
                ctVO = new cotizacionVO();
                listaprod.clear();
                item = 0;
                total = 0.0;

                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", 0);
                request.getSession().removeAttribute("lista");
                request.getSession().removeAttribute("item");
                request.getSession().removeAttribute("Total");
                request.getSession().invalidate();

                request.getRequestDispatcher("CrearCotizacion1.jsp").forward(request, response);

        }

        request.getRequestDispatcher("CrearCotizacion1.jsp").forward(request, response);

    }

    private String generarTablaHTML(List<cotizacionVO> listaProductos) {
    StringBuilder sb = new StringBuilder();

    sb.append("<table class=\"tabla1\" id=\"tablaProductos\">");
    sb.append("<thead>");
    sb.append("<tr>");
    sb.append("<th>Item</th>");
    sb.append("<th>Idproducto</th>");
    sb.append("<th>Producto</th>");
    sb.append("<th>Cantidad</th>");
    sb.append("<th>Precio unitario</th>");
    sb.append("<th>Subtotal</th>");
    sb.append("<th class=\"action\">Acciones</th>");
    sb.append("</tr>");
    sb.append("</thead>");
    sb.append("<tbody>");

    for (cotizacionVO producto : listaProductos) {
        sb.append("<tr>");
        sb.append("<td>").append(producto.getItem()).append("</td>");
        sb.append("<td>").append(producto.getDc_id_producto()).append("</td>");
        sb.append("<td>").append(producto.getNombreproductoL()).append("</td>");
        sb.append("<td>").append(producto.getCantidad()).append("</td>");
        sb.append("<td>").append(producto.getPrecio()).append("</td>");
        sb.append("<td>").append(producto.getSubtotal()).append("</td>");
        sb.append("<td class=\"d-flex\">");
        sb.append("<a class=\"btn btn-danger\" style=\"margin-left: 10px\" onclick=\"borrarProducto(").append(producto.getItem()).append(")\">Borrar</a>");
        sb.append("</td>");
        sb.append("</tr>");
    }

    sb.append("</tbody>");
    sb.append("</table>");

    return sb.toString();
}


    private double calcularTotal(List<cotizacionVO> listaProductos) {
        double total = 0.0;

        for (cotizacionVO producto : listaProductos) {
            total += producto.getSubtotal();
        }

        return total;
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
