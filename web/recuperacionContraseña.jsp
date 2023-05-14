<%-- 
    Document   : recuperacionContraseña
    Created on : 13/05/2023, 04:27:58 PM
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Recuperacion Contraseña</title>
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
                </form>
            </div>
        </div>
        <script src="JS/login.js" type="text/javascript"></script>
        <script>
            
        </script>
    </body>
</html>
