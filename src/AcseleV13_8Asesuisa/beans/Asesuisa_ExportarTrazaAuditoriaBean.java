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
 * Created by cortiz on 29/03/2017.
 */
public class Asesuisa_ExportarTrazaAuditoriaBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_ExportarTrazaAuditoriaBean.class);

    private String fechaDesde;
    private String fechaHasta;
    private String tipoDoc;

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }





    public static ArrayList getExportarTrazaAuditoria() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList exportarTrazaAuditoria = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT *  FROM EXPORT_DOCUMENTOS_TRAZA  ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_ExportarTrazaAuditoriaBean exportarTrazaAuditoriaBean = new Asesuisa_ExportarTrazaAuditoriaBean();


                exportarTrazaAuditoriaBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                exportarTrazaAuditoriaBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                exportarTrazaAuditoriaBean.setTipoDoc(rs.getString("TIPODOC"));


                exportarTrazaAuditoria.add(exportarTrazaAuditoriaBean);

            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

        return exportarTrazaAuditoria;

    }
}