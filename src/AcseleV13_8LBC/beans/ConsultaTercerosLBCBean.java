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
 * Created by aazuaje on 14/10/2016.
 */
public class ConsultaTercerosLBCBean implements Serializable {
    private final static Logger log = Logger.getLogger(ConsultaTercerosLBCBean.class);

    private String tipoTercero;
    private String apellido;
    private String nombre;
    private String tipoDocId;
    private String numDocId;



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


    public static ArrayList getConsutaTercerosLBCBean() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList consutaTerceroLBC = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select PRUEBA,TIPO_TERCERO,APELLIDO,NOMBRE, TIPO_DOC_ID, NUM_DOC_ID  from CONSULTA_TERCEROS_LBC ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ConsultaTercerosLBCBean consultaTercerosLBCBean = new ConsultaTercerosLBCBean();

                consultaTercerosLBCBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                consultaTercerosLBCBean.setApellido(rs.getString("APELLIDO"));
                consultaTercerosLBCBean.setNombre(rs.getString("NOMBRE"));
                consultaTercerosLBCBean.setTipoDocId(rs.getString("TIPO_DOC_ID"));
                consultaTercerosLBCBean.setNumDocId(rs.getString("NUM_DOC_ID"));


                consutaTerceroLBC.add(consultaTercerosLBCBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return consutaTerceroLBC;

    }


}
