/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.DetallesPedidoProveedorVO;
import ModeloVO.pedidoProveedorVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;
import util.Crud;

/**
 *
 * @author Alexander
 */
public class DetallesPedidoProveedorDAO extends ConexionBd implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    private String dpro_id_producto = "";
    private int dpro_cantidad = 0;
    private double dpro_preciocompra = 0;

    public DetallesPedidoProveedorDAO() {
    }

    public DetallesPedidoProveedorDAO(DetallesPedidoProveedorVO detPedProvVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            dpro_id_producto = detPedProvVO.getDpro_id_producto();
            dpro_cantidad = detPedProvVO.getDpro_cantidad();
            dpro_preciocompra = detPedProvVO.getDpro_preciocompra();

        } catch (Exception e) {
            Logger.getLogger(DetallesPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public int obtenerUltimoIdPedido() {
        int idPedido = 0;
        sql = "SELECT MAX(id_proped) FROM tblpedidos_proveedor";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {
                idPedido = mensajero.getInt(1);
            }
        } catch (Exception e) {
            Logger.getLogger(pedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(pedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return idPedido;
    }

    public boolean agregarDetallesPedido(int idPedido, List<DetallesPedidoProveedorVO> listaProductos) {
    sql = "INSERT INTO detalles_propedido(dpro_id_pedido, dpro_id_producto, dpro_cantidad, dpro_preciocompra) values (?,?,?,?)";
    try {
        conexion = this.obtenerConexion();
        puente = conexion.prepareStatement(sql);
        
        for (DetallesPedidoProveedorVO producto : listaProductos) {
            puente.setInt(1, idPedido);
            puente.setString(2, producto.getDpro_id_producto());
            puente.setInt(3, producto.getDpro_cantidad());
            puente.setDouble(4, producto.getDpro_preciocompra());
            puente.executeUpdate();
        }
        
        operacion = true;
    } catch (Exception e) {
        Logger.getLogger(DetallesPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        try {
            //this.cerrarConexion();
        } catch (Exception e) {
            Logger.getLogger(DetallesPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    return operacion;
}


    @Override
    public boolean agregarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegisro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
