package AcseleV13_8Asesuisa.beans;

/**
 * Created by kcolina on 22/05/2017.
 */

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Asesuisa_TablaDinamicaExportBean implements Serializable{

    private final static Logger log = Logger.getLogger(Asesuisa_TablaDinamicaExportBean.class);

    private String nombreTablaDinamica;
    private String formato;

    public String getNombreTablaDinamica() {
        return nombreTablaDinamica;
    }

    public void setNombreTablaDinamica(String nombreTablaDinamica) {
        this.nombreTablaDinamica = nombreTablaDinamica;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public static ArrayList getTablaDinamicaExport() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tablaDinamicaExport = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_TDINAMICA_EXPORT ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                Asesuisa_TablaDinamicaExportBean bean = new Asesuisa_TablaDinamicaExportBean();

                bean.setNombreTablaDinamica(rs.getString("NTABLA_DINAMICA"));
                bean.setFormato(rs.getString("FORMATO"));

                tablaDinamicaExport.add(bean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return tablaDinamicaExport;
    }
}
