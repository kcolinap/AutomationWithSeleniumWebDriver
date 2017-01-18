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
 * Created by aazuaje on 06/01/2017.
 */
public class INTER_CumuloTerceroBean implements Serializable{

    private final static Logger log = Logger.getLogger(INTER_CumuloTerceroBean.class);

    private String tipoTercero;
    private String documentoIdentidad;
    private String pasaporte;
    private String apellido;
    private String nombre;
    private String moneda;

    public String getTipoTercero() {return tipoTercero;}
    public void setTipoTercero(String tipoTercero) {this.tipoTercero = tipoTercero;}

    public String getDocumentoIdentidad() {return documentoIdentidad;}
    public void setDocumentoIdentidad(String documentoIdentidad) {this.documentoIdentidad = documentoIdentidad;}

    public String getPasaporte() {return pasaporte;}
    public void setPasaporte(String pasaporte) {this.pasaporte = pasaporte;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getMoneda() {return moneda;}
    public void setMoneda(String moneda) {this.moneda = moneda;}


    public static ArrayList getINTER_CumuloTercero() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interCumuloTercero = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from INTER_CUMULO_TERCERO ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_CumuloTerceroBean inter_cumuloTerceroBean = new INTER_CumuloTerceroBean();

                inter_cumuloTerceroBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                inter_cumuloTerceroBean.setDocumentoIdentidad(rs.getString("DOCUMENTO_IDENTIDAD"));
                inter_cumuloTerceroBean.setPasaporte(rs.getString("PASAPORTE"));
                inter_cumuloTerceroBean.setApellido(rs.getString("APELLIDO"));
                inter_cumuloTerceroBean.setNombre(rs.getString("NOMBRE"));
                inter_cumuloTerceroBean.setMoneda(rs.getString("MONEDA"));

                interCumuloTercero.add(inter_cumuloTerceroBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interCumuloTercero;

    }


}
