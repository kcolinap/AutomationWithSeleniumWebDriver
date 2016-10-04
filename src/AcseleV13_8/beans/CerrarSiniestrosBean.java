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
 * Created by aazuaje on 13/09/2016.
 */
public class CerrarSiniestrosBean implements Serializable {

    private final static Logger log = Logger.getLogger(CerrarSiniestrosBean.class);

    private String ordenarPor;
    private String numSiniestro;
    private String numPoliza;
    private String fechaOcurrenciaSiniestro;
    private String producto;
    private String motivoCierre;

    public String getOrdenarPor() {return ordenarPor;}
    public void setOrdenarPor(String ordenarPor) {this.ordenarPor = ordenarPor;}

    public String getNumSiniestro() {return numSiniestro;}
    public void setNumSiniestro(String numSiniestro) {this.numSiniestro = numSiniestro;}

    public String getNumPoliza() {return numPoliza;}
    public void setNumPoliza(String numPoliza) {this.numPoliza = numPoliza;}

    public String getFechaOcurrenciaSiniestro() {return fechaOcurrenciaSiniestro;}
    public void setFechaOcurrenciaSiniestro(String fechaOcurrenciaSiniestro) {this.fechaOcurrenciaSiniestro = fechaOcurrenciaSiniestro;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getMotivoCierre() {return motivoCierre;}
    public void setMotivoCierre(String motivoCierre) {this.motivoCierre = motivoCierre;}

    public static ArrayList getCerrarSiestros() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList cerrarSiniestros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Cierre from CERRAR_SINIESTRO ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CerrarSiniestrosBean cerrarSiniestrosBean = new CerrarSiniestrosBean();

                cerrarSiniestrosBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                cerrarSiniestrosBean.setNumSiniestro(rs.getString("NUM_SINIESTRO"));
                cerrarSiniestrosBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                cerrarSiniestrosBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                cerrarSiniestrosBean.setProducto(rs.getString("PRODUCTO"));
                cerrarSiniestrosBean.setMotivoCierre(rs.getString("MOTIVO_CIERRE"));

                cerrarSiniestros.add(cerrarSiniestrosBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return cerrarSiniestros;

    }


}
