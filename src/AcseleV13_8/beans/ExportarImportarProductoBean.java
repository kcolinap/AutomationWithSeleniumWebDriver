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
 * Created by kzambrano on 17/08/2016.
 */
public class ExportarImportarProductoBean implements Serializable{

    private final static Logger log = Logger.getLogger(ExportarImportarProductoBean.class);

    private String ruta;

    public String getRuta() {return ruta;}
    public void setRuta(String ruta){this.ruta = ruta;}


    public static ArrayList getExportarImportarProducto() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList exportarImportarProducto = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, RUTA FROM EXPORTAR_IMPORTAR_PRODUCTO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());


            while (rs.next()) {
                ExportarImportarProductoBean exportarImportarProductoBean = new ExportarImportarProductoBean();

                exportarImportarProductoBean.setRuta(rs.getString("RUTA"));


                exportarImportarProducto.add(exportarImportarProductoBean); }


        }catch(SQLException e){
           log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return exportarImportarProducto;

    }

}
