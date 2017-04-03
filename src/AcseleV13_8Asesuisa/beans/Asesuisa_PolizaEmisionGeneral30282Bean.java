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
 * Created by kcolina on 03/04/2017.
 */
public class Asesuisa_PolizaEmisionGeneral30282Bean extends Asesuisa_PolizasBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionGeneral30282Bean.class);



    public static ArrayList getAsesuisaPolizaEmisionGeneral30282() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASE_POLIZAEMISION_30282 ORDER BY PRUEBA ASC");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_PolizaEmisionGeneral30282Bean bean = new Asesuisa_PolizaEmisionGeneral30282Bean();

                bean.setProducto(rs.getString("Producto"));
                bean.setVigencia(rs.getString("vigencia"));
                bean.setFechaDesde(rs.getString("fechaDesde"));
                bean.setFechaHasta(rs.getString("fechaHasta"));
                bean.setEventoAplicar(rs.getString("eventoAplicar"));
                bean.setFechaMovimiento(rs.getString("fechaMovimiento"));

                poliza.add(bean);
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
