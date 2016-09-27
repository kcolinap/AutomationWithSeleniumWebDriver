package AcseleV13_8.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 11/08/2016.
 */
public class EmisionPolizaAseguradoVidaBean extends PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(EmisionPolizaAseguradoVidaBean.class);


    public static ArrayList getEmisionPolizaAseguradoVida() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList emision = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, producto, vigencia, fecha_Desde, fecha_Hasta, evento_Aplicar, fecha_Movimiento, fecha_Efectiva_Aplica_Evento, plan_Financiamiento, moneda, sucursal, numero_Poliza, fecha_Emision, tipo_Produccion, periodo_Gracia, linea_Credito, hora_Iniciacion_Vencimiento, unidad_Negocio, canal_Venta, frecuencia_Pago, tipo_Poliza, tipo_Valor_Asegurado, nivel_Agrupamiento_Reaseguro, permite_Manejo_Cta_Provi, mes_Provisional, anio_Provisional, tomador_Nombre1, tomador_Nombre2, tomador_Apellido1, tomador_Apellido2, porcentaje_Participa_Tomador, numero_Unidad_Riesgo, numero_Credito, monto_Asegurado, factor_Vida, valor_Seguro_Prima, fecha_Desembolso, valor_Prestamo, cuotas_Pactadas, saldo_Capital, estado_Credito, cuotas_Mora, fecha_Proceso, fecha_Pago, cuota_Pagada, fecha_Mora, porcentaje_Facultativo, numero_Objeto_Aseg, asegurado_Primario, porcentaje_Extra_Prima, porcentaje_Descuento, edad_Asegurado, nombre_Completo_Asegurado, nombre_Completo_Beneficiario, num_Obj_Aseg_Contenidos_UR, documento_Identidad_Asegurado, fecha_Nacimiento_Asegurado, direccion_Asegurado, telefono_Fijo, departamento, ciudad, asegurado_Vida_Nombre1, asegurado_Vida_Nombre2, asegurado_Vida_Apellido1, asegurado_Vida_Apellido2, porcen_Participa_Aseg_Vida, nuevo_porcen_Partici_Aseg_Vida FROM POLIZA_ASEGURADO_VIDA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EmisionPolizaAseguradoVidaBean polizaBean = new EmisionPolizaAseguradoVidaBean();

                polizaBean.setProducto(rs.getString("PRODUCTO"));
                polizaBean.setVigencia(rs.getString("VIGENCIA"));
                polizaBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                polizaBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                polizaBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                polizaBean.setFechaMovimiento(rs.getString("FECHA_MOVIMIENTO"));
                polizaBean.setFechaEfectivaAplicacionEvento(rs.getString("FECHA_EFECTIVA_APLICA_EVENTO"));
                polizaBean.setPlanFinanciamiento(rs.getString("PLAN_FINANCIAMIENTO"));
                polizaBean.setMoneda(rs.getString("MONEDA"));
                polizaBean.setSucursal(rs.getString("SUCURSAL"));
                polizaBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                polizaBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                polizaBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                polizaBean.setPeriodoGracia(rs.getString("PERIODO_GRACIA"));
                polizaBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                polizaBean.setHoraIniciacionVencimiento(rs.getString("HORA_INICIACION_VENCIMIENTO"));
                polizaBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                polizaBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                polizaBean.setFrecuenciaPago(rs.getString("FRECUENCIA_PAGO"));
                polizaBean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                polizaBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                polizaBean.setNivelAgrupamientoReaseguro(rs.getString("NIVEL_AGRUPAMIENTO_REASEGURO"));
                polizaBean.setPermiteManejoCuentasProvisionales(rs.getString("PERMITE_MANEJO_CTA_PROVI"));
                polizaBean.setMesProvisional(rs.getString("MES_PROVISIONAL"));
                polizaBean.setAnioProvisional(rs.getString("ANIO_PROVISIONAL"));
                polizaBean.setTomadorNombre1(rs.getString("TOMADOR_NOMBRE1"));
                polizaBean.setTomadorNombre2(rs.getString("TOMADOR_NOMBRE2"));
                polizaBean.setTomadorApellido1(rs.getString("TOMADOR_APELLIDO1"));
                polizaBean.setTomadorApellido2(rs.getString("TOMADOR_APELLIDO2"));
                polizaBean.setPorcentajeParticipacionTomador(rs.getString("PORCENTAJE_PARTICIPA_TOMADOR"));
                polizaBean.setNumeroUnidadRiesgo(rs.getString("NUMERO_UNIDAD_RIESGO"));
                polizaBean.setNumeroCredito(rs.getString("NUMERO_CREDITO"));
                polizaBean.setMontoAsegurado(rs.getString("MONTO_ASEGURADO"));
                polizaBean.setFactorVida(rs.getString("FACTOR_VIDA"));
                polizaBean.setValorSeguroPrima(rs.getString("VALOR_SEGURO_PRIMA"));
                polizaBean.setFechaDesembolso(rs.getString("FECHA_DESEMBOLSO"));
                polizaBean.setValorPrestamo(rs.getString("VALOR_PRESTAMO"));
                polizaBean.setCuotasPactadas(rs.getString("CUOTAS_PACTADAS"));
                polizaBean.setSaldoCapital(rs.getString("SALDO_CAPITAL"));
                polizaBean.setEstadoCredito(rs.getString("ESTADO_CREDITO"));
                polizaBean.setCuotasMora(rs.getString("CUOTAS_MORA"));
                polizaBean.setFechaProceso(rs.getString("FECHA_PROCESO"));
                polizaBean.setFechaPago(rs.getString("FECHA_PAGO"));
                polizaBean.setCuotaPagada(rs.getString("CUOTA_PAGADA"));
                polizaBean.setFechaMora(rs.getString("FECHA_MORA"));
                polizaBean.setPorcentajeFacultativo(rs.getString("PORCENTAJE_FACULTATIVO"));
                polizaBean.setNumeroObjetoAseg(rs.getString("NUMERO_OBJETO_ASEG"));
                polizaBean.setAseguradoPrimario(rs.getString("ASEGURADO_PRIMARIO"));
                polizaBean.setPorcentajeExtraPrima(rs.getString("PORCENTAJE_EXTRA_PRIMA"));
                polizaBean.setPorcentajeDescuento(rs.getString("PORCENTAJE_DESCUENTO"));
                polizaBean.setEdadAsegurado(rs.getString("EDAD_ASEGURADO"));
                polizaBean.setNombreCompletoAsegurado(rs.getString("NOMBRE_COMPLETO_ASEGURADO"));
                polizaBean.setNombreCompletoBeneficiario(rs.getString("NOMBRE_COMPLETO_BENEFICIARIO"));
                polizaBean.setNumeroObjetosAseguradosContenidosUnidadRiesgo(rs.getString("NUM_OBJ_ASEG_CONTENIDOS_UR"));
                polizaBean.setDocumentoIdentidadAsegurado(rs.getString("DOCUMENTO_IDENTIDAD_ASEGURADO"));
                polizaBean.setFechaNacimientoAsegurado(rs.getString("FECHA_NACIMIENTO_ASEGURADO"));
                polizaBean.setDireccionAsegurado(rs.getString("DIRECCION_ASEGURADO"));
                polizaBean.setTelefonoFijo(rs.getString("TELEFONO_FIJO"));
                polizaBean.setDepartamento(rs.getString("DEPARTAMENTO"));
                polizaBean.setCiudad(rs.getString("CIUDAD"));
                polizaBean.setAseguradoVidaNombre1(rs.getString("ASEGURADO_VIDA_NOMBRE1"));
                polizaBean.setAseguradoVidaNombre2(rs.getString("ASEGURADO_VIDA_NOMBRE2"));
                polizaBean.setAseguradoVidaApellido1(rs.getString("ASEGURADO_VIDA_APELLIDO1"));
                polizaBean.setAseguradoVidaApellido2(rs.getString("ASEGURADO_VIDA_APELLIDO2"));
                polizaBean.setPorcentajeParticipacionAseguradoVida(rs.getString("PORCEN_PARTICIPA_ASEG_VIDA"));
                polizaBean.setNuevoPorcentajeParticipacionAseguradoVida(rs.getString("nuevo_porcen_Partici_Aseg_Vida"));

                emision.add(polizaBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }

        return emision;
    }
}
