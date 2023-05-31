<%-- 
    Document   : CrearCotizacion1
    Created on : 29/05/2023, 05:01:35 PM
    Author     : diego
--%>
<%@page import="ModeloVO.ClienteVO"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ModeloVO.productosVO"%>
<%@page import="java.util.List"%>
<%@page import="ModeloVO.CategoriaVO"%>
<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page import="ModeloDAO.productosDAO"%>
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
            <form method="post" action="cotizacion">
                <div class="dash-content">
                    <div class="overview">
                        <div class="title">
                            <span class="text">Crear Cotizacion</span>
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
                                            <input type="text" name="cot_id_cliente" value="${c.getId_cliente()}" autofocus> 
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
                            </div>
                            <h2>Lista de Productos</h2>
                            <table class="tabla1" id="tablaProductos">
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
                                <c:forEach var="list" items="${listaprod}">
                                    <tr>
                                       <td>${list.getItem()}</td>
                                                    <td>${list.getDc_id_producto()}</td>
                                                    <td>${list.getNombreproductoL()}</td>
                                                    <td>${list.getCantidad()}</td>
                                                    <td>${list.getPrecio()}</td>
                                                    <td>${list.getSubtotal()}</td>
                                                     <td class="d-flex">
                                                        <a class="btn btn-danger" style="margin-left: 10px">Borrar</a>
                                                    </td>
                                                    <td></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
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
                                                <option class="producto-option" value="<%=prodVO.getId_prod()%>" data-descripcion="<%=prodVO.getProdnombre()%>" data-precio="<%=prodVO.getProdprecio()%>" data-stock="<%=prodVO.getProdstock_disp()%>"><%=prodVO.getProdnombre()%> - REF: <%=prodVO.getId_prod()%></option>
                                                <% } %>
                                            </optgroup>
                                            <% }
                                                }%>
                                        </select>
                                        <label>Descripción</label>
                                        <input type="text" placeholder="Descripcion" id="prod_descripcion" name="nomproducto" >
                                        <label>Precio</label>
                                        <input type="text" placeholder="Precio" id="prodprecio" name="precio">
                                        <label>Stock</label>
                                        <input type="text" placeholder="Stock" id="prodstock_disp" name="prodstock_disp">
                                        <label>Cantidad</label>
                                        <input type="text" placeholder="Cantidad" name="cantidad">
                                        <label>Foto</label>
                                        <img class="foto-prod" src="ASSETS/Breaker.png" alt=""/>
                                         <button type="submit" name="accion" value="agregarproducto" class="btn btn-success">Agregar</button>
                                       
                                    </div>
                                </div>
                                        

                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </section>
        <script src="JS/agregaProducto.js" type="text/javascript"></script>
        <script src="JS/pedidoproveedor.js" type="text/javascript"></script>
        <script src="JS/buscador.js" type="text/javascript"></script>
        <script src="JS/popup.js" type="text/javascript"></script>
        <script>

        </script>
    </body>
</html>
