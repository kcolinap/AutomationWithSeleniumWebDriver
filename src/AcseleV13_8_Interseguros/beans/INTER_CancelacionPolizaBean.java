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
 * Created by rmontilla on 26/12/2016.
 */
public class INTER_CancelacionPolizaBean implements Serializable{

    private final static Logger log = Logger.getLogger(INTER_CancelacionPolizaBean.class);

    //PRUEBA, NUM_POLIZA, CONTRATANTE, ASEGURADO, OPCION, FECHA_APLICACION_EVENTO, MOTIVO_ANULACION, OBSERVACION
    private String numPoliza;
    private String contratante;
    private String asegurado;
    private String opcion;
    private String fechaAplicacionEvento;
    private String motivoAnulacion;
    private String observacion;

    public String getNumPoliza() {
        return numPoliza;
    }
    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getContratante() {
        return contratante;
    }
    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getAsegurado() {
        return asegurado;
    }
    public void setAsegurado(String asegurado) {
        this.asegurado = asegurado;
    }

    public String getOpcion() {
        return opcion;
    }
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getFechaAplicacionEvento() {
        return fechaAplicacionEvento;
    }
    public void setFechaAplicacionEvento(String fechaAplicacionEvento) {
        this.fechaAplicacionEvento = fechaAplicacionEvento;
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

    public static ArrayList getAnulacionPoliza() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList anulacionPoliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NUM_POLIZA, CONTRATANTE, ASEGURADO, OPCION, FECHA_APLICACION_EVENTO, MOTIVO_ANULACION, OBSERVACION FROM ANULACION_POLIZAS_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_CancelacionPolizaBean inter_cancelacionPolizaBean = new INTER_CancelacionPolizaBean();

                inter_cancelacionPolizaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                inter_cancelacionPolizaBean.setContratante(rs.getString("CONTRATANTE"));
                inter_cancelacionPolizaBean.setAsegurado(rs.getString("ASEGURADO"));
                inter_cancelacionPolizaBean.setOpcion(rs.getString("OPCION"));
                inter_cancelacionPolizaBean.setFechaAplicacionEvento(rs.getString("FECHA_APLICACION_EVENTO"));
                inter_cancelacionPolizaBean.setMotivoAnulacion(rs.getString("MOTIVO_ANULACION"));
                inter_cancelacionPolizaBean.setObservacion(rs.getString("OBSERVACION"));

                anulacionPoliza.add(inter_cancelacionPolizaBean);
            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return anulacionPoliza;
    }

}
