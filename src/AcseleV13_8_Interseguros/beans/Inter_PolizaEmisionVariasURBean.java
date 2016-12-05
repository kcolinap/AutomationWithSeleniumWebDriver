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
 * Created by agil on 04/12/2016.
 */
public class Inter_PolizaEmisionVariasURBean extends Inter_PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(Inter_TercerosCrearBean.class);

    public static ArrayList getInter_PolizaEmisionVariasUR() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM POLIZA_VARIAS_UR_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Inter_PolizaEmisionVariasURBean interPolizaEmisionVariasURBean = new Inter_PolizaEmisionVariasURBean();

                interPolizaEmisionVariasURBean.setProducto(rs.getString("Producto"));
                interPolizaEmisionVariasURBean.setVigencia(rs.getString("Vigencia"));
                interPolizaEmisionVariasURBean.setFechaDesde(rs.getString("FechaDesde"));
                interPolizaEmisionVariasURBean.setFechaHasta(rs.getString("FechaHasta"));
                interPolizaEmisionVariasURBean.setEventoAplicar(rs.getString("EventoAplicar"));
                interPolizaEmisionVariasURBean.setFechaMovimiento(rs.getString("FechaMovimiento"));
                interPolizaEmisionVariasURBean.setPlanesFinanciamiento(rs.getString("PlanesFinanciamiento"));
                interPolizaEmisionVariasURBean.setMonedas(rs.getString("Monedas"));
                interPolizaEmisionVariasURBean.setOficina(rs.getString("Oficina"));
                interPolizaEmisionVariasURBean.setNumeroPoliza(rs.getString("NumeroPoliza"));
                interPolizaEmisionVariasURBean.setFechaEmision(rs.getString("FechaEmision"));
                interPolizaEmisionVariasURBean.setCanalVenta(rs.getString("CanalVenta"));
                interPolizaEmisionVariasURBean.setFrecuenciaPago(rs.getString("FrecuenciaPago"));
                interPolizaEmisionVariasURBean.setFechaEventoAnterior(rs.getString("FechaEventoAnterior"));
                interPolizaEmisionVariasURBean.setFechaProximaGeneracionPrima(rs.getString("FechaProximaGeneracionPrima"));
                interPolizaEmisionVariasURBean.setFechaProximaFacturacion(rs.getString("FechaProximaFacturacion"));
                interPolizaEmisionVariasURBean.setNumeroPlan(rs.getString("NumeroPlan"));
                interPolizaEmisionVariasURBean.setFechaEmisionEnAcsele(rs.getString("FechaEmisionEnAcsele"));
                interPolizaEmisionVariasURBean.setPlanInteligo(rs.getString("PlanInteligo"));
                interPolizaEmisionVariasURBean.setNivelAgrupamientoReaseguro(rs.getString("NivelAgrupamientoReaseguro"));
                interPolizaEmisionVariasURBean.setFechaVenta(rs.getString("FechaVenta"));
                interPolizaEmisionVariasURBean.setClaseReaseguro(rs.getString("ClaseReaseguro"));
                interPolizaEmisionVariasURBean.setNumeroCotizacion(rs.getString("NumeroCotizacion"));
                interPolizaEmisionVariasURBean.setNumeroPropuesta(rs.getString("NumeroPropuesta"));
                interPolizaEmisionVariasURBean.setAcuerdos(rs.getString("Acuerdos"));
                interPolizaEmisionVariasURBean.setContratante1Nombre1(rs.getString("Contratante1Nombre1"));
                interPolizaEmisionVariasURBean.setContratante1Nombre2(rs.getString("Contratante1Nombre2"));
                interPolizaEmisionVariasURBean.setContratante1Apellido1(rs.getString("Contratante1Apellido1"));
                interPolizaEmisionVariasURBean.setContratante1Apellido2(rs.getString("Contratante1Apellido2"));
                interPolizaEmisionVariasURBean.setPorcentajeContratante1(rs.getString("PorcentajeContratante1"));
                interPolizaEmisionVariasURBean.setNumeroUnidadRiesgo1(rs.getString("NumeroUnidadRiesgo1"));
                interPolizaEmisionVariasURBean.setNumeroUnidadRiesgo2(rs.getString("NumeroUnidadRiesgo2"));
                interPolizaEmisionVariasURBean.setNumeroObjetoAsegurado1(rs.getString("NumeroObjetoAsegurado1"));
                interPolizaEmisionVariasURBean.setNombreCompletoAsegurado1(rs.getString("NombreCompletoAsegurado1"));
                interPolizaEmisionVariasURBean.setNombreCompletoBeneficiario1(rs.getString("NombreCompletoBeneficiario1"));
                interPolizaEmisionVariasURBean.setNumeroObjetoAsegurado2(rs.getString("NumeroObjetoAsegurado2"));
                interPolizaEmisionVariasURBean.setNombreCompletoAsegurado2(rs.getString("NombreCompletoAsegurado2"));
                interPolizaEmisionVariasURBean.setNombreCompletoBeneficiario2(rs.getString("NombreCompletoBeneficiario2"));
                interPolizaEmisionVariasURBean.setAsegurado1Nombre1(rs.getString("Asegurado1Nombre1"));
                interPolizaEmisionVariasURBean.setAsegurado1Nombre2(rs.getString("Asegurado1Nombre2"));
                interPolizaEmisionVariasURBean.setAsegurado1Apellido1(rs.getString("Asegurado1Apellido1"));
                interPolizaEmisionVariasURBean.setAsegurado1Apellido2(rs.getString("Asegurado1Apellido2"));
                interPolizaEmisionVariasURBean.setPorcentajeAsegurado1(rs.getString("PorcentajeAsegurado1"));
                interPolizaEmisionVariasURBean.setAsegurado2Nombre1(rs.getString("Asegurado2Nombre1"));
                interPolizaEmisionVariasURBean.setAsegurado2Nombre2(rs.getString("Asegurado2Nombre2"));
                interPolizaEmisionVariasURBean.setAsegurado2Apellido1(rs.getString("Asegurado2Apellido1"));
                interPolizaEmisionVariasURBean.setAsegurado2Apellido2(rs.getString("Asegurado2Apellido2"));
                interPolizaEmisionVariasURBean.setPorcentajeAsegurado2(rs.getString("PorcentajeAsegurado2"));
                interPolizaEmisionVariasURBean.setBeneficiario1Nombre1(rs.getString("Beneficiario1Nombre1"));
                interPolizaEmisionVariasURBean.setBeneficiario1Nombre2(rs.getString("Beneficiario1Nombre2"));
                interPolizaEmisionVariasURBean.setBeneficiario1Apellido1(rs.getString("Beneficiario1Apellido1"));
                interPolizaEmisionVariasURBean.setBeneficiario1Apellido2(rs.getString("Beneficiario1Apellido2"));
                interPolizaEmisionVariasURBean.setTipoBeneficiario1(rs.getString("TipoBeneficiario1"));
                interPolizaEmisionVariasURBean.setBeneficiarioIrrevocable1(rs.getString("BeneficiarioIrrevocable1"));
                interPolizaEmisionVariasURBean.setPorcentajeBeneficiario1(rs.getString("PorcentajeBeneficiario1"));
                interPolizaEmisionVariasURBean.setCodigoBeneficiario1(rs.getString("CodigoBeneficiario1"));
                interPolizaEmisionVariasURBean.setParentescoBeneficiario1(rs.getString("ParentescoBeneficiario1"));
                interPolizaEmisionVariasURBean.setBeneficiario2Nombre1(rs.getString("Beneficiario2Nombre1"));
                interPolizaEmisionVariasURBean.setBeneficiario2Nombre2(rs.getString("Beneficiario2Nombre2"));
                interPolizaEmisionVariasURBean.setBeneficiario2Apellido1(rs.getString("Beneficiario2Apellido1"));
                interPolizaEmisionVariasURBean.setBeneficiario2Apellido2(rs.getString("Beneficiario2Apellido2"));
                interPolizaEmisionVariasURBean.setTipoBeneficiario2(rs.getString("TipoBeneficiario2"));
                interPolizaEmisionVariasURBean.setBeneficiarioIrrevocable2(rs.getString("BeneficiarioIrrevocable2"));
                interPolizaEmisionVariasURBean.setPorcentajeBeneficiario2(rs.getString("PorcentajeBeneficiario2"));
                interPolizaEmisionVariasURBean.setCodigoBeneficiario2(rs.getString("CodigoBeneficiario2"));
                interPolizaEmisionVariasURBean.setParentescoBeneficiario2(rs.getString("ParentescoBeneficiario2"));
                interPolizaEmisionVariasURBean.setCanalVentaVida(rs.getString("canalVentaVida"));
                interPolizaEmisionVariasURBean.setAplicaDescuento(rs.getString("aplicaDescuento"));
                interPolizaEmisionVariasURBean.setTipoDocumento(rs.getString("tipoDocumento"));
                interPolizaEmisionVariasURBean.setNumeroDocumento(rs.getString("numeroDocumento"));
                interPolizaEmisionVariasURBean.setTipoPago(rs.getString("tipoPago"));
                interPolizaEmisionVariasURBean.setNumeroOperacion(rs.getString("numeroOperacion"));
                interPolizaEmisionVariasURBean.setMonedaTransaccion(rs.getString("monedaTransaccion"));
                interPolizaEmisionVariasURBean.setMontoTransaccion(rs.getString("montoTransaccion"));
                interPolizaEmisionVariasURBean.setMonedaDePrima(rs.getString("monedaDePrima"));
                interPolizaEmisionVariasURBean.setMontoPrimeraPrima(rs.getString("montoPrimeraPrima"));
                interPolizaEmisionVariasURBean.setFechaCotizacion(rs.getString("fechaCotizacion"));
                interPolizaEmisionVariasURBean.setNumeroPropuestaAnterior(rs.getString("numeroPropuestaAnterior"));
                interPolizaEmisionVariasURBean.setCambioNumeroPropuesta(rs.getString("CambioNumeroPropuesta"));
                interPolizaEmisionVariasURBean.setIndicadorDPS(rs.getString("indicadorDPS"));
                interPolizaEmisionVariasURBean.setEnvioComunicacionesPoliza(rs.getString("enviocomunicacionesPoliza"));
                interPolizaEmisionVariasURBean.setEnvioComunicacionesEndoso(rs.getString("enviocomunicacionesEndoso"));
                interPolizaEmisionVariasURBean.setPrevalizacionViaCobro(rs.getString("prevalizacionViaCobro"));
                interPolizaEmisionVariasURBean.setAgenteInicialPoliza(rs.getString("agenteInicialPoliza"));
                interPolizaEmisionVariasURBean.setCodigoAgenteInicial(rs.getString("codigoAgenteInicial"));
                interPolizaEmisionVariasURBean.setCorreoAgenteInicial(rs.getString("correoAgenteInicial"));
                interPolizaEmisionVariasURBean.setCodigoAgenciaInicial(rs.getString("codigoAgenciaInicial"));
                interPolizaEmisionVariasURBean.setAgenteFinalPoliza(rs.getString("agenteFinalPoliza"));
                interPolizaEmisionVariasURBean.setCodigoAgenteFinal(rs.getString("codigoAgenteFinal"));
                interPolizaEmisionVariasURBean.setCorreoAgenteFinal(rs.getString("correoAgenteFinal"));
                interPolizaEmisionVariasURBean.setCodigoAgenciaFinal(rs.getString("codigoAgenciaFinal"));
                interPolizaEmisionVariasURBean.setPeriodoDiasProcedeSuspencionCancelacion(rs.getString("periodoDiasProcedeSuspCancel"));
                interPolizaEmisionVariasURBean.setProductosVida(rs.getString("productosVida"));
                interPolizaEmisionVariasURBean.setPlan(rs.getString("plan"));
                interPolizaEmisionVariasURBean.setFechaProxGenPrimaVi(rs.getString("fechaProxGenPrimaVi"));
                interPolizaEmisionVariasURBean.setPolizaCesionada(rs.getString("polizaCesionada"));
                interPolizaEmisionVariasURBean.setLoginUsuario(rs.getString("loginUsiario"));
                interPolizaEmisionVariasURBean.setCapitalAseguradoCoberturaFallecimiento1(rs.getString("capitalAsegCobFallecimiento1"));
                interPolizaEmisionVariasURBean.setCapitalAseguradoCoberturaFallecimiento2(rs.getString("capitalAsegCobFallecimiento2"));
                interPolizaEmisionVariasURBean.setNumOACOT(rs.getString("numOACOT"));
                interPolizaEmisionVariasURBean.setFechaNacimientoCotizador(rs.getString("fechaNacimientoCotizador"));
                interPolizaEmisionVariasURBean.setSexoAseguradoCotizador(rs.getString("sexoAseguradoCotizador"));
                interPolizaEmisionVariasURBean.setCotizadorFumador(rs.getString("cotizadorFumador"));
                interPolizaEmisionVariasURBean.setEdadActuarialAsegurado(rs.getString("edadActuarialAsegurado"));
                interPolizaEmisionVariasURBean.setEdadMinimaIngreso(rs.getString("edadMinimaIngreso"));
                interPolizaEmisionVariasURBean.setEdadMaximaIngreso(rs.getString("edadMaximaIngreso"));
                interPolizaEmisionVariasURBean.setEdadMaximaPermanencia(rs.getString("edadMaximaPermanencia"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario1Apellido1(rs.getString("infBenef1Apellido1"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario1Apellido2(rs.getString("infBenef1Apellido2"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario1Nombres(rs.getString("infBenef1Nombres"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario1FechaNacimiento(rs.getString("infBenef1FechaNacimiento"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario1DocumentoIdentidad(rs.getString("infBenef1DocumentoIdentidad"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario1Parentesco(rs.getString("infBenef1Parentesco"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario1PorcDistribucion(rs.getString("infBenef1PorcDistribucion"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario2Apellido1(rs.getString("infBenef2Apellido1"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario2Apellido2(rs.getString("infBenef2Apellido2"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario2Nombres(rs.getString("infBenef2Nombres"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario2FechaNacimiento(rs.getString("infBenef2FechaNacimiento"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario2DocumentoIdentidad(rs.getString("infBenef2DocumentoIdentidad"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario2Parentesco(rs.getString("infBenef2Parentesco"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario2PorcDistribucion(rs.getString("infBenef2PorcDistribucion"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario3Apellido1(rs.getString("infBenef3Apellido1"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario3Apellido2(rs.getString("infBenef3Apellido2"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario3Nombres(rs.getString("infBenef3Nombres"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario3FechaNacimiento(rs.getString("infBenef3FechaNacimiento"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario3DocumentoIdentidad(rs.getString("infBenef3DocumentoIdentidad"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario3Parentesco(rs.getString("infBenef3Parentesco"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiario3PorcDistribucion(rs.getString("infBenef3PorcDistribucion"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente1Apellido1(rs.getString("infBenefCont1Apellido1"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente1Apellido2(rs.getString("infBenefCont1Apellido2"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente1Nombres(rs.getString("infBenefCont1Nombres"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente1FechaNacimiento(rs.getString("infBenefCont1FechaNac"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente1DocumentoIdentidad(rs.getString("infBenefCont1DocIdentidad"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente1Parentesco(rs.getString("infBenefCont1Parentesco"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente1PorcDistribucion(rs.getString("infBenefCont1PorcDistrib"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente2Apellido1(rs.getString("infBenefCont2Apellido1"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente2Apellido2(rs.getString("infBenefCont2Apellido2"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente2Nombres(rs.getString("infBenefCont2Nombres"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente2FechaNacimiento(rs.getString("infBenefCont2FechaNac"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente2DocumentoIdentidad(rs.getString("infBenefCont2DocIdentidad"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente2Parentesco(rs.getString("infBenefCont2Parentesco"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente2PorcDistribucion(rs.getString("infBenefCont2PorcDistrib"));
                interPolizaEmisionVariasURBean.setNuevaCotizacionRecibida(rs.getString("NuevaCotizacionRecibida"));
                interPolizaEmisionVariasURBean.setSolicitudAfiliacion(rs.getString("SolicitudAfiliacion"));
                interPolizaEmisionVariasURBean.setNumOACOT2(rs.getString("numOACOT2"));
                interPolizaEmisionVariasURBean.setFechaNacimientoCotizador2(rs.getString("fechaNacimientoCotizador2"));
                interPolizaEmisionVariasURBean.setSexoAseguradoCotizador2(rs.getString("sexoAseguradoCotizador2"));
                interPolizaEmisionVariasURBean.setCotizadorFumador2(rs.getString("cotizadorFumador2"));
                interPolizaEmisionVariasURBean.setEdadActuarialAsegurado2(rs.getString("edadActuarialAsegurado2"));
                interPolizaEmisionVariasURBean.setEdadMinimaIngreso2(rs.getString("edadMinimaIngreso2"));
                interPolizaEmisionVariasURBean.setEdadMaximaIngreso2(rs.getString("edadMaximaIngreso2"));
                interPolizaEmisionVariasURBean.setEdadMaximaPermanencia2(rs.getString("edadMaximaPermanencia2"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario1Apellido1(rs.getString("inf2Benef1Apellido1"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario1Apellido2(rs.getString("inf2Benef1Apellido2"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario1Nombres(rs.getString("inf2Benef1Nombres"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario1FechaNacimiento(rs.getString("inf2Benef1FechaNacimiento"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario1DocumentoIdentidad(rs.getString("inf2Benef1DocumentoIdentidad"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario1Parentesco(rs.getString("inf2Benef1Parentesco"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario1PorcDistribucion(rs.getString("inf2Benef1PorcDistribucion"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario2Apellido1(rs.getString("inf2Benef2Apellido1"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario2Apellido2(rs.getString("inf2Benef2Apellido2"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario2Nombres(rs.getString("inf2Benef2Nombres"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario2FechaNacimiento(rs.getString("inf2Benef2FechaNacimiento"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario2DocumentoIdentidad(rs.getString("inf2Benef2DocumentoIdentidad"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario2Parentesco(rs.getString("inf2Benef2Parentesco"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario2PorcDistribucion(rs.getString("inf2Benef2PorcDistribucion"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario3Apellido1(rs.getString("inf2Benef3Apellido1"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario3Apellido2(rs.getString("inf2Benef3Apellido2"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario3Nombres(rs.getString("inf2Benef3Nombres"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario3FechaNacimiento(rs.getString("inf2Benef3FechaNacimiento"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario3DocumentoIdentidad(rs.getString("inf2Benef3DocumentoIdentidad"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario3Parentesco(rs.getString("inf2Benef3Parentesco"));
                interPolizaEmisionVariasURBean.setInformacion2Beneficiario3PorcDistribucion(rs.getString("inf2Benef3PorcDistribucion"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente1Apellido1(rs.getString("inf2BenefCont1Apellido1"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente1Apellido2(rs.getString("inf2BenefCont1Apellido2"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente1Nombres(rs.getString("inf2BenefCont1Nombres"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente1FechaNacimiento(rs.getString("inf2BenefCont1FechaNac"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente1DocumentoIdentidad(rs.getString("inf2BenefCont1DocId"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente1Parentesco(rs.getString("inf2BenefCont1Parentesco"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente1PorcDistribucion(rs.getString("inf2BenefCont1PorcDistribucion"));
                interPolizaEmisionVariasURBean.setInformacionBeneficiarioContingente2Apellido1(rs.getString("inf2BenefCont2Apellido1"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente2Apellido2(rs.getString("inf2BenefCont2Apellido2"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente2Nombres(rs.getString("inf2BenefCont2Nombres"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente2FechaNacimiento(rs.getString("inf2BenefCont2FechaNac"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente2DocumentoIdentidad(rs.getString("inf2BenefCont2DocId"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente2Parentesco(rs.getString("inf2BenefCont2Parentesco"));
                interPolizaEmisionVariasURBean.setInformacion2BeneficiarioContingente2PorcDistribucion(rs.getString("inf2BenefCont2PorcDistribucion"));


                poliza.add(interPolizaEmisionVariasURBean);
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

