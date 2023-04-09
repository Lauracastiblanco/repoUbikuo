<%-- 
    Document   : login
    Created on : 8/04/2023, 03:36:31 PM
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/styleinicio.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <!--<img src="ASSETS/wave.png" alt=""/> -->
        <div class="container">
            <div class="img">
                <img src="ASSETS/login.png" alt=""/>
            </div>
            <div class="login-container">
                <form method = "post" action = "usuario">
                    <img class="logo"src="ASSETS/logo_web.png" alt=""/>
                    <h2>Bienvenido</h2>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div"> 
                            <h5>Documento</h5>
                            <input class="input" type="text" name="id_usuario" placeholder = "Documento" required>
                        </div>
                    </div>
                    <div class="input-div two"> 
                        <div class="i">
                            <i class="fas fa-lock"></i>
                        </div>
                        <div>
                            <h5>Contraseña</h5>
                            <input class="input"type="Password" name="usupassword" placeholder="Contraseña"required>
                        </div>
                    </div>
                    <button class="btn">Iniciar Sesion</button>
                    <input type ="hidden" name="opcion" value ="3">
                </form>
            </div>
        </div>
        <script src="JS/Login.js" type="text/javascript"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    </body> 
</html>


