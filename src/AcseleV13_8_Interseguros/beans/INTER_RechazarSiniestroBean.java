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
 * Created by aazuaje on 22/12/2016.
 */
public class INTER_RechazarSiniestroBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_ReabrirSiniestroBean.class);

    private String ordenarPor;
    private String numeroPoliza;
    private String numeroSiniestro;
    private String fechaOcurrenciaSiniestro;
    private String producto;
    private String motivoRechazo;
    private String comentariosSiniestro;
    private String nombreBeneficiario;
    private String direccionBeneficiario;

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

    public String getMotivoRechazo() {return motivoRechazo;}
    public void setMotivoRechazo(String motivoRechazo) {this.motivoRechazo = motivoRechazo;}

    public String getComentariosSiniestro() {return comentariosSiniestro;}
    public void setComentariosSiniestro(String comentariosSiniestro) {this.comentariosSiniestro = comentariosSiniestro;}

    public String getNombreBeneficiario() {return nombreBeneficiario;}
    public void setNombreBeneficiario(String nombreBeneficiario) {this.nombreBeneficiario = nombreBeneficiario;}

    public String getDireccionBeneficiario() {return direccionBeneficiario;}
    public void setDireccionBeneficiario(String direccionBeneficiario) {this.direccionBeneficiario = direccionBeneficiario;}

    public static ArrayList getINTER_RechazarSiniestro() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interRechazarSiniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * FROM INTER_RECHAZAR_SINIESTRO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_RechazarSiniestroBean inter_rechazarSiniestroBean = new INTER_RechazarSiniestroBean();

                inter_rechazarSiniestroBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_rechazarSiniestroBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                inter_rechazarSiniestroBean.setNumeroSiniestro(rs.getString("NUMERO_SINIESTRO"));
                inter_rechazarSiniestroBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                inter_rechazarSiniestroBean.setProducto(rs.getString("PRODUCTO"));
                inter_rechazarSiniestroBean.setMotivoRechazo(rs.getString("MOTIVO_RECHAZO"));
                inter_rechazarSiniestroBean.setComentariosSiniestro(rs.getString("COMENTARIOS_SINIESTRO"));
                inter_rechazarSiniestroBean.setNombreBeneficiario(rs.getString("NOMBRE_BENEFICIARIO"));
                inter_rechazarSiniestroBean.setDireccionBeneficiario(rs.getString("DIRECCION_BENEFICIARIO"));

                interRechazarSiniestro.add(inter_rechazarSiniestroBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return interRechazarSiniestro;
    }

}
