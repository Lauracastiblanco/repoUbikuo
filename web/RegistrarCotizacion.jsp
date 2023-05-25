<%-- 
    Document   : RegistrarCotizacion
    Created on : 24/03/2023, 03:53:00 AM
    Author     : Luisa
--%>
<%@page import="ModeloVO.usuarioVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="ModeloVO.usuarioVO"%>
<%@page import="ModeloDAO.usuarioDAO"%>
<%@include file="menuVendedor.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <!--------------------- Iconos ------------------------------->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!--------------------- Select ------------------------------->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>

        <!--------------------- Estilos ------------------------------->
        <link href="CSS/stylepopup.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/principal.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/pedido.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <section class="main">
        <div class="dash-content">
            <div class="container">
                <h1>Crear cotización</h1>

                <form action="cotizacion" method="post">
                    <div class="datos-usu">
                        <label>Usuario</label><br>
                        <select name="cot_id_usuario">
                            <option>Seleccione</option>
                            <% usuarioDAO usuDAO = new usuarioDAO();
                            for (usuarioVO usuVO : usuDAO.listar()) {%>
                            <option value="<%= usuVO.getId_usuario()%>"><%= usuVO.getUsunombre()%></option>
                            <% }%>
                        </select><br>
                    </div><br>

                    <div class="row">
                        <div class="columna1 col-lg-6">
                            <div class="caja1">
                                <label>Datos del Cliente</label>
                                <div class="box-container">
                                    <label>Documento</label>
                                    <input type="text" name="cot_id_cliente" value="${c.getId_cliente()}" autofocus>
                                </div>
                                <div class="box-container">
                                    <button type="submit" name="accion" value="buscarcliente" class="btn btn-secondary">Buscar</button>
                                </div>
                                <div class="box-container">
                                    <label>Nombre</label>
                                    <input type="text" name="nombrescliente" value="${c.getClinombre()}" placeholder="Nombre" readonly>
                                </div>
                                <div class="box-container">
                                    <label>Apellido</label>
                                    <input type="text" name="apellidocliente" value="${c.getCliapellido()}" placeholder="Apellido" readonly>
                                </div>
                                <div class="box-container">
                                    <label>Direccion</label>
                                    <input type="text" name="Direccion" value="${c.getClidireccion()}" placeholder="Dirección" readonly>
                                </div>
                                <div class="box-container">
                                    <label>Telefono</label>
                                    <input type="text" name="Telefono" value="${c.getClitelefono()}" placeholder="Teléfono" readonly>
                                </div>
                            </div><br>

                            <div class="box-container">
                                <div class="caja2">
                                    <label>Datos Productos</label>
                                    <input type="text" name="dc_id_prod" value="${pr.getId_prod()}">
                                    <button type="submit" name="accion" value="buscarproducto" class="btn btn-secondary">Buscar</button>
                                    <input type="text" name="nomproducto" value="${pr.getProdnombre()}" placeholder="Producto">
                                    <input type="number" id="precio" name="precio" value="${pr.getProdprecio()}" placeholder="$.0.00">
                                    <input type="number" id="cantidad" name="cantidad" placeholder="Cantidad">
                                    <input type="text" id="stock" name="stock" value="${pr.getProdstock_disp()}" placeholder="Stock">

                                    <div>
                                        <button type="submit" name="accion" value="agregarproducto" class="btn btn-success">Agregar</button>
                                    </div><br>
                                </div><br>
                            </div>
                        </div>

                        <div class="columna2 col-lg-6">
                            <div class="card">
                                <div class="card-body">
                                    <label for="estado">Selecciona un estado:</label>
                                    <select id="estado" name="estado">
                                        <option value="pendiente">Pendiente</option>
                                        <option value="aprobado">Aprobado</option>
                                        <option value="rechazado">Rechazado</option>
                                    </select>
                                    <table class="tabla1">
                                        <thead>
                                            <tr>
                                                <th>Item</th>
                                                <th>Idproducto</th>
                                                <th>Producto</th>
                                                <th>Cantidad</th>
                                                <th>Precio unitario</th>
                                                <th>Subtotal</th>
                                                <th class="action">Acciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="list" items="${lista}">
                                                <tr>
                                                    <td>${list.getItem()}</td>
                                                    <td>${list.getDc_id_producto()}</td>
                                                    <td>${list.getNombreproductoL()}</td>
                                                    <td>${list.getCantidad()}</td>
                                                    <td>${list.getPrecio()}</td>
                                                    <td>${list.getSubtotal()}</td>
                                                    <td></td>
                                                    <td class="d-flex">
                                                        <a class="btn btn-danger" style="margin-left: 10px">Borrar</a>
                                                    </td>
                                                    <td></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="card-footer d-flex parte04">
                                    <div class="col-sm-6">
                                       <button type="submit" name="accion" value="generarcotizacion" class="btn btn-secondary">generar cotizacion</button>
                                        <input type="submit" name="action" value="Cancelar" onclick="cancelarRegistro()" class="btn btn-danger" style="margin-left: 10px">
                                    </div>
                                    <div class="col-sm-3 ml-auto">
                                        <input type="text" name="Total" class="form-control" value="${Total}" placeholder="Total" readonly>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
</body>



</html>