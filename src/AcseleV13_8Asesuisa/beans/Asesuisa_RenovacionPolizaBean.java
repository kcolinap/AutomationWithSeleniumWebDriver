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
 * Created by kcolina on 10/04/2017.
 */
public class Asesuisa_RenovacionPolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_RenovacionPolizaBean.class);

    private String nroPoliza;

    public String getNroPoliza() {
        return nroPoliza;
    }

    public void setNroPoliza(String nroPoliza) {
        this.nroPoliza = nroPoliza;
    }

    public static ArrayList getRenovacionPoliza() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList renovacionPoliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from ASE_RENOVACION_POLIZA order by PRUEBA ASC ");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){
                Asesuisa_RenovacionPolizaBean bean = new Asesuisa_RenovacionPolizaBean();

                bean.setNroPoliza(rs.getString("NROPOLIZA"));

                renovacionPoliza.add(bean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }

        return renovacionPoliza;
    }
}
