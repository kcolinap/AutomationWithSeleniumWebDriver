package AcseleV13_8LBC.beans;
import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Created by aazuaje on 15/10/2016.
 */
public class EdicionTercerosFallaLBCBean implements Serializable {

    private final static Logger log = Logger.getLogger(EdicionTercerosFallaLBCBean.class);

    private String tipoTercero;
    private String apellido;
    private String nombre;
    private String tipoDocId;
    private String numDocId;
    private String tipoTerceroNuevo;
    private String apellidoNuevo;
    private String nombreNuevo;
    private String tipoDocIdNuevo;
    private String numDocIdNuevo;

    public String getTipoTercero() {return tipoTercero;}
    public void setTipoTercero(String tipoTercero) {this.tipoTercero = tipoTercero;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getTipoDocId() {return tipoDocId;}
    public void setTipoDocId(String tipoDocId) {this.tipoDocId = tipoDocId;}

    public String getNumDocId() {return numDocId;}
    public void setNumDocId(String numDocId) {this.numDocId = numDocId;}

    public String getTipoTerceroNuevo() {return tipoTerceroNuevo;}
    public void setTipoTerceroNuevo(String tipoTerceroNuevo) {this.tipoTerceroNuevo = tipoTerceroNuevo;}

    public String getApellidoNuevo() {return apellidoNuevo;}
    public void setApellidoNuevo(String apellidoNuevo) {this.apellidoNuevo = apellidoNuevo;}

    public String getNombreNuevo() {return nombreNuevo;}
    public void setNombreNuevo(String nombreNuevo) {this.nombreNuevo = nombreNuevo;}

    public String getTipoDocIdNuevo() {return tipoDocIdNuevo;}
    public void setTipoDocIdNuevo(String tipoDocIdNuevo) {this.tipoDocIdNuevo = tipoDocIdNuevo;}

    public String getNumDocIdNuevo() {return numDocIdNuevo;}
    public void setNumDocIdNuevo(String numDocIdNuevo) {this.numDocIdNuevo = numDocIdNuevo;}

    public static ArrayList getEdicionTercerosFallaLBCBean() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList edicionTercerosFallaLBC = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select PRUEBA,TIPO_TERCERO,APELLIDO,NOMBRE, TIPO_DOC_ID, NUM_DOC_ID,TIPO_TERCERO_NUEVO, APELLIDO_NUEVO,NOMBRE_NUEVO, TIPO_DOC_ID_NUEVO, NUM_DOC_ID_NUEVO from EDICION_TERCEROS_LBC ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EdicionTercerosFallaLBCBean edicionTercerosFallaLBCBean = new EdicionTercerosFallaLBCBean();

                edicionTercerosFallaLBCBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                edicionTercerosFallaLBCBean.setApellido(rs.getString("APELLIDO"));
                edicionTercerosFallaLBCBean.setNombre(rs.getString("NOMBRE"));
                edicionTercerosFallaLBCBean.setTipoDocId(rs.getString("TIPO_DOC_ID"));
                edicionTercerosFallaLBCBean.setNumDocId(rs.getString("NUM_DOC_ID"));
                edicionTercerosFallaLBCBean.setTipoTerceroNuevo(rs.getString("TIPO_TERCERO_NUEVO"));
                edicionTercerosFallaLBCBean.setApellidoNuevo(rs.getString("APELLIDO_NUEVO"));
                edicionTercerosFallaLBCBean.setNombreNuevo(rs.getString("NOMBRE_NUEVO"));
                edicionTercerosFallaLBCBean.setTipoDocIdNuevo(rs.getString("TIPO_DOC_ID_NUEVO"));
                edicionTercerosFallaLBCBean.setNumDocIdNuevo(rs.getString("NUM_DOC_ID_NUEVO"));


                edicionTercerosFallaLBC.add(edicionTercerosFallaLBCBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return edicionTercerosFallaLBC;

    }




}
