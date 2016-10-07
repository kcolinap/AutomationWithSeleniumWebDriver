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
 * Created by aazuaje on 23/09/2016.
 */
public class ReabrirSiniestroBean implements Serializable{
    private final static Logger log = Logger.getLogger(RechazarSiniestroBean.class);

    private String ordenarPor;
    private String numSiniestro;
    private String numPoliza;
    private String fechaOcurrenciaSiniestro;
    private String producto;
    private String motivoReapertura;
    private String comentarioSiniestro;

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

    public String getMotivoReapertura() {return motivoReapertura;}
    public void setMotivoReapertura(String motivoReapertura) {this.motivoReapertura = motivoReapertura;}

    public String getComentarioSiniestro() {return comentarioSiniestro;}
    public void setComentarioSiniestro(String comentarioSiniestro) {this.comentarioSiniestro = comentarioSiniestro;}

    public static ArrayList getReabrirSiestros() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList reabrirSiniestros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Reapertura,Comentario_Siniestro  from REABRIR_SINIESTRO ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ReabrirSiniestroBean reabrirSiniestroBean = new ReabrirSiniestroBean();

                reabrirSiniestroBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                reabrirSiniestroBean.setNumSiniestro(rs.getString("NUM_SINIESTRO"));
                reabrirSiniestroBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                reabrirSiniestroBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                reabrirSiniestroBean.setProducto(rs.getString("PRODUCTO"));
                reabrirSiniestroBean.setMotivoReapertura(rs.getString("MOTIVO_REAPERTURA"));
                reabrirSiniestroBean.setComentarioSiniestro(rs.getString("COMENTARIO_SINIESTRO"));

                reabrirSiniestros.add(reabrirSiniestroBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return reabrirSiniestros;

    }



}
