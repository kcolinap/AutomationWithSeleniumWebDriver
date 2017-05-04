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
 * Created by cortiz on 01/04/2017.
 */
public class Asesuisa_ManteSiniestroBean extends Asesuisa_SiniestroBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_ManteSiniestroBean.class);

    private String ID;
    private String NSINIESTRO;
    private String NPOLIZA;
    private String FOCURRENCIA;
    private String PRODUCTO;
    private String FOPERACION;
    private String MRECHAZOCIERRE;
    private String CCOMENTARIO;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNSINIESTRO() {
        return NSINIESTRO;
    }

    public void setNSINIESTRO(String NSINIESTRO) {
        this.NSINIESTRO = NSINIESTRO;
    }

    public String getNPOLIZA() {
        return NPOLIZA;
    }

    public void setNPOLIZA(String NPOLIZA) {
        this.NPOLIZA = NPOLIZA;
    }

    public String getFOCURRENCIA() {
        return FOCURRENCIA;
    }

    public void setFOCURRENCIA(String FOCURRENCIA) {
        this.FOCURRENCIA = FOCURRENCIA;
    }

    public String getPRODUCTO() {
        return PRODUCTO;
    }

    public void setPRODUCTO(String PRODUCTO) {
        this.PRODUCTO = PRODUCTO;
    }

    public String getFOPERACION() {
        return FOPERACION;
    }

    public void setFOPERACION(String FOPERACION) {
        this.FOPERACION = FOPERACION;
    }

    public String getMRECHAZOCIERRE() {
        return MRECHAZOCIERRE;
    }

    public void setMRECHAZOCIERRE(String MRECHAZOCIERRE) {
        this.MRECHAZOCIERRE = MRECHAZOCIERRE;
    }

    public String getCCOMENTARIO() {
        return CCOMENTARIO;
    }

    public void setCCOMENTARIO(String CCOMENTARIO) {
        this.CCOMENTARIO = CCOMENTARIO;
    }

    public static ArrayList getAsesuisa_siniestro() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList siniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_MANTENIMIENTOSIN ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_ManteSiniestroBean siniestroBean = new Asesuisa_ManteSiniestroBean();

                siniestroBean.setNSINIESTRO(rs.getString("NSINIESTRO"));
                siniestroBean.setNPOLIZA(rs.getString("NPOLIZA"));
                siniestroBean.setFOCURRENCIA(rs.getString("FOCURRENCIA"));
                siniestroBean.setPRODUCTO(rs.getString("PRODUCTO"));
                siniestroBean.setFOPERACION(rs.getString("FOPERACION"));
                siniestroBean.setMRECHAZOCIERRE(rs.getString("MRECHAZOCIERRE"));
                siniestroBean.setCCOMENTARIO(rs.getString("CCOMENTARIO"));


                siniestro.add(siniestroBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return siniestro;
    }
}
