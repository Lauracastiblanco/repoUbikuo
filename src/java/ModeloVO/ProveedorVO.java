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
public class ProveedorVO {
    
    private String id_prov,pronombre,prodireccion,protelefono,proestado,prodescripcion,procorreo,prorepresentante;

    public ProveedorVO() {
    }

    public ProveedorVO(String id_prov, String pronombre, String prodireccion, String protelefono, String proestado, String prodescripcion, String procorreo, String prorepresentante) {
        this.id_prov = id_prov;
        this.pronombre = pronombre;
        this.prodireccion = prodireccion;
        this.protelefono = protelefono;
        this.proestado = proestado;
        this.prodescripcion = prodescripcion;
        this.procorreo = procorreo;
        this.prorepresentante = prorepresentante;
    }

    public String getId_prov() {
        return id_prov;
    }

    public void setId_prov(String id_prov) {
        this.id_prov = id_prov;
    }

    public String getPronombre() {
        return pronombre;
    }

    public void setPronombre(String pronombre) {
        this.pronombre = pronombre;
    }

    public String getProdireccion() {
        return prodireccion;
    }

    public void setProdireccion(String prodireccion) {
        this.prodireccion = prodireccion;
    }

    public String getProtelefono() {
        return protelefono;
    }

    public void setProtelefono(String protelefono) {
        this.protelefono = protelefono;
    }

    public String getProestado() {
        return proestado;
    }

    public void setProestado(String proestado) {
        this.proestado = proestado;
    }

    public String getProdescripcion() {
        return prodescripcion;
    }

    public void setProdescripcion(String prodescripcion) {
        this.prodescripcion = prodescripcion;
    }

    public String getProcorreo() {
        return procorreo;
    }

    public void setProcorreo(String procorreo) {
        this.procorreo = procorreo;
    }

    public String getProrepresentante() {
        return prorepresentante;
    }

    public void setProrepresentante(String prorepresentante) {
        this.prorepresentante = prorepresentante;
    }
    
    
}
