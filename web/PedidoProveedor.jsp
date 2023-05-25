<%-- 
    Document   : Proveedor
    Created on : 26/04/2023, 07:56:00 AM
    Author     : APRENDIZ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="ModeloVO.productosVO"%>
<%@page import="ModeloDAO.productosDAO"%>
<%@page import="ModeloVO.CategoriaVO"%>
<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ModeloDAO.rolesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.ProveedorDAO"%>
<%@page import="ModeloVO.ProveedorVO"%>
<%@include file="menuVendedor.jsp" %>
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
                <div class="overview">
                    <div class="title">
                        <span class="text">Pedido Proveedor</span>
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
                            <h4>Datos Proveedor</h4>
                            <div class="datos-prov">
                                <div class="box-container">
                                    <label>NIT</label>
                                    <select name="id_prov" onchange="inputsProveedor()" id="id_prov">
                                        <option>Seleccione...</option>
                                        <% ProveedorDAO provDAO = new ProveedorDAO();
                                            for (ProveedorVO rolVO : provDAO.listar()) {
                                                String id_prov = String.valueOf(rolVO.getId_prov());
                                        %>
                                        <option value="<%= id_prov%>" data-nombre="<%= rolVO.getPronombre()%>" data-representante="<%= rolVO.getProrepresentante()%>" data-direccion="<%= rolVO.getProdireccion()%>" data-correo="<%= rolVO.getProcorreo()%>"><%= rolVO.getPronombre()%> NIT <%= rolVO.getId_prov()%></option>
                                        <% }%>
                                    </select>
                                </div>
                                <div class="box-container">
                                    <label>Nombre</label>
                                    <input type="text" placeholder="Nombre" id="pronombre" value="<%= request.getAttribute("pronombre")%>">
                                </div>  
                                <div class="box-container">
                                    <label>Representante</label>
                                    <input type="text" placeholder="Representante" id="prorepresentante" value="<%= request.getAttribute("prorepresentante")%>">
                                </div>
                                <div class="box-container">
                                    <label>Direccion</label>
                                    <input type="text" placeholder="Direccion" id="prodireccion" value="<%= request.getAttribute("prodireccion")%>">
                                </div>
                                <div class="box-container">
                                    <label>Correo Electronico</label>
                                    <input type="text" placeholder="Correo Electronico" id="procorreo" value="<%= request.getAttribute("procorreo")%>">
                                </div>
                            </div>
                        </div>
                        <form method="post" action="DetallesPedidoProveedor">
                            <h2>Lista de Productos</h2>
                            <table class="tabla1">
                                <thead>
                                    <tr>
                                        <td>Item</td>
                                        <th>Id Producto</th>
                                        <th>Nombre</th>
                                        <th>Cantidad</th>
                                        <th>Precio Unitario</th>
                                        <th>Sub Total</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="detalle" items="${listaProductos}">
                                        <tr>
                                            <td>${detalle.item}</td>
                                            <td>${detalle.dpro_id_producto}</td>
                                            <td>${detalle.descripcionProducto}</td>
                                            <td>${detalle.dpro_cantidad}</td>
                                            <td>${detalle.dpro_preciocompra}</td>
                                            <td>${detalle.dpro_subtotal}</td>
                                            <td>Acciones</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <button class="generar-pedido">Generar Pedido</button>
                            <input  type="hidden" name="opcion" value="2">
                        </form>
                    </div>
                    <div class="columna2">
                        <h3 class="titulo-prod">Productos</h3>
                        <div class="caja2">
                            <form method="post" action="DetallesPedidoProveedor">
                                <div class="productos">
                                    <div class="datosproductos">
                                        <label>Producto</label>
                                        <select name="id_prod" id="selectProducto" onchange="inputsProductos()" class="select2" id="miSelect">
                                            <option value="">Seleccione...</option>
                                            <% productosDAO prodDAO = new productosDAO();
                                                List<productosVO> listaProductos = prodDAO.listar();
                                                for (productosVO prodVO : listaProductos) {%>
                                            <option class="producto-option" value="<%= prodVO.getId_prod()%>" data-descripcion="<%= prodVO.getProd_descripcion()%>" data-precio="<%= prodVO.getProdprecio()%>" data-stock="<%= prodVO.getProdstock_disp()%>"><%= prodVO.getProdnombre()%> - REF: <%= prodVO.getId_prod()%></option>
                                            <% }%>
                                        </select>
                                        <label>Descripción</label>
                                        <input type="text" placeholder="Descripcion" id="prod_descripcion" name="prod_descripcion" >
                                        <label>Precio</label>
                                        <input type="text" placeholder="Precio" id="prodprecio" name="prodprecio">
                                        <label>Stock</label>
                                        <input type="text" placeholder="Stock" id="prodstock_disp" name="prodstock_disp">
                                        <label>Cantidad</label>
                                        <input type="text" placeholder="Cantidad" name="dpro_cantidad">
                                        <label>Foto</label>
                                        <img class="foto-prod" src="ASSETS/Breaker.png" alt=""/>
                                        <button class="btn agregar" id="agregar-btn" onclick="guardarDatos()">Agregar al pedido</button>
                                        <input  type="hidden" name="opcion" value="1">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="JS/pedidoproveedor.js" type="text/javascript"></script>
        <script src="JS/buscador.js" type="text/javascript"></script>
        <script src="JS/popup.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>
        <script>
                  // Obtener los valores del almacenamiento local
           var id_usuario = localStorage.getItem('id_usuario');
           var pronombre = localStorage.getItem('pronombre');
           var prorepresentante = localStorage.getItem('prorepresentante');
           var procorreo = localStorage.getItem('procorreo');
           var prodireccion = localStorage.getItem('prodireccion');
           var id_prov = localStorage.getItem('id_prov');

           // Establecer los valores en los campos del formulario
           document.getElementById('id_usuario').value = id_usuario;
           document.getElementById('pronombre').value = pronombre;
           document.getElementById('prorepresentante').value = prorepresentante;
           document.getElementById('procorreo').value = procorreo;
           document.getElementById('prodireccion').value = prodireccion;
           document.getElementById('id_prov').value = id_prov;
        </script>
    </body>
</html>