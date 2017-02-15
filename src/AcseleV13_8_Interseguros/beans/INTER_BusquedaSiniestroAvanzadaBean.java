package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 23/01/2017.
 */
public class INTER_BusquedaSiniestroAvanzadaBean {

    private final static Logger log = Logger.getLogger(INTER_BusquedaSiniestroSimpleBean.class);

    private String ordenarPor;
    private String producto;
    private String eventoSiniestro;
    private String tipoTercero;
    private String apellido;
    private String nombre;
    private String rol;
    private String oficina;
    private String numPoliza;
    private String numPropuesta;



    public String getOrdenarPor() {return ordenarPor;}
    public void setOrdenarPor(String ordenarPor) {this.ordenarPor = ordenarPor;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getEventoSiniestro() {return eventoSiniestro;}
    public void setEventoSiniestro(String eventoSiniestro) {this.eventoSiniestro = eventoSiniestro;}

    public String getTipoTercero() {return tipoTercero;}
    public void setTipoTercero(String tipoTercero) {this.tipoTercero = tipoTercero;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getRol() {return rol;}
    public void setRol(String rol) {this.rol = rol;}

    public String getOficina() {return oficina;}
    public void setOficina(String oficina) {this.oficina = oficina;}

    public String getNumPoliza() {return numPoliza;}
    public void setNumPoliza(String numPoliza) {this.numPoliza = numPoliza;}

    public String getNumPropuesta() {return numPropuesta;}
    public void setNumPropuesta(String numPropuesta) {this.numPropuesta = numPropuesta;}




    public static ArrayList getINTER_BusquedaSiniestroAvanzada() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interBusquedaSiniestroAvanzada = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * FROM INTER_BUSQUEDA_AVANZADA ORDER BY PRUEBA ASC");
        //Prueba,Ordenar_Por, producto, Tipo_Tercero, apellido, nombre,Rol, Oficina, Num_Poliza,Num_Propuesta, evento_Siniestro
        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_BusquedaSiniestroAvanzadaBean inter_busquedaSiniestroAvanzadaBean= new INTER_BusquedaSiniestroAvanzadaBean();

                inter_busquedaSiniestroAvanzadaBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_busquedaSiniestroAvanzadaBean.setProducto(rs.getString("PRODUCTO"));
                inter_busquedaSiniestroAvanzadaBean.setEventoSiniestro(rs.getString("EVENTO_SINIESTRO"));
                inter_busquedaSiniestroAvanzadaBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                inter_busquedaSiniestroAvanzadaBean.setApellido(rs.getString("APELLIDO"));
                inter_busquedaSiniestroAvanzadaBean.setNombre(rs.getString("NOMBRE"));
                inter_busquedaSiniestroAvanzadaBean.setRol(rs.getString("ROL"));
                inter_busquedaSiniestroAvanzadaBean.setOficina(rs.getString("OFICINA"));
                inter_busquedaSiniestroAvanzadaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                inter_busquedaSiniestroAvanzadaBean.setNumPropuesta(rs.getString("NUM_PROPUESTA"));

                interBusquedaSiniestroAvanzada.add(inter_busquedaSiniestroAvanzadaBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interBusquedaSiniestroAvanzada;

    }
}
