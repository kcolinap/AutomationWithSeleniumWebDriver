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
 * Created by kzambrano on 21/09/2016.
 */
public class TrazaDetalleAuditoriaCajaBean implements Serializable {

    private final static Logger log = Logger.getLogger(TransformadoresBean.class);

    private String nro_Caja;
    private String tipoTraza;
    private String fecha_Desde;
    private String fecha_Hasta;
    private String categoria_Traza;

    public String getNro_Caja() {return nro_Caja;}
    public void setNro_Caja (String nro_Caja) {this.nro_Caja = nro_Caja;}

    public String getTipoTraza() {return tipoTraza;}
    public void setTipoTraza (String tipoTraza) {this.tipoTraza = tipoTraza;}

    public String getFecha_Desde() {return fecha_Desde;}
    public void setFecha_Desde (String fecha_Desde) {this.fecha_Desde = fecha_Desde;}

    public String getFecha_Hasta() {
        return fecha_Hasta;
    }

    public void setFecha_Hasta(String fecha_Hasta) {
        this.fecha_Hasta = fecha_Hasta;
    }

    public String getCategoria_Traza() {return categoria_Traza;}
    public void setCategoria_Traza (String categoria_Traza) {this.categoria_Traza = categoria_Traza;}


    public static ArrayList getTrazaDetalleAuditoriaCaja() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList trazaDetalleAuditoriaCaja = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, Nro_Caja, Tipo_Traza, Fecha_Desde, Fecha_hasta, Categoria_Traza FROM Apertura_Caja_Traza ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TrazaDetalleAuditoriaCajaBean trazaDetalleAuditoriaCajaBean = new TrazaDetalleAuditoriaCajaBean();

                trazaDetalleAuditoriaCajaBean.setNro_Caja(rs.getString("Nro_Caja"));
                trazaDetalleAuditoriaCajaBean.setTipoTraza(rs.getString("Tipo_Traza"));
                trazaDetalleAuditoriaCajaBean.setFecha_Desde(rs.getString("Fecha_Desde"));
                trazaDetalleAuditoriaCajaBean.setFecha_Hasta(rs.getString("Fecha_hasta"));
                trazaDetalleAuditoriaCajaBean.setCategoria_Traza(rs.getString("Categoria_Traza"));


                trazaDetalleAuditoriaCaja.add(trazaDetalleAuditoriaCajaBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return trazaDetalleAuditoriaCaja;

    }

}
