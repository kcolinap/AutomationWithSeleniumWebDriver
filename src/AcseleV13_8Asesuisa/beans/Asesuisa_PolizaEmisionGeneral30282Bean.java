package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by kcolina on 03/04/2017.
 */
public class Asesuisa_PolizaEmisionGeneral30282Bean extends Asesuisa_PolizasBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionGeneral30282Bean.class);

    private String codigoAgrupador;
    private String funcionamientoPoliza;
    private String observacionesSuscripcion;
    private String observacionesPoliza;
    private String giro;
    private String actvidadEconomica;
    private String deducibleRobo;
    private String participacionRobo;
    private String tarifaRobo;
    private String alcanceRobo;
    private String textoRobo;
    private String deducibleDineroValores;
    private String particiDineroValores;
    private String tarifaDineroValores;
    private String alcanceDineroValores;
    private String textoDineroValores;
    private String nivelAgrupacion;
    private String descuentosDonaciones;

    public String getCodigoAgrupador() {
        return codigoAgrupador;
    }

    public void setCodigoAgrupador(String codigoAgrupador) {
        this.codigoAgrupador = codigoAgrupador;
    }

    public String getFuncionamientoPoliza() {
        return funcionamientoPoliza;
    }

    public void setFuncionamientoPoliza(String funcionamientoPoliza) {
        this.funcionamientoPoliza = funcionamientoPoliza;
    }

    public String getObservacionesSuscripcion() {
        return observacionesSuscripcion;
    }

    public void setObservacionesSuscripcion(String observacionesSuscripcion) {
        this.observacionesSuscripcion = observacionesSuscripcion;
    }

    public String getObservacionesPoliza() {
        return observacionesPoliza;
    }

    public void setObservacionesPoliza(String observacionesPoliza) {
        this.observacionesPoliza = observacionesPoliza;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getActvidadEconomica() {
        return actvidadEconomica;
    }

    public void setActvidadEconomica(String actvidadEconomica) {
        this.actvidadEconomica = actvidadEconomica;
    }

    public String getDeducibleRobo() {
        return deducibleRobo;
    }

    public void setDeducibleRobo(String deducibleRobo) {
        this.deducibleRobo = deducibleRobo;
    }

    public String getParticipacionRobo() {
        return participacionRobo;
    }

    public void setParticipacionRobo(String participacionRobo) {
        this.participacionRobo = participacionRobo;
    }

    public String getTarifaRobo() {
        return tarifaRobo;
    }

    public void setTarifaRobo(String tarifaRobo) {
        this.tarifaRobo = tarifaRobo;
    }

    public String getAlcanceRobo() {
        return alcanceRobo;
    }

    public void setAlcanceRobo(String alcanceRobo) {
        this.alcanceRobo = alcanceRobo;
    }

    public String getTextoRobo() {
        return textoRobo;
    }

    public void setTextoRobo(String textoRobo) {
        this.textoRobo = textoRobo;
    }

    public String getDeducibleDineroValores() {
        return deducibleDineroValores;
    }

    public void setDeducibleDineroValores(String deducibleDineroValores) {
        this.deducibleDineroValores = deducibleDineroValores;
    }

    public String getParticiDineroValores() {
        return particiDineroValores;
    }

    public void setParticiDineroValores(String particiDineroValores) {
        this.particiDineroValores = particiDineroValores;
    }

    public String getTarifaDineroValores() {
        return tarifaDineroValores;
    }

    public void setTarifaDineroValores(String tarifaDineroValores) {
        this.tarifaDineroValores = tarifaDineroValores;
    }

    public String getAlcanceDineroValores() {
        return alcanceDineroValores;
    }

    public void setAlcanceDineroValores(String alcanceDineroValores) {
        this.alcanceDineroValores = alcanceDineroValores;
    }

    public String getTextoDineroValores() {
        return textoDineroValores;
    }

    public void setTextoDineroValores(String textoDineroValores) {
        this.textoDineroValores = textoDineroValores;
    }

    public String getNivelAgrupacion() {
        return nivelAgrupacion;
    }

    public void setNivelAgrupacion(String nivelAgrupacion) {
        this.nivelAgrupacion = nivelAgrupacion;
    }

    public String getDescuentosDonaciones() {
        return descuentosDonaciones;
    }

    public void setDescuentosDonaciones(String descuentosDonaciones) {
        this.descuentosDonaciones = descuentosDonaciones;
    }

    public static ArrayList getAsesuisaPolizaEmisionGeneral30282() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASE_POLIZAEMISION_30282 ORDER BY PRUEBA ASC");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_PolizaEmisionGeneral30282Bean bean = new Asesuisa_PolizaEmisionGeneral30282Bean();

                bean.setProducto(rs.getString("Producto"));
                bean.setVigencia(rs.getString("vigencia"));
                bean.setFechaDesde(rs.getString("fechaDesde"));
                bean.setFechaHasta(rs.getString("fechaHasta"));
                bean.setEventoAplicar(rs.getString("eventoAplicar"));
                bean.setFechaMovimiento(rs.getString("fechaMovimiento"));
                bean.setPlanesFinanciamiento(rs.getString("planesfinanciamiento"));
                bean.setMonedas(rs.getString("monedas"));
                bean.setSucursal(rs.getString("sucursal"));
                bean.setNumeroPoliza(rs.getString("numeropoliza"));
                bean.setTipoProduccion(rs.getString("TIPOPRODUCCION"));
                bean.setFuncionamientoPoliza(rs.getString("FUNCIONAMIENTOPOLIZA"));
                bean.setCanalVenta(rs.getString("CANALVENTA"));
                bean.setComisionNegociable(rs.getString("COMISIONNEGOCIABLE"));
                bean.setUnidadComercial(rs.getString("UNIDADCOMERCIAL"));
                bean.setProyectoDependencia(rs.getString("PROYECTODEPENDENCIA"));
                bean.setDPDVendedor(rs.getString("DPDVENDEDOR"));
                bean.setCodigoAgrupador(rs.getString("CODIGOAGRUPADOR"));
                bean.setObservacionesSuscripcion(rs.getString("OBSERVACIONESSUSCRIP"));
                bean.setObservacionesPoliza(rs.getString("OBSERVACIONESPOLIZA"));
                bean.setGiro(rs.getString("GIRO"));
                bean.setActvidadEconomica(rs.getString("ACTIVIDADECONOMICA"));
                bean.setDeducibleRobo(rs.getString("DEDUCIBLEROBO"));
                bean.setParticipacionRobo(rs.getString("PARTICIPACIONROBO"));
                bean.setTarifaRobo(rs.getString("TARIFAROBO"));
                bean.setAlcanceRobo(rs.getString("ALCANCEROBO"));
                bean.setTextoRobo(rs.getString("TEXTOROBO"));
                bean.setDeducibleDineroValores(rs.getString("DEDUCIBLEDINEROVALORES"));
                bean.setParticiDineroValores(rs.getString("PARTICIDINEROVALORES"));
                bean.setTarifaDineroValores(rs.getString("TARIFADINEROVALORES"));
                bean.setAlcanceDineroValores(rs.getString("ALCANCEDINEROVALORES"));
                bean.setTextoDineroValores(rs.getString("TEXTODINEROVALORES"));
                bean.setNivelAgrupacion(rs.getString("NIVELAGRUPACION"));
                bean.setDescuentosDonaciones(rs.getString("DESCUENTOSDONACIONES"));
                bean.setCodigoRamo(rs.getString("CODIGORAMO"));
                bean.setClasePoliza(rs.getString("CLASEPOLIZA"));
                bean.setTipoPoliza(rs.getString("TIPOPOLIZA"));
                bean.setTomador1Nombre1(rs.getString("TOMADOR1NOMBRE1"));
                bean.setAsegurado1Nombre1(rs.getString("ASEGURADO1NOMBRE1"));
                bean.setBeneficiario1Nombre1(rs.getString("BENEFICIARIO1NOMBRE1"));
                bean.setTipoBeneficiario1(rs.getString("TIPOBENEFICIARIO1"));

                poliza.add(bean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return poliza;
    }
}
