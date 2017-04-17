package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aandrade on 06/04/2017.
 */
public class Asesuisa_CajaModalidadesBean {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaModalidadesBean.class);

    private String modalidad;
    private String plantilla;

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(String plantilla) {
        this.plantilla = plantilla;
    }


    public static ArrayList getAsesuisa_CajaModalidades() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_CAJA_MODALIDADES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_CajaModalidadesBean cajaModalidadesBean = new Asesuisa_CajaModalidadesBean();

                cajaModalidadesBean.setModalidad(rs.getString("MODALIDAD"));
                cajaModalidadesBean.setPlantilla(rs.getString("PLANTILLA"));

                caja.add(cajaModalidadesBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return caja;
    }

}
