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
 * Created by aazuaje on 17/08/2016.
 */
public class CumulosProductosBean implements Serializable {

    private final static Logger log = Logger.getLogger(CumulosProductosBean.class);

    private String producto;
    private String moneda;

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getMoneda() {return moneda;}
    public void setMoneda(String moneda) {this.moneda = moneda;}

    public static ArrayList getCumulosProductos() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList cumulosProductos = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Producto, Moneda FROM CUMULOS_PRODUCTOS ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CumulosProductosBean cumulosProductosBean = new CumulosProductosBean();

                cumulosProductosBean.setProducto(rs.getString("PRODUCTO"));
                cumulosProductosBean.setMoneda(rs.getString("MONEDA"));

                cumulosProductos.add(cumulosProductosBean);

        }

    }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return cumulosProductos;

    }
}