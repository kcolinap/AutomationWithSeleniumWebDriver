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
 * Created by aazuaje on 28/12/2016.
 */
public class INTER_CerrarSiniestroBean implements Serializable{

    private final static Logger log = Logger.getLogger(INTER_ReabrirSiniestroBean.class);

    private String ordenarPor;
    private String numeroPoliza;
    private String numeroSiniestro;
    private String fechaOcurrenciaSiniestro;
    private String producto;
    private String motivoCierre;
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

    public String getMotivoCierre() {return motivoCierre;}
    public void setMotivoCierre(String motivoCierre) {this.motivoCierre = motivoCierre;}

    public String getComentariosSiniestro() {return comentariosSiniestro;}
    public void setComentariosSiniestro(String comentariosSiniestro) {this.comentariosSiniestro = comentariosSiniestro;}


    public static ArrayList getINTER_CerrarSiniestro() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interCerrarSiniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Ordenar_Por,Numero_Poliza,Numero_Siniestro,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Cierre, Comentarios_Siniestro from INTER_CERRAR_SINIESTRO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_CerrarSiniestroBean inter_cerrarSiniestroBean = new INTER_CerrarSiniestroBean();

                inter_cerrarSiniestroBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_cerrarSiniestroBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                inter_cerrarSiniestroBean.setNumeroSiniestro(rs.getString("NUMERO_SINIESTRO"));
                inter_cerrarSiniestroBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                inter_cerrarSiniestroBean.setProducto(rs.getString("PRODUCTO"));
                inter_cerrarSiniestroBean.setMotivoCierre(rs.getString("MOTIVO_CIERRE"));
                inter_cerrarSiniestroBean.setComentariosSiniestro(rs.getString("COMENTARIOS_SINIESTRO"));


                interCerrarSiniestro.add(inter_cerrarSiniestroBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return interCerrarSiniestro;
    }


}
