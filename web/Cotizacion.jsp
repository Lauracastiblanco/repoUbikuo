<%-- 
    Document   : Cotizacion
    Created on : 30/05/2023, 08:57:39 PM
    Author     : diego
--%>

<%@page import="ModeloDAO.cotizacionDAO"%>
<%@page import="ModeloVO.cotizacionVO"%>
<%@page import="java.util.ArrayList"%>

<%@include file="menuVendedor.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cotizacion</title>
        <link href="CSS/stylepopup.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/principal.css" rel="stylesheet" type="text/css"/>
        <!--------------------- Iconos ------------------------------->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    </head>
    <body>
        <%-- Mostrar SweetAlert si se registra el cliente normal exitosamente --%>
        <% String successMessage = (String) request.getAttribute("RegistroExitoso"); %>
        <% if (successMessage != null) { %>
            <script>
                Swal.fire({
                    icon: 'success',
                    title: 'Registro Éxitoso',
                    text: '<%= successMessage %>'
                });
            </script>
        <% } %>
        
        <%-- Mostrar SweetAlert en caso de error al registrar el cliente normal --%>
        <% String errorMessage = (String) request.getAttribute("mensajeError"); %>
        <% if (errorMessage != null) { %>
            <script>
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: '<%= errorMessage %>'
                });
            </script>
        <% } %>
         <section class="main">
            <div class="dash-content pedido">
                <div class="overview">
                    <div class="title">
                        <span class="text">Cotizaciones</span>
                    </div>
                    <div class="boxes">
                        <div class="box box1">
                            <button class="open-popup" data-popup="popup1"><i class='bx bxs-plus-circle registrar'></i></button>
                            <span class="text">Registrar Cliente</span>
                            <div class="popup" id="popup1">
                                <div class="overlay"></div>
                                <div class="popup-content">
                                    <h2>Nuevo Cliente</h2>
                                    <form method = "post" action="Cliente">
                                        <div class="module-details">
                                            <div class="input-box">
                                                <span class="details">Documento </span>
                                                <input type="text" id="id_prov" name="id_cliente" placeholder="Documento" required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Nombres </span>
                                                <input type="text" name="clinombre"  placeholder="Nombre"required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Apellidos </span>
                                                <input type="text" name="cliapellido"  placeholder="Apellido"required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Dirección* </span>
                                                <input type="text" name="clidireccion" placeholder="Direccion" required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Telefono* </span>
                                                <input type="number" name="clitelefono" placeholder="Telefono" required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Correo Electronico* </span>
                                                <input type="text" name="clicorreo" placeholder="Correo Electronico"required>
                                            </div>
                                           
                                            <div class="input-box">
                                                <span class="details">Descripcion</span>
                                                <select type="text" name="clidescripcion">
                                                    <option value="activo">Natural</option>
                                                    <option value="inactivo">Credito</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="controls">
                                            <a href="#" class="cancelarbtn">Cancelar</a>
                                            <button class="registrarbtn">Registrar Cliente</button>
                                            <input  type="hidden" name="opcion" value="1">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <a style="text-decoration:none" href="consultarPedProveedor.jsp">
                            <div class="box box2">
                                <i class='bx bx-package pedido'></i>
                                <span class="text">Cotizaciones</span>
                            </div>
                        </a>
                        <div class="box box3">
                            <i class='bx bxs-report activos'></i>
                            <span class="text">Reportes</span>
                        </div>
                        <div class="box box2">
                            <i class='bx bxs-user-check activos' ></i>
                            <span class="number">10</span>
                            <span class="text">Pendientes</span>
                        </div>
                        <div class="box box3">
                            <i class='bx bxs-user total'></i>
                            <span class="number">20</span>
                            <span class="text">Total</span>
                        </div>
                    </div>
                </div>
                <div id="customers" class="table-data">
                    <div  class="order">
                        <div class="head">
                            <h3>Consultar cotizacion</h3>
                            <div class="buscar">
                                <input type="text" id="buscador" name="id_prov"class="buscar__input" placeholder="Buscar">
                            </div>
                            <select class="selectico" id="estado">
                                <option value="">Todos</option>
                                <option value="activo">Activo</option>
                                <option value="inactivo">Inactivo</option>
                            </select>
                            <i class='bx bx-search'></i>
                            <i class='bx bx-filter'></i>
                        </div>
           <table>
    <thead>
        <tr>
            <th>N° Cotización</th>
            <th>Cliente</th>
            <th>Usuario</th>
            <th>Fecha</th>
            <th>Total</th>
            <th>Estado</th>
            <th>Actualizar</th>
        </tr>
    </thead>
    <tbody>
        <%
        cotizacionDAO dao = new cotizacionDAO(); // Crear una instancia del DAO
        ArrayList<cotizacionVO> listaCotizaciones = dao.consultarDatos(); // Obtener la lista de cotizaciones
        
        for (cotizacionVO cotizacion : listaCotizaciones) {
        %>
        <tr>
            <td><%= cotizacion.getId()%></td>
            <td><%= cotizacion.getCliente() %></td>
            <td><%= cotizacion.getUsuario() %></td>
            <td><%= cotizacion.getFecha() %></td>
            <td><%= cotizacion.getTotal() %></td>
            <td><%= cotizacion.getEstado() %></td>
            <td><input type="button" value="Actualizar"></td>
        </tr>
        <% } %>
    </tbody>
</table>


                    </div>
                </div>
            </div>
        </section>
        <script src="JS/buscador.js" type="text/javascript"></script>
        <script src="JS/popup.js" type="text/javascript"></script>
    </body>
</html>
