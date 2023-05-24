<%-- 
    Document   : crearPedProveedor
    Created on : 21/05/2023, 02:55:07 PM
    Author     : Alexander
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ModeloVO.ProveedorVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.ProveedorDAO"%>
<%@include file="menuVendedor.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <!--------------------- Iconos ------------------------------->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!--------------------- Select ------------------------------->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>-->
        <!--------------------- Estilos ------------------------------->
        <link href="CSS/stylepopup.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/principal.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/pedido.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section class="main">
            <div class="dash-content pedido">
                <div class="overview">
                    <div class="title">
                        <span class="text">Pedido Proveedor</span>
                    </div>
                    <div class="boxes">
                        <div class="box box1">
                            <button class="open-popup" data-popup="popup1"><i class='bx bxs-plus-circle registrar'></i></button>
                            <span class="text">Nuevo Pedido</span>
                            <div class="popup" id="popup1">
                                <div class="overlay"></div>
                                <div class="popup-content">
                                    <h2>Nuevo Pedido</h2>
                                    <form method = "post" action="ProveedorPedido">
                                        <div class="module-details">
                                            <div class="input-box">
                                                <span class="details">Fecha de pedido </span>
                                                <%
                                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                                    Date currentDate = new Date();
                                                    String currentDateStr = dateFormat.format(currentDate);
                                                %>
                                                <input type="date" value="<%= currentDateStr%>"readonly name="proped_fecha"> <!-- fecha -->
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Usuario*</span>
                                                <select name="id_usuario" id="id_usuario"> <!-- usuario -->
                                                    <option value="">Selccione...</option>
                                                    <option value="1">Laura Castiblanco</option>
                                                    <option value="1074414468">Luisa Toquica</option>
                                                </select>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Nit* </span>
                                                <select name="ped_id_proveedor" class="select2" id="miSelect" onchange="inputsProveedor()" id="id_prov"> <!-- idProveedor -->
                                                    <option>Selecione...</option>
                                                    <% ProveedorDAO provDAOSelect = new ProveedorDAO();
                                                            for (ProveedorVO provVO : provDAOSelect.listar()) {%>
                                                    <option value="<%=provVO.getId_prov()%>" data-nombre="<%=provVO.getPronombre()%>"data-representante="<%=provVO.getProrepresentante()%>" data-direccion="<%=provVO.getProdireccion()%>" data-correo="<%=provVO.getProcorreo()%>"><%=provVO.getPronombre()%> NIT <%=provVO.getId_prov()%></option>
                                                    <% }%>
                                                </select>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Nombre* </span>
                                                <input type="text" placeholder= "Nombre" id="pronombre" name="pronombre">
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Representante* </span>
                                                <input type="text" placeholder="Representante" id="prorepresentante" name="prorepresentante">
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Dirección* </span>
                                                <input type="text" placeholder="Direccion" id="prodireccion" name="prodireccion">
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Correo Electronico* </span>
                                                <input type="text" placeholder="Correo Electronico" id="procorreo" name="procorreo">
                                            </div>
                                        </div>
                                        <div class="controls">
                                            <a href="#" class="cancelarbtn">Cancelar</a>
                                            <button class="registrarbtn" onclick="guardarDatos()">Crear Pedido</button>
                                            <input  type="hidden" name="opcion" value="1">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="box box3">
                            <i class='bx bxs-report activos'></i>
                            <span class="text">Facturas</span>
                        </div>
                        <div class="box box2">
                            <i class='bx bxs-user-check activos' ></i>
                            <span class="number">10</span>
                            <span class="text">Pendiente</span>
                        </div>
                    </div>
                </div>
                <div id="customers" class="table-data">
                    <div  class="order">
                        <div class="head">
                            <h3>Consultar Pedido</h3>
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
                                    <th>NIT</th>
                                    <th>Nombre</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>
                                    <th>Descripcion</th>
                                    <th>Correo</th>
                                    <th>Representante</th>
                                    <th>Estado</th>
                                    <th>Actualizar</th>
                                </tr>
                            </thead>
                            <%
                                ProveedorVO provVO = new ProveedorVO();
                                ProveedorDAO provDAO = new ProveedorDAO(provVO);
                                ArrayList<ProveedorVO> listar = provDAO.listar();

                                for (int i = 0; i < listar.size(); i++) {
                                    provVO = listar.get(i);
                            %>
                            <tbody>
                                <tr class="daticos">
                                    <td class="id_usuario"><%=provVO.getId_prov()%></td>
                                    <td><%=provVO.getPronombre()%></td>
                                    <td><%=provVO.getProdireccion()%></td>
                                    <td><%=provVO.getProtelefono()%></td>
                                    <td><%=provVO.getProdescripcion()%></td>
                                    <td><%=provVO.getProcorreo()%></td>
                                    <td> <%=provVO.getProrepresentante()%></td>
                                    <td class="estado-usuario"><span class="status <%=provVO.getProestado().equals("activo") ? "completed" : "inactive"%>"><%=provVO.getProestado()%></span></td>
                                    <td><button class="open-popup actualizar-usuario" data-popup="popup2" data-prov-id="<%=provVO.getId_prov()%>" data-prov-nombre="<%=provVO.getPronombre()%>" data-prov-direccion="<%=provVO.getProdireccion()%>"data-prov-telefono="<%=provVO.getProtelefono()%>" data-prov-descripcion="<%=provVO.getProdescripcion()%>" data-prov-email="<%=provVO.getProcorreo()%>" data-usu-password="<%=provVO.getProrepresentante()%>" data-usu-estado="<%=provVO.getProestado()%>">
                                            <i class='bx bx-edit actualizar'></i></button>
                                            <%}%>
                                        <div class="popup actualizar-popup" id="popup2">
                                            <div class="overlay"></div>
                                            <div class="popup-content">
                                                <h2>Actualizar Proveedor</h2>
                                                <form method = "post" action="Proveedor">
                                                    <div class="module-details">
                                                        <div class="input-box">
                                                            <span class="details">Nombre(s)* </span>
                                                            <input type="text" name ="usunombre" placeholder="Nombre(s)" id="usunombre">
                                                        </div>
                                                        <div class="input-box">
                                                            <span class="details">Apellidos* </span>
                                                            <input type="text" name ="usuapellido" placeholder="Apellidos" id="usuapellido">
                                                        </div>
                                                        <div class="input-box">
                                                            <span class="details">Documento* </span>
                                                            <input type="number" name="id_usuario" placeholder="Documento" id="id_usuario">
                                                        </div>
                                                        <div class="input-box">
                                                            <span class="details">Dirección* </span>
                                                            <input type="text" name ="usudireccion" placeholder="Dirección" id="usudireccion">
                                                        </div>
                                                        <div class="input-box">
                                                            <span class="details">Telefono * </span>
                                                            <input type="number" name ="usutelefono" placeholder="Celular" id="usutelefono">
                                                        </div>
                                                        <div class="input-box">
                                                            <span class="details">Correo Electronico* </span>
                                                            <input type="email" name ="usuemail" placeholder="Correo Electronico" id="usuemail">
                                                        </div>
                                                        <div class="input-box">
                                                            <span class="details">Contraseña* </span>
                                                            <input type="text"  name="usupassword" placeholder="Contraseña" id="usupassword">
                                                        </div>
                                                        <div class="input-box">
                                                            <span class="details">Estado* </span>
                                                            <select name="usuestado" id="usuestado">
                                                                <option value="activo">Activo</option>
                                                                <option value="inactivo">Inactivo</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="controls">
                                                        <a href="#" class="cancelarbtn">Cancelar</a>
                                                        <button class="registrarbtn">Actualizar Usuario</button>
                                                        <input  type="hidden" name="opcion" value="2">
                                                    </div>   
                                                </form>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <script src="JS/agregaProducto.js" type="text/javascript"></script>
        <script src="JS/pedidoproveedor.js" type="text/javascript"></script>
        <script src="JS/buscador.js" type="text/javascript"></script>
        <script src="JS/popup.js" type="text/javascript"></script>
<script>
  function guardarDatos() {
    // Obtener los valores de los campos del formulario
    var pronombre = document.getElementById('pronombre').value;
    var prorepresentante = document.getElementById('prorepresentante').value;
    var procorreo = document.getElementById('procorreo').value;
    var prodireccion = document.getElementById('prodireccion').value;

    // Obtener la opción seleccionada del campo select
    var id_usuario = document.getElementById('id_usuario');
    var id_usuario = id_usuario.options[id_usuario.selectedIndex].value;

    // Guardar los valores en el almacenamiento local
    localStorage.setItem('id_usuario', id_usuario);
    localStorage.setItem('pronombre', pronombre);
    localStorage.setItem('prorepresentante', prorepresentante);
    localStorage.setItem('procorreo', procorreo);
    localStorage.setItem('prodireccion', prodireccion);
    localStorage.setItem('id_prov', id_prov);
  }
</script>

    </body>
</html>
