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
 * Created by agil on 16/09/2016.
 */
public class ImpresionDocumentosNivelPólizaBean extends PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(ImpresionDocumentosNivelPólizaBean.class);

    public static ArrayList getImpresionDocNivelPoliza() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList impDocPoliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                PolizaBean polizaBean = new PolizaBean();

                PolizaBean.set(rs.getString(""));
                PolizaBean.set(rs.getString(""));
                PolizaBean.set(rs.getString(""));
                PolizaBean.set(rs.getString(""));
                PolizaBean.set(rs.getString(""));
                impDocPoliza.add(PolizaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }
        finally{
            if (conn != null){
                conn.close();
            }
        }
        return impDocPoliza;
    }

}
