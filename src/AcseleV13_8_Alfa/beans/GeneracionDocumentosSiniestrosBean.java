package AcseleV13_8_Alfa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by rmontilla on 23/09/2016.
 */
public class GeneracionDocumentosSiniestrosBean implements Serializable {

    private final static Logger log = Logger.getLogger(GeneracionDocumentosSiniestrosBean.class);

    private String ordenarPor;
    private String numSiniestro;
    private String fechaOcurrenciaSiniestro;
    private String producto;
    private String numPoliza;

    public String getOrdenarPor() {
        return ordenarPor;
    }

    public void setOrdenarPor(String ordenarPor) {
        this.ordenarPor = ordenarPor;
    }

    public String getNumSiniestro() {
        return numSiniestro;
    }

    public void setNumSiniestro(String numSiniestro) {
        this.numSiniestro = numSiniestro;
    }

    public String getFechaOcurrenciaSiniestro() {
        return fechaOcurrenciaSiniestro;
    }

    public void setFechaOcurrenciaSiniestro(String fechaOcurrenciaSiniestro) {
        this.fechaOcurrenciaSiniestro = fechaOcurrenciaSiniestro;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }



    public static ArrayList getGeneracionDocumentosSiniestros() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList ordenes = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM DOCUMENTOS_SINIESTROS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                GeneracionDocumentosSiniestrosBean generacionDocumentosSiniestrosBean = new GeneracionDocumentosSiniestrosBean();

                generacionDocumentosSiniestrosBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                generacionDocumentosSiniestrosBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                generacionDocumentosSiniestrosBean.setNumSiniestro(rs.getString("NUM_SINIESTRO"));
                generacionDocumentosSiniestrosBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                generacionDocumentosSiniestrosBean.setProducto(rs.getString("PRODUCTO"));


                ordenes.add(generacionDocumentosSiniestrosBean);
            }
        }catch(SQLException e){
            log.error(e);
        }
        finally{
            if (conn != null){
                conn.close();
            }
        }
        return ordenes;
    }

}
