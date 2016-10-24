package AcseleV13_8LBC.beans;

import AcseleV13_8LBC.main.controller.InformacionFinancieraLBC;
import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by rmontilla on 20/10/2016.
 */
public class InformacionFinancieraLBCBean implements Serializable{

    private final static Logger log = Logger.getLogger(InformacionFinancieraLBC.class);

    private String tipoTercero;
    private String tipoDocId;
    private String cedula;
    private String nombre;
    private String apellido;
    private String codIdentificador;
    private String activos;
    private String activosFijos;
    private String inversiones;
    private String otrosActivos;
    private String totalActivos;
    private String pasivoCirculante;
    private String pasivosLargoPlazo;
    private String capitalPagado;
    private String capitalReserva;
    private String excedente;
    private String totPasCap;
    private String capitalTrabajo;
    private String solvencia;
    private String liquidez;


    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getTipoDocId() {
        return tipoDocId;
    }

    public void setTipoDocId(String tipoDocId) {
        this.tipoDocId = tipoDocId;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodIdentificador() {
        return codIdentificador;
    }

    public void setCodIdentificador(String codIdentificador) {
        this.codIdentificador = codIdentificador;
    }

    public String getActivos() {
        return activos;
    }

    public void setActivos(String activos) {
        this.activos = activos;
    }

    public String getActivosFijos() {
        return activosFijos;
    }

    public void setActivosFijos(String activosFijos) {
        this.activosFijos = activosFijos;
    }

    public String getInversiones() {
        return inversiones;
    }

    public void setInversiones(String inversiones) {
        this.inversiones = inversiones;
    }

    public String getOtrosActivos() {
        return otrosActivos;
    }

    public void setOtrosActivos(String otrosActivos) {
        this.otrosActivos = otrosActivos;
    }

    public String getTotalActivos() {
        return totalActivos;
    }

    public void setTotalActivos(String totalActivos) {
        this.totalActivos = totalActivos;
    }

    public String getPasivoCirculante() {
        return pasivoCirculante;
    }

    public void setPasivoCirculante(String pasivoCirculante) {
        this.pasivoCirculante = pasivoCirculante;
    }

    public String getPasivosLargoPlazo() {
        return pasivosLargoPlazo;
    }

    public void setPasivosLargoPlazo(String pasivosLargoPlazo) {
        this.pasivosLargoPlazo = pasivosLargoPlazo;
    }

    public String getCapitalPagado() {
        return capitalPagado;
    }

    public void setCapitalPagado(String capitalPagado) {
        this.capitalPagado = capitalPagado;
    }

    public String getCapitalReserva() {
        return capitalReserva;
    }

    public void setCapitalReserva(String capitalReserva) {
        this.capitalReserva = capitalReserva;
    }

    public String getExcedente() {
        return excedente;
    }

    public void setExcedente(String excedente) {
        this.excedente = excedente;
    }

    public String getTotPasCap() {
        return totPasCap;
    }

    public void setTotPasCap(String totPasCap) {
        this.totPasCap = totPasCap;
    }

    public String getCapitalTrabajo() {
        return capitalTrabajo;
    }

    public void setCapitalTrabajo(String capitalTrabajo) {
        this.capitalTrabajo = capitalTrabajo;
    }

    public String getSolvencia() {
        return solvencia;
    }

    public void setSolvencia(String solvencia) {
        this.solvencia = solvencia;
    }

    public String getLiquidez() {
        return liquidez;
    }

    public void setLiquidez(String liquidez) {
        this.liquidez = liquidez;
    }



    public static ArrayList getInformacionFinanciera() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList terceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM INFORMACION_FINANCIERA_LBC ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                InformacionFinancieraLBCBean informacionFinancieraLBCBean = new InformacionFinancieraLBCBean();
                informacionFinancieraLBCBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                informacionFinancieraLBCBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                informacionFinancieraLBCBean.setCedula(rs.getString("CEDULA"));
                informacionFinancieraLBCBean.setNombre(rs.getString("NOMBRE"));
                informacionFinancieraLBCBean.setApellido(rs.getString("APELLIDO"));
                informacionFinancieraLBCBean.setCodIdentificador(rs.getString("COD_IDENTIFICADOR"));
                informacionFinancieraLBCBean.setActivos(rs.getString("ACTIVOS"));
                informacionFinancieraLBCBean.setActivosFijos(rs.getString("ACTIVOS_FIJOS"));
                informacionFinancieraLBCBean.setInversiones(rs.getString("INVERSIONES"));
                informacionFinancieraLBCBean.setOtrosActivos(rs.getString("OTROS_ACTIVOS"));
                informacionFinancieraLBCBean.setTotalActivos(rs.getString("TOTAL_ACTIVOS"));
                informacionFinancieraLBCBean.setPasivoCirculante(rs.getString("PASIVO_CIRCULANTE"));
                informacionFinancieraLBCBean.setPasivosLargoPlazo(rs.getString("PASIVO_LARGO_PLAZO"));
                informacionFinancieraLBCBean.setCapitalPagado(rs.getString("CAPITAL_PAGADO"));
                informacionFinancieraLBCBean.setCapitalReserva(rs.getString("CAPITAL_RESERVA"));
                informacionFinancieraLBCBean.setExcedente(rs.getString("EXCEDENTE"));
                informacionFinancieraLBCBean.setTotPasCap(rs.getString("TOTAL_PASIVO_CAPITAL"));
                informacionFinancieraLBCBean.setCapitalTrabajo(rs.getString("CAPITAL_TRABAJO"));
                informacionFinancieraLBCBean.setSolvencia(rs.getString("SOLVENCIA"));
                informacionFinancieraLBCBean.setLiquidez(rs.getString("LIQUIDEZ"));

                terceros.add(informacionFinancieraLBCBean);
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
