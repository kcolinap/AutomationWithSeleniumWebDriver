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
 * Created by agil on 21/03/2017.
 */
public class Asesuisa_PolizaEmisionVariosURVidaIntegralBean extends Asesuisa_PolizasBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionVariosURVidaIntegralBean.class);

    public static ArrayList getAsesuisa_PolizaEmisionVariosURVidaIntegral() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_PolizaEmisionVariosURVidaIntegralBean bean = new Asesuisa_PolizaEmisionVariosURVidaIntegralBean();

                bean.setProducto(rs.getString("Producto"));
                bean.setVigencia(rs.getString("vigencia"));
                bean.setFechaDesde(rs.getString("fechaDesde"));
                bean.setFechaHasta(rs.getString("fechaHasta"));
                bean.setEventoAplicar(rs.getString("eventoAplicar"));
                bean.setFechaMovimiento(rs.getString("fechaMovimiento"));
                bean.setPlanesFinanciamiento(rs.getString("planesFinanciamiento"));
                bean.setMonedas(rs.getString("monedas"));
                bean.setSucursal(rs.getString("sucursal"));
                bean.setNumeroPoliza(rs.getString("numeroPoliza"));
                bean.setNumeroPolizaBlanca(rs.getString("numeroPolizaBlanca"));
                bean.setNumeroCotizacion(rs.getString("numeroCotizacion"));
                bean.setFechaEmision(rs.getString("fechaEmision"));
                bean.setTipoPoliza(rs.getString("tipoPoliza"));
                bean.setTipoProduccion(rs.getString("tipoProduccion"));
                bean.setCanalVenta(rs.getString("canalVenta"));
                bean.setCodigoRamo(rs.getString("codigoRamo"));
                bean.setClasePoliza(rs.getString("clasePoliza"));
                bean.setObservacionSuscripcion(rs.getString("observacionSuscripcion"));
                bean.setComisionNegociable(rs.getString("comisionNegociable"));
                bean.setNivelAgrupacionReaseguro(rs.getString("nivelAgrupacionReaseguro"));
                bean.setUnidadComercial(rs.getString("unidadComercial"));
                bean.setProyectoDependencia(rs.getString("proyectoDependencia"));
                bean.setDPDVendedor(rs.getString("dPDVendedor"));
                bean.setNombreVendedorBancaseguros(rs.getString("nombreVendedorBancaseguros"));
                bean.setCodigoAgenciaVentas(rs.getString("codigoAgenciaVentas"));
                bean.setNombreAgenciaVentas(rs.getString("nombreAgenciaVentas"));
                bean.setCiudadAgenciaBancaria(rs.getString("ciudadAgenciaBancaria"));
                bean.setCanalVentaBancaseguros(rs.getString("canalVentaBancaseguros"));
                bean.setGrupoAgencia(rs.getString("grupoAgencia"));
                bean.setDistritoComercial(rs.getString("distritoComercial"));
                bean.setDistritoOperativo(rs.getString("distritoOperativo"));
                bean.setSupervisorBancaseguros(rs.getString("supervisorBancaseguros"));
                bean.setTomador1Nombre1(rs.getString("tomador1Nombre1"));
                bean.setTomador1Nombre2(rs.getString("tomador1Nombre2"));
                bean.setTomador1Apellido1(rs.getString("tomador1Apellido1"));
                bean.setTomador1Apellido2(rs.getString("tomador1Apellido2"));
                bean.setPorcentajeTomador1(rs.getString("porcentajeTomador1"));
                bean.setPorcentajeTomador2(rs.getString("porcentajeTomador2"));
                bean.setAsesor1Nombre1(rs.getString("asesor1Nombre1"));
                bean.setAsesor1Nombre2(rs.getString("asesor1Nombre2"));
                bean.setAsesor1Apellido1(rs.getString("asesor1Apellido1"));
                bean.setAsesor1Apellido2(rs.getString("asesor1Apellido2"));
                bean.setPorcentajeAsesor1(rs.getString("porcentajeAsesor1"));
                bean.setPorcentajeAsesor2(rs.getString("porcentajeAsesor2"));
                bean.setVendedor1Nombre1(rs.getString("vendedor1Nombre1"));
                bean.setVendedor1Nombre2(rs.getString("vendedor1Nombre2"));
                bean.setVendedor1Apellido1(rs.getString("vendedor1Apellido1"));
                bean.setVendedor1Apellido2(rs.getString("vendedor1Apellido2"));
                bean.setPorcentajeVendedor1(rs.getString("porcentajeVendedor1"));
                bean.setPorcentajeVendedor2(rs.getString("porcentajeVendedor2"));
                bean.setNumeroUnidadRiesgo1(rs.getString("numeroUnidadRiesgo1"));
                bean.setNumeroUnidadRiesgo2(rs.getString("numeroUnidadRiesgo2"));
                bean.setNumeroObjetoAsegurado1(rs.getString("numeroObjetoAsegurado1"));
                bean.setOpcionAsegurado1(rs.getString("opcionAsegurado1"));
                bean.setPrima1(rs.getString("prima1"));
                bean.setComision1(rs.getString("comision1"));
                bean.setEdadEmision1(rs.getString("edadEmision1"));
                bean.setRangoEdades1(rs.getString("rangoEdades1"));
                bean.setCodigoPlan1(rs.getString("codigoPlan1"));
                bean.setNombrePlan1(rs.getString("nombrePlan1"));
                bean.setNumeroObjetoAsegurado2(rs.getString("numeroObjetoAsegurado2"));
                bean.setOpcionAsegurado2(rs.getString("opcionAsegurado2"));
                bean.setPrima2(rs.getString("prima2"));
                bean.setComision2(rs.getString("comision2"));
                bean.setEdadEmision2(rs.getString("edadEmision2"));
                bean.setRangoEdades2(rs.getString("rangoEdades2"));
                bean.setCodigoPlan2(rs.getString("codigoPlan2"));
                bean.setNombrePlan2(rs.getString("nombrePlan2"));
                bean.setAsegurado1Nombre1(rs.getString("asegurado1Nombre1"));
                bean.setAsegurado1Nombre2(rs.getString("asegurado1Nombre2"));
                bean.setAsegurado1Apellido1(rs.getString("asegurado1Apellido1"));
                bean.setAsegurado1Apellido2(rs.getString("asegurado1Apellido2"));
                bean.setPorcentajeAsegurado1(rs.getString("porcentajeAsegurado1"));
                bean.setAsegurado2Nombre1(rs.getString("asegurado2Nombre1"));
                bean.setAsegurado2Nombre2(rs.getString("asegurado2Nombre2"));
                bean.setAsegurado2Apellido1(rs.getString("asegurado2Apellido1"));
                bean.setAsegurado2Apellido2(rs.getString("asegurado2Apellido2"));
                bean.setPorcentajeAsegurado2(rs.getString("porcentajeAsegurado2"));
                bean.setBeneficiario1Nombre1(rs.getString("beneficiario1Nombre1"));
                bean.setBeneficiario1Nombre2(rs.getString("beneficiario1Nombre2"));
                bean.setBeneficiario1Apellido1(rs.getString("beneficiario1Apellido1"));
                bean.setBeneficiario1Apellido2(rs.getString("beneficiario1Apellido2"));
                bean.setTipoBeneficiario1(rs.getString("tipoBeneficiario1"));
                bean.setPorcentajeBeneficiario1(rs.getString("porcentajeBeneficiario1"));
                bean.setBeneficiario2Nombre1(rs.getString("beneficiario2Nombre1"));
                bean.setBeneficiario2Nombre2(rs.getString("beneficiario2Nombre2"));
                bean.setBeneficiario2Apellido1(rs.getString("beneficiario2Apellido1"));
                bean.setBeneficiario2Apellido2(rs.getString("beneficiario2Apellido2"));
                bean.setTipoBeneficiario2(rs.getString("tipoBeneficiario2"));
                bean.setPorcentajeBeneficiario2(rs.getString("porcentajeBeneficiario2"));


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
