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
 * Created by agil on 20/04/2017.
 */
public class Asesuisa_TercerosDocumentosBean extends Asesuisa_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosDocumentosBean.class);

    private String tipoDocumento;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public static ArrayList getAsesuisa_TercerosDocumentos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tercero = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_TERCERO_DOCUMENTO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_TercerosDocumentosBean bean = new Asesuisa_TercerosDocumentosBean();

                bean.setNumeroNIT(rs.getString("TERCERO_NIT"));
                bean.setDescripcion(rs.getString("DESCRIPCION"));
                bean.setTipoDocumento(rs.getString("TIPO_DOCUMENTO"));

                tercero.add(bean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return tercero;
    }
}
