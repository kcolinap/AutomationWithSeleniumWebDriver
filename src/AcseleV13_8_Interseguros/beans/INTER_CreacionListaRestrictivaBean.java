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
 * Created by aazuaje on 21/11/2016.
 */
public class INTER_CreacionListaRestrictivaBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_CreacionListaRestrictivaBean.class);

    private String nombrePlantilla;

    public String getNombrePlantilla() {return nombrePlantilla;}
    public void setNombrePlantilla (String nombrePlantilla) {this.nombrePlantilla = nombrePlantilla;}


    public static ArrayList getInterCreacionListaRestrictiva() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interCreacionListaRestrictiva = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,NOMBRE_PLANTILLA FROM INTER_CREAR_LISTA_RESTRICTIVA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_CreacionListaRestrictivaBean inter_creacionListaRestrictivaBean = new INTER_CreacionListaRestrictivaBean();

                inter_creacionListaRestrictivaBean.setNombrePlantilla(rs.getString("NOMBRE_PLANTILLA"));


                interCreacionListaRestrictiva.add(inter_creacionListaRestrictivaBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interCreacionListaRestrictiva;

    }

}
