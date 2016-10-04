package AcseleV13_8.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by kzambrano on 01/09/2016.
 */
public class CreacionListaTemplateBean implements Serializable {

    private final static Logger log = Logger.getLogger(CreacionListaTemplateBean.class);

    private String nombrePlantilla;

    public String getNombrePlantilla() {return nombrePlantilla;}
    public void setNombrePlantilla (String nombrePlantilla) {this.nombrePlantilla = nombrePlantilla;}


    public static ArrayList getCreacionListaTemplate() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList creacionListaTemplate = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NOMBREPLANTILLA FROM LISTAS_RESTRICTIVAS_TEMPLATE ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CreacionListaTemplateBean creacionListaTemplateBean = new CreacionListaTemplateBean();

                creacionListaTemplateBean.setNombrePlantilla(rs.getString("NOMBREPLANTILLA"));


                creacionListaTemplate.add(creacionListaTemplateBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return creacionListaTemplate;

    }


}
