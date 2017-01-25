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
 * Created by kcolina on 25/01/2017.
 */
public class INTER_ValidarOpenItemBean extends Inter_PolizaBean implements Serializable {

        private final static Logger Log = Logger.getLogger(INTER_ValidarOpenItemBean.class);

        public static ArrayList getInter_ValidarOpenItem() throws SQLException{

            Connection conn = null;
            Statement stmt;
            ResultSet rs;
            ArrayList poliza = new ArrayList();

            StringBuilder queryLoad = new StringBuilder();
            queryLoad.append("SELECT * FROM INTER_VALIDAR_OPEN_ITEM ORDER BY PRUEBA ASC");

            try {

                conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(queryLoad.toString());

                while(rs.next()){

                    INTER_ValidarOpenItemBean inter_validarOpenItemBean = new INTER_ValidarOpenItemBean();

                    inter_validarOpenItemBean.setProducto(rs.getString("producto"));
                    inter_validarOpenItemBean.setVigencia(rs.getString("vigencia"));
                    inter_validarOpenItemBean.setFechaDesde(rs.getString("fecha_Desde"));
                    inter_validarOpenItemBean.setFechaHasta(rs.getString("fecha_Hasta"));
                    inter_validarOpenItemBean.setEventoAplicar(rs.getString("evento_Aplicar"));
                    inter_validarOpenItemBean.setFechaMovimiento(rs.getString("fecha_Movimiento"));
                    inter_validarOpenItemBean.setPlanesFinanciamiento(rs.getString("planes_Financiamiento"));
                    inter_validarOpenItemBean.setMonedas(rs.getString("monedas"));
                    inter_validarOpenItemBean.setOficina(rs.getString("oficina"));
                    inter_validarOpenItemBean.setNumeroPoliza(rs.getString("numero_Poliza"));
                    inter_validarOpenItemBean.setFechaEmision(rs.getString("fecha_Emision"));
                    inter_validarOpenItemBean.setCanalVentaVida(rs.getString("canal_VentaVida"));
                    inter_validarOpenItemBean.setCanalVenta(rs.getString("canal_Venta"));
                    inter_validarOpenItemBean.setFrecuenciaPago(rs.getString("frecuencia_Pago"));
                    inter_validarOpenItemBean.setAplicaDescuento(rs.getString("aplica_Descuento"));
                    inter_validarOpenItemBean.setTipoDocumento(rs.getString("tipo_Documento"));
                    inter_validarOpenItemBean.setNumeroDocumento(rs.getString("numero_Documento"));
                    inter_validarOpenItemBean.setFechaCotizacion(rs.getString("fecha_Cotizacion"));
                    inter_validarOpenItemBean.setNumeroCotizacion(rs.getString("numero_Cotizacion"));
                    inter_validarOpenItemBean.setNumeroPropuestaAnterior(rs.getString("numero_Propuesta_Anterior"));
                    inter_validarOpenItemBean.setCambioNumeroPropuesta(rs.getString("Cambio_Numero_Propuesta"));
                    inter_validarOpenItemBean.setNumeroPropuesta(rs.getString("numero_Propuesta"));
                    inter_validarOpenItemBean.setNivelAgrupamientoReaseguro(rs.getString("nivel_Agrupamiento_Reaseguro"));
                    inter_validarOpenItemBean.setIndicadorDPS(rs.getString("INDICADOR_PEP"));
                    inter_validarOpenItemBean.setEnvioComunicacionesPoliza(rs.getString("envio_comunicaciones_Poliza"));
                    inter_validarOpenItemBean.setEnvioComunicacionesEndoso(rs.getString("envio_comunicaciones_Endoso"));
                    inter_validarOpenItemBean.setPrevalizacionViaCobro(rs.getString("prevalizacion_Via_Cobro"));
                    inter_validarOpenItemBean.setNuevaCotizacionRecibida(rs.getString("Nueva_Cotizacion_Recibida"));
                    inter_validarOpenItemBean.setSolicitudAfiliacion(rs.getString("Solicitud_Afiliacion"));
                    inter_validarOpenItemBean.setTipoPago(rs.getString("tipo_Pago"));
                    inter_validarOpenItemBean.setNumeroOperacion(rs.getString("numero_Operacion"));
                    inter_validarOpenItemBean.setMonedaTransaccion(rs.getString("moneda_Transaccion"));
                    inter_validarOpenItemBean.setMontoTransaccion(rs.getString("monto_Transaccion"));
                    inter_validarOpenItemBean.setMonedaDePrima(rs.getString("moneda_de_Prima"));
                    inter_validarOpenItemBean.setMontoPrimeraPrima(rs.getString("monto_Primera_Prima"));
                    inter_validarOpenItemBean.setAgenteInicialPoliza(rs.getString("agente_Inicial_Poliza"));
                    inter_validarOpenItemBean.setCodigoAgenteInicial(rs.getString("codigo_Agente_Inicial"));
                    inter_validarOpenItemBean.setCorreoAgenteInicial(rs.getString("correo_Agente_Inicial"));
                    inter_validarOpenItemBean.setCodigoAgenciaInicial(rs.getString("codigo_Agencia_Inicial"));
                    inter_validarOpenItemBean.setAgenteFinalPoliza(rs.getString("agente_Final_Poliza"));
                    inter_validarOpenItemBean.setCodigoAgenteFinal(rs.getString("codigo_Agente_Final"));
                    inter_validarOpenItemBean.setCorreoAgenteFinal(rs.getString("correo_Agente_Final"));
                    inter_validarOpenItemBean.setCodigoAgenciaFinal(rs.getString("codigo_Agencia_Final"));
                    inter_validarOpenItemBean.setPeriodoDiasProcedeSuspencionCancelacion(rs.getString("periodo_Dia_Proce_Susp_Cancel"));
                    inter_validarOpenItemBean.setProductosVida(rs.getString("productos_Vida"));
                    inter_validarOpenItemBean.setPlan(rs.getString("plan"));
                    inter_validarOpenItemBean.setFechaProxGenPrimaVi(rs.getString("fecha_Prox_Gen_Prima_Vi"));
                    inter_validarOpenItemBean.setPolizaCesionada(rs.getString("poliza_Cesionada"));
                    inter_validarOpenItemBean.setContratante1Nombre1(rs.getString("contratante1_Nombre1"));
                    inter_validarOpenItemBean.setContratante1Nombre2(rs.getString("contratante1_Nombre2"));
                    inter_validarOpenItemBean.setContratante1Apellido1(rs.getString("contratante1_Apellido1"));
                    inter_validarOpenItemBean.setContratante1Apellido2(rs.getString("contratante1_Apellido2"));
                    inter_validarOpenItemBean.setPorcentajeContratante1(rs.getString("porcentaje_Contratante1"));
                    inter_validarOpenItemBean.setPorcentajeContratante2(rs.getString("porcentaje_Contratante2"));

                    poliza.add(inter_validarOpenItemBean);
                }

            }catch (Exception e){
                e.printStackTrace();
                Log.error(e);
            }finally {
                if(conn!=null){
                    conn.close();
                }
            }

            return poliza;
        }
}
