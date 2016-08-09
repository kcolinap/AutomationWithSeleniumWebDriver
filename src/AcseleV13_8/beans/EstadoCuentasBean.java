package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by agil on 27/05/2016.
 */
public class EstadoCuentasBean implements Serializable {

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



    public static EstadoCuentasBean getEstadoCuentas(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        EstadoCuentasBean estadoCuentasBean = null;

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, TIPO_TERCERO, NUM_DOCUMENTO_IDENTIFICACION, PRIMER_NOMBRE, PRIMER_APELLIDO, NUM_POLIZA, MONEDA, PRODUCTO FROM ESTADO_CUENTA");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                estadoCuentasBean = new EstadoCuentasBean();
                estadoCuentasBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                estadoCuentasBean.setNumDocIdentificacion(rs.getString("NUM_DOCUMENTO_IDENTIFICACION"));
                estadoCuentasBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                estadoCuentasBean.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                estadoCuentasBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                estadoCuentasBean.setMoneda(rs.getString("MONEDA"));
                estadoCuentasBean.setProducto(rs.getString("PRODUCTO"));
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return estadoCuentasBean;
    }

}
