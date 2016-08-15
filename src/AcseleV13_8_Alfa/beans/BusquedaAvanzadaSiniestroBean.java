package AcseleV13_8_Alfa.beans;


import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 09/08/2016.
 */
public class BusquedaAvanzadaSiniestroBean {

    private final static Logger log = Logger.getLogger(BusquedaAvanzadaSiniestroBean.class);

    private String ordenar;
    private String producto;
    private String evento;
    private String sucursal;
    private String numPoliza;
    private String emision;
    private String tipoProduccion;
    private String canalVenta;
    private String frecuenciaPago;
    private String tipoPoliza;
    private String tipoTercero;
    private String tipoDocumento;
    private String numDocumento;
    private String nombreApellido;
    private String fechaInclusion;
    private String tlfOficina;
    private String extension;
    private String tlfOficinaComp;
    private String email1;
    private String email2;
    private String codigoInterno;
    private String codigoIdentificador;
    private String indicativo;
    private String rol;
    private String numUnidadRiesgo;
    private String tipoObjAsegurado;
    private String numObjAsegurado;
    private String nombreAsegurado;
    private String nombreBeneficiario;



    public String getOrdenar() {
        return ordenar;
    }
    public void setOrdenar(String ordenar) {
        this.ordenar = ordenar;
    }

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;
    }

    public String getEvento(){
        return evento;
    }
    public void setEvento(String evento){
        this.evento = evento;
    }

    public String getNumPoliza(){
        return numPoliza;
    }
    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getOcurrencia(){
        return ocurrencia;
    }
    public void setOcurrencia(String ocurrencia) {
        this.ocurrencia = ocurrencia;
    }



    public static ArrayList getBuscarSiniestroSimple() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA,ORDEN,NUM_SINIESTRO,NUM_POLIZA,FECHA,PRODUCTO FROM BUSCAR_SINIESTRO_SIMPLE ORDER BY PRUEBA ASC");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                BusquedaAvanzadaSiniestroBean buscarSiniestroSimpleBean = new BusquedaAvanzadaSiniestroBean();
                buscarSiniestroSimpleBean.setOrdenar(rs.getString("ORDEN"));
                buscarSiniestroSimpleBean.setNumSiniestro(rs.getString("NUM_SINIESTRO"));
                buscarSiniestroSimpleBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                buscarSiniestroSimpleBean.setOcurrencia(rs.getString("FECHA"));
                buscarSiniestroSimpleBean.setProducto(rs.getString("PRODUCTO"));
                caja.add(buscarSiniestroSimpleBean);
            }

        }catch(SQLException e){

            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return caja;
    }
}
