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
 * Created by aazuaje on 21/12/2016.
 */
public class INTER_ReabrirSiniestroBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_ReabrirSiniestroBean.class);

    private String ordenarPor;
    private String numeroPoliza;
    private String numeroSiniestro;
    private String fechaOcurrenciaSiniestro;
    private String producto;
    private String motivoReapertura;
    private String comentariosSiniestro;

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

    public String getMotivoReapertura() {return motivoReapertura;}
    public void setMotivoReapertura(String motivoReapertura) {this.motivoReapertura = motivoReapertura;}

    public String getComentariosSiniestro() {return comentariosSiniestro;}
    public void setComentariosSiniestro(String comentariosSiniestro) {this.comentariosSiniestro = comentariosSiniestro;}

    public static ArrayList getINTER_ReabrirSiniestro() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interReabrirSiniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * FROM INTER_REABRIR_SINIESTRO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_ReabrirSiniestroBean inter_reabrirSiniestroBean = new INTER_ReabrirSiniestroBean();

                inter_reabrirSiniestroBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_reabrirSiniestroBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                inter_reabrirSiniestroBean.setNumeroSiniestro(rs.getString("NUMERO_SINIESTRO"));
                inter_reabrirSiniestroBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                inter_reabrirSiniestroBean.setProducto(rs.getString("PRODUCTO"));
                inter_reabrirSiniestroBean.setMotivoReapertura(rs.getString("MOTIVO_REAPERTURA"));
                inter_reabrirSiniestroBean.setComentariosSiniestro(rs.getString("COMENTARIOS_SINIESTRO"));

                interReabrirSiniestro.add(inter_reabrirSiniestroBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return interReabrirSiniestro;
    }










    }
