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
 * Created by rmontilla on 11/10/2016.
 */
public class LBC_EstadoCuentasBean implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_EstadoCuentasBean.class);

    //TIPO_TERCERO, NUM_DOCUMENTO_IDENTIFICACION, PRIMER_NOMBRE, PRIMER_APELLIDO, NUM_POLIZA, MONEDA, PRODUCTO

    private String tipoTercero;
    private String numDocIdentificacion;
    private String primerNombre;
    private String primerApellido;
    private String numPoliza;
    private String moneda;
    private String producto;



    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getNumDocIdentificacion() {
        return numDocIdentificacion;
    }

    public void setNumDocIdentificacion(String numDocIdentificacion) {
        this.numDocIdentificacion = numDocIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public static ArrayList getLBC_EstadoCuentasBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList edoCuentas = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, TIPO_TERCERO, NUM_DOCUMENTO_IDENTIFICACION, PRIMER_NOMBRE, PRIMER_APELLIDO, NUM_POLIZA, MONEDA, PRODUCTO FROM ESTADO_CUENTAS_LBC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_EstadoCuentasBean lbcEstadoCuentasBean = new LBC_EstadoCuentasBean();

                lbcEstadoCuentasBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                lbcEstadoCuentasBean.setNumDocIdentificacion(rs.getString("NUM_DOCUMENTO_IDENTIFICACION"));
                lbcEstadoCuentasBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                lbcEstadoCuentasBean.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                lbcEstadoCuentasBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                lbcEstadoCuentasBean.setMoneda(rs.getString("MONEDA"));
                lbcEstadoCuentasBean.setProducto(rs.getString("PRODUCTO"));

                edoCuentas.add(lbcEstadoCuentasBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return edoCuentas;
    }


}
