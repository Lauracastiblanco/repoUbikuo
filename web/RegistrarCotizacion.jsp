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
        <title>Cotizacion</title>
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

    <%
        // Obtener la fecha actual
        Date fecha = new Date();

        // Definir el formato deseado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Formatear la fecha en el formato deseado
        String fechaFormateada = sdf.format(fecha);
    %>

    <body>
        <form action="/Controlador/Cotizacion" method="post">
            <section class="main">
                <div class="dash-content">
                    <div class="overview">
                        <div class="title">
                            <span class="text">Crear Cotizacion</span>
                        </div>
                    </div>
                    <div class="container">
                        <div class="columna1">
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

                                </div>
                                <label>usuario</label><br>
                                <div class="box-container">
                                    <select name="cot_id_usuario">
                                        <option>seleccione</option>
                                        <%
                                            usuarioDAO usuDAO = new usuarioDAO();
                                            for (usuarioVO usuVO : usuDAO.listar()) {

                                        %>
                                        <option value="<%=usuVO.getId_usuario()%>"><%=usuVO.getUsunombre()%></option>
                                        <% }%>
                                    </select>
                                </div>

                                <h4>Datos del Cliente</h4>
                                <div class="datos-prov">

                                    <div class="box-container">
                                        <label>Id Cliente</label>
                                        <input type="text"  name="cot_id_cliente" value="${c.getId_cliente()}" >
                                    </div>  
                                    <button type="submit" name="accion" value="buscarcliente" class="btn btn-secondary" >buscar</button>
                                    <div class="box-container">
                                        <label>Nombre</label>
                                        <input type ="text" name="nombrescliente" value="${c.getClinombre()}" placeholder="Nombre" readonly>
                                    </div>
                                    <div class="box-container">
                                        <label>Apellido</label>
                                        <input type ="text" name="apellidocliente" value="${c.getCliapellido()}" placeholder="apellido" readonly>
                                    </div>
                                    <div class="box-container">
                                        <label>Direccion</label>
                                        <input type ="text" name="Direccion" value="${c.getClidireccion()}" placeholder="Direccion" readonly>
                                    </div>
                                    <div class="box-container">
                                        <label>Direccion</label>
                                        <input type ="text" name="Telefono" value="${c.getClitelefono()} "placeholder="Telefono" readonly>
                                    </div>
                                </div>
                            </div>
                            <div class="columna2">

                                <h3 class="titulo-prod">Productos</h3>
                                <div class="caja2">
                                    <div class="productos">
                                        <div class="datosproductos">
                                            <div class="box-container"> 
                                                <label>Codigo</label>
                                                <input type="text"  name="dc_id_prod" value="${pr.getId_prod()}"  >
                                                <button type="submit" name="accion" value="buscarproducto" class="btn btn-secondary">buscar</button>
                                            </div>
                                            <div class="box-container"> 
                                                <label>Producto</label>
                                                <input type ="text" name="nomproducto" value="${pr.getProdNombre()}" placeholder="producto" >
                                            </div>
                                            <div class="box-container"> 
                                                <label>Precio</label>
                                                <input type="number" id="precio" name="precio" value="${pr.getProdPrecio()}" placeholder="$/.0.00">
                                            </div>
                                            <div class="box-container"> 
                                                <label>Cantidad</label>
                                                <input type="number" id="cantidad" name="cantidad" placeholder="cantidad" >  
                                            </div>
                                            <div class="box-container"> 
                                                <label>Stock</label>
                                                <input type="text" id="stock" name="stock"  value="${pr. getProdstock_disp()}" placeholder="stock" >
                                            </div>




                                            <div >
                                                <button type="submit" name="accion" value="agregarproducto" class="btn btn-success">agregar</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>                 

                            <div class="card">
                                <div class="card-body">
                                    <label for="estado">Selecciona un estado:</label>
                                    <select id="estado" name="estado">
                                        <option value="pendiente">Pendiente</option>
                                        <option value="aprobado">Aprobado</option>
                                        <option value="rechazado">Rechazado</option>
                                    </select>
                                </div>
                            </div>
                            <div class="columna3">
                                <table class="tabla1">
                                    <thead>
                                        <tr>
                                            <th>item</th>
                                            <th>idproducto</th>
                                            <th>Producto</th>
                                            <th>Cantidad</th>
                                            <th>Precio unitario</th>
                                            <th>subtotal</th>
                                            <th class="action">acciones</th>
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







                                <div class="card-footer d-flex parte04">
                                    <div class="col-sm-6">
                                        <a href="Controlador?menu=cotizacion&accion=generarcotizacion" onclick="print()" class="btn btn-success">generar cotizacion</a>

                                        <input type="submit" name="action" value="Cancelar" onclick="cancelarRegistro()" class="btn btn-danger" style="margin-left: 10px">
                                    </div>
                                    <div class="col-sm-3 ml-auto">
                                        <input type="text" name="Total" class="form-control" value="${Total}" placeholder="total" readonly>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>      



            </section>
        </center>
        <script src="JS/agregaProducto.js" type="text/javascript"></script>
        <script src="JS/pedidoproveedor.js" type="text/javascript"></script>
        <script src="JS/buscador.js" type="text/javascript"></script>
        <script src="JS/popup.js" type="text/javascript"></script>
</body>
<script>
                                    function deleteItem(itemId) {
                                    // Aquí puedes escribir la lógica para eliminar el registro con el id "itemId"
                                    }

                                    const deleteButtons = document.querySelectorAll('.btn-danger');
                                    deleteButtons.forEach(button = > {
                                    button.addEventListener('click', () = > {
                                    const itemId = button.parentNode.parentNode.firstChild.textContent;
                                    deleteItem(itemId);
                                    button.parentNode.parentNode.remove();
                                    });
                                    });</script>
<script>
    function cancelarRegistro() {
    if (confirm("¿Está seguro que desea cancelar el registro?")) {
    window.location.href = "RegistrarCotizacion.jsp";
    }
    }
</script>
</html>
