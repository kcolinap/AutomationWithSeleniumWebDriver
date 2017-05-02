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
 * Created by kcolina on 30/04/2017.
 */
public class Asesuisa_SiniestroCrearBean extends Asesuisa_SiniestroBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroCrearBean.class);

    public static ArrayList getSiniestroCrearBean() throws SQLException {


        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList creacionSiniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM Asesuisa_Siniestro_Crear ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){
                Asesuisa_SiniestroCrearBean bean = new Asesuisa_SiniestroCrearBean();

                bean.setOrdenarPor(rs.getString("ORDENARPOR"));
                bean.setNroPoliza(rs.getString("NROPOLIZA"));
                bean.setSucursal(rs.getString("SUCURSAL"));
                bean.setEventoSiniestro(rs.getString("EVENTO"));
                bean.setFechaNotificacion(rs.getString("FECHA_NOTIFICACION"));
                bean.setFechaOcurrencia(rs.getString("FECHAOCURRENCIA"));

                creacionSiniestro.add(bean);
            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return creacionSiniestro;
    }

}
