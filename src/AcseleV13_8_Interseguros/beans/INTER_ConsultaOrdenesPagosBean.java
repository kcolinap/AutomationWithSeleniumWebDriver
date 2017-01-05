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
 * Created by aazuaje on 04/01/2017.
 */
public class INTER_ConsultaOrdenesPagosBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_ConsultaOrdenesPagosBean.class);

    private String ordenarPor;
    private String numeroPoliza;
    private String numeroSiniestro;
    private String fechaOcurrenciaSiniestro;
    private String producto;

    public String getOrdenarPor() {return ordenarPor;}
    public void setOrdenarPor(String ordenarPor) {this.ordenarPor = ordenarPor;}

    public String getNumeroPoliza() {return numeroPoliza;}
    public void setNumeroPoliza(String numeroPoliza) {this.numeroPoliza = numeroPoliza;}

    public String getNumeroSiniestro() {return numeroSiniestro;}
    public void setNumeroSiniestro(String numeroSiniestro) {this.numeroSiniestro = numeroSiniestro;}

    public String getFechaOcurrenciaSiniestro() {return fechaOcurrenciaSiniestro;}
    public void setFechaOcurrenciaSiniestro(String fechaOcurrenciaSiniestro) {this.fechaOcurrenciaSiniestro = fechaOcurrenciaSiniestro;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public static ArrayList getINTER_ConsultaOrdenesPagos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList inter_consultaOrdenesPagos = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from INTER_CONSULTA_ORDEN_PAGO ORDER BY PRUEBA ASC");


        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_ConsultaOrdenesPagosBean inter_consultaOrdenesPagosBean = new INTER_ConsultaOrdenesPagosBean();

                inter_consultaOrdenesPagosBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_consultaOrdenesPagosBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                inter_consultaOrdenesPagosBean.setNumeroSiniestro(rs.getString("NUMERO_SINIESTRO"));
                inter_consultaOrdenesPagosBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                inter_consultaOrdenesPagosBean.setProducto(rs.getString("PRODUCTO"));

                inter_consultaOrdenesPagos.add(inter_consultaOrdenesPagosBean);
            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return inter_consultaOrdenesPagos;
    }



}
