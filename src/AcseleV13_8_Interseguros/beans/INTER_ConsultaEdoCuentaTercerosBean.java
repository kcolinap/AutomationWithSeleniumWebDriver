package AcseleV13_8_Interseguros.beans;
import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Created by aazuaje on 15/11/2016.
 */
public class INTER_ConsultaEdoCuentaTercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_ConsultaEdoCuentaTercerosBean.class);

    private String tipoTercero;
    private String numDocIdent;
    private String apellido;
    private String nombre;
    private String fechaInicial;
    private String fechaFinal;
    private String moneda;
    private String producto;

    public String getTipoTercero() {return tipoTercero;}
    public void setTipoTercero(String tipoTercero) {this.tipoTercero = tipoTercero;}

    public String getNumDocIdent() {return numDocIdent;}
    public void setNumDocIdent(String numDocIdent) {this.numDocIdent = numDocIdent;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getFechaInicial() {return fechaInicial;}
    public void setFechaInicial(String fechaInicial) {this.fechaInicial = fechaInicial;}

    public String getFechaFinal() {return fechaFinal;}
    public void setFechaFinal(String fechaFinal) {this.fechaFinal = fechaFinal;}

    public String getMoneda() {return moneda;}
    public void setMoneda(String moneda) {this.moneda = moneda;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public static ArrayList getInterConsultaEdoCuentaTerceros() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interEdoCuentas = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA,TIPO_TERCERO, NUM_DOC_IDENT,APELLIDO,NOMBRE, FECHA_INICIAL, FECHA_FINAL, MONEDA, PRODUCTO FROM INTER_CONSULTA_EDO_CUENTAS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_ConsultaEdoCuentaTercerosBean inter_consultaEdoCuentaTercerosBean = new INTER_ConsultaEdoCuentaTercerosBean();

                inter_consultaEdoCuentaTercerosBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                inter_consultaEdoCuentaTercerosBean.setNumDocIdent(rs.getString("NUM_DOC_IDENT"));
                inter_consultaEdoCuentaTercerosBean.setApellido(rs.getString("APELLIDO"));
                inter_consultaEdoCuentaTercerosBean.setNombre(rs.getString("NOMBRE"));
                inter_consultaEdoCuentaTercerosBean.setFechaInicial(rs.getString("FECHA_INICIAL"));
                inter_consultaEdoCuentaTercerosBean.setFechaFinal(rs.getString("FECHA_FINAL"));
                inter_consultaEdoCuentaTercerosBean.setMoneda(rs.getString("MONEDA"));
                inter_consultaEdoCuentaTercerosBean.setProducto(rs.getString("PRODUCTO"));

                interEdoCuentas.add(inter_consultaEdoCuentaTercerosBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return interEdoCuentas;
    }




}
