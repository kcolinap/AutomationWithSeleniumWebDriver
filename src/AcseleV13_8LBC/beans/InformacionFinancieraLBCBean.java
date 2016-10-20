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
    private String fechaExpedicionDocId;
    private String lugarExpedicionDocId;
    private String actividadEconomica;
    private String nacionalidad;
    private String empresaTrabaja;
    private String areaTrabajo;
    private String cargoTrabajo;
    private String direccionLaboral;
    private String ciudadLaboral;
    private String telefonoLaboral;
    private String numeroFax;
    private String telefonoFijo;
    private String telefonoCelular;
    private String fechaDiligencia;
    private String ingresosMensuales;
    private String otrosIngresos;
    private String conceptoOtrosIngresos;
    private String egresosMensuales;
    private String activos;
    private String pasivos;
    private String verifInformacion;
    private String observaciones;
    private String manejaRecursosPub;
    private String ejercePoderPub;
    private String reconoPubGeneral;
    private String reportaProdExterior;
    private String opExtranjerasNo;
    private String opExtranjerasImporta;
    private String opExtranjerasExporta;
    private String opExtranjerasInversion;
    private String opExtranjerasOtra;

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

    public String getFechaExpedicionDocId() {
        return fechaExpedicionDocId;
    }
    public void setFechaExpedicionDocId(String fechaExpedicionDocId) {
        this.fechaExpedicionDocId = fechaExpedicionDocId;
    }

    public String getLugarExpedicionDocId() {
        return lugarExpedicionDocId;
    }
    public void setLugarExpedicionDocId(String lugarExpedicionDocId) {
        this.lugarExpedicionDocId = lugarExpedicionDocId;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }
    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmpresaTrabaja() {
        return empresaTrabaja;
    }
    public void setEmpresaTrabaja(String empresaTrabaja) {
        this.empresaTrabaja = empresaTrabaja;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }
    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public String getCargoTrabajo() {
        return cargoTrabajo;
    }
    public void setCargoTrabajo(String cargoTrabajo) {
        this.cargoTrabajo = cargoTrabajo;
    }

    public String getDireccionLaboral() {
        return direccionLaboral;
    }
    public void setDireccionLaboral(String direccionLaboral) {
        this.direccionLaboral = direccionLaboral;
    }

    public String getCiudadLaboral() {
        return ciudadLaboral;
    }
    public void setCiudadLaboral(String ciudadLaboral) {
        this.ciudadLaboral = ciudadLaboral;
    }

    public String getTelefonoLaboral() {
        return telefonoLaboral;
    }
    public void setTelefonoLaboral(String telefonoLaboral) {
        this.telefonoLaboral = telefonoLaboral;
    }

    public String getNumeroFax() {
        return numeroFax;
    }
    public void setNumeroFax(String numeroFax) {
        this.numeroFax = numeroFax;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }
    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }
    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getFechaDiligencia() {
        return fechaDiligencia;
    }
    public void setFechaDiligencia(String fechaDiligencia) {
        this.fechaDiligencia = fechaDiligencia;
    }

    public String getIngresosMensuales() {
        return ingresosMensuales;
    }
    public void setIngresosMensuales(String ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }

    public String getOtrosIngresos() {
        return otrosIngresos;
    }
    public void setOtrosIngresos(String otrosIngresos) {
        this.otrosIngresos = otrosIngresos;
    }

    public String getConceptoOtrosIngresos() {
        return conceptoOtrosIngresos;
    }
    public void setConceptoOtrosIngresos(String conceptoOtrosIngresos) {
        this.conceptoOtrosIngresos = conceptoOtrosIngresos;
    }

    public String getEgresosMensuales() {
        return egresosMensuales;
    }
    public void setEgresosMensuales(String egresosMensuales) {
        this.egresosMensuales = egresosMensuales;
    }

    public String getActivos() {
        return activos;
    }
    public void setActivos(String activos) {
        this.activos = activos;
    }

    public String getPasivos() {
        return pasivos;
    }
    public void setPasivos(String pasivos) {
        this.pasivos = pasivos;
    }

    public String getVerifInformacion() {
        return verifInformacion;
    }
    public void setVerifInformacion(String verifInformacion) {
        this.verifInformacion = verifInformacion;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getManejaRecursosPub() {
        return manejaRecursosPub;
    }
    public void setManejaRecursosPub(String manejaRecursosPub) {
        this.manejaRecursosPub = manejaRecursosPub;
    }

    public String getEjercePoderPub() {
        return ejercePoderPub;
    }
    public void setEjercePoderPub(String ejercePoderPub) {
        this.ejercePoderPub = ejercePoderPub;
    }

    public String getReconoPubGeneral() {
        return reconoPubGeneral;
    }
    public void setReconoPubGeneral(String reconoPubGeneral) {
        this.reconoPubGeneral = reconoPubGeneral;
    }

    public String getReportaProdExterior() {
        return reportaProdExterior;
    }
    public void setReportaProdExterior(String reportaProdExterior) {
        this.reportaProdExterior = reportaProdExterior;
    }

    public String getOpExtranjerasNo() {
        return opExtranjerasNo;
    }
    public void setOpExtranjerasNo(String opExtranjerasNo) {
        this.opExtranjerasNo = opExtranjerasNo;
    }

    public String getOpExtranjerasImporta() {
        return opExtranjerasImporta;
    }
    public void setOpExtranjerasImporta(String opExtranjerasImporta) {
        this.opExtranjerasImporta = opExtranjerasImporta;
    }

    public String getOpExtranjerasExporta() {
        return opExtranjerasExporta;
    }
    public void setOpExtranjerasExporta(String opExtranjerasExporta) {
        this.opExtranjerasExporta = opExtranjerasExporta;
    }

    public String getOpExtranjerasInversion() {
        return opExtranjerasInversion;
    }
    public void setOpExtranjerasInversion(String opExtranjerasInversion) {
        this.opExtranjerasInversion = opExtranjerasInversion;
    }

    public String getOpExtranjerasOtra() {
        return opExtranjerasOtra;
    }
    public void setOpExtranjerasOtra(String opExtranjerasOtra) {
        this.opExtranjerasOtra = opExtranjerasOtra;
    }

    public static ArrayList getInformacionFinanciera() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList terceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM TERCEROS_INF_FINANCIERA ORDER BY PRUEBA ASC");

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
                informacionFinancieraLBCBean.setFechaExpedicionDocId(rs.getString("FEC_EXPE_DOC_ID"));
                informacionFinancieraLBCBean.setLugarExpedicionDocId(rs.getString("LUG_EXPE_DOC_ID"));
                informacionFinancieraLBCBean.setActividadEconomica(rs.getString("ACTIVIDAD_ECONOMICA_CIIU"));
                informacionFinancieraLBCBean.setNacionalidad(rs.getString("NACIONALIDAD"));
                informacionFinancieraLBCBean.setEmpresaTrabaja(rs.getString("EMPRESA_TRABAJA"));
                informacionFinancieraLBCBean.setAreaTrabajo(rs.getString("AREA"));
                informacionFinancieraLBCBean.setCargoTrabajo(rs.getString("CARGO"));
                informacionFinancieraLBCBean.setDireccionLaboral(rs.getString("DIRECCION_LABORAL"));
                informacionFinancieraLBCBean.setCiudadLaboral(rs.getString("CIUDAD_LABORAL"));
                informacionFinancieraLBCBean.setTelefonoLaboral(rs.getString("TELF_LABORAL"));
                informacionFinancieraLBCBean.setNumeroFax(rs.getString("NUM_FAX"));
                informacionFinancieraLBCBean.setTelefonoFijo(rs.getString("TELF_FIJO"));
                informacionFinancieraLBCBean.setTelefonoCelular(rs.getString("TELF_CELULAR"));
                informacionFinancieraLBCBean.setFechaDiligencia(rs.getString("FEC_DILIG_SARLAFT"));
                informacionFinancieraLBCBean.setIngresosMensuales(rs.getString("INGRESOS_MENSUALES"));
                informacionFinancieraLBCBean.setOtrosIngresos(rs.getString("OTROS_INGRESOS"));
                informacionFinancieraLBCBean.setConceptoOtrosIngresos(rs.getString("CONCEPTO_OTROS_INGRESOS"));
                informacionFinancieraLBCBean.setEgresosMensuales(rs.getString("EGRESOS_MENSUALES"));
                informacionFinancieraLBCBean.setActivos(rs.getString("ACTIVOS"));
                informacionFinancieraLBCBean.setPasivos(rs.getString("PASIVOS"));
                informacionFinancieraLBCBean.setVerifInformacion(rs.getString("VERIF_INFORMACION"));
                informacionFinancieraLBCBean.setObservaciones(rs.getString("OBSERVACIONES"));
                informacionFinancieraLBCBean.setManejaRecursosPub(rs.getString("MANEJA_RECURSO_PUBLICOS"));
                informacionFinancieraLBCBean.setEjercePoderPub(rs.getString("EJERCE_PODER_PUBLICO"));
                informacionFinancieraLBCBean.setReconoPubGeneral(rs.getString("RECONOCIMIENTO_PUBLICO_GENERAL"));
                informacionFinancieraLBCBean.setReportaProdExterior(rs.getString("REP_PRODUCTOS_EXTERIOR"));
                informacionFinancieraLBCBean.setOpExtranjerasNo(rs.getString("OPERA_EXTRANJERAS_NO"));
                informacionFinancieraLBCBean.setOpExtranjerasImporta(rs.getString("OPERA_EXTRANJERAS_IMPORTA"));
                informacionFinancieraLBCBean.setOpExtranjerasExporta(rs.getString("OPERA_EXTRANJERAS_EXPORTA"));
                informacionFinancieraLBCBean.setOpExtranjerasInversion(rs.getString("OPERA_EXTRANJERAS_INVERSION"));
                informacionFinancieraLBCBean.setOpExtranjerasOtra(rs.getString("OPERA_EXTRANJERAS_OTRA"));
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
