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
 * Created by agil on 04/07/2016.
 */
public class TercerosLineaCreditoGarantiaBean implements Serializable {

    private final static Logger log = Logger.getLogger(TercerosLineaCreditoGarantiaBean.class);

    private String tipoTercero;
    private String tipoDocId;
    private String cedula;
    private String nombre;
    private String apellido;
    private String tipos;
    private String montos;
    private String descripcion;
    private String fechaDesde;
    private String fechaHasta;

    public String getTipoTercero(){
        return tipoTercero;
    }
    public void setTipoTercero(String tipoTercero){
        this.tipoTercero = tipoTercero;
    }

    public String getTipoDocId(){
        return tipoDocId;
    }
    public void setTipoDocId(String tipoDocId){
        this.tipoDocId = tipoDocId;
    }

    public String getCedula(){
        return cedula;
    }
    public void setCedula(String cedula){
        this.cedula = cedula;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getTipos(){
        return tipos;
    }
    public void setTipos(String tipos){
        this.tipos = tipos;
    }

    public String getMontos(){
        return montos;
    }
    public void setMontos(String montos){
        this.montos = montos;
    }

    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getFechaDesde(){
        return fechaDesde;
    }
    public void setFechaDesde(String fechaDesde){
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta(){
        return fechaHasta;
    }
    public void setFechaHasta(String fechaHasta){
        this.fechaHasta = fechaHasta;
    }

    public static ArrayList getTercerosLinaCreditoGarantia() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList terceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, TIPO_DOC_IDENTIDAD, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO, TIPOS, MONTOS, DESCRIPCION, FECHA_DESDE, FECHA_HASTA FROM TERCERO_LINEA_CREDITO_GARANTIA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TercerosLineaCreditoGarantiaBean tercerosLineaCreditoGarantiaBean = new TercerosLineaCreditoGarantiaBean();
                tercerosLineaCreditoGarantiaBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                tercerosLineaCreditoGarantiaBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                tercerosLineaCreditoGarantiaBean.setCedula(rs.getString("CEDULA"));
                tercerosLineaCreditoGarantiaBean.setNombre(rs.getString("NOMBRE"));
                tercerosLineaCreditoGarantiaBean.setApellido(rs.getString("APELLIDO"));
                tercerosLineaCreditoGarantiaBean.setTipos(rs.getString("TIPOS"));
                tercerosLineaCreditoGarantiaBean.setMontos(rs.getString("MONTOS"));
                tercerosLineaCreditoGarantiaBean.setDescripcion(rs.getString("DESCRIPCION"));
                tercerosLineaCreditoGarantiaBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                tercerosLineaCreditoGarantiaBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                terceros.add(tercerosLineaCreditoGarantiaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }
        finally{
            if (conn != null){
                conn.close();
            }
        }
        return terceros;
    }


}
