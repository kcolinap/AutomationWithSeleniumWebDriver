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
 * Created by kcolina on 29/03/2017.
 */
public class Asesuisa_CancelacionAnulacionPolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_CancelacionAnulacionPolizaBean.class);

    private String nroPoliza;

    public String getNroPoliza() {
        return nroPoliza;
    }

    public void setNroPoliza(String nroPoliza) {
        this.nroPoliza = nroPoliza;
    }

    public static ArrayList getCancelacionAnulacionPoliza() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList cancelacionAnulacionPoliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from ASE_CANCEL_ANULA_POLIZA order by PRUEBA ASC ");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                Asesuisa_CancelacionAnulacionPolizaBean asesuisaCancelacionAnulacionPolizaBean = new Asesuisa_CancelacionAnulacionPolizaBean();

                asesuisaCancelacionAnulacionPolizaBean.setNroPoliza(rs.getString("NROPOLIZA"));


                cancelacionAnulacionPoliza.add(asesuisaCancelacionAnulacionPolizaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return cancelacionAnulacionPoliza;
    }
}
