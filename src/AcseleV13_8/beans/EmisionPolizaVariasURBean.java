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
 * Created by agil on 18/07/2016.
 */
public class EmisionPolizaVariasURBean extends PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(EmisionPolizaVariasURBean.class);

    public static ArrayList getEmisionPolizaVariasUR() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR_NOMBRE1, TOMADOR_NOMBRE2, TOMADOR_APELLIDO1, TOMADOR_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, NUMERO_UNIDAD_RIESGO, NUMERO_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, NUMERO_UNIDAD_RIESGO2, NUMERO_CREDITO2, MONTO_ASEGURADO2, FACTOR_VIDA2, VALOR_SEGURO_PRIMA2, FECHA_DESEMBOLSO2, VALOR_PRESTAMO2, CUOTAS_PACTADAS2, SALDO_CAPITAL2, ESTADO_CREDITO2, CUOTAS_MORA2, FECHA_PROCESO2, FECHA_PAGO2, CUOTA_PAGADA2, FECHA_MORA2, PORCENTAJE_FACULTATIVO2 FROM POLIZA_UNIDADES_RIESGO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {

                EmisionPolizaVariasURBean polizaBean = new EmisionPolizaVariasURBean();

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
                polizaBean.setNumeroUnidadRiesgo2(rs.getString("NUMERO_UNIDAD_RIESGO2"));
                polizaBean.setNumeroCredito2(rs.getString("NUMERO_CREDITO2"));
                polizaBean.setMontoAsegurado2(rs.getString("MONTO_ASEGURADO2"));
                polizaBean.setFactorVida2(rs.getString("FACTOR_VIDA2"));
                polizaBean.setValorSeguroPrima2(rs.getString("VALOR_SEGURO_PRIMA2"));
                polizaBean.setFechaDesembolso2(rs.getString("FECHA_DESEMBOLSO2"));
                polizaBean.setValorPrestamo2(rs.getString("VALOR_PRESTAMO2"));
                polizaBean.setCuotasPactadas2(rs.getString("CUOTAS_PACTADAS2"));
                polizaBean.setSaldoCapital2(rs.getString("SALDO_CAPITAL2"));
                polizaBean.setEstadoCredito2(rs.getString("ESTADO_CREDITO2"));
                polizaBean.setCuotasMora2(rs.getString("CUOTAS_MORA2"));
                polizaBean.setFechaProceso2(rs.getString("FECHA_PROCESO2"));
                polizaBean.setFechaPago2(rs.getString("FECHA_PAGO2"));
                polizaBean.setCuotaPagada2(rs.getString("CUOTA_PAGADA2"));
                polizaBean.setFechaMora2(rs.getString("FECHA_MORA2"));
                polizaBean.setPorcentajeFacultativo2(rs.getString("PORCENTAJE_FACULTATIVO2"));

                poliza.add(polizaBean);
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
