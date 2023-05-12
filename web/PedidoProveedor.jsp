<%-- 
    Document   : Proveedor
    Created on : 26/04/2023, 07:56:00 AM
    Author     : APRENDIZ
--%>

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
                                    <select name="" id="">
                                        <option value="">Selccione...</option>
                                        <option value="activo">Laura Castiblanco</option>
                                        <option value="inactivo">Luisa Toquica</option>
                                    </select>
                                </div>
                            </div>
                            <h4>Datos Proveedor</h4>
                            <div class="datos-prov">
                                <div class="box-container">
                                    <label>NIT</label>
                                    <select name="id_prov" class="select2" id="miSelect" onchange="inputsProveedor()">
                                        <option>Selecione...</option>
                                        <% ProveedorDAO provDAO = new ProveedorDAO();
                                            for (ProveedorVO rolVO : provDAO.listar()) {%>
                                        <option value="<%=rolVO.getId_prov()%>" data-nombre="<%=rolVO.getPronombre()%>"data-representante="<%=rolVO.getProrepresentante()%>" data-direccion="<%=rolVO.getProdireccion()%>" data-correo="<%=rolVO.getProcorreo()%>"><%=rolVO.getPronombre()%> NIT <%=rolVO.getId_prov()%></option>
                                        <% }%>
                                    </select>
                                </div>
                                <div class="box-container">
                                    <label>Nombre</label>
                                    <input type="text" placeholder="Nombre" id="pronombre">
                                </div>  
                                <div class="box-container">
                                    <label>Representante</label>
                                    <input type="text" placeholder="Representante" id="prorepresentante">
                                </div>
                                <div class="box-container">
                                    <label>Direccion</label>
                                    <input type="text" placeholder="Direccion" id="prodireccion">
                                </div>
                                <div class="box-container">
                                    <label>Correo Electronico</label>
                                    <input type="text" placeholder="Correo Electronico" id="procorreo">
                                </div>
                            </div>
                        </div>
                        <h2>Lista de Productos</h2>
                        <table class="tabla1">
                            <thead>
                                <tr>
                                    <th>Item</th>
                                    <th>Id Producto</th>
                                    <th>Nombre</th>
                                    <th>Cantidad</th>
                                    <th>Precio Unitario</th>
                                    <th>Sub Total</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                        <button class="generar-pedido">Generar Pedido</button>
                    </div>
                    <div class="columna2">
                        <h3 class="titulo-prod">Productos</h3>
                        <div class="caja2">
                            <div class="productos">
                                <div class="datosproductos">
                                    <label>Producto</label>
                                    <select name="id_prod" id="selectProducto" onchange="inputsProductos()" class="select2" id="miSelect">
                                        <option value="">Seleccione...</option>
                                        <%
                                            productosDAO prodDAO = new productosDAO();
                                            CategoriaDAO catProdDAO = new CategoriaDAO();
                                            List<CategoriaVO> listaCategorias = catProdDAO.listarC();
                                            for (CategoriaVO catVO : listaCategorias) {
                                                List<productosVO> listaProductos = prodDAO.listarCategoria(catVO.getId_cat());
                                                if (!listaProductos.isEmpty()) {
                                        %>
                                        <optgroup label="Categoria: <%=catVO.getCatnombre()%>">
                                            <% for (productosVO prodVO : listaProductos) {%>
                                            <option class="producto-option" value="<%=prodVO.getId_prod()%>" data-descripcion="<%=prodVO.getProd_descripcion()%>" data-precio="<%=prodVO.getProdprecio()%>" data-stock="<%=prodVO.getProdstock_disp()%>"><%=prodVO.getProdnombre()%> REF: <%=prodVO.getId_prod()%></option>
                                            <% } %>
                                        </optgroup>
                                        <% }
                                            }%>
                                    </select>
                                    <label>Descripción</label>
                                    <input type="text" placeholder="Descripcion" id="prod_descripcion">
                                    <label>Precio</label>
                                    <input type="text" placeholder="Precio" id="prodprecio">
                                    <label>Stock</label>
                                    <input type="text" placeholder="Precio" id="prodstock_disp">
                                    <label>Cantidad</label>
                                    <input type="text" placeholder="Cantidad">
                                    <label>Foto</label>
                                    <img class="foto-prod" src="ASSETS/Breaker.png" alt=""/>
                                    <button class="btn agregar" id="agregar-btn">Agregar al pedido</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="JS/agregaProducto.js" type="text/javascript"></script>
        <script src="JS/pedidoproveedor.js" type="text/javascript"></script>
        <script src="JS/buscador.js" type="text/javascript"></script>
        <script src="JS/popup.js" type="text/javascript"></script>
    </body>
</html>
