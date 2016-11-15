package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by rmontilla on 14/11/2016.
 */
public class INTER_ConsultaTerceroBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_ConsultaTerceroBean.class);

    private String tipoTercero;
    private String apellido;
    private String nombre;
    private String codIdenti;
    private String numDocId;




    public String getTipoTercero() {return tipoTercero;}
    public void setTipoTercero(String tipoTercero) {this.tipoTercero = tipoTercero;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getCodIdenti() {return codIdenti;}
    public void setCodIdenti(String codIdenti) {this.codIdenti = codIdenti;}

    public String getNumDocId() {return numDocId;}
    public void setNumDocId(String numDocId) {this.numDocId = numDocId;}


    public static ArrayList getConsutaTercerosINTERBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList consultaTerceroINTER = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select PRUEBA,TIPO_TERCERO,APELLIDO,NOMBRE, COD_IDENTIFICADOR, NUM_DOC_ID  from CONSULTA_TERCEROS_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_ConsultaTerceroBean inter_consultaTerceroBean = new INTER_ConsultaTerceroBean();

                inter_consultaTerceroBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                inter_consultaTerceroBean.setApellido(rs.getString("APELLIDO"));
                inter_consultaTerceroBean.setNombre(rs.getString("NOMBRE"));
                inter_consultaTerceroBean.setCodIdenti(rs.getString("COD_IDENTIFICADOR"));
                inter_consultaTerceroBean.setNumDocId(rs.getString("NUM_DOC_ID"));


                consultaTerceroINTER.add(inter_consultaTerceroBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return consultaTerceroINTER;

    }



}
