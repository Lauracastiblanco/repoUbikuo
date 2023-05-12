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
public class rolesVO {
    
    private String id_Rol, rolnombre;

    public rolesVO() {
    }

    public rolesVO(String id_Rol, String rolnombre) {
        this.id_Rol = id_Rol;
        this.rolnombre = rolnombre;
    }

    public String getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(String id_Rol) {
        this.id_Rol = id_Rol;
    }

    public String getRolnombre() {
        return rolnombre;
    }

    public void setRolnombre(String rolnombre) {
        this.rolnombre = rolnombre;
    }
    

}
