package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aandrade on 06/04/2017.
 */
public class Asesuisa_CajaDosificacionesBean {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaDosificacionesBean.class);

    private String generica;
    private String modfactura;
    private String comtiraje;
    private String anotiraje;
    private String certiraje;
    private String rangodesd;
    private String rangohast;

    public String getGenerica() {
        return generica;
    }

    public void setGenerica(String generica) {
        this.generica = generica;
    }

    public String getModfactura() {
        return modfactura;
    }

    public void setModfactura(String modfactura) {
        this.modfactura = modfactura;
    }

    public String getComtiraje() {
        return comtiraje;
    }

    public void setComtiraje(String comtiraje) {
        this.comtiraje = comtiraje;
    }

    public String getAnotiraje() {
        return anotiraje;
    }

    public void setAnotiraje(String anotiraje) {
        this.anotiraje = anotiraje;
    }

    public String getCertiraje() {
        return certiraje;
    }

    public void setCertiraje(String certiraje) {
        this.certiraje = certiraje;
    }

    public String getRangodesd() {
        return rangodesd;
    }

    public void setRangodesd(String rangodesd) {
        this.rangodesd = rangodesd;
    }

    public String getRangohast() {
        return rangohast;
    }

    public void setRangohast(String rangohast) {
        this.rangohast = rangohast;
    }




    public static ArrayList getAsesuisa_CajaDosificaciones() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_CAJA_DOSIFICACIONES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_CajaDosificacionesBean cajaDosificacionesBean = new Asesuisa_CajaDosificacionesBean();

                cajaDosificacionesBean.setGenerica(rs.getString("GENERICA"));
                cajaDosificacionesBean.setModfactura(rs.getString("MODFACTURA"));
                cajaDosificacionesBean.setComtiraje(rs.getString("COMTIRAJE"));
                cajaDosificacionesBean.setAnotiraje(rs.getString("ANOTIRAJE"));
                cajaDosificacionesBean.setCertiraje(rs.getString("CERTIRAJE"));
                cajaDosificacionesBean.setRangodesd(rs.getString("RANGODESD"));
                cajaDosificacionesBean.setRangohast(rs.getString("RANGOHAST"));

                caja.add(cajaDosificacionesBean);
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
