/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.rolesDAO;
import ModeloDAO.usuarioDAO;
import ModeloVO.rolesVO;
import ModeloVO.usuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luisa
 */
@WebServlet(name = "usuarioControlador", urlPatterns = {"/usuario"})
public class usuarioControlador extends HttpServlet {

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
            
        String id_usuario = request.getParameter("id_usuario");
        String usunombre = request.getParameter("usunombre");
        String usuapellido = request.getParameter("usuapellido");
        String usudireccion = request.getParameter("usudireccion");
        String usutelefono = request.getParameter("usutelefono");
        String usuemail = request.getParameter("usuemail");
        String usupassword = request.getParameter("usupassword");
        String usuestado = request.getParameter("usuestado");
        String usu_id_rol = request.getParameter("usu_id_rol");     
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        //2. quien tiene los datos seguros
        usuarioVO usuVO = new usuarioVO(id_usuario, usunombre,  usuapellido , usudireccion, usutelefono, usuemail, usupassword , usuestado , usu_id_rol);
        rolesVO rolVO = new rolesVO();
//3. quien hace las operaciones
        usuarioDAO usuDAO = new usuarioDAO(usuVO);
        rolesDAO rolDAO = new rolesDAO(rolVO);
        switch (opcion){
            case 1: 
                if (usuDAO.agregarRegistro()) { //agregar registro
                    request.setAttribute("mensajeExito","El usuario se registro correctamente");
                } else {
                    request.setAttribute("mensajeError","El usuario no se registro correctamente");
                }
                request.getRequestDispatcher("Usuarios.jsp").forward(request,response);
            break;
            
            case 2:
            if (usuDAO.actualizarRegistro()) { //agregar registro
                    request.setAttribute("mensajeExito","El usuario se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError","El usuario no se actualizo correctamente");
                }
                request.getRequestDispatcher("Usuarios.jsp").forward(request,response);
            break;
            
            
            case 3:
                    if (usuDAO.iniciarSesion(id_usuario, usupassword)) {
                        HttpSession miSesion = request.getSession(true);
                        usuVO = usuDAO.consultarPorId(id_usuario);
                        miSesion.setAttribute("datosUsuario", usuVO);
                        String idUsuario = usuVO.getId_usuario();

                        ArrayList<rolesVO> listaRoles = rolDAO.listarInicio(idUsuario);
                        for (int i = 0; i < listaRoles.size(); i++) {
                            rolVO = listaRoles.get(i);
                            if (listaRoles.size() > 1) {
                                request.getRequestDispatcher("menu.jsp").forward(request, response);
                            }
                            if (rolVO.getId_Rol().equals("1")) {
                                request.getRequestDispatcher("menuVendedor.jsp").forward(request, response);

                            }
                            if (rolVO.getId_Rol().equals("2")) {
                                request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);

                            }
                            if (rolVO.getId_Rol().equals("3")) {
                                request.getRequestDispatcher("menuGerente.jsp").forward(request, response);

                            }
                        }
                    } else {
                        request.setAttribute("mensajeError", "¡Datos incorrectos!");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    break;
            case 4:
                usuVO = usuDAO.consultarPorId(id_usuario);
                if (usuVO != null) {
                    request.setAttribute("¡Usuario encontrado!", usuVO);
                    request.getRequestDispatcher("consultarUsuario2.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El usuario NO existe");
                    request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
                }
                break;
                
                case 5:
                usuVO = usuDAO.consultarPorId(id_usuario);
                if (usuVO != null) {
                    request.setAttribute("¡Usuario encontrado!", usuVO);
                    request.getRequestDispatcher("actualizarUsuario2.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El usuario NO existe");
                    request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
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
