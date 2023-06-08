<%-- 
    Document   : CrearPedido
    Created on : Jun 5, 2023, 3:25:11 AM
    Author     : WIN
--%>

<%@page import="ModeloVO.pedidoVO"%>
<%@page import="ModeloDAO.pedidoDAO"%>
<%@page import="ModeloVO.productosVO"%>
<%@page import="ModeloVO.CategoriaVO"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page import="ModeloDAO.productosDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@include file="menuVendedor.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
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
            <form method="post" action="Pedido">
                <div class="dash-content">
                    <div class="overview">
                        <div class="title">
                            <span class="text">Crear Pedido</span>
                        </div>
                    </div>
                    <div class="container">
                        <div class="columna1">
                            <div class="caja1">
                                <h4>Datos Generales</h4>
                                <div class="datos-usu">
                                    <%
                                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                        Date currentDate = new Date();
                                        String currentDateStr = dateFormat.format(currentDate);
                                    %>
                                    <div class="box-container">
                                        <label>Fecha</label>
                                        <input type="date" value="<%= currentDateStr%>"readonly>
                                    </div>
                                    <div class="box-container">
                                        <label>Usuario</label>
                                        <select name="id_usuario" id="id_usuario">
                                            <option value="">Selccione...</option>
                                            <option value="1">Laura Castiblanco</option>
                                            <option value="1074414468">Luisa Toquica</option>
                                        </select>
                                    </div>
                                </div>
                                <h4>Datos Cliente</h4>
                                <div class="datos-prov">
                                    <div class="datosclientes">

                                        <label>Documento</label>


                                        <div style="display: flex; align-items: center;">
                                            <input type="text" name="id_cliente" value="${c.getId_cliente()}" autofocus> 
                                            <button type="submit" name="accion" value="buscarcliente" class="btn btn-success" >Buscar</button>
                                        </div>



                                        <label>Nombre</label>
                                        <input type="text" placeholder="Nombre" value="${c.getClinombre()}" readonly>

                                        <label>Apellido</label>
                                        <input type="text" placeholder="Apellido" value="${c.getCliapellido()}" readonly>

                                        <label>Descripción</label>
                                        <input type="text" placeholder="Descripción" value="${c.getClidescripcion()}" readonly>

                                        <label>Correo</label>
                                        <input type="text" placeholder="Correo" value="${c.getClicorreo()}" readonly>

                                        <label>Dirección</label>
                                        <input type="text" placeholder="Dirección" value="${c.getClidireccion()}" readonly>

                                        <label>Teléfono</label>
                                        <input type="text" placeholder="Teléfono" value="${c.getClitelefono()}" readonly>


                                    </div>



                                </div>

                                <div class="columna2">
                                    <h3 class="titulo-prod">Productos</h3>
                                    <div class="caja2">

                                        <div class="productos">
                                            <div class="datosproductos">
                                                <label>Producto</label>
                                                <input type="text" name="id_prod" class="select2" placeholder="Codigo Producto" value="${producto.getId_prod()}">
                                                <button type="submit" name="accion" value="buscarproducto" class="btn btn-success">Buscar</button>
                                                <label>Descripción</label>
                                                <input type="text" placeholder="Descripcion" id="prod_descripcion" name="nombreproducto" value="${producto.getProdnombre()}">
                                                <label>Precio</label>
                                                <input type="text" placeholder="Precio" id="prodprecio" name="precio" value="${producto.getProdprecio()}">
                                                <label>Stock</label>
                                                <input type="text" placeholder="Stock" id="prodstock_disp" name="prodstock_disp" value="${producto.getProdstock_disp()}">
                                                <label>Cantidad</label>
                                                <input type="text" placeholder="Cantidad" name="cantidad" value="1">
                                                <button type="submit" name="accion" value="agregarproducto" class="btn btn-success">Agregar Producto</button>

                                            </div>
                                        </div>


                                    </div>
                                </div>

                            </div>
                            <h2>Lista de Productos</h2>
                            <table class="tabla1">
                                <thead>
                                    <tr>
                                        <th>Item</th>
                                        <th>Idproducto</th>
                                        <th>Producto</th>
                                        <th>Cantidad</th>
                                        <th>Precio unitario</th>
                                        <th>Subtotal</th>
                                        <th>Acciones</th>

                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getDp_id_producto()}</td>
                                        <td>${list.getNombreprod()}</td>
                                        <td>${list.getDp_cantidad()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td>
                                            <a href="#" class="btn btn-warning">Editar</a>
                                            <a href="#" class="btn btn-danger">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <div class="card-footer d-flex parte04">
                                <div class="col-sm-6">
                                    <button type="submit" name="accion" value="generarpedido" class="btn btn-secondary">generar pedido</button>
                                    <input type="submit" name="action" value="Cancelar" onclick="cancelarRegistro()" class="btn btn-danger" style="margin-left: 10px">
                                </div>
                                <div class="col-sm-3 ml-auto">
                                    <input type="text" name="txtTotal" class="form-control" value="${total}" placeholder="Total" readonly>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </form>
        </section>
    </body>
</html>
