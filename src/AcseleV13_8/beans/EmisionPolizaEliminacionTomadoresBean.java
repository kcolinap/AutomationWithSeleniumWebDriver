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
 * Created by agil on 01/08/2016.
 */
public class EmisionPolizaEliminacionTomadoresBean extends PolizaBean implements Serializable{

    private final static Logger log = Logger.getLogger(EmisionPolizaEliminacionTomadoresBean.class);

    public static ArrayList getEmisionPolizaEliminacionTomadores() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList emision = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR1_NOMBRE1, TOMADOR1_NOMBRE2, TOMADOR1_APELLIDO1, TOMADOR1_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, TOMADOR2_NOMBRE1, TOMADOR2_NOMBRE2, TOMADOR2_APELLIDO1, TOMADOR2_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR2, NUEVO_PORCENTAJE_TOMADOR1 FROM POLIZA_ELIMINACION_TOMADORES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EmisionPolizaEliminacionTomadoresBean polizaBean = new EmisionPolizaEliminacionTomadoresBean();

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
                polizaBean.setTomadorNombre1(rs.getString("TOMADOR1_NOMBRE1"));
                polizaBean.setTomadorNombre2(rs.getString("TOMADOR1_NOMBRE2"));
                polizaBean.setTomadorApellido1(rs.getString("TOMADOR1_APELLIDO1"));
                polizaBean.setTomadorApellido2(rs.getString("TOMADOR1_APELLIDO2"));
                polizaBean.setPorcentajeParticipacionTomador(rs.getString("PORCENTAJE_PARTICIPA_TOMADOR"));
                polizaBean.setTomador2Nombre1(rs.getString("TOMADOR2_NOMBRE1"));
                polizaBean.setTomador2Nombre2(rs.getString("TOMADOR2_NOMBRE2"));
                polizaBean.setTomador2Apellido1(rs.getString("TOMADOR2_APELLIDO1"));
                polizaBean.setTomador2Apellido2(rs.getString("TOMADOR2_APELLIDO2"));
                polizaBean.setPorcentajeParticipacionTomador2(rs.getString("PORCENTAJE_PARTICIPA_TOMADOR2"));
                polizaBean.setNuevoPorcentajeParticipacionTomador(rs.getString("NUEVO_PORCENTAJE_TOMADOR1"));

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
