package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 07/02/2017.
 */
public class INTER_TerceroDeshabilitarBean extends Inter_PolizaBean {

    private final static Logger log = Logger.getLogger(INTER_TerceroDeshabilitarBean.class);

    private String tipoTercero;
    private String tipoDoc;
    private String docId;
    private String nombre;
    private String apellido;

    public String getTipoTercero() {return tipoTercero;}
    public void setTipoTercero(String tipoTercero) {this.tipoTercero = tipoTercero;}

    public String getTipoDoc() {return tipoDoc;}
    public void setTipoDoc(String tipoDoc) {this.tipoDoc = tipoDoc;}

    public String getDocId() {return docId;}
    public void setDocId(String docId) {this.docId = docId;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}


    public static ArrayList getINTER_TerceroDeshabilitar() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interTerceroDeshabilitar = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,tipo_tercero, tipo_doc, doc_id,nombre, apellido, producto, vigencia, fecha_Desde, fecha_Hasta, evento_Aplicar, fecha_Movimiento, planes_Financiamiento, monedas, tipo_Documento, numero_Documento, moneda_DePrima, monto_Primera_Prima, fecha_Cotizacion, envio_Comunicaciones_Poliza, plan, contratante1_Nombre1, contratante1_Nombre2, contratante1_Apellido1,contratante1_Apellido2,porcentaje_Contratante1,porcentaje_Contratante2 FROM INTER_TERCERODESHABILITAR ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_TerceroDeshabilitarBean inter_terceroDeshabilitarBean= new INTER_TerceroDeshabilitarBean();

                inter_terceroDeshabilitarBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                inter_terceroDeshabilitarBean.setTipoDoc(rs.getString("TIPO_DOC"));
                inter_terceroDeshabilitarBean.setDocId(rs.getString("DOC_ID"));
                inter_terceroDeshabilitarBean.setNombre(rs.getString("NOMBRE"));
                inter_terceroDeshabilitarBean.setApellido(rs.getString("APELLIDO"));
                inter_terceroDeshabilitarBean.setProducto(rs.getString("PRODUCTO"));
                inter_terceroDeshabilitarBean.setVigencia(rs.getString("VIGENCIA"));
                inter_terceroDeshabilitarBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                inter_terceroDeshabilitarBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                inter_terceroDeshabilitarBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                inter_terceroDeshabilitarBean.setFechaMovimiento(rs.getString("FECHA_MOVIMIENTO"));
                inter_terceroDeshabilitarBean.setPlanesFinanciamiento(rs.getString("PLANES_FINANCIAMIENTO"));
                inter_terceroDeshabilitarBean.setMonedas(rs.getString("MONEDAS"));
                inter_terceroDeshabilitarBean.setTipoDocumento(rs.getString("TIPO_DOCUMENTO"));
                inter_terceroDeshabilitarBean.setNumeroDocumento(rs.getString("NUMERO_DOCUMENTO"));
                inter_terceroDeshabilitarBean.setMonedaDePrima(rs.getString("MONEDA_DEPRIMA"));
                inter_terceroDeshabilitarBean.setMontoPrimeraPrima(rs.getString("MONTO_PRIMERA_PRIMA"));
                inter_terceroDeshabilitarBean.setFechaCotizacion(rs.getString("FECHA_COTIZACION"));
                inter_terceroDeshabilitarBean.setEnvioComunicacionesPoliza(rs.getString("ENVIO_COMUNICACIONES_POLIZA"));
                inter_terceroDeshabilitarBean.setPlan(rs.getString("PLAN"));
                inter_terceroDeshabilitarBean.setContratante1Nombre1(rs.getString("CONTRATANTE1_NOMBRE1"));
                inter_terceroDeshabilitarBean.setContratante1Nombre2(rs.getString("CONTRATANTE1_NOMBRE2"));
                inter_terceroDeshabilitarBean.setContratante1Apellido1(rs.getString("CONTRATANTE1_APELLIDO1"));
                inter_terceroDeshabilitarBean.setContratante1Apellido2(rs.getString("CONTRATANTE1_APELLIDO2"));
                inter_terceroDeshabilitarBean.setPorcentajeContratante1(rs.getString("PORCENTAJE_CONTRATANTE1"));
                inter_terceroDeshabilitarBean.setPorcentajeContratante2(rs.getString("PORCENTAJE_CONTRATANTE2"));





                interTerceroDeshabilitar.add(inter_terceroDeshabilitarBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interTerceroDeshabilitar;

    }
}
