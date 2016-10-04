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
 * Created by agil on 27/05/2016.
 */
public class AnulacionPolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(AnulacionPolizaBean.class);

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

    public static ArrayList getAnulacionPoliza() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList anulacionPoliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NUM_POLIZA, CONTRATANTE, ASEGURADO, OPCION, FECHA_APLICACION_EVENTO, MOTIVO_ANULACION, OBSERVACION FROM ANULACION_POLIZAS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                AnulacionPolizaBean anulacionPolizaBean = new AnulacionPolizaBean();

                anulacionPolizaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                anulacionPolizaBean.setContratante(rs.getString("CONTRATANTE"));
                anulacionPolizaBean.setAsegurado(rs.getString("ASEGURADO"));
                anulacionPolizaBean.setOpcion(rs.getString("OPCION"));
                anulacionPolizaBean.setFechaAplicacionEvento(rs.getString("FECHA_APLICACION_EVENTO"));
                anulacionPolizaBean.setMotivoAnulacion(rs.getString("MOTIVO_ANULACION"));
                anulacionPolizaBean.setObservacion(rs.getString("OBSERVACION"));

                anulacionPoliza.add(anulacionPolizaBean);
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
