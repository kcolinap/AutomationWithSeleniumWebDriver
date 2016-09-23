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
 * Created by kzambrano on 22/09/2016.
 */
public class TrazaDetalleAuditoriaReservaConcepBean implements Serializable {

    private final static Logger log = Logger.getLogger(PagoPorConceptosBean.class);



    private String nro_Siniestro;
    private String nro_Poliza;
    private String fecha_siniestro;
    private String producto;
    private String ordenarPor;
    private String cobertura;
    private String montoReserva;
    private String tipo_Traza;
    private String fecha_Desde;
    private String fecha_Hasta;
    private String categoria_Traza;


    public String getNro_Siniestro() {return nro_Siniestro;}
    public void setNro_Siniestro(String nro_Siniestro) {this.nro_Siniestro = nro_Siniestro;}

    public String getNro_Poliza() {return nro_Poliza;}
    public void setNro_Poliza(String nro_Poliza) {this.nro_Poliza = nro_Poliza;}

    public String getFecha_siniestro() {return fecha_siniestro;}
    public void setFecha_siniestro(String fecha_siniestro) {this.fecha_siniestro = fecha_siniestro;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getOrdenarPor() {
        return ordenarPor;
    }
    public void setOrdenarPor(String ordenarPor) {this.ordenarPor = ordenarPor;}

    public String getCobertura() {return cobertura;}
    public void setCobertura(String cobertura) {this.cobertura = cobertura;}

    public String getMontoReserva() {return montoReserva;}
    public void setMontoReserva(String montoReserva) {this.montoReserva = montoReserva;}

    public String getTipo_Traza() {return tipo_Traza;}
    public void setTipo_Traza(String tipo_Traza) {this.tipo_Traza = tipo_Traza;}

    public String getFecha_Desde() {return fecha_Desde;}
    public void setFecha_Desde(String fecha_Desde) {this.fecha_Desde = fecha_Desde;}

    public String getFecha_Hasta() {return fecha_Hasta;}
    public void setFecha_Hasta(String fecha_Hasta) {this.fecha_Hasta = fecha_Hasta;}

    public String getCategoria_Traza() {return categoria_Traza;}
    public void setCategoria_Traza(String categoria_Traza) {this.categoria_Traza = categoria_Traza;}


    public static ArrayList getTrazaDetalleReservaConceptos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList trazaDetalleReservaConceptos = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, Nro_Siniestro, Nro_Poliza,  Fecha_siniestro, Producto, Ordenar_Por, Cobertura, Monto_Reserva, Tipo_Traza, Fecha_Desde, Fecha_hasta, Categoria_Traza FROM Reserva_Conceptos_Traza ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TrazaDetalleAuditoriaReservaConcepBean trazaDetalleAuditoriaReservaConcepBean = new TrazaDetalleAuditoriaReservaConcepBean();

                trazaDetalleAuditoriaReservaConcepBean.setNro_Siniestro(rs.getString("Nro_Siniestro"));
                trazaDetalleAuditoriaReservaConcepBean.setNro_Poliza(rs.getString("Nro_Poliza"));
                trazaDetalleAuditoriaReservaConcepBean.setFecha_siniestro(rs.getString("Fecha_siniestro"));
                trazaDetalleAuditoriaReservaConcepBean.setProducto(rs.getString("Producto"));
                trazaDetalleAuditoriaReservaConcepBean.setOrdenarPor(rs.getString("Ordenar_Por"));
                trazaDetalleAuditoriaReservaConcepBean.setCobertura(rs.getString("Cobertura"));
                trazaDetalleAuditoriaReservaConcepBean.setMontoReserva(rs.getString("Monto_Reserva"));
                trazaDetalleAuditoriaReservaConcepBean.setTipo_Traza(rs.getString("Tipo_Traza"));
                trazaDetalleAuditoriaReservaConcepBean.setFecha_Desde(rs.getString("Fecha_Desde"));
                trazaDetalleAuditoriaReservaConcepBean.setFecha_Hasta(rs.getString("Fecha_hasta"));
                trazaDetalleAuditoriaReservaConcepBean.setCategoria_Traza(rs.getString("Categoria_Traza"));


                trazaDetalleReservaConceptos.add(trazaDetalleAuditoriaReservaConcepBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return trazaDetalleReservaConceptos;

    }

















}
