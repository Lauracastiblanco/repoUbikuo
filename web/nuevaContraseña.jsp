<%-- 
    Document   : nuevaContraseña
    Created on : 13/05/2023, 05:39:31 PM
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nueva Contraseña</title>
        <link href="CSS/stylelogin.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <img class="wave" src="ASSETS/wave.png" alt=""/>
        <div class="container">
            <div class="img">
                <img src="ASSETS/nuevaContraseña.svg">
            </div>
            <div class="login-content">
                <form method = "post" action = "usuario">
                    <img src="ASSETS/logo_web.png" alt=""/>
                    <h2 style= "font-size:1.6rem"class="title">Nueva Contraseña</h2>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fas fa-user"></i> 
                        </div>
                        <div class="div">
                            <h5>Documento</h5>
                            <input class="input" type="text" name="id_usuario" required>
                        </div>
                    </div>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fas fa-lock"></i>
                        </div>
                        <div class="div">
                            <h5>Nueva Contraseña</h5>
                            <input class="input" type="password" name="usupassword" required>
                        </div>
                    </div>
                    <!--<div class="input-div pass">
                        <div class="i"> 
                            <i class="fas fa-lock"></i>
                        </div>
                        <div class="div">
                            <h5>Confirmación de contraseña</h5>
                            <input class="input"type="Password" name="usupassword"required>
                        </div>
                    </div>-->
                    <button class="btn">Restablecer</button>
                    <input type ="hidden" name="opcion" value ="6">
                    <%
                        if (request.getAttribute("mensajeError") != null) {%>
                    ${mensajeError}
                    <%} else {%>
                    ${mensajeExito}
                    <%}%>
                </form>
            </div>
        </div>
        <script src="JS/login.js" type="text/javascript"></script>
    </body>
</html>
