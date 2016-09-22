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
 * Created by agil on 22/08/2016.
 */
public class ValidacionFormulacionesImExProductoBean extends PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(ValidacionFormulacionesImExProductoBean.class);

    private String formula;

    public String getFormula(){
        return formula;
    }
    public void setFormula(String formula){
        this.formula = formula;
    }

    public static ArrayList getValidacionFormulacionesImExProducto() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList validaciones = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, FORMULA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR_NOMBRE1, TOMADOR_NOMBRE2, TOMADOR_APELLIDO1, TOMADOR_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, NUMERO_UNIDAD_RIESGO, NUMERO_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, NUMERO_OBJETO_ASEG, ASEGURADO_PRIMARIO, PORCENTAJE_EXTRA_PRIMA, PORCENTAJE_DESCUENTO, EDAD_ASEGURADO, NOMBRE_COMPLETO_ASEGURADO, NOMBRE_COMPLETO_BENEFICIARIO, NUM_OBJ_ASEG_CONTENIDOS_UR, DOCUMENTO_IDENTIDAD_ASEGURADO, FECHA_NACIMIENTO_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, ASEGURADO_VIDA_NOMBRE1, ASEGURADO_VIDA_NOMBRE2, ASEGURADO_VIDA_APELLIDO1, ASEGURADO_VIDA_APELLIDO2, PORCEN_PARTICIPA_ASEG_VIDA, BENEFICIARIO_NATURAL_NOMBRE1, BENEFICIARIO_NATURAL_NOMBRE2, BENEFICIARIO_NATURAL_APELLIDO1, BENEFICIARIO_NATURAL_APELLIDO2, TIPO_BENEFICIARIO, BENEFICIARIO_IRREVOCABLE, PORCEN_PARTICIP_BENEF_NATURAL, CODIGO_BENEFICIARIO, PARENTESCO FROM VALIDACION_FORMULACIONES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ValidacionFormulacionesImExProductoBean validacionFormulacionesImExProductoBean = new ValidacionFormulacionesImExProductoBean();

                validacionFormulacionesImExProductoBean.setFormula(rs.getString("FORMULA"));

                validacionFormulacionesImExProductoBean.setProducto(rs.getString("PRODUCTO"));
                validacionFormulacionesImExProductoBean.setVigencia(rs.getString("VIGENCIA"));
                validacionFormulacionesImExProductoBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                validacionFormulacionesImExProductoBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                validacionFormulacionesImExProductoBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                validacionFormulacionesImExProductoBean.setFechaMovimiento(rs.getString("FECHA_MOVIMIENTO"));
                validacionFormulacionesImExProductoBean.setFechaEfectivaAplicacionEvento(rs.getString("FECHA_EFECTIVA_APLICA_EVENTO"));
                validacionFormulacionesImExProductoBean.setPlanFinanciamiento(rs.getString("PLAN_FINANCIAMIENTO"));
                validacionFormulacionesImExProductoBean.setMoneda(rs.getString("MONEDA"));
                validacionFormulacionesImExProductoBean.setSucursal(rs.getString("SUCURSAL"));
                validacionFormulacionesImExProductoBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                validacionFormulacionesImExProductoBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                validacionFormulacionesImExProductoBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                validacionFormulacionesImExProductoBean.setPeriodoGracia(rs.getString("PERIODO_GRACIA"));
                validacionFormulacionesImExProductoBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                validacionFormulacionesImExProductoBean.setHoraIniciacionVencimiento(rs.getString("HORA_INICIACION_VENCIMIENTO"));
                validacionFormulacionesImExProductoBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                validacionFormulacionesImExProductoBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                validacionFormulacionesImExProductoBean.setFrecuenciaPago(rs.getString("FRECUENCIA_PAGO"));
                validacionFormulacionesImExProductoBean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                validacionFormulacionesImExProductoBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                validacionFormulacionesImExProductoBean.setNivelAgrupamientoReaseguro(rs.getString("NIVEL_AGRUPAMIENTO_REASEGURO"));
                validacionFormulacionesImExProductoBean.setPermiteManejoCuentasProvisionales(rs.getString("PERMITE_MANEJO_CTA_PROVI"));
                validacionFormulacionesImExProductoBean.setMesProvisional(rs.getString("MES_PROVISIONAL"));
                validacionFormulacionesImExProductoBean.setAnioProvisional(rs.getString("ANIO_PROVISIONAL"));
                validacionFormulacionesImExProductoBean.setTomadorNombre1(rs.getString("TOMADOR_NOMBRE1"));
                validacionFormulacionesImExProductoBean.setTomadorNombre2(rs.getString("TOMADOR_NOMBRE2"));
                validacionFormulacionesImExProductoBean.setTomadorApellido1(rs.getString("TOMADOR_APELLIDO1"));
                validacionFormulacionesImExProductoBean.setTomadorApellido2(rs.getString("TOMADOR_APELLIDO2"));
                validacionFormulacionesImExProductoBean.setPorcentajeParticipacionTomador(rs.getString("PORCENTAJE_PARTICIPA_TOMADOR"));
                validacionFormulacionesImExProductoBean.setNumeroUnidadRiesgo(rs.getString("NUMERO_UNIDAD_RIESGO"));
                validacionFormulacionesImExProductoBean.setNumeroCredito(rs.getString("NUMERO_CREDITO"));
                validacionFormulacionesImExProductoBean.setMontoAsegurado(rs.getString("MONTO_ASEGURADO"));
                validacionFormulacionesImExProductoBean.setFactorVida(rs.getString("FACTOR_VIDA"));
                validacionFormulacionesImExProductoBean.setValorSeguroPrima(rs.getString("VALOR_SEGURO_PRIMA"));
                validacionFormulacionesImExProductoBean.setFechaDesembolso(rs.getString("FECHA_DESEMBOLSO"));
                validacionFormulacionesImExProductoBean.setValorPrestamo(rs.getString("VALOR_PRESTAMO"));
                validacionFormulacionesImExProductoBean.setCuotasPactadas(rs.getString("CUOTAS_PACTADAS"));
                validacionFormulacionesImExProductoBean.setSaldoCapital(rs.getString("SALDO_CAPITAL"));
                validacionFormulacionesImExProductoBean.setEstadoCredito(rs.getString("ESTADO_CREDITO"));
                validacionFormulacionesImExProductoBean.setCuotasMora(rs.getString("CUOTAS_MORA"));
                validacionFormulacionesImExProductoBean.setFechaProceso(rs.getString("FECHA_PROCESO"));
                validacionFormulacionesImExProductoBean.setFechaPago(rs.getString("FECHA_PAGO"));
                validacionFormulacionesImExProductoBean.setCuotaPagada(rs.getString("CUOTA_PAGADA"));
                validacionFormulacionesImExProductoBean.setFechaMora(rs.getString("FECHA_MORA"));
                validacionFormulacionesImExProductoBean.setPorcentajeFacultativo(rs.getString("PORCENTAJE_FACULTATIVO"));
                validacionFormulacionesImExProductoBean.setNumeroObjetoAseg(rs.getString("NUMERO_OBJETO_ASEG"));
                validacionFormulacionesImExProductoBean.setAseguradoPrimario(rs.getString("ASEGURADO_PRIMARIO"));
                validacionFormulacionesImExProductoBean.setPorcentajeExtraPrima(rs.getString("PORCENTAJE_EXTRA_PRIMA"));
                validacionFormulacionesImExProductoBean.setPorcentajeDescuento(rs.getString("PORCENTAJE_DESCUENTO"));
                validacionFormulacionesImExProductoBean.setEdadAsegurado(rs.getString("EDAD_ASEGURADO"));
                validacionFormulacionesImExProductoBean.setNombreCompletoAsegurado(rs.getString("NOMBRE_COMPLETO_ASEGURADO"));
                validacionFormulacionesImExProductoBean.setNombreCompletoBeneficiario(rs.getString("NOMBRE_COMPLETO_BENEFICIARIO"));
                validacionFormulacionesImExProductoBean.setNumeroObjetosAseguradosContenidosUnidadRiesgo(rs.getString("NUM_OBJ_ASEG_CONTENIDOS_UR"));
                validacionFormulacionesImExProductoBean.setDocumentoIdentidadAsegurado(rs.getString("DOCUMENTO_IDENTIDAD_ASEGURADO"));
                validacionFormulacionesImExProductoBean.setFechaNacimientoAsegurado(rs.getString("FECHA_NACIMIENTO_ASEGURADO"));
                validacionFormulacionesImExProductoBean.setDireccionAsegurado(rs.getString("DIRECCION_ASEGURADO"));
                validacionFormulacionesImExProductoBean.setTelefonoFijo(rs.getString("TELEFONO_FIJO"));
                validacionFormulacionesImExProductoBean.setDepartamento(rs.getString("DEPARTAMENTO"));
                validacionFormulacionesImExProductoBean.setCiudad(rs.getString("CIUDAD"));
                validacionFormulacionesImExProductoBean.setAseguradoVidaNombre1(rs.getString("ASEGURADO_VIDA_NOMBRE1"));
                validacionFormulacionesImExProductoBean.setAseguradoVidaNombre2(rs.getString("ASEGURADO_VIDA_NOMBRE2"));
                validacionFormulacionesImExProductoBean.setAseguradoVidaApellido1(rs.getString("ASEGURADO_VIDA_APELLIDO1"));
                validacionFormulacionesImExProductoBean.setAseguradoVidaApellido2(rs.getString("ASEGURADO_VIDA_APELLIDO2"));
                validacionFormulacionesImExProductoBean.setPorcentajeParticipacionAseguradoVida(rs.getString("PORCEN_PARTICIPA_ASEG_VIDA"));
                validacionFormulacionesImExProductoBean.setBeneficiarioNaturalNombre1(rs.getString("BENEFICIARIO_NATURAL_NOMBRE1"));
                validacionFormulacionesImExProductoBean.setBeneficiarioNaturalNombre2(rs.getString("BENEFICIARIO_NATURAL_NOMBRE2"));
                validacionFormulacionesImExProductoBean.setBeneficiarioNaturalApellido1(rs.getString("BENEFICIARIO_NATURAL_APELLIDO1"));
                validacionFormulacionesImExProductoBean.setBeneficiarioNaturalApellido2(rs.getString("BENEFICIARIO_NATURAL_APELLIDO2"));
                validacionFormulacionesImExProductoBean.setTipoBeneficiario(rs.getString("TIPO_BENEFICIARIO"));
                validacionFormulacionesImExProductoBean.setBeneficiarioIrrevocable(rs.getString("BENEFICIARIO_IRREVOCABLE"));
                validacionFormulacionesImExProductoBean.setPorcentajeParticipacionBeneficiarioNatural(rs.getString("PORCEN_PARTICIP_BENEF_NATURAL"));
                validacionFormulacionesImExProductoBean.setCodigoBeneficiario(rs.getString("CODIGO_BENEFICIARIO"));
                validacionFormulacionesImExProductoBean.setParentesco(rs.getString("PARENTESCO"));

                validaciones.add(validacionFormulacionesImExProductoBean);
            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return validaciones;
    }
}
