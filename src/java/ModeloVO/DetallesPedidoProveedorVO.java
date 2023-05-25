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
    
    private String dpro_id_producto, descripcionProducto;
    private int dpro_id_pedido, dpro_cantidad, item;
    private double dpro_subtotal, dpro_preciocompra;

    public DetallesPedidoProveedorVO() {
    }

    public DetallesPedidoProveedorVO(String dpro_id_producto, String descripcionProducto, int dpro_id_pedido, int dpro_cantidad, int item, double dpro_subtotal, double dpro_preciocompra) {
        this.dpro_id_producto = dpro_id_producto;
        this.descripcionProducto = descripcionProducto;
        this.dpro_id_pedido = dpro_id_pedido;
        this.dpro_cantidad = dpro_cantidad;
        this.item = item;
        this.dpro_subtotal = dpro_subtotal;
        this.dpro_preciocompra = dpro_preciocompra;
    }

    public String getDpro_id_producto() {
        return dpro_id_producto;
    }

    public void setDpro_id_producto(String dpro_id_producto) {
        this.dpro_id_producto = dpro_id_producto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getDpro_id_pedido() {
        return dpro_id_pedido;
    }

    public void setDpro_id_pedido(int dpro_id_pedido) {
        this.dpro_id_pedido = dpro_id_pedido;
    }

    public int getDpro_cantidad() {
        return dpro_cantidad;
    }

    public void setDpro_cantidad(int dpro_cantidad) {
        this.dpro_cantidad = dpro_cantidad;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public double getDpro_subtotal() {
        return dpro_subtotal;
    }

    public void setDpro_subtotal(double dpro_subtotal) {
        this.dpro_subtotal = dpro_subtotal;
    }

    public double getDpro_preciocompra() {
        return dpro_preciocompra;
    }

    public void setDpro_preciocompra(double dpro_preciocompra) {
        this.dpro_preciocompra = dpro_preciocompra;
    }
    

    
   
}
