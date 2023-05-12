/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ProveedorVO;
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
public class ProveedorDAO extends ConexionBd implements Crud {
    
    //Declarar variables y/o objetos
    ConexionBd conec = new ConexionBd();
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    private String id_prov="", pronombre="", prodireccion="", protelefono="", proestado="", prodescripcion="", procorreo="", prorepresentante="";

    public ProveedorDAO() {
    }

    public ProveedorDAO(ProveedorVO provVO){
        super();
          try {
            
            // Conectarse a la base de datos
            conexion = this.obtenerConexion();
            // Trae los datos del VO al DAO
            id_prov = provVO.getId_prov();
            pronombre = provVO.getPronombre();
            prodireccion = provVO.getProdireccion();
            protelefono = provVO.getProtelefono();
            proestado = provVO.getProestado();
            prodescripcion = provVO.getProdescripcion();
            procorreo = provVO.getProcorreo();
            prorepresentante = provVO.getProrepresentante();

            
        } catch (Exception e) {
          Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE,null,e);
            
        }
              
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql="INSERT INTO tblproveedores (id_prov,pronombre,prodireccion,protelefono,proestado,prodescripcion,procorreo,prorepresentante) values(?, ?, ?, ?, ?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1,id_prov);
            puente.setString(2, pronombre);
            puente.setString(3, prodireccion);
            puente.setString(4, protelefono);
            puente.setString(5, proestado);
            puente.setString(6, prodescripcion);            
            puente.setString(7, procorreo);
            puente.setString(8, prorepresentante);
            puente.executeUpdate();
            operacion = true;
            
        } catch (Exception e) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE,null,e);

        } finally{
            try {
                 this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE,null,e);

            }
           
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
         try {
            sql="tblproductos set prodnombre = ?, prodprecio = ?, prod_id_categoria = ?, prodestado = ?, prodstock_disp = ?, prod_descripcion = ?, prod_id_prov = ? where (id_prod = ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, pronombre);
            puente.setString(2, prodireccion);
            puente.setString(3, protelefono);
            puente.setString(4, proestado);
            puente.setString(5, prodescripcion);            
            puente.setString(6, procorreo);
            puente.setString(7, prorepresentante);
            puente.setString(8,id_prov);
            puente.executeUpdate();
            operacion = true;
            
        } catch (Exception e) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE,null,e);

        } finally{
            try {
                 this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE,null,e);

            }
           
        }
        return operacion;
    }
        
    public ArrayList<ProveedorVO> listar(){
        
        ArrayList<ProveedorVO> listaProveedores = new ArrayList<>();
            
        try {
            conexion = this.obtenerConexion();
            sql= "select * from tblproveedores";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                
            ProveedorVO provVO= new ProveedorVO (mensajero.getString(1), mensajero.getString(2),mensajero.getString(3), mensajero.getString(4), 
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
            
            listaProveedores.add(provVO);
            
    }
        } catch (Exception e) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return  listaProveedores;
    }

    public ProveedorVO consultarPorId(String id_prov) {
    ProveedorVO provVO = null;
        
        try {
            conexion = this.obtenerConexion();
            sql= "select * from tblproveedores where id_prov = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1,id_prov);
            mensajero=puente.executeQuery();
            while(mensajero.next())
            {
             provVO = new ProveedorVO(id_prov, mensajero.getString(2),mensajero.getString(3), mensajero.getString(4), 
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
            }       

        } catch (Exception e) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return provVO;
    }
    @Override
    public boolean eliminarRegisro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

