<%-- 
    Document   : resultado
    Created on : 19/04/2023, 09:03:21 AM
    Author     : APRENDIZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Confirmacion</title>
        <link href="CSS/stylelogin.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <img class="wave" src="ASSETS/wave.png" alt=""/>
        <div class="container">
            <div class="img">
                <img src="ASSETS/email.svg">
            </div>
            <div class="login-content">
                <form method="post" action="envioCorreo">
                    <img src="ASSETS/logo_web.png" alt=""/>
                    <h2 style= "font-size:1.6rem"class="title">Restablecer Contraseña</h2>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">
                            <h5>Correo Electronico</h5>
                            <input class="input" type="text" name="destino" required>
                        </div>
                    </div>
                    <input class="btn" type="submit" value="Enviar">
                    <p><%=request.getAttribute("EstadoMensaje")%></p>
                </form>
            </div>
        </div>
        <script src="JS/login.js" type="text/javascript"></script>
    </body>
</html>
