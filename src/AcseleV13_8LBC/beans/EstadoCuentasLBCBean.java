package AcseleV13_8LBC.beans;

import AcseleV13_8LBC.main.controller.EstadoCuentasLBC;
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
public class EstadoCuentasLBCBean implements Serializable {

    private final static Logger log = Logger.getLogger(EstadoCuentasLBCBean.class);

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

    public static ArrayList getEstadoCuentasLBC() throws SQLException {

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
                EstadoCuentasLBCBean estadoCuentasLBCBean = new EstadoCuentasLBCBean();

                estadoCuentasLBCBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                estadoCuentasLBCBean.setNumDocIdentificacion(rs.getString("NUM_DOCUMENTO_IDENTIFICACION"));
                estadoCuentasLBCBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                estadoCuentasLBCBean.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                estadoCuentasLBCBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                estadoCuentasLBCBean.setMoneda(rs.getString("MONEDA"));
                estadoCuentasLBCBean.setProducto(rs.getString("PRODUCTO"));

                edoCuentas.add(estadoCuentasLBCBean);
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
