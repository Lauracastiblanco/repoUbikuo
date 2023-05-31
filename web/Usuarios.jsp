<%-- 
    Document   : Usuarios
    Created on : 12/04/2023, 10:18:32 PM
    Author     : Alexander
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.usuarioDAO"%>
<%@page import="ModeloVO.usuarioVO"%>
<%@page import="ModeloVO.rolesVO"%>
<%@page import="ModeloDAO.rolesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="menuVendedor.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <link href="CSS/stylepopup.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/principal.css" rel="stylesheet" type="text/css"/>
        <!--------------------- Iconos ------------------------------->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    </head>
    <body>
        <section class="main">
            <div class="dash-content">
                <div class="overview">
                    <div class="title">
                        <span class="text">Usuarios</span>
                    </div>
                    <div class="boxes">
                        <div class="box box1">
                            <button class="open-popup" data-popup="popup1"><i class='bx bxs-plus-circle registrar'></i></button>
                            <span class="text">Registrar Usuario</span>
                            <div class="popup" id="popup1">
                                <div class="overlay"></div>
                                <div class="popup-content">
                                    <h2>Registrar Usuario</h2>
                                    <form method= "post" action="usuario">
                                        <div class="module-details">
                                            <div class="input-box">
                                                <span class="details">Nombre(s)<span style="color: red;">*</span> </span>
                                                <input type="text" name ="usunombre" placeholder="Nombre(s)" required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Apellidos<span style="color: red;">*</span> </span>
                                                <input type="text" name ="usuapellido" placeholder="Apellidos" required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Documento<span style="color: red;">*</span> </span>
                                                <input type="text" name="id_usuario" inputmode="numeric" pattern="[0-9]{1,10}" maxlength="10" placeholder="Documento" required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Dirección<span style="color: red;">*</span> </span>
                                                <input type="text" name ="usudireccion" placeholder="Dirección" required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Telefono<span style="color: red;">*</span> </span>
                                                <input type="number" name ="usutelefono" placeholder="Celular" required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Correo Electronico<span style="color: red;">*</span> </span>
                                                <input type="email" name ="usuemail" placeholder="Correo Electronico" required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Contraseña<span style="color: red;">*</span> </span>
                                                <input type="password"  name="usupassword" placeholder="Contraseña" required>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Rol<span style="color: red;">*</span></span>
                                                <select name="usu_id_rol" >
                                                    <%
                                                        rolesDAO rolDAO = new rolesDAO();
                                                        for (rolesVO rolVO : rolDAO.listar()) {
                                                    %>
                                                    <option value="<%=rolVO.getId_Rol()%>"><%=rolVO.getRolnombre()%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                            <div class="input-box">
                                                <span class="details">Estado<span style="color: red;">*</span></span>
                                                <select name="usuestado">
                                                    <option value="activo">Activo</option>
                                                    <option value="inactivo">Inactivo</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="controls">
                                            <a href="#" class="cancelarbtn">Cancelar</a>
                                            <button class="registrarbtn">Registrar Usuario</button>
                                            <input  type="hidden" name="opcion" value="1">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="box box3">
                            <i class='bx bxs-report activos'></i>
                            <form method="post" action="generadorReportes.jsp" target="_blank">
                                <input type="submit" value="Generar PDF">
                            </form>
                            <span class="text">Generar Reporte</span>
                        </div>
                        <div class="box box2">
                            <i class='bx bxs-user-check activos' ></i>
                            <span class="number">10</span>
                            <span class="text">Activos</span>
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
                            <h3>Consultar Usuario</h3>
                            <div class="buscar">
                                <input type="text" id="buscador" name="id_usuario"class="buscar__input" placeholder="Buscar">
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
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>
                                    <th>Email</th>
                                    <th>Contraseña</th>
                                    <th>Estado</th>
                                    <th>Rol</th>
                                    <th>Actualizar</th>
                                </tr>
                            </thead>
                            <%
                                usuarioVO usuVO = new usuarioVO();
                                usuarioDAO usuDAO = new usuarioDAO();
                                ArrayList<usuarioVO> listaUsuarios = usuDAO.listar();
                                int contador = 0;
                                for (int i = 0; i < listaUsuarios.size(); i++) {
                                    usuVO = listaUsuarios.get(i);
                                    contador = contador + 1;
                            %>
                            <tbody>
                                <tr class="daticos">
                                    <td class="id_usuario"><%=usuVO.getId_usuario()%></td>
                                    <td><%=usuVO.getUsunombre()%></td>
                                    <td><%=usuVO.getUsuapellido()%></td>
                                    <td><%=usuVO.getUsudireccion()%></td>
                                    <td><%=usuVO.getUsutelefono()%></td>
                                    <td><%=usuVO.getUsuemail()%></td>
                                    <td><%=usuVO.getUsupassword()%></td>
                                    <td class="estado-usuario"><span class="status <%=usuVO.getUsuestado().equals("activo") ? "completed" : "inactive"%>"><%=usuVO.getUsuestado()%></span></td>
                                    <td>Administrador</td>
                                    <td><button class="open-popup actualizar-usuario updatebutton" data-popup="popup2" data-usu-id="<%=usuVO.getId_usuario()%>" data-usu-nombre="<%=usuVO.getUsunombre()%>" data-usu-apellido="<%=usuVO.getUsuapellido()%>"data-usu-direccion="<%=usuVO.getUsudireccion()%>" data-usu-telefono="<%=usuVO.getUsutelefono()%>" data-usu-email="<%=usuVO.getUsuemail()%>" data-usu-password="<%=usuVO.getUsupassword()%>" data-usu-rol="<%=usuVO.getUsu_id_rol()%>"data-usu-estado="<%=usuVO.getUsuestado()%>">
                                            <i class='bx bx-edit actualizar'></i></button>
                                            <%}%>
                                        <div class="popup actualizar-popup" id="popup2">
                                            <div class="overlay"></div>
                                            <div class="popup-content">
                                                <h2>Actualizar Usuario</h2>
                                                <form method = "post" action="usuario">
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
                                                            <span class="details">Rol*</span>
                                                            <select name="usu_id_rol" id="usu_id_rol">  
                                                                <%
                                                                    rolesDAO rolDAO_act = new rolesDAO();
                                                                    for (rolesVO rolVO : rolDAO_act.listar()) {
                                                                %>
                                                                <option value="<%=rolVO.getId_Rol()%>"><%=rolVO.getRolnombre()%></option>
                                                                <%}%>
                                                            </select>
                                                        </div>
                                                        <div class="input-box">
                                                            <span class="details">Rol*</span>
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
        <script src="JS/buscador.js" type="text/javascript"></script>
        <script src="JS/popup.js" type="text/javascript"></script>
    </body>
</html>