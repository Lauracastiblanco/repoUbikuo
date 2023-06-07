/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author diego
 */
public class DetallesCotizacionVO {

    public DetallesCotizacionVO() {
    }
    private int dc_id_producto,item ,id,cantidad;
    private double precio;

    public DetallesCotizacionVO(int dc_id_producto, int item, int id, int cantidad, double precio) {
        this.dc_id_producto = dc_id_producto;
        this.item = item;
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getDc_id_producto() {
        return dc_id_producto;
    }

    public void setDc_id_producto(int dc_id_producto) {
        this.dc_id_producto = dc_id_producto;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
