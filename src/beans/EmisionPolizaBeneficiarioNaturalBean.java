package beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 02/08/2016.
 */
public class EmisionPolizaBeneficiarioNaturalBean implements Serializable {
    
    // SUCURSAL, NUM_POLIZA, TIPO_PRODUCCION, PERIODO_GRACIA_DIAS, LINEA_CREDITO,
    // HORA_INI_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA,
    // TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERM_MANEJO_CTA_PROV,
    // TIPO_TERCERO_T, TIPO_DOC_ID_T, NUM_DOCUMENTO_ID_T, NOMBRE_T, APELLIDO_T,
    // NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA,
    // FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO,
    // CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA,
    // PORCENTAJE_FACULTATIVO, ASEGURADO_PRIMARIO, PORCETAJE_EXTRA_PRIMA,
    // PORCETAJE_DESCUENTO, DOC_ID_ASEGURADO, FECHA_NAC_ASEGURADO, DIRECCION_ASEGURADO,
    // TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, TIPO_TERCERO_BN, TIPO_DOC_ID_BN,
    // NUM_DOCUMENTO_ID_BN, NOMBRE_BN, APELLIDO_BN, TIPO_DEBENIFICARIO,
    // BENEFICIARIO_IRREVOCABLE, PORCENTAJE_BENEFICIARIO, CODIGO_BENEFICIARIO,
    // PARENTEZCO, NUEVO_TIPO_DEBENIFICARIO, NUEVO_BENEFICIARIO_IRREVOCABLE,
    // NUEVO_PORCENTAJE_BENEFICIARIO, NUEVO_CODIGO_BENEFICIARIO, NUEVO_PARENTEZCO
    private String producto;
    private String vigencia;
    private String fechaDesde;
    private String fechaHasta;
    private String eventoAplicar;

    private String fechaMovimiento;
    private String fechaEfectivaApliEv;
    private String planFinanciamiento;
    private String moneda;

    private String sucursal;
    private String tipoProduccion;
    private String periodoGracia;
    private String lineaCredito;
    private String unidadNegocio;
    private String canalVenta;
    private String tipoValorAsegurado;
    private String tasa;
    private String tipoTasa;
    private String tipoTerceroT;
    private String tipoDocIdT;
    private String cedulaT;
    private String nombreT;
    private String apellidoT;
    private String porcentajeTomador;
    private String numUnidadRiesgo;
    private String numCredito;
    private String montoAsegurado;
    private String tipoTerceroBenNat1;
    private String tipoDocIdBenNat1;
    private String cedulaBenNat1;
    private String nombreBenNat1;
    private String apellidoBenNat1;
    private String porcentajeBenNat1;
    private String tipoTerceroBenNat2;
    private String tipoDocIdBenNat2;
    private String cedulaBenNat2;
    private String nombreBenNat2;
    private String apellidoBenNat2;
    private String porcentajeBenNat2;
    private String nuevoPorcentajeBenNat1;

    public String getProducto(){
        return producto;
    }
    public void setProducto(String producto){
        this.producto = producto;
    }

    public String getVigencia(){
        return vigencia;
    }
    public void setVigencia(String vigencia){
        this.vigencia = vigencia;
    }



    public static ArrayList getEmisionPolizaBeneficiarioNatural(){
        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList emision = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO_T, TIPO_DOC_IDENTIDAD_T, CEDULA_T, NOMBRE_T, APELLIDO_T, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, TIPO_TERCERO_BEN_NAT_1, TIPO_DOC_IDENTIDAD_BEN_NAT_1, CEDULA_BEN_NAT_1, NOMBRE_BEN_NAT_1, APELLIDO_BEN_NAT_1, PORCENTAJE_BEN_NAT_1, TIPO_TERCERO_BEN_NAT_2, TIPO_DOC_IDENTIDAD_BEN_NAT_2, CEDULA_BEN_NAT_2, NOMBRE_BEN_NAT_2, APELLIDO_BEN_NAT_2, PORCENTAJE_BEN_NAT_2, NUEVO_PORCENTAJE_BEN_NAT_1 FROM POLIZA_BENEFICIARIO_NATURAL ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean = new EmisionPolizaBeneficiarioNaturalBean();

                emisionPolizaBeneficiarioNaturalBean.setProducto(rs.getString("PRODUCTO"));
                emisionPolizaBeneficiarioNaturalBean.(rs.getString(""));

                emision.add(emisionPolizaBeneficiarioNaturalBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return emision;
    }
}

// PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR,
// FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLI_EV, PLAN_FINANCIAMIENTO, MONEDA,
// SUCURSAL, NUM_POLIZA, TIPO_PRODUCCION, PERIODO_GRACIA_DIAS, LINEA_CREDITO,
// HORA_INI_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA,
// TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERM_MANEJO_CTA_PROV,
// TIPO_TERCERO_T, TIPO_DOC_ID_T, NUM_DOCUMENTO_ID_T, NOMBRE_T, APELLIDO_T,
// NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA,
// FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO,
// CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA,
// PORCENTAJE_FACULTATIVO, ASEGURADO_PRIMARIO, PORCETAJE_EXTRA_PRIMA,
// PORCETAJE_DESCUENTO, DOC_ID_ASEGURADO, FECHA_NAC_ASEGURADO, DIRECCION_ASEGURADO,
// TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, TIPO_TERCERO_BN, TIPO_DOC_ID_BN,
// NUM_DOCUMENTO_ID_BN, NOMBRE_BN, APELLIDO_BN, TIPO_DEBENIFICARIO,
// BENEFICIARIO_IRREVOCABLE, PORCENTAJE_BENEFICIARIO, CODIGO_BENEFICIARIO,
// PARENTEZCO, NUEVO_TIPO_DEBENIFICARIO, NUEVO_BENEFICIARIO_IRREVOCABLE,
// NUEVO_PORCENTAJE_BENEFICIARIO, NUEVO_CODIGO_BENEFICIARIO, NUEVO_PARENTEZCO
