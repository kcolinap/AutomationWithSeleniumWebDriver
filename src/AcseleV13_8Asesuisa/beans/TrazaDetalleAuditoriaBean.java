package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by cortiz on 29/03/2017.
 */
public class TrazaDetalleAuditoriaBean implements Serializable {

    private final static Logger log = Logger.getLogger(TrazaDetalleAuditoriaBean.class);

    private String tipoTraza;
    private String categoria_Traza;
    private String ipdesde;
    private String iphasta;
    private String usuario;
    private String mascaraip;
    private String horadesde;
    private String horahasta;
    private String desde;
    private String hasta;
    private String identificador;

    public String getTipoTraza() {
        return tipoTraza;
    }

    public void setTipoTraza(String tipoTraza) {
        this.tipoTraza = tipoTraza;
    }

    public String getCategoria_Traza() {
        return categoria_Traza;
    }

    public void setCategoria_Traza(String categoria_Traza) {
        this.categoria_Traza = categoria_Traza;
    }

    public String getIpdesde() {
        return ipdesde;
    }

    public void setIpdesde(String ipdesde) {
        this.ipdesde = ipdesde;
    }

    public String getIphasta() {
        return iphasta;
    }

    public void setIphasta(String iphasta) {
        this.iphasta = iphasta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMascaraip() {
        return mascaraip;
    }

    public void setMascaraip(String mascaraip) {
        this.mascaraip = mascaraip;
    }

    public String getHoradesde() {
        return horadesde;
    }

    public void setHoradesde(String horadesde) {
        this.horadesde = horadesde;
    }

    public String getHorahasta() {
        return horahasta;
    }

    public void setHorahasta(String horahasta) {
        this.horahasta = horahasta;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public static ArrayList getTrazaDetalleAuditoria() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList trazaDetalleAuditoria = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT *  FROM Asesuisa_Detalle_Traza ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TrazaDetalleAuditoriaBean trazaDetalleAuditoriaBean = new TrazaDetalleAuditoriaBean();


                trazaDetalleAuditoriaBean.setTipoTraza(rs.getString("Tipo_Traza"));
                trazaDetalleAuditoriaBean.setCategoria_Traza(rs.getString("Categoria_Traza"));
                trazaDetalleAuditoriaBean.setIpdesde(rs.getString("ipdesde"));
                trazaDetalleAuditoriaBean.setIphasta(rs.getString("iphasta"));
                trazaDetalleAuditoriaBean.setUsuario(rs.getString("usuario"));
                trazaDetalleAuditoriaBean.setMascaraip(rs.getString("mascaraip"));
                trazaDetalleAuditoriaBean.setHoradesde(rs.getString("horadesde"));
                trazaDetalleAuditoriaBean.setHorahasta(rs.getString("horahasta"));
                trazaDetalleAuditoriaBean.setDesde(rs.getString("desde"));
                trazaDetalleAuditoriaBean.setHasta(rs.getString("hasta"));
                trazaDetalleAuditoriaBean.setIdentificador(rs.getString("identificador"));

                trazaDetalleAuditoria.add(trazaDetalleAuditoriaBean);

            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

        return trazaDetalleAuditoria;

    }
}