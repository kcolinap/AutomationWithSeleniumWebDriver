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
 * Created by aazuaje on 17/10/2016.
 */
public class LBC_CumulosProductolbcBean implements Serializable{

    private final static Logger log = Logger.getLogger(LBC_CumulosProductolbcBean.class);

    private String producto;
    private String moneda;

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getMoneda() {return moneda;}
    public void setMoneda(String moneda) {this.moneda = moneda;}

    public static ArrayList getCumulosProductosLBC() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList cumulosProductoLBC = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Producto, Moneda FROM CUMULOS_PRODUCTOS_LBC ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_CumulosProductolbcBean lbcCumulosProductolbcBean = new LBC_CumulosProductolbcBean();

                lbcCumulosProductolbcBean.setProducto(rs.getString("PRODUCTO"));
                lbcCumulosProductolbcBean.setMoneda(rs.getString("MONEDA"));

                cumulosProductoLBC.add(lbcCumulosProductolbcBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return cumulosProductoLBC;

    }

}
