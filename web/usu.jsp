<%-- 
    Document   : PedidoProveedor
    Created on : 4/05/2023, 09:28:38 PM
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,0,0" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="CSS/menu.css" rel="stylesheet" type="text/css"/>
    <title>Document</title>
</head>

<body>
    <div class="container">
        <aside>
            <div class="top">
                <div class="logo">
                    <img src="ASSETS/logo_web - copia.png" alt=""/>
                    <h2><span class="danger">Electricos </span><span>Estrada</span></h2>
                </div>
                <div class="close" id="close-btn">
                    <span class="material-symbols-sharp">close</span>
                </div>
            </div>
            <div class="sidebar">
                <a href="PedidoProveedor.jsp">
                    <span class="material-symbols-outlined">home</span>
                    <h3>Inicio</h3>
                </a>
                <a href="#">
                    <span class="material-symbols-outlined">inventory</span>
                    <h3>Productos</h3>
                </a>
                <a href="#" >
                    <span class="material-symbols-sharp">face</span>
                    <h3>Clientes</h3>
                </a>
                <a href="#">
                    <span class="material-symbols-sharp">order_approve</span>
                    <h3>Pedido</h3>
                </a>
                <a href="#">
                    <span class="material-symbols-sharp">inactive_order</span>
                    <h3>Cotizacion</h3>
                </a>
                <a href="#">
                    <span class="material-symbols-sharp">category</span>
                    <h3>Categorias</h3>
                </a>
                <a href="usu.jsp" id="link-usuario">
                    <span class="material-symbols-sharp">account_circle</span>
                    <h3>Usuarios</h3>
                </a>
                <a href="#">
                    <span class="material-symbols-sharp">engineering</span>
                    <h3>Roles</h3>
                </a>
                <a href="#">
                    <span class="material-symbols-sharp">logout</span>
                    <h3>Logout</h3>
                </a>
            </div>
        </aside>
        <main>
            <h1>Usuarios</h1>
            <div class="box">
                <h4>Datos Usuario</h4>
                <div class="datos-usu">
                    <div class="box-container">
                        <label>Fecha</label>
                        <input type="date">
                    </div>
                    <div class="box-container">
                        <label>Usuario</label>
                        <select name="" id="">
                            <option value="">Todos</option>
                            <option value="activo">Laura Castiblanco</option>
                            <option value="inactivo">Inactivo</option>
                        </select>
                    </div>
                </div>
                <h4>Datos Proveedor</h4>
                <div class="datos-prov">
                    <div class="box-container">
                        <label>NIT</label>
                        <input type="text" placeholder="Identificacion">
                    </div>
                    
                    <div class="box-container">
                        <label>Nombre</label>
                        <input type="text" placeholder="Nombre">
                    </div>
                    <div class="box-container">
                        <label>Representante</label>
                        <input type="text" placeholder="Representante">
                    </div>
                    <div class="box-container">
                        <label>Direccion</label>
                        <input type="text" placeholder="Direccion">
                    </div>
                    <div class="box-container">
                        <label>Correo Electronico</label>
                        <input type="text" placeholder="Correo Electronico">
                    </div>
                </div>
            </div>
            <div class="lista-pedido">
                <h2>Lista de Productos</h2>
                <table>
                    <thead>
                    <tbody>
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
                        <tr>
                            <td>1</td>
                            <td>5</td>
                            <td>Breaker</td>
                            <td>12</td>
                            <td>20.000</td>
                            <td>240.000</td>
                            <td><button class="eliminar">Eliminar</button></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>5</td>
                            <td>Breaker</td>
                            <td>12</td>
                            <td>20.000</td>
                            <td>240.000</td>
                            <td><button class="eliminar">Eliminar</button></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>5</td>
                            <td>Breaker</td>
                            <td>12</td>
                            <td>20.000</td>
                            <td>240.000</td>
                            <td><button class="eliminar">Eliminar</button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </main>
        <!---------------END OF MAIN  --------------------->
        <div class="right">
            <div class="top">
                <button id="menu-btn">
                    <span class="material-symbols-outlined">menu</span>
                </button>
                <div class="theme-toggler">
                    <span class="material-symbols-outlined active">light_mode</span>
                    <span class="material-symbols-outlined">dark_mode</span>
                </div>
                <div class="profile">
                    <div class="info">
                        <p>Hey, <b>Daniela</b></p>
                        <small class="text.muted">Admin</small>
                    </div>
                    <div class="profile-photo">
                        <span class="material-symbols-outlined">account_circle</span>
                    </div>
                </div>
            </div>
            <div class="productos">
                <h2>Productos</h2>
                <div class="datosproductos">
                    <div class="box-container">
                        <label>Categoria</label>
                        <input type="text" placeholder="Identificacion">
                    </div>
                    <div class="box-container">
                        <label>Producto</label>
                        <input type="text" placeholder="Identificacion">
                    </div>
                    <div class="box-container">
                        <label>Nombre</label>
                        <input type="text" placeholder="Nombre">
                    </div>
                    <div class="box-container">
                        <label>Precio</label>
                        <input type="text" placeholder="Precio">
                    </div>
                    <div class="box-container">
                        <label>Descrpcion</label>
                        <input type="text" placeholder="Descrpcion">
                    </div>
                    <div class="box-container">
                        <label>Cantidad</label>
                        <input type="text" placeholder="Cantidad">
                    </div>
                    <div class="box-container">
                        <label>Foto</label>
                        <img class="foto-prod"src="Breaker.png" alt="Foto Producto">
                    </div>
                    <div class="box-container agregar">
                            <button class="btn agregar">Agregar al pedido</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="JS/sidebar.js" type="text/javascript"></script>
</body>
</html>
