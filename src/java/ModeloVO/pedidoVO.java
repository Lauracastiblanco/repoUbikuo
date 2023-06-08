/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author WIN
 */
public class pedidoVO {
    
    private int id_ped,item,ped_id_cliente,ped_id_usuario,dp_id_pedido,dp_id_producto,dp_cantidad;
    private String pedestado,nombreprod;
    private double total,subtotal,precio;

    public pedidoVO(int id_ped, int item, int ped_id_cliente, int ped_id_usuario, int dp_id_pedido, int dp_id_producto, int dp_cantidad, String pedestado, String nombreprod, double total, double subtotal, double precio) {
        this.id_ped = id_ped;
        this.item = item;
        this.ped_id_cliente = ped_id_cliente;
        this.ped_id_usuario = ped_id_usuario;
        this.dp_id_pedido = dp_id_pedido;
        this.dp_id_producto = dp_id_producto;
        this.dp_cantidad = dp_cantidad;
        this.pedestado = pedestado;
        this.nombreprod = nombreprod;
        this.total = total;
        this.subtotal = subtotal;
        this.precio = precio;
    }
    
    public pedidoVO(){}

    public int getId_ped() {
        return id_ped;
    }

    public void setId_ped(int id_ped) {
        this.id_ped = id_ped;
    }

    public int getItem() {
        return item;
    } 

    public void setItem(int item) {
        this.item = item;
    }

    public int getPed_id_cliente() {
        return ped_id_cliente;
    }

    public void setPed_id_cliente(int ped_id_cliente) {
        this.ped_id_cliente = ped_id_cliente;
    }

    public int getPed_id_usuario() {
        return ped_id_usuario;
    }

    public void setPed_id_usuario(int ped_id_usuario) {
        this.ped_id_usuario = ped_id_usuario;
    }

    public int getDp_id_pedido() {
        return dp_id_pedido;
    }

    public void setDp_id_pedido(int dp_id_pedido) {
        this.dp_id_pedido = dp_id_pedido;
    }

    public int getDp_id_producto() {
        return dp_id_producto;
    }

    public void setDp_id_producto(int dp_id_producto) {
        this.dp_id_producto = dp_id_producto;
    }

    public int getDp_cantidad() {
        return dp_cantidad;
    }

    public void setDp_cantidad(int dp_cantidad) {
        this.dp_cantidad = dp_cantidad;
    }

    public String getPedestado() {
        return pedestado;
    }

    public void setPedestado(String pedestado) {
        this.pedestado = pedestado;
    }

    public String getNombreprod() {
        return nombreprod;
    }

    public void setNombreprod(String nombreprod) {
        this.nombreprod = nombreprod;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
