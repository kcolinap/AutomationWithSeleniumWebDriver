package AcseleV13_8_Rimac.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 20/03/2017.
 */
public class Rimac_ImportProductoBean implements Serializable {

    private final static Logger log = Logger.getLogger(Rimac_ImportProductoBean.class);

    private String producto;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public static ArrayList getRimac_ImportProducto() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList producto = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Rimac_ImportProductoBean importProductoBean = new Rimac_ImportProductoBean();

                importProductoBean.setProducto(rs.getString(""));

                producto.add(importProductoBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return producto;
    }
}
