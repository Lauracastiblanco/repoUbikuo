/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

import java.sql.Timestamp;

/**
 *
 * @author Luisa
 */
public class cotizacionVO {

private int id ,item ,id_cot_cliente,cot_id_usuario,dc_id_producto,cantidad,fecha,estado;
private double precio,total,subtotal;
private String cotestado, nombreproductoL,cliente,usuario;


public cotizacionVO() {
}

    public cotizacionVO(int id, int item, int id_cot_cliente, int cot_id_usuario, int dc_id_producto, int cantidad, int fecha, int estado, double precio, double total, double subtotal, String cotestado, String nombreproductoL, String cliente, String usuario) {
        this.id = id;
        this.item = item;
        this.id_cot_cliente = id_cot_cliente;
        this.cot_id_usuario = cot_id_usuario;
        this.dc_id_producto = dc_id_producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.estado = estado;
        this.precio = precio;
        this.total = total;
        this.subtotal = subtotal;
        this.cotestado = cotestado;
        this.nombreproductoL = nombreproductoL;
        this.cliente = cliente;
        this.usuario = usuario;
    }

    public cotizacionVO(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public cotizacionVO(String string, String string0, String string1, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public cotizacionVO(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public cotizacionVO(String cotizacion, String cliente, String usuario, String fecha, double total, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public cotizacionVO(int columna1, String columna2, String columna3, Timestamp columna4, double columna5, String columna6) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getId_cot_cliente() {
        return id_cot_cliente;
    }

    public void setId_cot_cliente(int id_cot_cliente) {
        this.id_cot_cliente = id_cot_cliente;
    }

    public int getCot_id_usuario() {
        return cot_id_usuario;
    }

    public void setCot_id_usuario(int cot_id_usuario) {
        this.cot_id_usuario = cot_id_usuario;
    }

    public int getDc_id_producto() {
        return dc_id_producto;
    }

    public void setDc_id_producto(int dc_id_producto) {
        this.dc_id_producto = dc_id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    public String getCotestado() {
        return cotestado;
    }

    public void setCotestado(String cotestado) {
        this.cotestado = cotestado;
    }

    public String getNombreproductoL() {
        return nombreproductoL;
    }

    public void setNombreproductoL(String nombreproductoL) {
        this.nombreproductoL = nombreproductoL;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    


}
