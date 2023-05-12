/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;


import ModeloVO.CategoriaVO;
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
public class CategoriaDAO extends ConexionBd implements Crud{
    
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
   private String  catnombre="", catestado="", catdescripcion="",id_cat="";

  
   
    public CategoriaDAO() {
    }
    
    public CategoriaDAO(CategoriaVO catVO) {
            super();
        try{
        conexion = this.obtenerConexion();
         id_cat= catVO.getId_cat();
         catnombre= catVO.getCatnombre();
         catestado= catVO.getCatestado();
         catdescripcion= catVO.getCatdescripcion();


    } catch (Exception e) {
          Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null,e);
            
        }

    }
    

    @Override
    public boolean agregarRegistro() {
         sql="INSERT INTO tblcategorias (catnombre,catestado,catdescripcion) values (?,?,?)";
        try{
         
        conexion = this.obtenerConexion();
        puente = conexion.prepareStatement(sql);
            puente.setString(1, catnombre);
            puente.setString(2, catestado);
            puente.setString(3, catdescripcion); 
            puente.executeUpdate();
            operacion = true;
        }
        catch (Exception e) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null,e);

        } finally{
            try {
                 //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null,e);

            }
            }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql="UPDATE tblcategorias SET catnombre= ?, catestado= ?, catdescripcion= ? WHERE (id_cat = ?);";
            puente = conexion.prepareStatement(sql);          
            puente.setString(1, catnombre );
            puente.setString(2, catestado);
            puente.setString(3, catdescripcion);
            puente.setString(4,id_cat );
            
        } catch (Exception e) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null,e);

        } finally{
            try {
                 //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null,e);

            }
            }
        return operacion;
    }
    
    @Override
    public boolean eliminarRegisro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CategoriaVO consultarPorId(String id_cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ArrayList<CategoriaVO> listarC() {
        ArrayList<CategoriaVO> listaCategoria = new ArrayList<>();
                
        try {
            conexion = this.obtenerConexion();
            sql = "select * from tblcategorias";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CategoriaVO catVO = new CategoriaVO(mensajero.getString(1),mensajero.getString(2),mensajero.getString(3),mensajero.getString(4));
                listaCategoria.add(catVO);
            }
        } catch (Exception e) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaCategoria;
    }
}


     


