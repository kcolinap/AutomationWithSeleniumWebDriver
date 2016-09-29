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
 * Created by kzambrano on 23/09/2016.
 */
public class TrazaAuditoriaExportarBean implements Serializable{

    private final static Logger log = Logger.getLogger(TransformadoresBean.class);

    private String fecha_Desde;
    private String fecha_Hasta;

    public String getFecha_Desde() {return fecha_Desde;}
    public void setFecha_Desde(String fecha_Desde) {this.fecha_Desde = fecha_Desde;}


    public String getFecha_Hasta() {return fecha_Hasta;}
    public void setFecha_Hasta(String fecha_Hasta) {this.fecha_Hasta = fecha_Hasta;}


    public static ArrayList getTrazaAuditoriaExportar() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList trazaAuditoriaExportar = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, Fecha_Desde, Fecha_hasta FROM Export_Documentos_Traza ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TrazaAuditoriaExportarBean trazaAuditoriaExportarBean = new TrazaAuditoriaExportarBean();


                trazaAuditoriaExportarBean.setFecha_Desde(rs.getString("Fecha_Desde"));
                trazaAuditoriaExportarBean.setFecha_Hasta(rs.getString("Fecha_hasta"));



                trazaAuditoriaExportar.add(trazaAuditoriaExportarBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return trazaAuditoriaExportar;

    }






}
