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
 * Created by agil on 27/07/2016.
 */
public class EmisionPolizaVariosOABean extends PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(EmisionPolizaVariosOABean.class);

    public static ArrayList getEmisionPolizaVariosOA() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList emision = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR_NOMBRE1, TOMADOR_NOMBRE2, TOMADOR_APELLIDO1, TOMADOR_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, NUMERO_UNIDAD_RIESGO, NUMERO_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, NUMERO_OBJETO_ASEG, ASEGURADO_PRIMARIO, PORCENTAJE_EXTRA_PRIMA, PORCENTAJE_DESCUENTO, EDAD_ASEGURADO, NOMBRE_COMPLETO_ASEGURADO, NOMBRE_COMPLETO_BENEFICIARIO, NUM_OBJ_ASEG_CONTENIDOS_UR, DOCUMENTO_IDENTIDAD_ASEGURADO, FECHA_NACIMIENTO_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, NUMERO_OBJETO_ASEG2, ASEGURADO_PRIMARIO2, PORCENTAJE_EXTRA_PRIMA2, PORCENTAJE_DESCUENTO2, EDAD_ASEGURADO2, NOMBRE_COMPLETO_ASEGURADO2, NOMBRE_COMPLETO_BENEFICIARIO2, NUM_OBJ_ASEG_CONTENIDOS_UR2, DOCUMENTO_IDENTIDAD_ASEGURADO2, FECHA_NACIMIENTO_ASEGURADO2, DIRECCION_ASEGURADO2, TELEFONO_FIJO2, DEPARTAMENTO2, CIUDAD2 FROM POLIZA_OBJETOS_ASEGURADOS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {

                EmisionPolizaVariosOABean polizaBean = new EmisionPolizaVariosOABean();

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
                polizaBean.setNumeroObjetoAseg2(rs.getString("NUMERO_OBJETO_ASEG2"));
                polizaBean.setAseguradoPrimario2(rs.getString("ASEGURADO_PRIMARIO2"));
                polizaBean.setPorcentajeExtraPrima2(rs.getString("PORCENTAJE_EXTRA_PRIMA2"));
                polizaBean.setPorcentajeDescuento2(rs.getString("PORCENTAJE_DESCUENTO2"));
                polizaBean.setEdadAsegurado2(rs.getString("EDAD_ASEGURADO2"));
                polizaBean.setNombreCompletoAsegurado2(rs.getString("NOMBRE_COMPLETO_ASEGURADO2"));
                polizaBean.setNombreCompletoBeneficiario2(rs.getString("NOMBRE_COMPLETO_BENEFICIARIO2"));
                polizaBean.setNumeroObjetosAseguradosContenidosUnidadRiesgo2(rs.getString("NUM_OBJ_ASEG_CONTENIDOS_UR2"));
                polizaBean.setDocumentoIdentidadAsegurado2(rs.getString("DOCUMENTO_IDENTIDAD_ASEGURADO2"));
                polizaBean.setFechaNacimientoAsegurado2(rs.getString("FECHA_NACIMIENTO_ASEGURADO2"));
                polizaBean.setDireccionAsegurado2(rs.getString("DIRECCION_ASEGURADO2"));
                polizaBean.setTelefonoFijo2(rs.getString("TELEFONO_FIJO2"));
                polizaBean.setDepartamento2(rs.getString("DEPARTAMENTO2"));
                polizaBean.setCiudad2(rs.getString("CIUDAD2"));

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