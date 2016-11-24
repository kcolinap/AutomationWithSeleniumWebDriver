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
 * Created by agil on 22/11/2016.
 */
public class Inter_PolizaEmisionVariosOABean extends Inter_PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(Inter_TercerosCrearBean.class);

    public static ArrayList getInter_PolizaEmisionVariosOA() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM POLIZA_VARIOS_OA_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Inter_PolizaEmisionVariosOABean interPolizaEmisionVariosOABean = new Inter_PolizaEmisionVariosOABean();

                interPolizaEmisionVariosOABean.setProducto(rs.getString("Producto"));
                interPolizaEmisionVariosOABean.setVigencia(rs.getString("Vigencia"));
                interPolizaEmisionVariosOABean.setFechaDesde(rs.getString("FechaDesde"));
                interPolizaEmisionVariosOABean.setFechaHasta(rs.getString("FechaHasta"));
                interPolizaEmisionVariosOABean.setEventoAplicar(rs.getString("EventoAplicar"));
                interPolizaEmisionVariosOABean.setFechaMovimiento(rs.getString("FechaMovimiento"));
                interPolizaEmisionVariosOABean.setPlanesFinanciamiento(rs.getString("PlanesFinanciamiento"));
                interPolizaEmisionVariosOABean.setMonedas(rs.getString("Monedas"));
                interPolizaEmisionVariosOABean.setOficina(rs.getString("Oficina"));
                interPolizaEmisionVariosOABean.setNumeroPoliza(rs.getString("NumeroPoliza"));
                interPolizaEmisionVariosOABean.setFechaEmision(rs.getString("FechaEmision"));
                interPolizaEmisionVariosOABean.setCanalVenta(rs.getString("CanalVenta"));
                interPolizaEmisionVariosOABean.setFrecuenciaPago(rs.getString("FrecuenciaPago"));
                interPolizaEmisionVariosOABean.setFechaEventoAnterior(rs.getString("FechaEventoAnterior"));
                interPolizaEmisionVariosOABean.setFechaProximaGeneracionPrima(rs.getString("FechaProximaGeneracionPrima"));
                interPolizaEmisionVariosOABean.setFechaProximaFacturacion(rs.getString("FechaProximaFacturacion"));
                interPolizaEmisionVariosOABean.setNumeroPlan(rs.getString("NumeroPlan"));
                interPolizaEmisionVariosOABean.setFechaEmisionEnAcsele(rs.getString("FechaEmisionEnAcsele"));
                interPolizaEmisionVariosOABean.setPlanInteligo(rs.getString("PlanInteligo"));
                interPolizaEmisionVariosOABean.setNivelAgrupamientoReaseguro(rs.getString("NivelAgrupamientoReaseguro"));
                interPolizaEmisionVariosOABean.setFechaVenta(rs.getString("FechaVenta"));
                interPolizaEmisionVariosOABean.setClaseReaseguro(rs.getString("ClaseReaseguro"));
                interPolizaEmisionVariosOABean.setNumeroCotizacion(rs.getString("NumeroCotizacion"));
                interPolizaEmisionVariosOABean.setNumeroPropuesta(rs.getString("NumeroPropuesta"));
                interPolizaEmisionVariosOABean.setAcuerdos(rs.getString("Acuerdos"));
                interPolizaEmisionVariosOABean.setContratante1Nombre1(rs.getString("Contratante1Nombre1"));
                interPolizaEmisionVariosOABean.setContratante1Nombre2(rs.getString("Contratante1Nombre2"));
                interPolizaEmisionVariosOABean.setContratante1Apellido1(rs.getString("Contratante1Apellido1"));
                interPolizaEmisionVariosOABean.setContratante1Apellido2(rs.getString("Contratante1Apellido2"));
                interPolizaEmisionVariosOABean.setPorcentajeContratante1(rs.getString("PorcentajeContratante1"));
                interPolizaEmisionVariosOABean.setNumeroUnidadRiesgo1(rs.getString("NumeroUnidadRiesgo1"));
                interPolizaEmisionVariosOABean.setNumeroUnidadRiesgo2(rs.getString("NumeroUnidadRiesgo2"));
                interPolizaEmisionVariosOABean.setNumeroObjetoAsegurado1(rs.getString("NumeroObjetoAsegurado1"));
                interPolizaEmisionVariosOABean.setNombreCompletoAsegurado1(rs.getString("NombreCompletoAsegurado1"));
                interPolizaEmisionVariosOABean.setNombreCompletoBeneficiario1(rs.getString("NombreCompletoBeneficiario1"));
                interPolizaEmisionVariosOABean.setNumeroObjetoAsegurado2(rs.getString("NumeroObjetoAsegurado2"));
                interPolizaEmisionVariosOABean.setNombreCompletoAsegurado2(rs.getString("NombreCompletoAsegurado2"));
                interPolizaEmisionVariosOABean.setNombreCompletoBeneficiario2(rs.getString("NombreCompletoBeneficiario2"));
                interPolizaEmisionVariosOABean.setAsegurado1Nombre1(rs.getString("Asegurado1Nombre1"));
                interPolizaEmisionVariosOABean.setAsegurado1Nombre2(rs.getString("Asegurado1Nombre2"));
                interPolizaEmisionVariosOABean.setAsegurado1Apellido1(rs.getString("Asegurado1Apellido1"));
                interPolizaEmisionVariosOABean.setAsegurado1Apellido2(rs.getString("Asegurado1Apellido2"));
                interPolizaEmisionVariosOABean.setPorcentajeAsegurado1(rs.getString("PorcentajeAsegurado1"));
                interPolizaEmisionVariosOABean.setAsegurado2Nombre1(rs.getString("Asegurado2Nombre1"));
                interPolizaEmisionVariosOABean.setAsegurado2Nombre2(rs.getString("Asegurado2Nombre2"));
                interPolizaEmisionVariosOABean.setAsegurado2Apellido1(rs.getString("Asegurado2Apellido1"));
                interPolizaEmisionVariosOABean.setAsegurado2Apellido2(rs.getString("Asegurado2Apellido2"));
                interPolizaEmisionVariosOABean.setPorcentajeAsegurado2(rs.getString("PorcentajeAsegurado2"));
                interPolizaEmisionVariosOABean.setBeneficiario1Nombre1(rs.getString("Beneficiario1Nombre1"));
                interPolizaEmisionVariosOABean.setBeneficiario1Nombre2(rs.getString("Beneficiario1Nombre2"));
                interPolizaEmisionVariosOABean.setBeneficiario1Apellido1(rs.getString("Beneficiario1Apellido1"));
                interPolizaEmisionVariosOABean.setBeneficiario1Apellido2(rs.getString("Beneficiario1Apellido2"));
                interPolizaEmisionVariosOABean.setTipoBeneficiario1(rs.getString("TipoBeneficiario1"));
                interPolizaEmisionVariosOABean.setBeneficiarioIrrevocable1(rs.getString("BeneficiarioIrrevocable1"));
                interPolizaEmisionVariosOABean.setPorcentajeBeneficiario1(rs.getString("PorcentajeBeneficiario1"));
                interPolizaEmisionVariosOABean.setCodigoBeneficiario1(rs.getString("CodigoBeneficiario1"));
                interPolizaEmisionVariosOABean.setParentescoBeneficiario1(rs.getString("ParentescoBeneficiario1"));
                interPolizaEmisionVariosOABean.setBeneficiario2Nombre1(rs.getString("Beneficiario2Nombre1"));
                interPolizaEmisionVariosOABean.setBeneficiario2Nombre2(rs.getString("Beneficiario2Nombre2"));
                interPolizaEmisionVariosOABean.setBeneficiario2Apellido1(rs.getString("Beneficiario2Apellido1"));
                interPolizaEmisionVariosOABean.setBeneficiario2Apellido2(rs.getString("Beneficiario2Apellido2"));
                interPolizaEmisionVariosOABean.setTipoBeneficiario2(rs.getString("TipoBeneficiario2"));
                interPolizaEmisionVariosOABean.setBeneficiarioIrrevocable2(rs.getString("BeneficiarioIrrevocable2"));
                interPolizaEmisionVariosOABean.setPorcentajeBeneficiario2(rs.getString("PorcentajeBeneficiario2"));
                interPolizaEmisionVariosOABean.setCodigoBeneficiario2(rs.getString("CodigoBeneficiario2"));
                interPolizaEmisionVariosOABean.setParentescoBeneficiario2(rs.getString("ParentescoBeneficiario2"));


                poliza.add(interPolizaEmisionVariosOABean);
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
