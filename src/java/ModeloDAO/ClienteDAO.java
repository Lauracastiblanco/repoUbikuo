/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ClienteVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;
import util.Crud;

/**
 *
 * @author Luisa
 */
public class ClienteDAO extends ConexionBd implements Crud {

    ConexionBd conec = new ConexionBd();
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    private String id_cliente = "", clinombre = "", cliapellido = "", clicorreo = "", clidireccion = "", clitelefono = "", clidescripcion = "";

    public ClienteDAO() {

    }

    public ClienteDAO(ClienteVO cliVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            id_cliente = cliVO.getId_cliente();
            clinombre = cliVO.getClinombre();
            cliapellido = cliVO.getCliapellido();
            clicorreo = cliVO.getClicorreo();
            clidireccion = cliVO.getClidireccion();
            clitelefono = cliVO.getClitelefono();
            clidescripcion = cliVO.getClidescripcion();

        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO tblclientes (id_cliente,clinombre, cliapellido, clicorreo, clidireccion,clitelefono, clidescripcion) values(?, ?, ?, ?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_cliente);
            puente.setString(2, clinombre);
            puente.setString(3, cliapellido);
            puente.setString(4, clicorreo);
            puente.setString(5, clidireccion);
            puente.setString(6, clitelefono);
            puente.setString(7, clidescripcion);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "UPDATE tblclientes SET  clinombre= ?, cliapellido= ?, clicorreo= ?, clidireccion= ?, clitelefono= ?, clidescripcion = ? WHERE (id_cliente = ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, clinombre);
            puente.setString(2, cliapellido);
            puente.setString(3, clicorreo);
            puente.setString(4, clidireccion);
            puente.setString(5, clitelefono);
            puente.setString(6, clidescripcion);
            puente.setString(7, id_cliente);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;
    }

    public ArrayList<ClienteVO> listarClientes() {

        ArrayList<ClienteVO> listaClientes = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from tblclientes";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                ClienteVO cliVO = new ClienteVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));

                listaClientes.add(cliVO);

            }
        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaClientes;
    }

    public ClienteVO consultarPorId(String id_cliente) {
        ClienteVO cliVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from tblclientes where id_cliente = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_cliente);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                cliVO = new ClienteVO(id_cliente, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));
            }

        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return cliVO;
    }

    @Override
    public boolean eliminarRegisro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ClienteVO buscar(String documento) {
        ClienteVO cvo = new ClienteVO();

        sql = "select * from tblclientes where id_cliente=" + documento;
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                cvo.setId_cliente(mensajero.getString(1));
                cvo.setClinombre(mensajero.getString(2));
                cvo.setCliapellido(mensajero.getString(3));
                cvo.setClicorreo(mensajero.getString(4));
                cvo.setClidireccion(mensajero.getString(5));
                cvo.setClitelefono(mensajero.getString(6));
                cvo.setClidescripcion(mensajero.getString(7));

            }
        } catch (Exception e) {
        }
        return cvo;
    }

}
