package JavaMail;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(urlPatterns = {"/envioCorreo"})
public class envioCorreo extends HttpServlet {

    private String servidor, puerto, usuario, clave;

    public void init() {
        ServletContext context = getServletContext();
        servidor = context.getInitParameter("servidor");
        puerto = context.getInitParameter("puerto");
        usuario = context.getInitParameter("usuario");
        clave = context.getInitParameter("clave");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destino = request.getParameter("destino");
        String asunto = "Registro de solicitud de cuenta de usuario– ELECTRICOS ESTRADA S.A.S ";
        String mensaje = "Estimado(a) Usuario: "
                + "\nPor favor haga clic en el siguiente enlace para restablecer su contraseña: "   
                + "http://localhost:8080/repoUbikuo/nuevaContrase%C3%B1a.jsp";

        String resultadoMensaje = "";

        try {
            PropiedadesCorreo.envioCorreo(servidor, puerto, usuario, clave, destino, asunto, mensaje);
            resultadoMensaje = "El correo ha sido enviado.";

        } catch (Exception e) {
            e.printStackTrace();
            resultadoMensaje = "Error al enviar el correo: " + e.getMessage();
        } finally {
            request.setAttribute("EstadoMensaje", resultadoMensaje);
            getServletContext().getRequestDispatcher("/mensajeConfirmacion.jsp").forward(request, response);
        }
    }

}
