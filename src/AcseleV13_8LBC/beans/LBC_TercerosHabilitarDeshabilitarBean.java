package AcseleV13_8LBC.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 20/10/2016.
 */
public class LBC_TercerosHabilitarDeshabilitarBean extends LBC_PolizasBean implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_TercerosHabilitarDeshabilitarBean.class);

    private String apellidoPaterno;
    private String apellidoMaterno;
    private String primerNombre;
    private String segundoNombre;
    private String tercerNombre;
    private String tipoDocumentoId;
    private String numeroDocumentoId;

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }
    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getTipoDocumentoId() {
        return tipoDocumentoId;
    }
    public void setTipoDocumentoId(String tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getNumeroDocumentoId() {
        return numeroDocumentoId;
    }
    public void setNumeroDocumentoId(String numeroDocumentoId) {
        this.numeroDocumentoId = numeroDocumentoId;
    }

    public static ArrayList getLBC_TercerosHabilitarDeshabilitarBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tercero = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, APELLIDO_PATERNO, APELLIDO_MATERNO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, TERCER_NOMBRE, TIPO_DOC_ID, NUM_DOC_ID, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, DIAS_AMPLIACION, PLANES_FINANCIAMIENTO, MONEDAS, TIPO_COASEGURO, OFICINA, NUMERO_POLIZA, NUMERO_PROPUESTA, FECHA_EMISION, TIPO_PRODUCCION, CANAL_VENTA, COMISION_NEGOCIABLE, SEGMENTO, PORCENTAJE_CUOTA_INICIAL, PRIMA_TOTAL, PRIMA_TECNICA_NETA, FECHA_FIN_COTIZACION, OBSERVACIONES_POLIZA, OBSERVACIONES_SUSCRIPCION, VALOR_ASEG_TOTAL_POLIZA_ENDOSO FROM TERCERO_ENABLE_DISABLE_LBC ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_TercerosHabilitarDeshabilitarBean lbcTercerosHabilitarDeshabilitarBean = new LBC_TercerosHabilitarDeshabilitarBean();


                lbcTercerosHabilitarDeshabilitarBean.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                lbcTercerosHabilitarDeshabilitarBean.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
                lbcTercerosHabilitarDeshabilitarBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                lbcTercerosHabilitarDeshabilitarBean.setSegundoNombre(rs.getString("SEGUNDO_NOMBRE"));
                lbcTercerosHabilitarDeshabilitarBean.setTercerNombre(rs.getString("TERCER_NOMBRE"));
                lbcTercerosHabilitarDeshabilitarBean.setTipoDocumentoId(rs.getString("TIPO_DOC_ID"));
                lbcTercerosHabilitarDeshabilitarBean.setNumeroDocumentoId(rs.getString("NUM_DOC_ID"));
                lbcTercerosHabilitarDeshabilitarBean.setProducto(rs.getString("PRODUCTO"));
                lbcTercerosHabilitarDeshabilitarBean.setVigencia(rs.getString("VIGENCIA"));
                lbcTercerosHabilitarDeshabilitarBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                lbcTercerosHabilitarDeshabilitarBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                lbcTercerosHabilitarDeshabilitarBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                lbcTercerosHabilitarDeshabilitarBean.setFechaMovimiento(rs.getString("FECHA_MOVIMIENTO"));
                lbcTercerosHabilitarDeshabilitarBean.setDiasApmpliacion(rs.getString("DIAS_AMPLIACION"));
                lbcTercerosHabilitarDeshabilitarBean.setPlanesFinanciamiento(rs.getString("PLANES_FINANCIAMIENTO"));
                lbcTercerosHabilitarDeshabilitarBean.setMonedas(rs.getString("MONEDAS"));
                lbcTercerosHabilitarDeshabilitarBean.setTipoCoaseguro(rs.getString("TIPO_COASEGURO"));
                lbcTercerosHabilitarDeshabilitarBean.setOficina(rs.getString("OFICINA"));
                lbcTercerosHabilitarDeshabilitarBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                lbcTercerosHabilitarDeshabilitarBean.setNumeroPropuesta(rs.getString("NUMERO_PROPUESTA"));
                lbcTercerosHabilitarDeshabilitarBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                lbcTercerosHabilitarDeshabilitarBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                lbcTercerosHabilitarDeshabilitarBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                lbcTercerosHabilitarDeshabilitarBean.setComisionNegociable(rs.getString("COMISION_NEGOCIABLE"));
                lbcTercerosHabilitarDeshabilitarBean.setSegmento(rs.getString("SEGMENTO"));
                lbcTercerosHabilitarDeshabilitarBean.setPorcentajeCuotaInicial(rs.getString("PORCENTAJE_CUOTA_INICIAL"));
                lbcTercerosHabilitarDeshabilitarBean.setPrimaTotal(rs.getString("PRIMA_TOTAL"));
                lbcTercerosHabilitarDeshabilitarBean.setPrimaTecnicaNeta(rs.getString("PRIMA_TECNICA_NETA"));
                lbcTercerosHabilitarDeshabilitarBean.setFechaFinCotizacion(rs.getString("FECHA_FIN_COTIZACION"));
                lbcTercerosHabilitarDeshabilitarBean.setObservacionesPolizas(rs.getString("OBSERVACIONES_POLIZA"));
                lbcTercerosHabilitarDeshabilitarBean.setObservacionesSuscripcion(rs.getString("OBSERVACIONES_SUSCRIPCION"));
                lbcTercerosHabilitarDeshabilitarBean.setValorAseguradoTotalPolizaEndoso(rs.getString("VALOR_ASEG_TOTAL_POLIZA_ENDOSO"));

                tercero.add(lbcTercerosHabilitarDeshabilitarBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return tercero;
    }
}
