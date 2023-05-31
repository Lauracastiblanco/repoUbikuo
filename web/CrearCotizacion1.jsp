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
                                    <label>Cliente</label>
                                    <select name="id_cliente" id="selectCliente" class="select2" onchange="cargarDatos()">
                                        <option value="">Seleccione...</option>
                                        <%
                                            ClienteDAO clienteDAO = new ClienteDAO();
                                            List<ClienteVO> listaClientes = clienteDAO.listarClientes();
                                            for (ClienteVO cliente : listaClientes) {
                                        %>
                                        <option class="cliente-option" value="<%= cliente.getId_cliente()%>" data-nombre="<%= cliente.getClinombre()%>" data-apellido="<%= cliente.getCliapellido()%>" data-descripcion="<%= cliente.getClidescripcion()%>" data-correo="<%= cliente.getClicorreo()%>" data-direccion="<%= cliente.getClidireccion()%>" data-telefono="<%= cliente.getClitelefono()%>">
                                            <%= cliente.getClinombre()%> <%= cliente.getCliapellido()%> - ID: <%= cliente.getId_cliente()%>
                                        </option>
                                        <% } %>
                                    </select>

                                    <label>Nombre</label>
                                    <input type="text" placeholder="Nombre" id="nombre_input" readonly>

                                    <label>Apellido</label>
                                    <input type="text" placeholder="Apellido" id="apellido_input" readonly>

                                    <label>Descripción</label>
                                    <input type="text" placeholder="Descripción" id="descripcion_input" readonly>

                                    <label>Correo</label>
                                    <input type="text" placeholder="Correo" id="correo_input" readonly>

                                    <label>Dirección</label>
                                    <input type="text" placeholder="Dirección" id="direccion_input" readonly>

                                    <label>Teléfono</label>
                                    <input type="text" placeholder="Teléfono" id="telefono_input" readonly>


                                </div>

                                <script>
                                    function cargarDatos() {
                                        var selectCliente = document.getElementById("selectCliente");
                                        var selectedOption = selectCliente.options[selectCliente.selectedIndex];
                                        var nombre = selectedOption.getAttribute("data-nombre");
                                        var apellido = selectedOption.getAttribute("data-apellido");
                                        var descripcion = selectedOption.getAttribute("data-descripcion");
                                        var correo = selectedOption.getAttribute("data-correo");
                                        var direccion = selectedOption.getAttribute("data-direccion");
                                        var telefono = selectedOption.getAttribute("data-telefono");

                                        document.getElementById("nombre_input").value = nombre;
                                        document.getElementById("apellido_input").value = apellido;
                                        document.getElementById("descripcion_input").value = descripcion;
                                        document.getElementById("correo_input").value = correo;
                                        document.getElementById("direccion_input").value = direccion;
                                        document.getElementById("telefono_input").value = telefono;
                                    }
                                </script>

                            </div>
                        </div>
                        <h2>Lista de Productos</h2>
                        <table class="tabla1" id="tablaProductos">
                            <thead>
                                <tr>
                                    <th>Id Producto</th>
                                    <th>Nombre</th>
                                    <th>Cantidad</th>
                                    <th>Precio Unitario</th>
                                    <th>Sub Total</th>
                                
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${listaprod}">
                                <tr>
                                    <td>${listaprod.getDc_id_producto()}</td>
                                    <td>${listaprod.getNombreproductoL()}</td>
                                    <td>${listaprod.getCantidad()}</td>
                                    <td>${listaprod.getPrecio()}</td>
                                    <td>${listaprod.getSubtotal()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <button class="generar-pedido">Generar Pedido</button>
                    </div>
                    <div class="columna2">
                        <h3 class="titulo-prod">Productos</h3>
                        <div class="caja2">
                             <form method="post" action="cotizacion">
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
                                                <option class="producto-option" value="<%=prodVO.getId_prod()%>" data-descripcion="<%=prodVO.getProd_descripcion()%>" data-precio="<%=prodVO.getProdprecio()%>" data-stock="<%=prodVO.getProdstock_disp()%>"><%=prodVO.getProdnombre()%> - REF: <%=prodVO.getId_prod()%></option>
                                                <% } %>
                                            </optgroup>
                                            <% }
                                                }%>
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
                                        <button class="btn agregar" id="agregar-btn" onclick="guardarDatoscot()" >Agregar al pedido</button>
                                        <input  type="hidden" name="accion" value="agregarproducto">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="JS/agregaProducto.js" type="text/javascript"></script>
        <script src="JS/pedidoproveedor.js" type="text/javascript"></script>
        <script src="JS/buscador.js" type="text/javascript"></script>
        <script src="JS/popup.js" type="text/javascript"></script>
       <script>
  function guardarDatoscot() {
    // Obtener los valores de los campos del formulario

    var nombre = document.getElementById('nombre_input').value;
    var apellido = document.getElementById('apellido_input').value;
    var descripcion = document.getElementById('descripcion_input').value;
    var correo = document.getElementById('correo_input').value;
    var direccion = document.getElementById('direccion_input').value;
     var telefono = document.getElementById('telefono_input').value;

    // Obtener la opción seleccionada del campo select
    var id_usuario = document.getElementById('id_usuario');
    var id_usuario = id_usuario.options[id_usuario.selectedIndex].value;

    // Guardar los valores en el almacenamiento local
    localStorage.setItem('id_usuario', id_usuario);
    localStorage.setItem('nombre_input', nombre);
    localStorage.setItem('apellido_input', apellido);
    localStorage.setItem('descripcion_input', descripcion);
    localStorage.setItem('correo_input', correo);
    localStorage.setItem('direccion_input',direccion);
    localStorage.setItem('telefono_input',telefono);
    
</script>
    </body>
</html>
