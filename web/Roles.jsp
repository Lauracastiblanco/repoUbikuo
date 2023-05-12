<%-- 
    Document   : Roles
    Created on : 16/04/2023, 04:37:41 PM
    Author     : Alexander
--%>

<%@page import="ModeloDAO.rolesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.rolesVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="menuVendedor.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roles</title>
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
                        <span class="text">Roles</span>
                    </div>
                    <div class="boxes">
                        <div class="box box1">
                            <button class="open-popup" data-popup="popup1"><i class='bx bxs-plus-circle registrar'></i></button>
                            <span class="text">Registrar Rol</span>
                            <!------------- VENTANA MODAL DE REGISTRO ------------->
                            <div class="popup" id="popup1">
                                <div class="overlay"></div>
                                <div class="popup-content">
                                    <h2>Registrar Rol</h2>
                                    <form method = "post" action="roles">
                                        <div class="module-details">
                                            <div class="input-box">
                                                <span class="details">Nombre* </span>
                                                <input type="text" name="rolnombre" placeholder="Ingrese nombre..." required>
                                            </div>
                                        </div>
                                        <button class="registrarbtn">Registrar Rol</button>
                                        <input  type="hidden" name="opcion" value="1">
                                    </form>
                                    <div class="controls">
                                        <button class="cancelarbtn">Cancelar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box box2">
                            <i class='bx bxs-user-check activos' ></i>
                            <span class="number">10</span>
                            <span class="text">Usuarios activos</span>
                        </div>
                        <div class="box box3">
                            <i class='bx bxs-user total'></i>
                            <span class="number">20</span>
                            <span class="text">Total usuarios</span>
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
                                <select id="estado">
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
                                        <th>Identificación</th>
                                        <th>Nombre Rol</th>
                                    </tr>
                                </thead>
                                <%
                                    rolesVO rolVO = new rolesVO();
                                    rolesDAO rolDAO = new rolesDAO(rolVO);
                                    ArrayList<rolesVO> ListaRoles = rolDAO.listar();

                                    for (int i = 0; i < ListaRoles.size(); i++) {
                                        rolVO = ListaRoles.get(i);
                                %>
                                <tbody>
                                    <tr class="daticos">
                                        <td><%=rolVO.getId_Rol()%></td>
                                        <td><%=rolVO.getRolnombre()%></td>
                                        <td><button class="open-popup actualizar-rol" data-popup="popup2" data-rol-id="<%=rolVO.getId_Rol()%>">
                                                <i class='bx bx-edit actualizar'></i></button>
                                            <div class="popup actualizar-popup" id="popup2">
                                                <div class="overlay"></div>
                                                <div class="popup-content">
                                                    <h2>Actualizar Rol</h2>
                                                    <form method = "post" action="roles">
                                                        <div class="module-details">
                                                            <div class="input-box">
                                                                <span class="details">Identificación </span>
                                                                <input type="text" name ="id_Rol" placeholder="Identificacion" id="id_Rol">
                                                            </div>
                                                            <div class="input-box">
                                                                <span class="details">Nombre </span>
                                                                <input type="text" name ="rolnombre" placeholder="Nombre" id="rolnombre">
                                                            </div>
                                                        </div>
                                                    </form>
                                                    <div class="controls">
                                                        <button class="cancelarbtn">Cancelar</button>
                                                        <button class="registrarbtn">Registrar Usuario</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <% }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
        </section>
        <script src="JS/buscador.js" type="text/javascript"></script>
        <script src="JS/popuprol.js" type="text/javascript"></script>
    </body>
</html>
