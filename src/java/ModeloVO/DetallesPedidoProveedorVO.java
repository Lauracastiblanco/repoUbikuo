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
public class DetallesPedidoProveedorVO {
    
    private String dpro_id_producto;
    private int dpro_id_pedido, dpro_cantidad;
    private double dpro_subtotal, dpro_preciocompra;
    

    public DetallesPedidoProveedorVO() {
    }

    public DetallesPedidoProveedorVO(String dpro_id_producto, String dpro_cantidad, String dpro_preciocompra, int dpro_id_pedido) {
        this.dpro_id_producto = dpro_id_producto;
        this.dpro_cantidad = dpro_cantidad;
        this.dpro_preciocompra = dpro_preciocompra;
        this.dpro_id_pedido = dpro_id_pedido;
    }

    public DetallesPedidoProveedorVO(String dpro_id_producto, String dpro_cantidad, String dpro_preciocompra) {
        this.dpro_id_producto = dpro_id_producto;
        this.dpro_cantidad = dpro_cantidad;
        this.dpro_preciocompra = dpro_preciocompra;
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

    public int getDpro_id_pedido() {
        return dpro_id_pedido;
    }

    public void setDpro_id_pedido(int dpro_id_pedido) {
        this.dpro_id_pedido = dpro_id_pedido;
    }
    
    
}
