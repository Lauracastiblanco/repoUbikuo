<%-- 
    Document   : menuVendedor
    Created on : 12/04/2023, 07:48:40 PM
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!------------------- Estilos Menu --------------------->
        <link href="CSS/stylemenu.css" rel="stylesheet" type="text/css"/>
        <!------------------- Iconos --------------------->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,0,0" />
        <title>Inicio</title>
    </head>
    <body>
        <nav>
            <!------------------- Logo --------------------->
        <div class="logo-name">
            <div class="logo-image">
                <img src="ASSETS/logo_web - copia.png" alt=""/>
            </div>
            <span class="logo_name">Electricos <span style="color: black;">Estrada</span></span>
        </div>
            <!------------------- Barra Lateral --------------------->
        <div class="menu-items">
            <ul class="nav-links">
                <li><a href="#">
                    <i class="material-symbols-outlined">home</i>
                    <span class="link-name">Inicio</span>
                </a></li>
                <li><a href="#">
                    <i class="material-symbols-outlined">inventory</i>
                    <span class="link-name">Productos</span>
                </a></li>
                <li><a href="#">
                    <i class="material-symbols-sharp">face</i>
                    <span class="link-name">Clientes</span>
                </a></li>
                <li><a href="CrearPedido.jsp">
                    <i class="material-symbols-sharp">order_approve</i>
                    <span class="link-name">Pedido</span>
                </a></li>
                <li><a href="Proveedor.jsp">
                    <i class="material-symbols-sharp">badge</i>
                    <span class="link-name">Proveedores</span>
                </a></li>
                <li><a href="Cotizacion.jsp">
                    <i class="material-symbols-sharp">inactive_order</i>
                    <span class="link-name">Cotizacion</span>
                </a></li>
                <li><a href="#">
                    <i class="material-symbols-sharp">category</i>
                    <span class="link-name">Categorias</span>
                </a></li>
                <li><a href="Usuarios.jsp">
                    <i class="material-symbols-sharp">account_circle</i>
                    <span class="link-name">Usuarios</span>
                </a></li>
                <li><a href="Roles.jsp">
                    <i class="material-symbols-sharp">engineering</i>
                    <span class="link-name">Roles</span>
                </a></li>
            </ul>
            <!------------------- Cerrar Sesion --------------------->
            <ul class="logout-mode">
                <li><a href="#">
                    <i class="uil uil-signout"></i>
                    <span class="link-name">Logout</span>
                </a></li>
                <div class="mode-toggle">
                  <span class="switch"></span>
                </div>
            </ul>
        </div>
    </nav>
        <!------------------- Barra Superior --------------------->
        <section class="dashboard">
            <div class="top">
                <i class="uil uil-bars sidebar-toggle"></i>
                <!--<div class="text-header">
                    <p>Hola, <b>Daniela</b></p>
                    <small>Admin</small>
                </div>
                
            </div>-->
                <p>Hola, <b>Daniela</b></p>
                <img src="ASSETS/fotoperfil.svg">
        </section>
        <!------------------- Codigo Java --------------------->
        <script src="JS/menu.js" type="text/javascript"></script>
    </body>
</html>
