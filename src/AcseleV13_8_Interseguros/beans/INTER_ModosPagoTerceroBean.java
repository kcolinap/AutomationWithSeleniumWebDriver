package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 04/01/2017.
 */
public class INTER_ModosPagoTerceroBean {

    private final static Logger log = Logger.getLogger(INTER_ModosPagoTerceroBean.class);

    private String tipoTercero;
    private String numDocId;
    private String apellido;
    private String nombre;
    private String modoPago;
    private String evaluacionRiesgo;
    private String emisorDeTarjeta;
    private String tipoCuenta;
    private String colector;
    private String sucursal;


    public String getTipoTercero() {return tipoTercero;}
    public void setTipoTercero(String tipoTercero) {this.tipoTercero = tipoTercero;}

    public String getNumDocId() {return numDocId;}
    public void setNumDocId(String numDocId) {this.numDocId = numDocId;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getModoPago() {return modoPago;}
    public void setModoPago(String modoPago) {this.modoPago = modoPago;}

    public String getEvaluacionRiesgo() {return  evaluacionRiesgo;}
    public void setEvaluacionRiesgo(String evaluacionRiesgo) {this.evaluacionRiesgo = evaluacionRiesgo;}

    public String getEmisorDeTarjeta() {return emisorDeTarjeta;}
    public void setEmisorDeTarjeta(String emisorDeTarjeta) {this.emisorDeTarjeta = emisorDeTarjeta;}

    public String getTipoCuenta() {return tipoCuenta;}
    public void setTipoCuenta(String tipoCuenta) {this.tipoCuenta = tipoCuenta;}

    public String getColector() {return colector;}
    public void setColector(String colector) {this.colector = colector;}

    public String getSucursal() {return sucursal;}
    public void setSucursal(String sucursal) {this.sucursal = sucursal;}

    public static ArrayList getINTER_ModosPagoTerceroBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList ModosPagoTerceroBean = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from MODOS_PAGO_TERCERO_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_ModosPagoTerceroBean interModosPagoTerceroBean = new INTER_ModosPagoTerceroBean();

                interModosPagoTerceroBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                interModosPagoTerceroBean.setNumDocId(rs.getString("NUM_DOC_IDENTIDAD"));
                interModosPagoTerceroBean.setApellido(rs.getString("APELLIDO"));
                interModosPagoTerceroBean.setNombre(rs.getString("NOMBRE"));
                interModosPagoTerceroBean.setModoPago(rs.getString("MODO_PAGO"));
                interModosPagoTerceroBean.setEvaluacionRiesgo(rs.getString("EVALUACION_RIESGO"));
                interModosPagoTerceroBean.setEmisorDeTarjeta(rs.getString("EMISOR_DE_TARJETA"));
                interModosPagoTerceroBean.setTipoCuenta(rs.getString("TIPO_CUENTA"));
                interModosPagoTerceroBean.setColector(rs.getString("COLECTOR"));
                interModosPagoTerceroBean.setSucursal(rs.getString("SUCURSAL"));


                ModosPagoTerceroBean.add(interModosPagoTerceroBean);
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
