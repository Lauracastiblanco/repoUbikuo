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
        <title>JSP Page</title>
    </head>
    <body>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/styleinicio.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Poppins:wght@600&display=swap" rel="stylesheet">
    </head>
    <body>
        <img src="ASSETS/wave.png" alt=""/>
        <div class="container">
            <div class="img">
                <img src="ASSETS/login.png" alt=""/>
            </div>
            <div class="login-container">
                <form method = "post" action = "usuario">
                    <img src="ASSETS/logo_web.png" alt=""/>
                    <div> Inicio Sesion</div>
                    <div class="input-div">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div> 
                            <h5>Documento</h5>
                            <input type="text" name="id_usuario" placeholder = "Documento" required>
                        </div>
                    </div>
                    <div class="input-div"> 
                        <div class="i">
                            <i class="fas fa-lock"></i>
                        </div>
                        <h5>Contraseña</h5>
                        <input class="form-control" type="Password" name="usupassword" placeholder="Contraseña"required>
                    </div>
                    <button>Iniciar Sesion</button>
                    <input type ="hidden" name="opcion" value ="3">
                </form>
            </div>
        </div>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    </body>
</body>
</html>
