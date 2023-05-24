<%-- 
    Document   : AVER
    Created on : 20/05/2023, 03:23:19 PM
    Author     : Alexander
--%>

<%@page import="ModeloVO.ProveedorVO"%>
<%@page import="ModeloDAO.ProveedorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="ProveedorPedido">
            <div class="box-container">
                <label>Usuario</label>
                <select name="id_usuario"> <!-- usuario -->
                    <option value="">Seleccione...</option>
                    <option value="1">Laura Castiblanco</option>
                    <option value="1074414468">Luisa Toquica</option>
                </select>
            </div>
            <div class="box-container">
                <label>NIT</label>
                <select name="ped_id_proveedor"> <!-- idProveedor -->
                    <option value="">Seleccione...</option>
                    <% ProveedorDAO provDAO = new ProveedorDAO();
                for (ProveedorVO provVO : provDAO.listar()) {%>
                    <option value="<%=provVO.getId_prov()%>"><%=provVO.getPronombre()%></option>
                    <% }%>
                </select>
            </div>
            <button class="generar-pedido">Generar Pedido</button>
            <input type="hidden" name="opcion" value="1">
        </form>

    </body>
</html>
