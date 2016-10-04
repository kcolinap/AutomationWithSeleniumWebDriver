package AcseleV13_8.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 13/08/2016.
 */
public class ImportExportTablasDinamicasBean implements Serializable {

    private final static Logger log = Logger.getLogger(EmisionPolizaAseguradoVidaBean.class);

    // , NOMBRE_TABLA_DINAMICA, FORMATO, RUTA_TABLA_DINAMICA
    private String nombreTablaDinamica;
    private String formato;
    private String rutaTablaDinamica;

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

    public String getRutaTablaDinamica(){
        return rutaTablaDinamica;
    }
    public void setRutaTablaDinamica(String rutaTablaDinamica){
        this.rutaTablaDinamica = rutaTablaDinamica;
    }


    public static ArrayList getImportExportTablasDinamicas() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tablas = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NOMBRE_TABLA_DINAMICA, FORMATO, RUTA_TABLA_DINAMICA FROM IMPORT_EXPORT_TABLA_DINAMICA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ImportExportTablasDinamicasBean importExportTablasDinamicasBean = new ImportExportTablasDinamicasBean();

                importExportTablasDinamicasBean.setNombreTablaDinamica(rs.getString("NOMBRE_TABLA_DINAMICA"));
                importExportTablasDinamicasBean.setFormato(rs.getString("FORMATO"));
                importExportTablasDinamicasBean.setRutaTablaDinamica(rs.getString("RUTA_TABLA_DINAMICA"));

                tablas.add(importExportTablasDinamicasBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }

        return tablas;

    }
}
