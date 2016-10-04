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
 * Created by aazuaje on 03/10/2016.
 */
public class ValidacionSimbolosBean implements Serializable{

    private final static Logger log = Logger.getLogger(ValidacionSimbolosBean.class);

    private String producto;


    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}


    public static ArrayList getValidarSimbolos() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList validarSimbolos = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select PRUEBA,PRODUCTO from VALIDACION_SIMBOLOS ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ValidacionSimbolosBean validacionSimbolosBean = new ValidacionSimbolosBean();

                validacionSimbolosBean.setProducto(rs.getString("PRODUCTO"));

                validarSimbolos.add(validacionSimbolosBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return validarSimbolos;

    }




}
