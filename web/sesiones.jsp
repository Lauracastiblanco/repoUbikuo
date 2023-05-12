<%-- 
    Document   : sesiones
    Created on : 24/03/2023, 02:38:16 PM
    Author     : Luisa
--%>

<%@page import="ModeloVO.usuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesion</title>
    </head>

    <%
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-control", "no-cache,no-strore,must-revalidate");
        response.setDateHeader("Expires", 0);
    %>
    <body>
        <%
            String usuario = "", usuNombre = "";
            HttpSession buscarSesion = (HttpSession) request.getSession();

            if (buscarSesion.getAttribute("datosUsuario") != null) {
                usuarioVO usuVO = (usuarioVO) buscarSesion.getAttribute("datosUsuario");
                usuario = usuVO.getId_usuario();
                usuNombre = usuVO.getUsunombre();
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        %>
    </body>
</html>
