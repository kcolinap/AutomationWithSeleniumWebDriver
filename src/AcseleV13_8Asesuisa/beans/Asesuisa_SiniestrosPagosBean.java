package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aandrade on 13/05/2017.
 */
public class Asesuisa_SiniestrosPagosBean {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestrosPagosBean.class);

    private String siniestro;
    private String pagomax;
    private String cobertura;
    private String montosini;
    private String tercero;

    public String getSiniestro() {
        return siniestro;
    }

    public void setSiniestro(String siniestro) {
        this.siniestro = siniestro;
    }

    public String getPagomax() {
        return pagomax;
    }

    public void setPagomax(String pagomax) {
        this.pagomax = pagomax;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getMontosini() {
        return montosini;
    }

    public void setMontosini(String montosini) {
        this.montosini = montosini;
    }

    public String getTercero() {
        return tercero;
    }

    public void setTercero(String tercero) {
        this.tercero = tercero;
    }



    public static ArrayList getAsesuisa_SiniestrosPagos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList siniestroPago = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_SINIESTROS_PAGOS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_SiniestrosPagosBean siniestrosPagosBean = new Asesuisa_SiniestrosPagosBean();

                siniestrosPagosBean.setSiniestro(rs.getString("SINIESTRO"));
                siniestrosPagosBean.setPagomax(rs.getString("PAGOMAX"));
                siniestrosPagosBean.setCobertura(rs.getString("COBERTURA"));
                siniestrosPagosBean.setMontosini(rs.getString("MONTOSINI"));
                siniestrosPagosBean.setTercero(rs.getString("TERCERO"));

                siniestroPago.add(siniestrosPagosBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return siniestroPago;
    }

}
