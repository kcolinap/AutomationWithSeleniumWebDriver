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
 * Created by rmontilla on 03/11/2016.
 */
public class LBC_ModosPagoTerceroBean implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_ModosPagoTerceroBean.class);

    private String tipoTercero;
    private String apellido;
    private String nombre;
    private String tipoDocId;
    private String numDocId;
    private String modoPago;
    private String tipoCuenta;
    private String numCtaBco;
    private String descripcion;
    private String collector;
    private String sucursal;

    public String getTipoCuenta() {return tipoCuenta;}
    public void setTipoCuenta(String tipoCuenta) {this.tipoCuenta = tipoCuenta;}

    public String getModoPago() { return modoPago;}
    public void setModoPago(String modoPago) {this.modoPago = modoPago;}

    public String getNumCtaBco() {return numCtaBco;}
    public void setNumCtaBco(String numCtaBco) {this.numCtaBco = numCtaBco;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getCollector() {return collector;}
    public void setCollector(String collector) {this.collector = collector;}

    public String getSucursal() {return sucursal;}
    public void setSucursal(String sucursal) {this.sucursal = sucursal;}

    public String getTipoTercero() {return tipoTercero;}
    public void setTipoTercero(String tipoTercero) {this.tipoTercero = tipoTercero;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getTipoDocId() {return tipoDocId;}
    public void setTipoDocId(String tipoDocId) {this.tipoDocId = tipoDocId;}

    public String getNumDocId() {return numDocId;}
    public void setNumDocId(String numDocId) {this.numDocId = numDocId;}


    public static ArrayList getLBC_ModosPagoTerceroBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList ModosPagoTerceroBean = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select *  from LBC_MODOS_PAGO_TERCERO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_ModosPagoTerceroBean lbc_ModosPagoTerceroBean = new LBC_ModosPagoTerceroBean();

                lbc_ModosPagoTerceroBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                lbc_ModosPagoTerceroBean.setApellido(rs.getString("APELLIDO"));
                lbc_ModosPagoTerceroBean.setNombre(rs.getString("NOMBRE"));
                lbc_ModosPagoTerceroBean.setTipoDocId(rs.getString("TIPO_DOC_ID"));
                lbc_ModosPagoTerceroBean.setNumDocId(rs.getString("NUM_DOC_ID"));
                lbc_ModosPagoTerceroBean.setModoPago(rs.getString("MODO_PAGO"));
                lbc_ModosPagoTerceroBean.setDescripcion(rs.getString("DESCRIPCION"));
                lbc_ModosPagoTerceroBean.setNumCtaBco(rs.getString("NUM_CTA_BCO"));
                lbc_ModosPagoTerceroBean.setCollector(rs.getString("COLLECTOR"));
                lbc_ModosPagoTerceroBean.setTipoCuenta(rs.getString("TIPO_CUENTA"));
                lbc_ModosPagoTerceroBean.setSucursal(rs.getString("SUCURSAL"));


                ModosPagoTerceroBean.add(lbc_ModosPagoTerceroBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return ModosPagoTerceroBean;

    }

}
