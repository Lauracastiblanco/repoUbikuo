/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.cotizacionVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author Luisa
 */
public class cotizacionDAO extends ConexionBd {

    ConexionBd conec = new ConexionBd();
    private Connection conexion;
    private PreparedStatement puente ,smt1,smt2;
    private ResultSet mensajero;
    private boolean operacion = false; //resultado de la ejecuion
    private String sql; //peticiones
    private int r;

    cotizacionVO cotVO = new cotizacionVO();

    public cotizacionDAO(cotizacionVO cotVO) {
        super();
        try {
            //conectarse a la base de datos
            conexion = this.obtenerConexion();
        } catch (Exception e) {

            Logger.getLogger(productosDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public cotizacionDAO() {
    }

    public int idCotizacion() {
        int id_cot = 0;
        sql = "select max(id_cot)from tblcotizaciones";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                id_cot = mensajero.getInt(1);

            }
        } catch (Exception e) {
        }

        return id_cot;
    }

    public int guardarCotizacion(cotizacionVO cotVO) {

        sql = "insert into tblcotizaciones (cot_id_cliente,cot_id_usuario,Totalcot,cotestado) values (?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            smt1 = conexion.prepareStatement(sql);
            smt1.setInt(1, cotVO.getId_cot_cliente());
            smt1.setInt(2, cotVO.getCot_id_usuario());
            smt1.setDouble(3, cotVO.getTotal());
            smt1.setString(4, cotVO.getCotestado());

            smt1.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(cotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //independimiente que no haga
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(cotizacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return r;

    }

    public int GuardarDetalleCotizacion(cotizacionVO cotVO) {

        sql = "insert into detalles_cotizacion (id_cot,dc_id_prod,dc_cantidad,precio) values (?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            smt2 = conexion.prepareStatement(sql);
            smt2.setInt(1, cotVO.getId());
            smt2.setInt(2, cotVO.getDc_id_producto());
            smt2.setInt(3, cotVO.getCantidad());
            smt2.setDouble(4, cotVO.getPrecio());
            smt2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(cotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //independimiente que no haga
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(cotizacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return r;

    }
    
   public ArrayList<cotizacionVO> consultarDatos() {
    ArrayList<cotizacionVO> resultado = new ArrayList<>();

    try {
        conexion = this.obtenerConexion();
        smt2 = conexion.prepareStatement(sql);

        // Ejecutar la consulta utilizando la vista
       sql = "SELECT cotizacion, cliente, usunombre, cotfecha, Totalcot, cotestado FROM consultarcotizaciones";
       mensajero = puente.executeQuery();

        // Recorrer los resultados y crear objetos personalizados
        while (mensajero.next()) {
            int columna1 = mensajero.getInt("cotizacion");
        String columna2 = mensajero.getString("cliente");
        String columna3 = mensajero.getString("usunombre");
        Timestamp columna4 = mensajero.getTimestamp("cotfecha");
        double columna5 = mensajero.getDouble("Totalcot");
        String columna6 = mensajero.getString("cotestado");

   
            

            // Crear un objeto personalizado y agregarlo al ArrayList
            cotizacionVO ctVO = new cotizacionVO(columna1, columna2, columna3, columna4, columna5, columna6);
            resultado.add(ctVO);
        }

      
    } catch (Exception e) {
        e.printStackTrace();
    }

    return resultado;
}


}


