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
public class ClienteVO {
    
     private String id_cliente,clinombre, cliapellido, clicorreo, clidireccion,clitelefono, clidescripcion;

    public ClienteVO() {
    }

    public ClienteVO(String id_cliente, String clinombre, String cliapellido, String clicorreo, String clidireccion, String clitelefono, String clidescripcion) {
        this.id_cliente = id_cliente;
        this.clinombre = clinombre;
        this.cliapellido = cliapellido;
        this.clicorreo = clicorreo;
        this.clidireccion = clidireccion;
        this.clitelefono = clitelefono;
        this.clidescripcion = clidescripcion;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getClinombre() {
        return clinombre;
    }

    public void setClinombre(String clinombre) {
        this.clinombre = clinombre;
    }

    public String getCliapellido() {
        return cliapellido;
    }

    public void setCliapellido(String cliapellido) {
        this.cliapellido = cliapellido;
    }

    public String getClicorreo() {
        return clicorreo;
    }

    public void setClicorreo(String clicorreo) {
        this.clicorreo = clicorreo;
    }

    public String getClidireccion() {
        return clidireccion;
    }

    public void setClidireccion(String clidireccion) {
        this.clidireccion = clidireccion;
    }

    public String getClitelefono() {
        return clitelefono;
    }

    public void setClitelefono(String clitelefono) {
        this.clitelefono = clitelefono;
    }

    public String getClidescripcion() {
        return clidescripcion;
    }

    public void setClidescripcion(String clidescripcion) {
        this.clidescripcion = clidescripcion;
    }
          
     
}


