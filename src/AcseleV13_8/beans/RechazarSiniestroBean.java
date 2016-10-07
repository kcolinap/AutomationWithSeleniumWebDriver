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
 * Created by aazuaje on 22/09/2016.
 */
public class RechazarSiniestroBean implements Serializable {

    private final static Logger log = Logger.getLogger(RechazarSiniestroBean.class);

    private String ordenarPor;
    private String numSiniestro;
    private String numPoliza;
    private String fechaOcurrenciaSiniestro;
    private String producto;
    private String motivoObjecion;
    private String fechaObjecion;
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

    public String getMotivoObjecion() {return motivoObjecion;}
    public void setMotivoObjecion(String motivoObjecion) {this.motivoObjecion = motivoObjecion;}

    public String getFechaObjecion() {return fechaObjecion;}
    public void setFechaObjecion(String fechaObjecion) {this.fechaObjecion = fechaObjecion;}

    public String getComentarioSiniestro() {return comentarioSiniestro;}
    public void setComentarioSiniestro(String comentarioSiniestro) {this.comentarioSiniestro = comentarioSiniestro;}

    public static ArrayList getRechazarSiestros() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList rechazarSiniestros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Objecion,Fecha_Objecion,Comentario_Siniestro  from RECHAZAR_SINIESTRO ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                RechazarSiniestroBean rechazarSiniestroBean = new RechazarSiniestroBean();

                rechazarSiniestroBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                rechazarSiniestroBean.setNumSiniestro(rs.getString("NUM_SINIESTRO"));
                rechazarSiniestroBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                rechazarSiniestroBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                rechazarSiniestroBean.setProducto(rs.getString("PRODUCTO"));
                rechazarSiniestroBean.setMotivoObjecion(rs.getString("MOTIVO_OBJECION"));
                rechazarSiniestroBean.setFechaObjecion(rs.getString("FECHA_OBJECION"));
                rechazarSiniestroBean.setComentarioSiniestro(rs.getString("COMENTARIO_SINIESTRO"));

                rechazarSiniestros.add(rechazarSiniestroBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return rechazarSiniestros;

    }



}
