package AcseleV13_8_Alfa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by rmontilla on 19/09/2016.
 */
public class AjustesReservasSiniestrosBean implements Serializable {
    private final static Logger log = Logger.getLogger(AjustesReservasSiniestrosBean.class);

    private String ordenarPor;
    private String numSiniestro;
    private String fechaOcurrenciaSiniestro;
    private String producto;
    private String numPoliza;
    private String tipoAjuste;
    private String razonAjuste;
    private String montoAjuste;

    public String getOrdenarPor() {
        return ordenarPor;
    }

    public void setOrdenarPor(String ordenarPor) {
        this.ordenarPor = ordenarPor;
    }

    public String getNumSiniestro() {
        return numSiniestro;
    }

    public void setNumSiniestro(String numSiniestro) {
        this.numSiniestro = numSiniestro;
    }

    public String getFechaOcurrenciaSiniestro() {
        return fechaOcurrenciaSiniestro;
    }

    public void setFechaOcurrenciaSiniestro(String fechaOcurrenciaSiniestro) {
        this.fechaOcurrenciaSiniestro = fechaOcurrenciaSiniestro;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getTipoAjuste() {
        return tipoAjuste;
    }

    public void setTipoAjuste(String tipoAjuste) {
        this.tipoAjuste = tipoAjuste;
    }

    public String getRazonAjuste() {
        return razonAjuste;
    }

    public void setRazonAjuste(String razonAjuste) {
        this.razonAjuste = razonAjuste;
    }

    public String getMontoAjuste() {
        return montoAjuste;
    }

    public void setMontoAjuste(String montoAjuste) {
        this.montoAjuste = montoAjuste;
    }

    public static ArrayList getAjustesReservasSiniestros() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList ordenes = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM AJUSTES_RESERVAS_SINIESTROS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                AjustesReservasSiniestrosBean ajustesReservasSiniestrosBean = new AjustesReservasSiniestrosBean();

                ajustesReservasSiniestrosBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                ajustesReservasSiniestrosBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                ajustesReservasSiniestrosBean.setNumSiniestro(rs.getString("NUM_SINIESTRO"));
                ajustesReservasSiniestrosBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                ajustesReservasSiniestrosBean.setProducto(rs.getString("PRODUCTO"));
                ajustesReservasSiniestrosBean.setTipoAjuste(rs.getString("TIPO_AJUSTE"));
                ajustesReservasSiniestrosBean.setRazonAjuste(rs.getString("RAZON_AJUSTE"));
                ajustesReservasSiniestrosBean.setMontoAjuste(rs.getString("MONTO_AJUSTE"));

                ordenes.add(ajustesReservasSiniestrosBean);
            }
        }catch(SQLException e){
            log.error(e);
        }
        finally{
            if (conn != null){
                conn.close();
            }
        }
        return ordenes;
    }
}
