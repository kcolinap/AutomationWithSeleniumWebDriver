package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 23/01/2017.
 */
public class INTER_BusquedaSiniestroSimpleBean {

    private final static Logger log = Logger.getLogger(INTER_BusquedaSiniestroSimpleBean.class);

    private String ordenarPor;
    private String numeroSiniestro;
    private String numeroPoliza;
    private String fechaOcurrenciaSin;
    private String producto;


    public String getOrdenarPor() {return ordenarPor;}
    public void setOrdenarPor(String ordenarPor) {this.ordenarPor = ordenarPor;}

    public String getNumeroSiniestro() {return numeroSiniestro;}
    public void setNumeroSiniestro(String numeroSiniestro) {this.numeroSiniestro = numeroSiniestro;}

    public String getNumeroPoliza() {return numeroPoliza;}
    public void setNumeroPoliza(String numeroPoliza) {this.numeroPoliza = numeroPoliza;}

    public String getFechaOcurrenciaSin() {return fechaOcurrenciaSin;}
    public void setFechaOcurrenciaSin(String fechaOcurrenciaSin) {this.fechaOcurrenciaSin = fechaOcurrenciaSin;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}


    public static ArrayList getINTER_BusquedaSiniestroSimple() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interBusquedaSiniestroSimple = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,numero_Siniestro, numero_Poliza, fecha_Ocurrencia_Sin, producto, ordenar_Por FROM INTER_BUSQUEDA_SIN_SIMPLE ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_BusquedaSiniestroSimpleBean inter_busquedaSiniestroSimpleBean= new INTER_BusquedaSiniestroSimpleBean();

                inter_busquedaSiniestroSimpleBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_busquedaSiniestroSimpleBean.setNumeroSiniestro(rs.getString("NUMERO_SINIESTRO"));
                inter_busquedaSiniestroSimpleBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                inter_busquedaSiniestroSimpleBean.setFechaOcurrenciaSin(rs.getString("NUMERO_POLIZA"));
                inter_busquedaSiniestroSimpleBean.setProducto(rs.getString("PRODUCTO"));



                interBusquedaSiniestroSimple.add(inter_busquedaSiniestroSimpleBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interBusquedaSiniestroSimple;

    }
}
