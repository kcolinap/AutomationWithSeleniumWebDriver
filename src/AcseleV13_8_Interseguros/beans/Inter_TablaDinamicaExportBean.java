package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 07/02/2017.
 */
public class Inter_TablaDinamicaExportBean implements Serializable {

    private final static Logger log = Logger.getLogger(Inter_TablaDinamicaExportBean.class);

    private String nombreTablaDinamica;
    private String formato;

    public String getNombreTablaDinamica(){
        return nombreTablaDinamica;
    }

    public void setNombreTablaDinamica(String nombreTablaDinamica){
        this.nombreTablaDinamica = nombreTablaDinamica;
    }

    public String getFormato(){
        return formato;
    }

    public void setFormato(String formato){
        this.formato = formato;
    }

    public static ArrayList getInter_TablaDinamicaExport() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM INTER_TABLA_DINAMICA_EXPORT ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Inter_TablaDinamicaExportBean interExportTablaDinamicaBean = new Inter_TablaDinamicaExportBean();

                interExportTablaDinamicaBean.setNombreTablaDinamica(rs.getString("NOMBRE_TABLA_DINAMICA"));
                interExportTablaDinamicaBean.setFormato(rs.getString("FORMATO"));

                poliza.add(interExportTablaDinamicaBean);
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
