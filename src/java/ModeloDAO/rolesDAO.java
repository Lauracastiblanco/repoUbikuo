/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.rolesVO;
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
public class rolesDAO extends ConexionBd implements Crud {

    ConexionBd conec = new ConexionBd();
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    private String id_Rol = "", rolnombre = "";

    public rolesDAO() {
    }

    public rolesDAO(rolesVO rolVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            id_Rol = rolVO.getId_Rol();
            rolnombre = rolVO.getRolnombre();
        } catch (Exception e) {
            Logger.getLogger(rolesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into tblroles(rolnombre) values (?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, rolnombre);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(rolesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            //independimiente que no haga 
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(rolesDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "UPDATE tblroles SET rolnombre = ? WHERE (id_Rol = ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, rolnombre);
            puente.setString(2, id_Rol);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(rolesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            //independimiente que no haga 
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(rolesDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegisro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<rolesVO> listar() {
        ArrayList<rolesVO> ListaRoles = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from tblroles;";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                rolesVO rolVO = new rolesVO(mensajero.getString(1), mensajero.getString(2));
                ListaRoles.add(rolVO);
            }
        } catch (Exception e) {
            Logger.getLogger(rolesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(rolesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ListaRoles;
    }
    
    public ArrayList<rolesVO> listarInicio(String IdUsuario)
    {
        ArrayList<rolesVO> listaRoles = new ArrayList<>();/*se creo el objeto*/
        
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT usu_id_rol, id_usuario FROM tblusuarios  where id_usuario = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, IdUsuario);
            //remplazar los interrogantes
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                
                rolesVO rolVO = new rolesVO(mensajero.getString(1),mensajero.getString(2));
                listaRoles.add(rolVO);
            }
        } catch (Exception e) {
            Logger.getLogger(rolesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(rolesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaRoles;
    }

}
