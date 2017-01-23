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
 * Created by agil on 23/01/2017.
 */
public class Inter_PolizaIncluirEditarEliminarContratanteBean extends Inter_PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(Inter_PolizaIncluirEditarEliminarContratanteBean.class);

    public static ArrayList getInter_PolizaIncluirEditarEliminarContratante() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM POLIZA_EDIT_CONTRATANTES_INTER ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Inter_PolizaIncluirEditarEliminarContratanteBean inter_poliza = new Inter_PolizaIncluirEditarEliminarContratanteBean();

                inter_poliza.setProducto(rs.getString("producto"));
                inter_poliza.setVigencia(rs.getString("vigencia"));
                inter_poliza.setFechaDesde(rs.getString("fecha_Desde"));
                inter_poliza.setFechaHasta(rs.getString("fecha_Hasta"));
                inter_poliza.setEventoAplicar(rs.getString("evento_Aplicar"));
                inter_poliza.setFechaMovimiento(rs.getString("fecha_Movimiento"));
                inter_poliza.setPlanesFinanciamiento(rs.getString("planes_Financiamiento"));
                inter_poliza.setMonedas(rs.getString("monedas"));
                inter_poliza.setOficina(rs.getString("oficina"));
                inter_poliza.setNumeroPoliza(rs.getString("numero_Poliza"));
                inter_poliza.setFechaEmision(rs.getString("fecha_Emision"));
                inter_poliza.setCanalVentaVida(rs.getString("canal_VentaVida"));
                inter_poliza.setCanalVenta(rs.getString("canal_Venta"));
                inter_poliza.setFrecuenciaPago(rs.getString("frecuencia_Pago"));
                inter_poliza.setAplicaDescuento(rs.getString("aplica_Descuento"));
                inter_poliza.setTipoDocumento(rs.getString("tipo_Documento"));
                inter_poliza.setNumeroDocumento(rs.getString("numero_Documento"));
                inter_poliza.setFechaCotizacion(rs.getString("fecha_Cotizacion"));
                inter_poliza.setNumeroCotizacion(rs.getString("numero_Cotizacion"));
                inter_poliza.setNumeroPropuestaAnterior(rs.getString("numero_Propuesta_Anterior"));
                inter_poliza.setCambioNumeroPropuesta(rs.getString("Cambio_Numero_Propuesta"));
                inter_poliza.setNumeroPropuesta(rs.getString("numero_Propuesta"));
                inter_poliza.setNivelAgrupamientoReaseguro(rs.getString("nivel_Agrupamiento_Reaseguro"));
                inter_poliza.setIndicadorDPS(rs.getString("INDICADOR_PEP"));
                inter_poliza.setEnvioComunicacionesPoliza(rs.getString("envio_comunicaciones_Poliza"));
                inter_poliza.setEnvioComunicacionesEndoso(rs.getString("envio_comunicaciones_Endoso"));
                inter_poliza.setPrevalizacionViaCobro(rs.getString("prevalizacion_Via_Cobro"));
                inter_poliza.setNuevaCotizacionRecibida(rs.getString("Nueva_Cotizacion_Recibida"));
                inter_poliza.setSolicitudAfiliacion(rs.getString("Solicitud_Afiliacion"));
                inter_poliza.setTipoPago(rs.getString("tipo_Pago"));
                inter_poliza.setNumeroOperacion(rs.getString("numero_Operacion"));
                inter_poliza.setMonedaTransaccion(rs.getString("moneda_Transaccion"));
                inter_poliza.setMontoTransaccion(rs.getString("monto_Transaccion"));
                inter_poliza.setMonedaDePrima(rs.getString("moneda_de_Prima"));
                inter_poliza.setMontoPrimeraPrima(rs.getString("monto_Primera_Prima"));
                inter_poliza.setAgenteInicialPoliza(rs.getString("agente_Inicial_Poliza"));
                inter_poliza.setCodigoAgenteInicial(rs.getString("codigo_Agente_Inicial"));
                inter_poliza.setCorreoAgenteInicial(rs.getString("correo_Agente_Inicial"));
                inter_poliza.setCodigoAgenciaInicial(rs.getString("codigo_Agencia_Inicial"));
                inter_poliza.setAgenteFinalPoliza(rs.getString("agente_Final_Poliza"));
                inter_poliza.setCodigoAgenteFinal(rs.getString("codigo_Agente_Final"));
                inter_poliza.setCorreoAgenteFinal(rs.getString("correo_Agente_Final"));
                inter_poliza.setCodigoAgenciaFinal(rs.getString("codigo_Agencia_Final"));
                inter_poliza.setPeriodoDiasProcedeSuspencionCancelacion(rs.getString("periodo_Dia_Proce_Susp_Cancel"));
                inter_poliza.setProductosVida(rs.getString("productos_Vida"));
                inter_poliza.setPlan(rs.getString("plan"));
                inter_poliza.setFechaProxGenPrimaVi(rs.getString("fecha_Prox_Gen_Prima_Vi"));
                inter_poliza.setPolizaCesionada(rs.getString("poliza_Cesionada"));
                inter_poliza.setContratante1Nombre1(rs.getString("contratante1_Nombre1"));
                inter_poliza.setContratante1Nombre2(rs.getString("contratante1_Nombre2"));
                inter_poliza.setContratante1Apellido1(rs.getString("contratante1_Apellido1"));
                inter_poliza.setContratante1Apellido2(rs.getString("contratante1_Apellido2"));
                inter_poliza.setPorcentajeContratante1(rs.getString("porcentaje_Contratante1"));
                inter_poliza.setPorcentajeContratante2(rs.getString("porcentaje_Contratante2"));

                poliza.add(inter_poliza);
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
