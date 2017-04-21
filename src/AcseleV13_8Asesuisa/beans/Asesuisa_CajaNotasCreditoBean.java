package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aandrade on 17/04/2017.
 */
public class Asesuisa_CajaNotasCreditoBean {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaNotasCreditoBean.class);

    private String razon;
    private String generar;
    private String aceptar1;
    private String aceptar2;

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getGenerar() {
        return generar;
    }

    public void setGenerar(String generar) {
        this.generar = generar;
    }

    public String getAceptar1() {
        return aceptar1;
    }

    public void setAceptar1(String aceptar1) {
        this.aceptar1 = aceptar1;
    }

    public String getAceptar2() {
        return aceptar2;
    }

    public void setAceptar2(String aceptar2) {
        this.aceptar2 = aceptar2;
    }

    public static ArrayList getAsesuisa_CajaNotasCredito() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_CAJA_NOTACREDITO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_CajaNotasCreditoBean cajaNotasCreditoBean = new Asesuisa_CajaNotasCreditoBean();

                cajaNotasCreditoBean.setRazon(rs.getString("RAZON"));
                cajaNotasCreditoBean.setGenerar(rs.getString("GENERAR"));
                cajaNotasCreditoBean.setAceptar1(rs.getString("ACEPTAR1"));
                cajaNotasCreditoBean.setAceptar2(rs.getString("ACEPTAR2"));

                caja.add(cajaNotasCreditoBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return caja;
    }
}
