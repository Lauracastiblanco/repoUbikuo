/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ClienteDAO;
import ModeloVO.ClienteVO;
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
@WebServlet(urlPatterns = {"/Cliente"})
public class ClienteControlador extends HttpServlet {

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
        String  id_cliente = request.getParameter("id_cliente");
        String  clinombre = request.getParameter("clinombre");
        String  cliapellido = request.getParameter("cliapellido");
        String  clicorreo = request.getParameter("clicorreo");
        String  clidireccion= request.getParameter("clidireccion");
        String  clitelefono = request.getParameter("clitelefono");
        String  clidescripcion = request.getParameter("clidescripcion");                    
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        ClienteVO cliVO = new ClienteVO(id_cliente,clinombre, cliapellido, clicorreo, clidireccion,clitelefono, clidescripcion);
        
        ClienteDAO cliDAO = new ClienteDAO(cliVO);
        
        switch(opcion)
        {
            case 1:
                if(cliDAO.agregarRegistro())
                {
                    request.setAttribute("RegistroExitoso", "Cliente registrado correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "Este cliente ya se encuentra registrado");
                    
                }
                request.getRequestDispatcher("Cotizacion.jsp").forward(request, response);
            break;
            
            case 2:
                if(cliDAO.actualizarRegistro())
                {
                    request.setAttribute("mensajeExito", "El Cliente actualizado correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "El Cliente no actualizado correctamente");
                    
                }
                request.getRequestDispatcher("actualizarCliente.jsp").forward(request, response);
            break;
            case 3:
                cliVO = cliDAO.consultarPorId(id_cliente);
                if (cliVO != null){
                 request.setAttribute("¡Cliente encontrado!", cliVO);
                 request.getRequestDispatcher("consultarCliente2.jsp").forward(request, response);
                }
                else
                {
                request.setAttribute("mensajeError", "El Cliente no ha sido encontrado!");
                }
                request.getRequestDispatcher("consultarCliente.jsp").forward(request, response);
                break;
        
                case 4:
                cliVO = cliDAO.consultarPorId(id_cliente);
                if (cliVO != null){
                 request.setAttribute("¡Cliente encontrado!", cliVO);
                 request.getRequestDispatcher("actualizarCliente2.jsp").forward(request, response);
                }else
                {
                request.setAttribute("mensajeError", "El Cliente no ha sido encontrado!");
                }
                request.getRequestDispatcher("consultarCliente.jsp").forward(request, response);
                
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

