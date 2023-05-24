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
public class pedidoProveedorVO {
    
    private String id_proped, proped_fecha, Total_proped, propedestado, 
            id_dpro, dpro_id_pedido, dpro_id_producto, dpro_cantidad, dpro_preciocompra;
    
    private int ped_id_proveedor, id_usuario;

    public pedidoProveedorVO() {
    }

    public pedidoProveedorVO(String id_proped, String proped_fecha, String Total_proped, String propedestado, String id_dpro, String dpro_id_pedido, String dpro_id_producto, String dpro_cantidad, String dpro_preciocompra) {
        this.id_proped = id_proped;
        this.proped_fecha = proped_fecha;
        this.Total_proped = Total_proped;
        this.propedestado = propedestado;
        this.id_dpro = id_dpro;
        this.dpro_id_pedido = dpro_id_pedido;
        this.dpro_id_producto = dpro_id_producto;
        this.dpro_cantidad = dpro_cantidad;
        this.dpro_preciocompra = dpro_preciocompra;
    }

    public pedidoProveedorVO(int ped_id_proveedor, int id_usuario) {
        this.ped_id_proveedor = ped_id_proveedor;
        this.id_usuario = id_usuario;
    }

    public pedidoProveedorVO(String dpro_id_producto, String dpro_cantidad, String dpro_preciocompra) {
        this.dpro_id_producto = dpro_id_producto;
        this.dpro_cantidad = dpro_cantidad;
        this.dpro_preciocompra = dpro_preciocompra;
    }
    

    public String getId_proped() {
        return id_proped;
    }

    public void setId_proped(String id_proped) {
        this.id_proped = id_proped;
    }

    public int getPed_id_proveedor() {
        return ped_id_proveedor;
    }

    public void setPed_id_proveedor(int ped_id_proveedor) {
        this.ped_id_proveedor = ped_id_proveedor;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    public String getProped_fecha() {
        return proped_fecha;
    }

    public void setProped_fecha(String proped_fecha) {
        this.proped_fecha = proped_fecha;
    }

    public String getTotal_proped() {
        return Total_proped;
    }

    public void setTotal_proped(String Total_proped) {
        this.Total_proped = Total_proped;
    }

    public String getPropedestado() {
        return propedestado;
    }

    public void setPropedestado(String propedestado) {
        this.propedestado = propedestado;
    }

    public String getId_dpro() {
        return id_dpro;
    }

    public void setId_dpro(String id_dpro) {
        this.id_dpro = id_dpro;
    }

    public String getDpro_id_pedido() {
        return dpro_id_pedido;
    }

    public void setDpro_id_pedido(String dpro_id_pedido) {
        this.dpro_id_pedido = dpro_id_pedido;
    }

    public String getDpro_id_producto() {
        return dpro_id_producto;
    }

    public void setDpro_id_producto(String dpro_id_producto) {
        this.dpro_id_producto = dpro_id_producto;
    }

    public String getDpro_cantidad() {
        return dpro_cantidad;
    }

    public void setDpro_cantidad(String dpro_cantidad) {
        this.dpro_cantidad = dpro_cantidad;
    }

    public String getDpro_preciocompra() {
        return dpro_preciocompra;
    }

    public void setDpro_preciocompra(String dpro_preciocompra) {
        this.dpro_preciocompra = dpro_preciocompra;
    }
    
    
    
    
}
