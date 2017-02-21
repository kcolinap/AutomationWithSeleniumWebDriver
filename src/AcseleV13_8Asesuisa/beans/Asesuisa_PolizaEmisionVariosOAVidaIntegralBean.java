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
 * Created by agil on 21/02/2017.
 */
public class Asesuisa_PolizaEmisionVariosOAVidaIntegralBean extends Asesuisa_PolizasBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionVariosOAVidaIntegralBean.class);

    public static ArrayList getAsesuisa_PolizaEmisionVariosOAVidaIntegral() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASE_POLIZAEMISION_OA_VID_INTE ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_PolizaEmisionVariosOAVidaIntegralBean asesuisaPolizaEmisionVariosOAVidaIntegralBean = new Asesuisa_PolizaEmisionVariosOAVidaIntegralBean();

                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setProducto(rs.getString("Producto"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setVigencia(rs.getString("vigencia"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setFechaDesde(rs.getString("fechaDesde"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setFechaHasta(rs.getString("fechaHasta"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setEventoAplicar(rs.getString("eventoAplicar"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setFechaMovimiento(rs.getString("fechaMovimiento"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPlanesFinanciamiento(rs.getString("planesFinanciamiento"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setMonedas(rs.getString("monedas"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setSucursal(rs.getString("sucursal"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNumeroPoliza(rs.getString("numeroPoliza"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNumeroPolizaBlanca(rs.getString("numeroPolizaBlanca"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNumeroCotizacion(rs.getString("numeroCotizacion"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setFechaEmision(rs.getString("fechaEmision"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setTipoPoliza(rs.getString("tipoPoliza"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setTipoProduccion(rs.getString("tipoProduccion"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setCanalVenta(rs.getString("canalVenta"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setCodigoRamo(rs.getString("codigoRamo"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setClasePoliza(rs.getString("clasePoliza"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setObservacionSuscripcion(rs.getString("observacionSuscripcion"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setComisionNegociable(rs.getString("comisionNegociable"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNivelAgrupacionReaseguro(rs.getString("nivelAgrupacionReaseguro"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setUnidadComercial(rs.getString("unidadComercial"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setProyectoDependencia(rs.getString("proyectoDependencia"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setDPDVendedor(rs.getString("dPDVendedor"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNombreVendedorBancaseguros(rs.getString("nombreVendedorBancaseguros"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setCodigoAgenciaVentas(rs.getString("codigoAgenciaVentas"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNombreAgenciaVentas(rs.getString("nombreAgenciaVentas"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setCiudadAgenciaBancaria(rs.getString("ciudadAgenciaBancaria"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setCanalVentaBancaseguros(rs.getString("canalVentaBancaseguros"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setGrupoAgencia(rs.getString("grupoAgencia"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setDistritoComercial(rs.getString("distritoComercial"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setDistritoOperativo(rs.getString("distritoOperativo"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setSupervisorBancaseguros(rs.getString("supervisorBancaseguros"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setTomador1Nombre1(rs.getString("tomador1Nombre1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setTomador1Nombre2(rs.getString("tomador1Nombre2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setTomador1Apellido1(rs.getString("tomador1Apellido1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setTomador1Apellido2(rs.getString("tomador1Apellido2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPorcentajeTomador1(rs.getString("porcentajeTomador1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPorcentajeTomador2(rs.getString("porcentajeTomador2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsesor1Nombre1(rs.getString("asesor1Nombre1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsesor1Nombre2(rs.getString("asesor1Nombre2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsesor1Apellido1(rs.getString("asesor1Apellido1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsesor1Apellido2(rs.getString("asesor1Apellido2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPorcentajeAsesor1(rs.getString("porcentajeAsesor1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPorcentajeAsesor2(rs.getString("porcentajeAsesor2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setVendedor1Nombre1(rs.getString("vendedor1Nombre1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setVendedor1Nombre2(rs.getString("vendedor1Nombre2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setVendedor1Apellido1(rs.getString("vendedor1Apellido1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setVendedor1Apellido2(rs.getString("vendedor1Apellido2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPorcentajeVendedor1(rs.getString("porcentajeVendedor1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPorcentajeVendedor2(rs.getString("porcentajeVendedor2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNumeroUnidadRiesgo1(rs.getString("numeroUnidadRiesgo1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNumeroUnidadRiesgo2(rs.getString("numeroUnidadRiesgo2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNumeroObjetoAsegurado1(rs.getString("numeroObjetoAsegurado1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setOpcionAsegurado1(rs.getString("opcionAsegurado1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPrima1(rs.getString("prima1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setComision1(rs.getString("comision1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setEdadEmision1(rs.getString("edadEmision1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setRangoEdades1(rs.getString("rangoEdades1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setCodigoPlan1(rs.getString("codigoPlan1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNombrePlan1(rs.getString("nombrePlan1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNumeroObjetoAsegurado2(rs.getString("numeroObjetoAsegurado2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setOpcionAsegurado2(rs.getString("opcionAsegurado2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPrima2(rs.getString("prima2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setComision2(rs.getString("comision2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setEdadEmision2(rs.getString("edadEmision2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setRangoEdades2(rs.getString("rangoEdades2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setCodigoPlan2(rs.getString("codigoPlan2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setNombrePlan2(rs.getString("nombrePlan2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsegurado1Nombre1(rs.getString("asegurado1Nombre1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsegurado1Nombre2(rs.getString("asegurado1Nombre2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsegurado1Apellido1(rs.getString("asegurado1Apellido1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsegurado1Apellido2(rs.getString("asegurado1Apellido2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPorcentajeAsegurado1(rs.getString("porcentajeAsegurado1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsegurado2Nombre1(rs.getString("asegurado2Nombre1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsegurado2Nombre2(rs.getString("asegurado2Nombre2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsegurado2Apellido1(rs.getString("asegurado2Apellido1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setAsegurado2Apellido2(rs.getString("asegurado2Apellido2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPorcentajeAsegurado2(rs.getString("porcentajeAsegurado2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setBeneficiario1Nombre1(rs.getString("beneficiario1Nombre1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setBeneficiario1Nombre2(rs.getString("beneficiario1Nombre2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setBeneficiario1Apellido1(rs.getString("beneficiario1Apellido1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setBeneficiario1Apellido2(rs.getString("beneficiario1Apellido2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setTipoBeneficiario1(rs.getString("tipoBeneficiario1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPorcentajeBeneficiario1(rs.getString("porcentajeBeneficiario1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setBeneficiario2Nombre1(rs.getString("beneficiario2Nombre1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setBeneficiario2Nombre2(rs.getString("beneficiario2Nombre2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setBeneficiario2Apellido1(rs.getString("beneficiario2Apellido1"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setBeneficiario2Apellido2(rs.getString("beneficiario2Apellido2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setTipoBeneficiario2(rs.getString("tipoBeneficiario2"));
                asesuisaPolizaEmisionVariosOAVidaIntegralBean.setPorcentajeBeneficiario2(rs.getString("porcentajeBeneficiario2"));


                poliza.add(asesuisaPolizaEmisionVariosOAVidaIntegralBean);
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
