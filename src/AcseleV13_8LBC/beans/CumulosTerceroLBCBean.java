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
 * Created by aazuaje on 18/10/2016.
 */
public class CumulosTerceroLBCBean implements Serializable{

    private final static Logger log = Logger.getLogger(CumulosTerceroLBCBean.class);

    private String tipoTerceros;
    private String apellido;
    private String nombre;
    private String tipoDocIdentificacion;
    private String numDocIdentificacion;
    private String moneda;


    public String getTipoTerceros() {return tipoTerceros;}
    public void setTipoTerceros(String tipoTerceros) {this.tipoTerceros = tipoTerceros;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getTipoDocIdentificacion() {return tipoDocIdentificacion;}
    public void setTipoDocIdentificacion(String tipoDocIdentificacion) {this.tipoDocIdentificacion = tipoDocIdentificacion;}

    public String getNumDocIdentificacion() {return numDocIdentificacion;}
    public void setNumDocIdentificacion(String numDocIdentificacion) {this.numDocIdentificacion = numDocIdentificacion;}

    public String getMoneda() {return moneda;}
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public static ArrayList getCumulosTercerosLBC() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList cumulosTercerosLBC = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Tipo_Terceros,Apellido, Nombre, Tipo_Doc_Identificacion, Num_Doc_Identificacion,Moneda from CUMULOS_TERCEROS_LBC ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CumulosTerceroLBCBean cumulosTerceroLBCBean = new CumulosTerceroLBCBean();

                cumulosTerceroLBCBean.setTipoTerceros(rs.getString("TIPO_TERCEROS"));
                cumulosTerceroLBCBean.setApellido(rs.getString("APELLIDO"));
                cumulosTerceroLBCBean.setNombre(rs.getString("NOMBRE"));
                cumulosTerceroLBCBean.setTipoDocIdentificacion(rs.getString("TIPO_DOC_IDENTIFICACION"));
                cumulosTerceroLBCBean.setNumDocIdentificacion(rs.getString("NUM_DOC_IDENTIFICACION"));
                cumulosTerceroLBCBean.setMoneda(rs.getString("MONEDA"));

                cumulosTercerosLBC.add(cumulosTerceroLBCBean);

            }


        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return cumulosTercerosLBC;

    }

}
