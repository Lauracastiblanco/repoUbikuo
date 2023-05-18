<%-- 
    Document   : GeneradorReporte
    Created on : 3/05/2023, 09:06:24 AM
    Author     : APRENDIZ
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.ConexionBd"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            File reporte = new File(application.getRealPath("Reportes/usuariosActivos.jasper"));
            Map<String,Object> parametros = new HashMap<String, Object>();

            ConexionBd conexion = new ConexionBd();
            Connection objetoConexion = conexion.obtenerConexion();
            byte[] bytes = JasperRunManager.runReportToPdf(reporte.getPath(), parametros, objetoConexion);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            response.setHeader("Content-Disposition", "attachment; filename=\"reporteUsuarios.pdf\";");
            ServletOutputStream salida = response.getOutputStream();
            salida.write(bytes, 0, bytes.length);
            salida.flush();
            salida.close();
            %>
    </body>
</html>
