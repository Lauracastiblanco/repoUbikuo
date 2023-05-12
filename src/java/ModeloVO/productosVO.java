/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Alexander
 */
public class productosVO {
    
   private String id_prod,prodnombre,prodprecio,prod_id_categoria,prodestado,prodstock_disp,prod_descripcion,prod_id_prov, catnombre, pronombre ;
   
   public productosVO() {
    }

    public productosVO(String id_prod, String prodnombre, String prodprecio, String prod_id_categoria, String prodestado, String prodstock_disp, String prod_descripcion, String prod_id_prov) {
        this.id_prod = id_prod;
        this.prodnombre = prodnombre;
        this.prodprecio = prodprecio;
        this.prod_id_categoria = prod_id_categoria;
        this.prodestado = prodestado;
        this.prodstock_disp = prodstock_disp;
        this.prod_descripcion = prod_descripcion;
        this.prod_id_prov = prod_id_prov;
        
    }

    public productosVO(String id_prod, String prodnombre, String prodprecio, String prod_id_categoria, String prodestado, String prodstock_disp, String prod_descripcion, String prod_id_prov, String catnombre, String pronombre) {
        this.id_prod = id_prod;
        this.prodnombre = prodnombre;
        this.prodprecio = prodprecio;
        this.prod_id_categoria = prod_id_categoria;
        this.prodestado = prodestado;
        this.prodstock_disp = prodstock_disp;
        this.prod_descripcion = prod_descripcion;
        this.prod_id_prov = prod_id_prov;
        this.catnombre = catnombre;
        this.pronombre = pronombre;
    }
    

    

    public String getCatnombre() {
        return catnombre;
    }

    public void setCatnombre(String catnombre) {
        this.catnombre = catnombre;
    }

    public String getPronombre() {
        return pronombre;
    }

    public void setPronombre(String pronombre) {
        this.pronombre = pronombre;
    }
    
    public String getId_prod() {
        return id_prod;
    }

    public void setId_prod(String id_prod) {
        this.id_prod = id_prod;
    }

    public String getProdnombre() {
        return prodnombre;
    }

    public void setProdnombre(String prodnombre) {
        this.prodnombre = prodnombre;
    }

    public String getProdprecio() {
        return prodprecio;
    }

    public void setProdprecio(String prodprecio) {
        this.prodprecio = prodprecio;
    }

    public String getProd_id_categoria() {
        return prod_id_categoria;
    }

    public void setProd_id_categoria(String prod_id_categoria) {
        this.prod_id_categoria = prod_id_categoria;
    }

    public String getProdestado() {
        return prodestado;
    }

    public void setProdestado(String prodestado) {
        this.prodestado = prodestado;
    }

    public String getProdstock_disp() {
        return prodstock_disp;
    }

    public void setProdstock_disp(String prodstock_disp) {
        this.prodstock_disp = prodstock_disp;
    }

    public String getProd_descripcion() {
        return prod_descripcion;
    }

    public void setProd_descripcion(String prod_descripcion) {
        this.prod_descripcion = prod_descripcion;
    }

    public String getProd_id_prov() {
        return prod_id_prov;
    }

    public void setProd_id_prov(String prod_id_prov) {
        this.prod_id_prov = prod_id_prov;
    }
    

}
