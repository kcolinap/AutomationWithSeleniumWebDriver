package AcseleV13_8_Interseguros.beans;
import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Created by aazuaje on 11/01/2017.
 */
public class INTER_CumuloProductoBean {

    private final static Logger log = Logger.getLogger(INTER_CumuloProductoBean.class);

    private String producto;
    private String moneda;

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getMoneda() {return moneda;}
    public void setMoneda(String moneda) {this.moneda = moneda;}

    public static ArrayList getINTER_CumuloProducto() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interCumuloProducto = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from INTER_CUMULO_PRODUCTO ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_CumuloProductoBean inter_cumuloProductoBean= new INTER_CumuloProductoBean();

                inter_cumuloProductoBean.setProducto(rs.getString("PRODUCTO"));
                inter_cumuloProductoBean.setMoneda(rs.getString("MONEDA"));

                interCumuloProducto.add(inter_cumuloProductoBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interCumuloProducto;

    }


}
