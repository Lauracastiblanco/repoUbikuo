<%-- 
    Document   : prueba
    Created on : 9/04/2023, 12:38:11 AM
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Animated Login Form</title>
        <link href="CSS/stylelogin.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <img class="wave" src="ASSETS/wave.png" alt=""/>
        <div class="container">
            <div class="img">
                <img src="ASSETS/login.svg">
            </div>
            <div class="login-content">
                <form method = "post" action = "usuario">
                    <img src="ASSETS/logo_web.png" alt=""/>
                    <h2 class="title">Bienvenido</h2>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">
                            <h5>Documento</h5>
                            <input class="input" type="text" name="id_usuario" required>
                        </div>
                    </div>
                    <div class="input-div pass">
                        <div class="i"> 
                            <i class="fas fa-lock"></i>
                        </div>
                        <div class="div">
                            <h5>Contraseña</h5>
                            <input class="input"type="Password" name="usupassword"required>
                        </div>
                    </div>
                    <button class="btn">Iniciar Sesion</button>
                    <input type ="hidden" name="opcion" value ="3">
                </form>
            </div>
        </div>
        <script src="JS/login.js" type="text/javascript"></script>
    </body>
    <%
    if (request.getAttribute("mensajeError") != null) {%>
    ${mensajeError}

    <%} else {%>
    ${mensajeExito}
    <%}%>
</html>
