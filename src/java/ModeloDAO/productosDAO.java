/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ProveedorVO;
import ModeloVO.productosVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;
import util.Crud;

/**
 *
 * @author Luisa
 */
public class productosDAO extends ConexionBd implements Crud {

    ConexionBd conec = new ConexionBd();
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    private String id_prod = "", prodnombre = "", prodprecio = "", prod_id_categoria = "", prodestado = "", prodstock_disp = "", prod_descripcion = "", prod_id_prov = "";

    public productosDAO() {
    }

    public productosDAO(productosVO prodVO) {
        super();
        try {

            // Conectarse a la base de datos
            conexion = this.obtenerConexion();
            // Trae los datos del VO al DAO
            id_prod = prodVO.getId_prod();
            prodnombre = prodVO.getProdnombre();
            prodprecio = prodVO.getProdprecio();
            prod_id_categoria = prodVO.getProd_id_categoria();
            prodestado = prodVO.getProdestado();
            prodstock_disp = prodVO.getProdstock_disp();
            prod_descripcion = prodVO.getProd_descripcion();
            prod_id_prov = prodVO.getProd_id_prov();

        } catch (Exception e) {
            Logger.getLogger(productosDAO.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO tblproductos(id_prod, prodnombre,prodprecio,prod_id_categoria,prodestado,prodstock_disp,prod_descripcion,prod_id_prov) values(?, ?, ?, ?, ?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_prod);
            puente.setString(2, prodnombre);
            puente.setString(3, prodprecio);
            puente.setString(4, prod_id_categoria);
            puente.setString(5, prodestado);
            puente.setString(6, prodstock_disp);
            puente.setString(7, prod_descripcion);
            puente.setString(8, prod_id_prov);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(productosDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(productosDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "UPDATE tblproductos SET prodnombre = ?, prodprecio = ?, prod_id_categoria = ?, prodestado = ?, prodstock_disp = ?, prod_descripcion = ?, prod_id_prov = ? WHERE (id_prod = ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, prodnombre);
            puente.setString(2, prodprecio);
            puente.setString(3, prod_id_categoria);
            puente.setString(4, prodestado);
            puente.setString(5, prodstock_disp);
            puente.setString(6, prod_descripcion);
            puente.setString(7, prod_id_prov);
            puente.setString(8, id_prod);

            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(productosDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(productosDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }
        return operacion;
    }

    public ArrayList<productosVO> listar() {

        ArrayList<productosVO> listaProductos = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from consultar_producto where prodestado='activo'";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                productosVO prodVO = new productosVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), mensajero.getString(9), mensajero.getString(10));

                listaProductos.add(prodVO);

            }
        } catch (Exception e) {
            Logger.getLogger(productosDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(productosDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaProductos;
    }

    public productosVO consultarPorId(String id_prod) {
        productosVO prodVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from tblproductos where id_prod = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_prod);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                prodVO = new productosVO(id_prod, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
            }

        } catch (Exception e) {
            Logger.getLogger(productosDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(productosDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return prodVO;
    }

    public productosVO listarid(String id) {
        productosVO pVO = new productosVO();
        sql = "select * from tblproductos where id_prod=" + id;
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                pVO.setId_prod(mensajero.getString(1));
                pVO.setProdnombre(mensajero.getString(2));
                pVO.setProdprecio(mensajero.getString(3));
                pVO.setProd_id_categoria(mensajero.getString(4));
                pVO.setProdestado(mensajero.getString(5));
                pVO.setProdstock_disp(mensajero.getString(6));
                pVO.setProd_descripcion(mensajero.getString(7));
                pVO.setProd_id_prov(mensajero.getString(8));

            }
        } catch (Exception e) {
        }
        return pVO;

    }

    
    

    @Override
    public boolean eliminarRegisro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
