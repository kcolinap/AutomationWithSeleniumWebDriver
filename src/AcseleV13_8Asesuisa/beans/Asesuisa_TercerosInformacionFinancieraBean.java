package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by cortiz on 26/04/2017.
 */
public class Asesuisa_TercerosInformacionFinancieraBean extends Asesuisa_TercerosBean {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosInformacionFinancieraBean.class);

    private String activos;
    private String paslargoplazo;
    private String reservadecap;
    private String giro;
    private String activosF;
    private String pasivosc;
    private String capitalp;
    private String superavit;
    private String nit;


    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getActivos() {
        return activos;
    }

    public void setActivos(String activos) {
        this.activos = activos;
    }

    public String getPaslargoplazo() {
        return paslargoplazo;
    }

    public void setPaslargoplazo(String paslargoplazo) {
        this.paslargoplazo = paslargoplazo;
    }

    public String getReservadecap() {
        return reservadecap;
    }

    public void setReservadecap(String reservadecap) {
        this.reservadecap = reservadecap;
    }

    public String getActivosF() {
        return activosF;
    }

    public void setActivosF(String activosF) {
        this.activosF = activosF;
    }

    public String getPasivosc() {
        return pasivosc;
    }

    public void setPasivosc(String pasivosc) {
        this.pasivosc = pasivosc;
    }

    public String getCapitalp() {
        return capitalp;
    }

    public void setCapitalp(String capitalp) {
        this.capitalp = capitalp;
    }

    public String getSuperavit() {
        return superavit;
    }

    public void setSuperavit(String superavit) {
        this.superavit = superavit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }



    public static ArrayList getTercerosInformacionFinancieraBean() throws SQLException{

        Connection conexion = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaTercerosInformacionFinanciera = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_TERCEROS_INFFIN ORDER BY prueba ASC");

        try {
            conexion = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){
                Asesuisa_TercerosInformacionFinancieraBean asesuisaTercerosInformacionFinanciBean = new Asesuisa_TercerosInformacionFinancieraBean();

                asesuisaTercerosInformacionFinanciBean.setActivos(rs.getString("ACTIVOS"));
                asesuisaTercerosInformacionFinanciBean.setPaslargoplazo(rs.getString("PASLARGOPLAZO"));
                asesuisaTercerosInformacionFinanciBean.setReservadecap(rs.getString("RESERVADECAP"));
                asesuisaTercerosInformacionFinanciBean.setGiro(rs.getString("GIRO"));
                asesuisaTercerosInformacionFinanciBean.setActivosF(rs.getString("ACTIVOSF"));
                asesuisaTercerosInformacionFinanciBean.setPasivosc(rs.getString("PASIVOSC"));
                asesuisaTercerosInformacionFinanciBean.setCapitalp(rs.getString("CAPITALP"));
                asesuisaTercerosInformacionFinanciBean.setSuperavit(rs.getString("SUPERAVIT"));
                asesuisaTercerosInformacionFinanciBean.setNit(rs.getString("NIT"));




                asesuisaTercerosInformacionFinanciera.add(asesuisaTercerosInformacionFinanciBean);
            }
        }catch (Exception e){
            log.error(e);
        }finally {
            if (conexion != null){
                conexion.close();
            }
        }

        return asesuisaTercerosInformacionFinanciera;
    }
}
