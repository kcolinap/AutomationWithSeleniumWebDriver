package AcseleV13_8LBC.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by rmontilla on 03/11/2016.
 */
public class LBC_RevisionTransformadoresBean implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_RevisionTransformadoresBean.class);

    private String buscar;

    public String getBuscar() {return buscar;}
    public void setBuscar (String buscar) {this.buscar = buscar;}


    public static ArrayList getLBC_RevisionTransformadores() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList lbc_RevisionTransformadores = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM LBC_REVISION_TRANSFORMADORES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_RevisionTransformadoresBean lbc_RevisionTransformadoresBean = new LBC_RevisionTransformadoresBean();

                lbc_RevisionTransformadoresBean.setBuscar(rs.getString("BUSCAR"));

                lbc_RevisionTransformadores.add(lbc_RevisionTransformadoresBean);


            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return lbc_RevisionTransformadores;
    }

}
