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
 * Created by kcolina on 05/05/2017.
 */
public class Asesuisa_CoberturasSiniestroBean extends Asesuisa_SiniestroBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_CoberturasSiniestroBean.class);

    public static ArrayList getCoberturasSiniestro() throws SQLException{
        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList coberturasSiniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from ASESUISA_COBERTURA_SINIESTRO order by PRUEBA ASC ");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                Asesuisa_CoberturasSiniestroBean bean = new Asesuisa_CoberturasSiniestroBean();

                bean.setNroPoliza(rs.getString("NROPOLIZA"));
                bean.setNroSiniestro(rs.getString("NROSINIESTRO"));
                bean.setFechaOcurrencia(rs.getString("FECHAOCURRENCIA"));
                bean.setProducto(rs.getString("PRODUCTO"));

                coberturasSiniestro.add(bean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return coberturasSiniestro;
    }

}
