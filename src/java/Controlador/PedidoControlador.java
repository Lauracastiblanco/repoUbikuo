/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ClienteDAO;
import ModeloDAO.pedidoDAO;
import ModeloDAO.productosDAO;
import ModeloVO.ClienteVO;
import ModeloVO.pedidoVO;
import ModeloVO.productosVO;
import ModeloVO.usuarioVO;
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
 * @author WIN
 */
@WebServlet(name = "PedidoControlador", urlPatterns = {"/Pedido"})
public class PedidoControlador extends HttpServlet {

    ClienteDAO cdao = new ClienteDAO();
    ClienteVO cvo = new ClienteVO();
    productosVO prVO = new productosVO();
    productosDAO prDAO = new productosDAO();
    pedidoVO pdVO = new pedidoVO();
    pedidoDAO pdDAO = new pedidoDAO();
    usuarioVO usuVO = new usuarioVO();
    List<pedidoVO> listaprod = new ArrayList<>();
    int idProducto, idpedido;
    String nombreProducto;
    int cantidad, item, cod;
    double precio, subtotal, total;
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

                pdVO = new pedidoVO();
                item++;

                producto = request.getParameter("nomproducto");
                cantidad = Integer.parseInt(request.getParameter("cantidad"));
                precio = Double.parseDouble(request.getParameter("precio"));

                subtotal = (int) (cantidad * precio);
                pdVO.setItem(item);
                cod = Integer.parseInt(prVO.getId_prod());
                pdVO.setDp_id_producto(cod);
                pdVO.setNombreprod(producto);
                pdVO.setDp_cantidad(cantidad);
                pdVO.setPrecio(precio);
                pdVO.setSubtotal(subtotal);
                pdVO.setTotal(total);

                listaprod.add(pdVO);
                for (int i = 0; i < listaprod.size(); i++) {
                    total = total + listaprod.get(i).getSubtotal();
                }
                request.setAttribute("Total", total);

                request.setAttribute("c", cvo);
                request.setAttribute("pr", prVO);
                request.setAttribute("lista", listaprod);
                break;

            case "generarpedido":
                //Pedido

                pdVO.setPed_id_cliente(Integer.parseInt(cvo.getId_cliente()));
                pdVO.setPed_id_usuario(1);
                pdVO.setTotal(total);
                pdVO.setPedestado("pendiente");
                pdDAO.guardarPedido(pdVO);

                //Detalles de Pedido
                idpedido = pdDAO.idPedido();
                if (listaprod.size() > 0) {
                    for (int i = 0; i < listaprod.size(); i++) {
                        pdVO = new pedidoVO();
                        pdVO.setId_ped(idpedido);
                        pdVO.setDp_id_producto(listaprod.get(i).getDp_id_producto());
                        pdVO.setDp_cantidad(listaprod.get(i).getDp_cantidad());
                        pdVO.setPrecio(listaprod.get(i).getPrecio());

                        pdDAO.GuardarDetallePedido(pdVO);

                    }
                }
                break;
            default:
                pdVO = new pedidoVO();
                listaprod = new ArrayList<>();

                total = 0.0;

        }

        request.getRequestDispatcher("CrearPedido.jsp").forward(request, response);

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
