/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;



import ModeloVO.pedidoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;

/**
 *
 * @author WIN
 */
public class pedidoDAO extends ConexionBd {
    
    ConexionBd conec = new ConexionBd();
    private Connection conexion;
    private PreparedStatement puente ,smt1,smt2;
    private ResultSet mensajero;
    private boolean operacion = false; //Lo que me retorna la ejecición
    private String sql; //Peticiones
    private int r;

    pedidoVO pedVO = new pedidoVO();

    public pedidoDAO(pedidoVO pedVO) {
        super();
        try {
            //Conexion BD
            conexion = this.obtenerConexion();
        } catch (Exception e) {

            Logger.getLogger(productosDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public pedidoDAO(){}
    
    public int idPedido() {
        int id_ped = 0;
        sql = "select max(id_ped)from tblpedido";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                id_ped = mensajero.getInt(1);
            }
        } catch (Exception e) {
        }
        return id_ped;
    }
    public int guardarPedido(pedidoVO pedVO) {

        sql = "insert into tblpedido (ped_id_cliente,ped_idusuario,Totalvalor,pedestado) values (?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            smt1 = conexion.prepareStatement(sql);
            smt1.setInt(1, pedVO.getPed_id_cliente());
            smt1.setInt(2, pedVO.getPed_id_usuario());
            smt1.setDouble(3, pedVO.getTotal());
            smt1.setString(4, pedVO.getPedestado());

            smt1.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(cotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(cotizacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return r;
    }
    public int GuardarDetallePedido(pedidoVO pedVO) {

        sql = "insert into detalles_pedido (id_pedido,dp_id_producto,dp_cantidad,dp_precio) values (?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            smt2 = conexion.prepareStatement(sql);
            smt2.setInt(1, pedVO.getId_ped());
            smt2.setInt(2, pedVO.getDp_id_producto());
            smt2.setInt(3, pedVO.getDp_cantidad());
            smt2.setDouble(4, pedVO.getPrecio());
            smt2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(cotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(cotizacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return r;

    }
    
}
