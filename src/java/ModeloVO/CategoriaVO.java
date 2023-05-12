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
public class CategoriaVO {
    
    private String  id_cat,catnombre, catestado, catdescripcion;

    

    public CategoriaVO() {
    }

    public CategoriaVO(String id_cat, String catnombre, String catestado, String catdescripcion) {
        this.id_cat = id_cat;
        this.catnombre = catnombre;
        this.catestado = catestado;
        this.catdescripcion = catdescripcion;
    }

    public String getId_cat() {
        return id_cat;
    }

    public void setId_cat(String id_cat) {
        this.id_cat = id_cat;
    }

    public String getCatnombre() {
        return catnombre;
    }

    public void setCatnombre(String catnombre) {
        this.catnombre = catnombre;
    }

    public String getCatestado() {
        return catestado;
    }

    public void setCatestado(String catestado) {
        this.catestado = catestado;
    }

    public String getCatdescripcion() {
        return catdescripcion;
    }

    public void setCatdescripcion(String catdescripcion) {
        this.catdescripcion = catdescripcion;
    }

   
    
}
