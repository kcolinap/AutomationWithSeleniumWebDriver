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
    private String accion;
    private String montosini;
    private String tercero;
    private String numSiniestro;

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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
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

    public String getNumSiniestro() {
        return numSiniestro;
    }

    public void setNumSiniestro(String numSiniestro) {
        this.numSiniestro = numSiniestro;
    }

    public static ArrayList getAsesuisa_SiniestrosPagos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        Statement stmt2;
        ResultSet rs;
        ResultSet rs2;
        ArrayList siniestroPago = new ArrayList();
        String    siniNumero=null;


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_SINIESTROS_PAGOS ORDER BY PRUEBA ASC");
        conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();

        // Busca el numero de un nuevo siniestro en la tabla ASESUISA_SINIESTROS_NUMERO
        try{
            stmt2 = conn.createStatement();
            rs2 = stmt2.executeQuery("SELECT * FROM ASESUISA_SINIESTROS_NUMERO WHERE PRUEBA =1");
            rs2.next();
            siniNumero = rs2.getString("NUMSINIESTRO");
            System.out.println("Numero de Siniestro:  " + siniNumero);
        }catch(SQLException ex){System.out.println(ex);}

        try {
            //conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_SiniestrosPagosBean siniestrosPagosBean = new Asesuisa_SiniestrosPagosBean();

                siniestrosPagosBean.setSiniestro(rs.getString("SINIESTRO"));
                siniestrosPagosBean.setPagomax(rs.getString("PAGOMAX"));
                siniestrosPagosBean.setAccion(rs.getString("ACCION"));
                siniestrosPagosBean.setMontosini(rs.getString("MONTOSINI"));
                siniestrosPagosBean.setTercero(rs.getString("TERCERO"));
                siniestrosPagosBean.setNumSiniestro(siniNumero);

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
