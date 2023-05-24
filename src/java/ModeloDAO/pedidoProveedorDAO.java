/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.pedidoProveedorVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;
import util.Crud;

/**
 *
 * @author Alexander
 */
public class pedidoProveedorDAO extends ConexionBd implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    private String id_proped = "",  proped_fecha = "", Total_proped = "", propedestado = "", id_dpro = "", dpro_id_pedido = "",
            dpro_id_producto = "", dpro_cantidad = "", dpro_preciocompra = "";

    private int ped_id_proveedor = 0, id_usuario = 0;
    public pedidoProveedorDAO() {
    }

    public pedidoProveedorDAO(pedidoProveedorVO pedProvVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            id_proped = pedProvVO.getId_proped();
            ped_id_proveedor = pedProvVO.getPed_id_proveedor();
            id_usuario = pedProvVO.getId_usuario();
            proped_fecha = pedProvVO.getProped_fecha();
            Total_proped = pedProvVO.getTotal_proped();
            propedestado = pedProvVO.getPropedestado();
            id_dpro = pedProvVO.getId_dpro();
            dpro_id_pedido = pedProvVO.getDpro_id_pedido();
            dpro_id_producto = pedProvVO.getDpro_id_producto();
            dpro_cantidad = pedProvVO.getDpro_cantidad();
            dpro_preciocompra = pedProvVO.getDpro_preciocompra();

        } catch (Exception e) {
            Logger.getLogger(pedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    @Override
    public boolean agregarRegistro() {
        sql = "INSERT INTO tblpedidos_proveedor(ped_id_proveedor, id_usuario) values (?,?)";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ped_id_proveedor);
            puente.setInt(2, id_usuario);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(pedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(pedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;
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
 
    public boolean agregarDetallesPedido(int idPedido) {
        sql = "INSERT INTO detalles_propedido(dpro_id_pedido, dpro_id_producto, dpro_cantidad,dpro_preciocompra) values (?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, idPedido);
            puente.setString(2, dpro_id_producto);
            puente.setString(3, dpro_cantidad);
            puente.setString(4, dpro_preciocompra);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(pedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(pedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
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
