package AcseleV13_8.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by rmontilla on 14/09/2016.
 */
public class ConsultasOrdenesPagoBean implements Serializable {

    private final static Logger log = Logger.getLogger(ConsultasOrdenesPagoBean.class);

    private String ordenarPor;
    private String numSiniestro;
    private String fechaOcurrenciaSiniestro;
    private String producto;
    private String numPoliza;

    public String getOrdenarPor() {
        return ordenarPor;
    }
    public void setOrdenarPor(String ordenarPor) {
        this.ordenarPor = ordenarPor;
    }
    public String getNumPoliza() {
        return numPoliza;
    }
    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
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


    public static ArrayList getConsultaOrdenesPago() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList ordenes = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM CONSULTAS_ORDENES_PAGO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ConsultasOrdenesPagoBean consultasOrdenesPagoBean = new ConsultasOrdenesPagoBean();

                consultasOrdenesPagoBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                consultasOrdenesPagoBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                consultasOrdenesPagoBean.setNumSiniestro(rs.getString("NUM_SINIESTRO"));
                consultasOrdenesPagoBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                consultasOrdenesPagoBean.setProducto(rs.getString("PRODUCTO"));

                ordenes.add(consultasOrdenesPagoBean);
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
