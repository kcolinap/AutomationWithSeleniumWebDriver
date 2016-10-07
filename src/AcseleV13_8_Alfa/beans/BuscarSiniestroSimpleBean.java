package AcseleV13_8_Alfa.beans;


import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 09/08/2016.
 */
public class BuscarSiniestroSimpleBean {

    private final static Logger log = Logger.getLogger(BuscarSiniestroSimpleBean.class);

    private String ordenar;
    private String numSiniestro;
    private String numPoliza;
    private String ocurrencia;
    private String producto;

    public String getOrdenar() {
        return ordenar;
    }
    public void setOrdenar(String ordenar) {
        this.ordenar = ordenar;
    }

    public String getNumSiniestro(){
        return numSiniestro;
    }
    public void setNumSiniestro(String numSiniestro){
        this.numSiniestro = numSiniestro;
    }

    public String getNumPoliza(){
        return numPoliza;
    }
    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getOcurrencia(){
        return ocurrencia;
    }
    public void setOcurrencia(String ocurrencia) {
        this.ocurrencia = ocurrencia;
    }

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;
    }

    public static ArrayList getBuscarSiniestroSimple() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA,ORDEN,NUM_SINIESTRO,NUM_POLIZA,FECHA,PRODUCTO FROM BUSCAR_SINIESTRO_SIMPLE ORDER BY PRUEBA ASC");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                BuscarSiniestroSimpleBean buscarSiniestroSimpleBean = new BuscarSiniestroSimpleBean();
                buscarSiniestroSimpleBean.setOrdenar(rs.getString("ORDEN"));
                buscarSiniestroSimpleBean.setNumSiniestro(rs.getString("NUM_SINIESTRO"));
                buscarSiniestroSimpleBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                buscarSiniestroSimpleBean.setOcurrencia(rs.getString("FECHA"));
                buscarSiniestroSimpleBean.setProducto(rs.getString("PRODUCTO"));
                caja.add(buscarSiniestroSimpleBean);
            }

        }catch(SQLException e){

            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return caja;
    }
}
