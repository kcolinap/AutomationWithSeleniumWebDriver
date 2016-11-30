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
                interPolizaEmisionVariosOABean.setCanalVentaVida(rs.getString("canalVentaVida"));
                interPolizaEmisionVariosOABean.setAplicaDescuento(rs.getString("aplicaDescuento"));
                interPolizaEmisionVariosOABean.setTipoDocumento(rs.getString("tipoDocumento"));
                interPolizaEmisionVariosOABean.setNumeroDocumento(rs.getString("numeroDocumento"));
                interPolizaEmisionVariosOABean.setTipoPago(rs.getString("tipoPago"));
                interPolizaEmisionVariosOABean.setNumeroOperacion(rs.getString("numeroOperacion"));
                interPolizaEmisionVariosOABean.setMonedaTransaccion(rs.getString("monedaTransaccion"));
                interPolizaEmisionVariosOABean.setMontoTransaccion(rs.getString("montoTransaccion"));
                interPolizaEmisionVariosOABean.setMonedaDePrima(rs.getString("monedaDePrima"));
                interPolizaEmisionVariosOABean.setMontoPrimeraPrima(rs.getString("montoPrimeraPrima"));
                interPolizaEmisionVariosOABean.setFechaCotizacion(rs.getString("fechaCotizacion"));
                interPolizaEmisionVariosOABean.setNumeroPropuestaAnterior(rs.getString("numeroPropuestaAnterior"));
                interPolizaEmisionVariosOABean.setCambioNumeroPropuesta(rs.getString("CambioNumeroPropuesta"));
                interPolizaEmisionVariosOABean.setIndicadorDPS(rs.getString("indicadorDPS"));
                interPolizaEmisionVariosOABean.setEnvioComunicacionesPoliza(rs.getString("enviocomunicacionesPoliza"));
                interPolizaEmisionVariosOABean.setEnvioComunicacionesEndoso(rs.getString("enviocomunicacionesEndoso"));
                interPolizaEmisionVariosOABean.setPrevalizacionViaCobro(rs.getString("prevalizacionViaCobro"));
                interPolizaEmisionVariosOABean.setAgenteInicialPoliza(rs.getString("agenteInicialPoliza"));
                interPolizaEmisionVariosOABean.setCodigoAgenteInicial(rs.getString("codigoAgenteInicial"));
                interPolizaEmisionVariosOABean.setCorreoAgenteInicial(rs.getString("correoAgenteInicial"));
                interPolizaEmisionVariosOABean.setCodigoAgenciaInicial(rs.getString("codigoAgenciaInicial"));
                interPolizaEmisionVariosOABean.setAgenteFinalPoliza(rs.getString("agenteFinalPoliza"));
                interPolizaEmisionVariosOABean.setCodigoAgenteFinal(rs.getString("codigoAgenteFinal"));
                interPolizaEmisionVariosOABean.setCorreoAgenteFinal(rs.getString("correoAgenteFinal"));
                interPolizaEmisionVariosOABean.setCodigoAgenciaFinal(rs.getString("codigoAgenciaFinal"));
                interPolizaEmisionVariosOABean.setPeriodoDiasProcedeSuspencionCancelacion(rs.getString("periodoDiasProcedeSuspCancel"));
                interPolizaEmisionVariosOABean.setProductosVida(rs.getString("productosVida"));
                interPolizaEmisionVariosOABean.setPlan(rs.getString("plan"));
                interPolizaEmisionVariosOABean.setFechaProxGenPrimaVi(rs.getString("fechaProxGenPrimaVi"));
                interPolizaEmisionVariosOABean.setPolizaCesionada(rs.getString("polizaCesionada"));
                interPolizaEmisionVariosOABean.setLoginUsuario(rs.getString("loginUsiario"));
                interPolizaEmisionVariosOABean.setCapitalAseguradoCoberturaFallecimiento1(rs.getString("capitalAsegCobFallecimiento1"));
                interPolizaEmisionVariosOABean.setCapitalAseguradoCoberturaFallecimiento2(rs.getString("capitalAsegCobFallecimiento2"));
                interPolizaEmisionVariosOABean.setNumOACOT(rs.getString("numOACOT"));
                interPolizaEmisionVariosOABean.setFechaNacimientoCotizador(rs.getString("fechaNacimientoCotizador"));
                interPolizaEmisionVariosOABean.setSexoAseguradoCotizador(rs.getString("sexoAseguradoCotizador"));
                interPolizaEmisionVariosOABean.setCotizadorFumador(rs.getString("cotizadorFumador"));
                interPolizaEmisionVariosOABean.setEdadActuarialAsegurado(rs.getString("edadActuarialAsegurado"));
                interPolizaEmisionVariosOABean.setEdadMinimaIngreso(rs.getString("edadMinimaIngreso"));
                interPolizaEmisionVariosOABean.setEdadMaximaIngreso(rs.getString("edadMaximaIngreso"));
                interPolizaEmisionVariosOABean.setEdadMaximaPermanencia(rs.getString("edadMaximaPermanencia"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario1Apellido1(rs.getString("infBenef1Apellido1"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario1Apellido2(rs.getString("infBenef1Apellido2"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario1Nombres(rs.getString("infBenef1Nombres"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario1FechaNacimiento(rs.getString("infBenef1FechaNacimiento"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario1DocumentoIdentidad(rs.getString("infBenef1DocumentoIdentidad"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario1Parentesco(rs.getString("infBenef1Parentesco"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario1PorcDistribucion(rs.getString("infBenef1PorcDistribucion"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario2Apellido1(rs.getString("infBenef2Apellido1"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario2Apellido2(rs.getString("infBenef2Apellido2"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario2Nombres(rs.getString("infBenef2Nombres"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario2FechaNacimiento(rs.getString("infBenef2FechaNacimiento"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario2DocumentoIdentidad(rs.getString("infBenef2DocumentoIdentidad"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario2Parentesco(rs.getString("infBenef2Parentesco"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario2PorcDistribucion(rs.getString("infBenef2PorcDistribucion"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario3Apellido1(rs.getString("infBenef3Apellido1"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario3Apellido2(rs.getString("infBenef3Apellido2"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario3Nombres(rs.getString("infBenef3Nombres"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario3FechaNacimiento(rs.getString("infBenef3FechaNacimiento"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario3DocumentoIdentidad(rs.getString("infBenef3DocumentoIdentidad"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario3Parentesco(rs.getString("infBenef3Parentesco"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiario3PorcDistribucion(rs.getString("infBenef3PorcDistribucion"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente1Apellido1(rs.getString("infBenefCont1Apellido1"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente1Apellido2(rs.getString("infBenefCont1Apellido2"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente1Nombres(rs.getString("infBenefCont1Nombres"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente1FechaNacimiento(rs.getString("infBenefCont1FechaNac"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente1DocumentoIdentidad(rs.getString("infBenefCont1DocIdentidad"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente1Parentesco(rs.getString("infBenefCont1Parentesco"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente1PorcDistribucion(rs.getString("infBenefCont1PorcDistrib"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente2Apellido1(rs.getString("infBenefCont2Apellido1"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente2Apellido2(rs.getString("infBenefCont2Apellido2"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente2Nombres(rs.getString("infBenefCont2Nombres"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente2FechaNacimiento(rs.getString("infBenefCont2FechaNac"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente2DocumentoIdentidad(rs.getString("infBenefCont2DocIdentidad"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente2Parentesco(rs.getString("infBenefCont2Parentesco"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente2PorcDistribucion(rs.getString("infBenefCont2PorcDistrib"));
                interPolizaEmisionVariosOABean.setNuevaCotizacionRecibida(rs.getString("NuevaCotizacionRecibida"));
                interPolizaEmisionVariosOABean.setSolicitudAfiliacion(rs.getString("SolicitudAfiliacion"));
                interPolizaEmisionVariosOABean.setNumOACOT2(rs.getString("numOACOT2"));
                interPolizaEmisionVariosOABean.setFechaNacimientoCotizador2(rs.getString("fechaNacimientoCotizador2"));
                interPolizaEmisionVariosOABean.setSexoAseguradoCotizador2(rs.getString("sexoAseguradoCotizador2"));
                interPolizaEmisionVariosOABean.setCotizadorFumador2(rs.getString("cotizadorFumador2"));
                interPolizaEmisionVariosOABean.setEdadActuarialAsegurado2(rs.getString("edadActuarialAsegurado2"));
                interPolizaEmisionVariosOABean.setEdadMinimaIngreso2(rs.getString("edadMinimaIngreso2"));
                interPolizaEmisionVariosOABean.setEdadMaximaIngreso2(rs.getString("edadMaximaIngreso2"));
                interPolizaEmisionVariosOABean.setEdadMaximaPermanencia2(rs.getString("edadMaximaPermanencia2"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario1Apellido1(rs.getString("inf2Benef1Apellido1"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario1Apellido2(rs.getString("inf2Benef1Apellido2"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario1Nombres(rs.getString("inf2Benef1Nombres"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario1FechaNacimiento(rs.getString("inf2Benef1FechaNacimiento"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario1DocumentoIdentidad(rs.getString("inf2Benef1DocumentoIdentidad"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario1Parentesco(rs.getString("inf2Benef1Parentesco"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario1PorcDistribucion(rs.getString("inf2Benef1PorcDistribucion"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario2Apellido1(rs.getString("inf2Benef2Apellido1"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario2Apellido2(rs.getString("inf2Benef2Apellido2"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario2Nombres(rs.getString("inf2Benef2Nombres"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario2FechaNacimiento(rs.getString("inf2Benef2FechaNacimiento"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario2DocumentoIdentidad(rs.getString("inf2Benef2DocumentoIdentidad"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario2Parentesco(rs.getString("inf2Benef2Parentesco"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario2PorcDistribucion(rs.getString("inf2Benef2PorcDistribucion"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario3Apellido1(rs.getString("inf2Benef3Apellido1"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario3Apellido2(rs.getString("inf2Benef3Apellido2"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario3Nombres(rs.getString("inf2Benef3Nombres"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario3FechaNacimiento(rs.getString("inf2Benef3FechaNacimiento"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario3DocumentoIdentidad(rs.getString("inf2Benef3DocumentoIdentidad"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario3Parentesco(rs.getString("inf2Benef3Parentesco"));
                interPolizaEmisionVariosOABean.setInformacion2Beneficiario3PorcDistribucion(rs.getString("inf2Benef3PorcDistribucion"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente1Apellido1(rs.getString("inf2BenefCont1Apellido1"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente1Apellido2(rs.getString("inf2BenefCont1Apellido2"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente1Nombres(rs.getString("inf2BenefCont1Nombres"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente1FechaNacimiento(rs.getString("inf2BenefCont1FechaNac"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente1DocumentoIdentidad(rs.getString("inf2BenefCont1DocId"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente1Parentesco(rs.getString("inf2BenefCont1Parentesco"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente1PorcDistribucion(rs.getString("inf2BenefCont1PorcDistribucion"));
                interPolizaEmisionVariosOABean.setInformacionBeneficiarioContingente2Apellido1(rs.getString("inf2BenefCont2Apellido1"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente2Apellido2(rs.getString("inf2BenefCont2Apellido2"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente2Nombres(rs.getString("inf2BenefCont2Nombres"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente2FechaNacimiento(rs.getString("inf2BenefCont2FechaNac"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente2DocumentoIdentidad(rs.getString("inf2BenefCont2DocId"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente2Parentesco(rs.getString("inf2BenefCont2Parentesco"));
                interPolizaEmisionVariosOABean.setInformacion2BeneficiarioContingente2PorcDistribucion(rs.getString("inf2BenefCont2PorcDistribucion"));


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
