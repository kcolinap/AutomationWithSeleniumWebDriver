package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 27/03/2017.
 */
public class Asesuisa_BusquedaAvanzadaPolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_BusquedaAvanzadaPolizaBean.class);

    private String tipoProducto;
    private String numeroPoliza;
    private String estadoCicloVida;
    private String fechaEmision;

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getEstadoCicloVida() {
        return estadoCicloVida;
    }

    public void setEstadoCicloVida(String estadoCicloVida) {
        this.estadoCicloVida = estadoCicloVida;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public static ArrayList getAsesuisa_BusquedaAvanzadaPoliza() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASE_BUSQUEDA_AVANZADA_POLIZA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_BusquedaAvanzadaPolizaBean bean = new Asesuisa_BusquedaAvanzadaPolizaBean();

                bean.setTipoProducto(rs.getString("TIPO_PRODUCTO"));
                bean.setEstadoCicloVida(rs.getString("ESTADO_CICLO_VIDA"));
                bean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                bean.setFechaEmision(rs.getString("FECHA_EMISION"));

                poliza.add(bean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return poliza;
    }
}
