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
public class Inter_TablaDinamicaImportBean implements Serializable {

    private final static Logger log = Logger.getLogger(Inter_TablaDinamicaImportBean.class);

    private String nombreTablaDinamica;
    private String rutaArchivo;

    public String getNombreTablaDinamica(){
        return nombreTablaDinamica;
    }

    public void setNombreTablaDinamica(String nombreTablaDinamica){
        this.nombreTablaDinamica = nombreTablaDinamica;
    }

    public String getRutaArchivo(){
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo){
        this.rutaArchivo = rutaArchivo;
    }

    public static ArrayList getInter_TablaDinamicaImport() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM INTER_TABLA_DINAMICA_IMPORT ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Inter_TablaDinamicaImportBean interImportTablaDinamicaBean = new Inter_TablaDinamicaImportBean();

                interImportTablaDinamicaBean.setNombreTablaDinamica(rs.getString("NOMBRE_TABLA_DINAMICA"));
                interImportTablaDinamicaBean.setRutaArchivo(rs.getString("RUTA_ARCHIVO"));

                poliza.add(interImportTablaDinamicaBean);
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
