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

    private String numeroPoliza;
    private String cliente;
    private String asegurado;

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(String asegurado) {
        this.asegurado = asegurado;
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
                Asesuisa_BusquedaSimplePolizaBean bean = new Asesuisa_BusquedaSimplePolizaBean();

                bean.setNumeroPoliza(rs.getString("numeroPoliza"));

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
