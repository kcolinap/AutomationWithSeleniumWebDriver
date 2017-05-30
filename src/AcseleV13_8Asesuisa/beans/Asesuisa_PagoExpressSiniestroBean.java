package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by cortiz on 09/05/2017.
 */
public class Asesuisa_PagoExpressSiniestroBean extends Asesuisa_SiniestroBean{

    private final static Logger log = Logger.getLogger(Asesuisa_PagoExpressSiniestroBean.class);


    private String NSINIESTRO;
    private String PRODUCTO;
    private String RAZON;
    private String MONTO;
    private String ACCION;
    private String BANDERA;


    public String getNSINIESTRO() {
        return NSINIESTRO;
    }

    public void setNSINIESTRO(String NSINIESTRO) {
        this.NSINIESTRO = NSINIESTRO;
    }

    public String getPRODUCTO() {
        return PRODUCTO;
    }

    public void setPRODUCTO(String PRODUCTO) {
        this.PRODUCTO = PRODUCTO;
    }

    public String getRAZON() {
        return RAZON;
    }

    public void setRAZON(String RAZON) {
        this.RAZON = RAZON;
    }

    public String getMONTO() {
        return MONTO;
    }

    public void setMONTO(String MONTO) {
        this.MONTO = MONTO;
    }

    public String getACCION() {
        return ACCION;
    }

    public void setACCION(String ACCION) {
        this.ACCION = ACCION;
    }

    public String getBANDERA() {
        return BANDERA;
    }

    public void setBANDERA(String BANDERA) {
        this.BANDERA = BANDERA;
    }

    public static ArrayList getPagoSiniestroBean() throws SQLException {
    Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList pagoSiniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_SINIESTRO_PAGOEXPRESS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){
                Asesuisa_PagoExpressSiniestroBean bean = new Asesuisa_PagoExpressSiniestroBean();

                bean.setNSINIESTRO(rs.getString("NSINIESTRO"));
                bean.setPRODUCTO(rs.getString("PRODUCTO"));
                bean.setRAZON(rs.getString("RAZON"));
                bean.setMONTO(rs.getString("MONTO"));
                bean.setACCION(rs.getString("ACCION"));
                bean.setBANDERA(rs.getString("BANDERA"));

                pagoSiniestro.add(bean);
            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return pagoSiniestro;
    }

}
