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
 * Created by aazuaje on 27/09/2016.
 */
public class EmisionProductoImportadoBean extends PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(EmisionProductoImportadoBean.class);


    public static ArrayList getEmisionProductoImportado() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList emisionProdImport = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select PRUEBA,PRODUCTO,VIGENCIA,FECHA_DESDE,FECHA_HASTA,EVENTO_APLICAR,FECHA_MOVIMIENTO,SUCURSAL,NUMERO_POLIZA,TIPO_PRODUCCION,PERIODO_GRACIA,LINEA_CREDITO,HORA_INICIACION_VENCIMIENTO,UNIDAD_NEGOCIO,CANAL_VENTA,TIPO_VALOR_ASEGURADO,TOMADOR_NOMBRE1,TOMADOR_NOMBRE2,TOMADOR_APELLIDO1,TOMADOR_APELLIDO2,NUMERO_CREDITO,MONTO_ASEGURADO,FACTOR_VIDA,VALOR_SEGURO_PRIMA,FECHA_DESEMBOLSO,VALOR_PRESTAMO,FECHA_PROCESO,DOCUMENTO_IDENTIDAD_ASEGURADO,FECHA_NACIMIENTO_ASEGURADO,DIRECCION_ASEGURADO,TELEFONO_FIJO,DEPARTAMENTO,CIUDAD,ASEGURADO_VIDA_NOMBRE1,ASEGURADO_VIDA_NOMBRE2,ASEGURADO_VIDA_APELLIDO1,ASEGURADO_VIDA_APELLIDO2   from EMISION_PRODUCTO_IMPORTADO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EmisionProductoImportadoBean polizaBean = new EmisionProductoImportadoBean();

                polizaBean.setProducto(rs.getString("PRODUCTO"));
                polizaBean.setVigencia(rs.getString("VIGENCIA"));
                polizaBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                polizaBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                polizaBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                polizaBean.setFechaMovimiento(rs.getString("FECHA_MOVIMIENTO"));
                polizaBean.setSucursal(rs.getString("SUCURSAL"));
                polizaBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                polizaBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                polizaBean.setPeriodoGracia(rs.getString("PERIODO_GRACIA"));
                polizaBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                polizaBean.setHoraIniciacionVencimiento(rs.getString("HORA_INICIACION_VENCIMIENTO"));
                polizaBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                polizaBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                polizaBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                polizaBean.setTomadorNombre1(rs.getString("TOMADOR_NOMBRE1"));
                polizaBean.setTomadorNombre2(rs.getString("TOMADOR_NOMBRE2"));
                polizaBean.setTomadorApellido1(rs.getString("TOMADOR_APELLIDO1"));
                polizaBean.setTomadorApellido2(rs.getString("TOMADOR_APELLIDO2"));
                polizaBean.setNumeroCredito(rs.getString("NUMERO_CREDITO"));
                polizaBean.setMontoAsegurado(rs.getString("MONTO_ASEGURADO"));
                polizaBean.setFactorVida(rs.getString("FACTOR_VIDA"));
                polizaBean.setValorSeguroPrima(rs.getString("VALOR_SEGURO_PRIMA"));
                polizaBean.setFechaDesembolso(rs.getString("FECHA_DESEMBOLSO"));
                polizaBean.setValorPrestamo(rs.getString("VALOR_PRESTAMO"));
                polizaBean.setFechaProceso(rs.getString("FECHA_PROCESO"));
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
                emisionProdImport.add(polizaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }
        finally{
            if (conn != null){
                conn.close();
            }
        }
        return emisionProdImport;
    }
}
