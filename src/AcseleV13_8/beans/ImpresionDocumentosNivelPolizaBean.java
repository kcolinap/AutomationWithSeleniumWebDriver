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
 * Created by agil on 16/09/2016.
 */
public class ImpresionDocumentosNivelPolizaBean extends PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(ImpresionDocumentosNivelPolizaBean.class);


    public static ArrayList getImpresionDocNivelPoliza() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList imprDocPoliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR_NOMBRE1, TOMADOR_NOMBRE2, TOMADOR_APELLIDO1, TOMADOR_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, NUMERO_UNIDAD_RIESGO, NUMERO_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, NUMERO_OBJETO_ASEG, ASEGURADO_PRIMARIO, PORCENTAJE_EXTRA_PRIMA, PORCENTAJE_DESCUENTO, EDAD_ASEGURADO, NOMBRE_COMPLETO_ASEGURADO, NOMBRE_COMPLETO_BENEFICIARIO, NUM_OBJ_ASEG_CONTENIDOS_UR, DOCUMENTO_IDENTIDAD_ASEGURADO, FECHA_NACIMIENTO_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, ASEGURADO_VIDA_NOMBRE1, ASEGURADO_VIDA_NOMBRE2, ASEGURADO_VIDA_APELLIDO1, ASEGURADO_VIDA_APELLIDO2, PORCEN_PARTICIPA_ASEG_VIDA, BENEFICIARIO_NATURAL_NOMBRE1, BENEFICIARIO_NATURAL_NOMBRE2, BENEFICIARIO_NATURAL_APELLIDO1, BENEFICIARIO_NATURAL_APELLIDO2, TIPO_BENEFICIARIO, BENEFICIARIO_IRREVOCABLE, PORCEN_PARTICIP_BENEF_NATURAL, CODIGO_BENEFICIARIO, PARENTESCO FROM Impresion_Doc_Nivel_UR ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ImpresionDocumentosNivelPolizaBean polizaBean = new ImpresionDocumentosNivelPolizaBean();

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
                polizaBean.setBeneficiarioNaturalNombre1(rs.getString("BENEFICIARIO_NATURAL_NOMBRE1"));
                polizaBean.setBeneficiarioNaturalNombre2(rs.getString("BENEFICIARIO_NATURAL_NOMBRE2"));
                polizaBean.setBeneficiarioNaturalApellido1(rs.getString("BENEFICIARIO_NATURAL_APELLIDO1"));
                polizaBean.setBeneficiarioNaturalApellido2(rs.getString("BENEFICIARIO_NATURAL_APELLIDO2"));
                polizaBean.setTipoBeneficiario(rs.getString("TIPO_BENEFICIARIO"));
                polizaBean.setBeneficiarioIrrevocable(rs.getString("BENEFICIARIO_IRREVOCABLE"));
                polizaBean.setPorcentajeParticipacionBeneficiarioNatural(rs.getString("PORCEN_PARTICIP_BENEF_NATURAL"));
                polizaBean.setCodigoBeneficiario(rs.getString("CODIGO_BENEFICIARIO"));
                polizaBean.setParentesco(rs.getString("PARENTESCO"));
                imprDocPoliza.add(polizaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }
        finally{
            if (conn != null){
                conn.close();
            }
        }
        return imprDocPoliza;
    }

}
