package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 18/01/2017.
 */
public class INTER_CrearOpenItemsBean {
    private final static Logger log = Logger.getLogger(INTER_CrearOpenItemsBean.class);

    private String tercero;
    private String tipoTercero;
    private String rol1;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String primerNombre;
    private String segundoNombre;
    private String tercerNombre;
    private String tipoDocIdent;
    private String numDocIdent;
    private String rol2;
    private String conceptoCuenta;
    private String fechaMov;
    private String fechaVencimiento;
    private String moneda;
    private String monto;
    private String numPoliza;
    private String tipoRef;


    public String getTercero() {
        return tercero;
    }

    public void setTercero(String tercero) {
        this.tercero = tercero;
    }

    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getRol1() {
        return rol1;
    }

    public void setRol1(String rol1) {
        this.rol1 = rol1;
    }

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
    public String getTipoDocIdent() {
        return tipoDocIdent;
    }
    public void setTipoDocIdent(String tipoDocIdent) {
        this.tipoDocIdent = tipoDocIdent;
    }

    public String getNumDocIdent() {
        return numDocIdent;
    }

    public void setNumDocIdent(String numDocIdent) {
        this.numDocIdent = numDocIdent;
    }

    public String getRol2() {
        return rol2;
    }

    public void setRol2(String rol2) {
        this.rol2 = rol2;
    }

    public String getConceptoCuenta() {
        return conceptoCuenta;
    }

    public void setConceptoCuenta(String conceptoCuenta) {
        this.conceptoCuenta = conceptoCuenta;
    }

    public String getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(String fechaMov) {
        this.fechaMov = fechaMov;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getNumPoliza() {
        return numPoliza;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMonto() {
        return numPoliza;
    }

    public void setNumPoliza(String monto) {
        this.monto = monto;
    }

    public String getTipoRef() {
        return tipoRef;
    }

    public void setTipoRef(String tipoRef) {
        this.tipoRef = tipoRef;
    }

    public static ArrayList getCrearOpenItems() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList item = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA,TERCERO,TIPO_TERCERO,ROL1,APELLIDO_PATERNO,APELLIDO_MATERNO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,TERCER_NOMBRE,TIPO_DOC_IDENT,NUM_DOC_IDENT,CONCEPTO_CUENTA,ROL2,FECHA_MOV,FECHA_VENCIMIENTO,MONEDA,MONTO,NUM_POLIZA,TIPO_REF FROM CREAR_OPEN_ITEMS_INTER ORDER BY PRUEBA ASC");
        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_CrearOpenItemsBean interCrearOpenItemsBean = new INTER_CrearOpenItemsBean();
                interCrearOpenItemsBean.setTercero(rs.getString("TERCERO"));
                interCrearOpenItemsBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                interCrearOpenItemsBean.setRol1(rs.getString("ROL1"));
                interCrearOpenItemsBean.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                interCrearOpenItemsBean.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
                interCrearOpenItemsBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                interCrearOpenItemsBean.setSegundoNombre(rs.getString("SEGUNDO_NOMBRE"));
                interCrearOpenItemsBean.setTercerNombre(rs.getString("TERCER_NOMBRE"));
                interCrearOpenItemsBean.setTipoDocIdent(rs.getString("TIPO_DOC_IDENT"));
                interCrearOpenItemsBean.setNumDocIdent(rs.getString("NUM_DOC_IDENT"));
                interCrearOpenItemsBean.setRol2(rs.getString("ROL2"));
                interCrearOpenItemsBean.setConceptoCuenta(rs.getString("CONCEPTO_CUENTA"));
                interCrearOpenItemsBean.setFechaMov(rs.getString("FECHA_MOV"));
                interCrearOpenItemsBean.setFechaVencimiento(rs.getString("FECHA_VENCIMIENTO"));
                interCrearOpenItemsBean.setMoneda(rs.getString("MONEDA"));
                interCrearOpenItemsBean.setMonto(rs.getString("MONTO"));
                interCrearOpenItemsBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                interCrearOpenItemsBean.setTipoRef(rs.getString("TIPO_REF"));
                item.add(interCrearOpenItemsBean);
            }

        } catch (SQLException e) {

            log.error(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return item;
    }
}
