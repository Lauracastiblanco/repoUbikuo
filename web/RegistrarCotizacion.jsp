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
        <title>Cotización</title>
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
        <form action="Controlador/cotizacion" method="POST">
            <section class="main">
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
                                <div class="box-container">
                                    <label>Fecha</label>
                                    <input type="date" value="<%= java.time.LocalDate.now()%>" readonly>
                                </div>
                                <div class="box-container">
                                    <label>usuario</label><br>

                                    <select name="cot_id_usuario">
                                        <option>seleccione</option>
                                        <%-- Aquí puedes agregar lógica para cargar los usuarios --%>
                                    </select>
                                </div>


                                <h4>Datos del Cliente</h4>
                                <div class="datos-prov">
                                    <div class="box-container">
                                        <label>Id Cliente</label>
                                        <input type="text" name="cot_id_cliente" value="" >
                                    </div>  
                                    <button type="submit" class="generar-pedido" name="accion" value="buscarcliente" class="btn btn-secondary" >buscar</button>
                                    <div class="box-container">
                                        <label>Nombre</label>
                                        <input type ="text" name="nombrescliente" value="" placeholder="Nombre" readonly>
                                    </div>
                                    <div class="box-container">
                                        <label>Apellido</label>
                                        <input type ="text" name="apellidocliente" value="" placeholder="apellido" readonly>
                                    </div>
                                    <div class="box-container">
                                        <label>Direccion</label>
                                        <input type ="text" name="Direccion" value="" placeholder="Direccion" readonly>
                                    </div>
                                    <div class="box-container">
                                        <label>Telefono</label>
                                        <input type ="text" name="Telefono" value="" placeholder="Telefono" readonly>
                                    </div>
                                </div>
                                <h2>Estado</h2>
                                <table class="tabla1">
                                    <label for="estado">Selecciona un estado:</label>
                                    <select id="estado" name="estado">
                                        <option value="pendiente">Pendiente</option>
                                        <option value="aprobado">Aprobado</option>
                                        <option value="rechazado">Rechazado</option>
                                    </select>
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
                                        <%-- Aquí puedes agregar lógica para mostrar los productos agregados --%>
                                    </tbody>
                                </table>
                            </div>
                            <br>
                            <div class="card-footer d-flex parte04">
                                <div class="col-sm-6 ml-auto">
                                    <a href="cotizacion/generarcotizacion" onclick="print()" class="generar-pedido">generar cotizacion</a>
                                    <input type="submit" name="action" value="Cancelar" onclick="cancelarRegistro()" class="generar-pedido" style="margin-left: 10px">
                                </div>
                                <br>
                                <div class="col-sm-6 ml-auto">
                                    <input type="text" name="Total" class="form-control" value="" placeholder="total" readonly>
                                </div>
                                <br>
                            </div>
                        </div>

                        <div class="columna2">    
                            <h3 class="titulo-prod">Productos</h3>
                            <div class="caja2">
                                <div class="productos">
                                    <div class="datosproductos">
                                        <label>Codigo</label>
                                        <input type="text" name="dc_id_prod" value=""  >
                                        <button type="submit" class="generar-pedido" name="accion" value="buscarproducto" class="btn btn-secondary">buscar</button>

                                        <label>Producto</label>
                                        <input type ="text" name="nomproducto" value="" placeholder="producto" >

                                        <label>Precio</label>
                                        <input type="number" id="precio" name="precio" value="" placeholder="$/.0.00">

                                        <label>Cantidad</label>
                                        <input type="number" id="cantidad" name="cantidad" placeholder="cantidad" >  

                                        <label>Stock</label>
                                        <input type="text" id="stock" name="stock"  value="" placeholder="stock" >
                                    </div>

                                    <div >
                                        <button type="submit" class="generar-pedido" name="accion" value="agregarproducto" class="btn btn-success">agregar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
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
