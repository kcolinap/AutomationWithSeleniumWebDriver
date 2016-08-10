package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by agil on 27/05/2016.
 */
public class AnulacionPolizaBean implements Serializable {

    private String numPoliza;
    private String opcion;
    private String motivoAnulacion;
    private String observacion;

    public String getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }

    public void setMotivoAnulacion(String motivoAnulacion) {
        this.motivoAnulacion = motivoAnulacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public static AnulacionPolizaBean getAnulacionPoliza(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        AnulacionPolizaBean anulacionPolizaBean = null;

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT NUM_POLIZA, OPCION, MOTIVO_ANULACION, OBSERVACION FROM ANULACION_POLIZAS");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                anulacionPolizaBean = new AnulacionPolizaBean();
                anulacionPolizaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                anulacionPolizaBean.setOpcion(rs.getString("OPCION"));
                anulacionPolizaBean.setMotivoAnulacion(rs.getString("MOTIVO_ANULACION"));
                anulacionPolizaBean.setObservacion(rs.getString("OBSERVACION"));
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return anulacionPolizaBean;
    }

}
