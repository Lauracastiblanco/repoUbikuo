/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Luisa
 */
public class usuarioVO {
    
    private String id_usuario, usunombre, usuapellido, usudireccion, usutelefono, usuemail, usupassword, usuestado, usu_id_rol;
    
     public usuarioVO() {
    }

    public usuarioVO(String id_usuario, String usunombre, String usuapellido, String usudireccion, String usutelefono, String usuemail, String usupassword, String usuestado, String usu_id_rol) {
        this.id_usuario = id_usuario;
        this.usunombre = usunombre;
        this.usuapellido = usuapellido;
        this.usudireccion = usudireccion;
        this.usutelefono = usutelefono;
        this.usuemail = usuemail;
        this.usupassword = usupassword;
        this.usuestado = usuestado;
        this.usu_id_rol = usu_id_rol;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsunombre() {
        return usunombre;
    }

    public void setUsunombre(String usunombre) {
        this.usunombre = usunombre;
    }

    public String getUsuapellido() {
        return usuapellido;
    }

    public void setUsuapellido(String usuapellido) {
        this.usuapellido = usuapellido;
    }

    public String getUsudireccion() {
        return usudireccion;
    }

    public void setUsudireccion(String usudireccion) {
        this.usudireccion = usudireccion;
    }

    public String getUsutelefono() {
        return usutelefono;
    }

    public void setUsutelefono(String usutelefono) {
        this.usutelefono = usutelefono;
    }

    public String getUsuemail() {
        return usuemail;
    }

    public void setUsuemail(String usuemail) {
        this.usuemail = usuemail;
    }

    public String getUsupassword() {
        return usupassword;
    }

    public void setUsupassword(String usupassword) {
        this.usupassword = usupassword;
    }

    public String getUsuestado() {
        return usuestado;
    }

    public void setUsuestado(String usuestado) {
        this.usuestado = usuestado;
    }

    public String getUsu_id_rol() {
        return usu_id_rol;
    }

    public void setUsu_id_rol(String usu_id_rol) {
        this.usu_id_rol = usu_id_rol;
    }
    
    

}