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
 * Created by aazuaje on 21/10/2016.
 */
public class TercerosInfTecnicaLBCBean implements Serializable {

    private final static Logger log = Logger.getLogger(TercerosInfTecnicaLBCBean.class);

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

    public static ArrayList getTercerosInfTecnicaLBC() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList TercerosInfTecnicaLBC = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Tipo_Terceros,Apellido, Nombre, Tipo_Doc_Identificacion, Num_Doc_Identificacion from TERCEROS_INF_TECNICA_LBC ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TercerosInfTecnicaLBCBean tercerosInfTecnicaLBCBean = new TercerosInfTecnicaLBCBean();

                tercerosInfTecnicaLBCBean.setTipoTerceros(rs.getString("TIPO_TERCEROS"));
                tercerosInfTecnicaLBCBean.setApellido(rs.getString("APELLIDO"));
                tercerosInfTecnicaLBCBean.setNombre(rs.getString("NOMBRE"));
                tercerosInfTecnicaLBCBean.setTipoDocIdentificacion(rs.getString("TIPO_DOC_IDENTIFICACION"));
                tercerosInfTecnicaLBCBean.setNumDocIdentificacion(rs.getString("NUM_DOC_IDENTIFICACION"));
                tercerosInfTecnicaLBCBean.setMoneda(rs.getString("MONEDA"));

                TercerosInfTecnicaLBC.add(tercerosInfTecnicaLBCBean);

            }


        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return TercerosInfTecnicaLBC;

    }
}
