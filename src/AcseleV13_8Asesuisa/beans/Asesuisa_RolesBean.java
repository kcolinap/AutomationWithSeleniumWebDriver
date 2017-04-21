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
 * Created by aandrade on 29/03/2017.
 */
public class Asesuisa_RolesBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_RolesBean.class);

    private String tipoTercero;
    private String asegurado;
    private String PRIMERNOMBRE;
    private String PRIMERAPELLIDO;
    private String NombreTercero;
    private String TIPOROL;
    private String TIPOCOMPROBANTE;
    private String TIPOPROVEEDOR;
    private String ESPECIALIDAD1;
    private String ESPECIALIDAD2;
    private String ESPECIALIDAD3;
    private String CLASIFIAREA;
    private String CONTRATO;
    private String CONVENIO;
    private String TIPOPAGO;
    private String CANTCTA;
    private String NROCTA;
    private String NOMBAN;
    private String TIPCTA;
    private String NOMCONTACTO;
    private String EMAIL;
    private String TipoCta;
    private String NroCta;


    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(String asegurado) {
        this.asegurado = asegurado;
    }

    public String getPRIMERNOMBRE() {
        return PRIMERNOMBRE;
    }

    public void setPRIMERNOMBRE(String PRIMERNOMBRE) {
        this.PRIMERNOMBRE = PRIMERNOMBRE;
    }

    public String getPRIMERAPELLIDO() {
        return PRIMERAPELLIDO;
    }

    public void setPRIMERAPELLIDO(String PRIMERAPELLIDO) {
        this.PRIMERAPELLIDO = PRIMERAPELLIDO;
    }

    public String getNombreTercero() {
        return NombreTercero;
    }

    public void setNombreTercero(String nombreTercero) {
        NombreTercero = nombreTercero;
    }

    public String getTIPOROL() {
        return TIPOROL;
    }

    public void setTIPOROL(String TIPOROL) {
        this.TIPOROL = TIPOROL;
    }

    public String getTIPOCOMPROBANTE() {
        return TIPOCOMPROBANTE;
    }

    public void setTIPOCOMPROBANTE(String TIPOCOMPROBANTE) {
        this.TIPOCOMPROBANTE = TIPOCOMPROBANTE;
    }

    public String getTIPOPROVEEDOR() {
        return TIPOPROVEEDOR;
    }

    public void setTIPOPROVEEDOR(String TIPOPROVEEDOR) {
        this.TIPOPROVEEDOR = TIPOPROVEEDOR;
    }

    public String getESPECIALIDAD1() {
        return ESPECIALIDAD1;
    }

    public void setESPECIALIDAD1(String ESPECIALIDAD1) {
        this.ESPECIALIDAD1 = ESPECIALIDAD1;
    }

    public String getESPECIALIDAD2() {
        return ESPECIALIDAD2;
    }

    public void setESPECIALIDAD2(String ESPECIALIDAD2) {
        this.ESPECIALIDAD2 = ESPECIALIDAD2;
    }

    public String getESPECIALIDAD3() {
        return ESPECIALIDAD3;
    }

    public void setESPECIALIDAD3(String ESPECIALIDAD3) {
        this.ESPECIALIDAD3 = ESPECIALIDAD3;
    }

    public String getCLASIFIAREA() {
        return CLASIFIAREA;
    }

    public void setCLASIFIAREA(String CLASIFIAREA) {
        this.CLASIFIAREA = CLASIFIAREA;
    }

    public String getCONTRATO() {
        return CONTRATO;
    }

    public void setCONTRATO(String CONTRATO) {
        this.CONTRATO = CONTRATO;
    }

    public String getCONVENIO() {
        return CONVENIO;
    }

    public void setCONVENIO(String CONVENIO) {
        this.CONVENIO = CONVENIO;
    }

    public String getTIPOPAGO() {
        return TIPOPAGO;
    }

    public void setTIPOPAGO(String TIPOPAGO) {
        this.TIPOPAGO = TIPOPAGO;
    }

    public String getCANTCTA() {
        return CANTCTA;
    }

    public void setCANTCTA(String CANTCTA) {
        this.CANTCTA = CANTCTA;
    }

    public String getNROCTA() {
        return NROCTA;
    }

    public void setNROCTA(String NROCTA) {
        this.NROCTA = NROCTA;
    }

    public String getNOMBAN() {
        return NOMBAN;
    }

    public void setNOMBAN(String NOMBAN) {
        this.NOMBAN = NOMBAN;
    }

    public String getTIPCTA() {
        return TIPCTA;
    }

    public void setTIPCTA(String TIPCTA) {
        this.TIPCTA = TIPCTA;
    }

    public String getNOMCONTACTO() {
        return NOMCONTACTO;
    }

    public void setNOMCONTACTO(String NOMCONTACTO) {
        this.NOMCONTACTO = NOMCONTACTO;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getTipoCta() {
        return TipoCta;
    }

    public void setTipoCta(String tipoCta) {
        TipoCta = tipoCta;
    }

    public String getNroCta() {
        return NroCta;
    }

    public void setNroCta(String nroCta) {
        NroCta = nroCta;
    }

    public static ArrayList getAsesuisa_Rol() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList rol = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_ROLES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_RolesBean rolBean = new Asesuisa_RolesBean();

                rolBean.setTipoTercero(rs.getString("TipoTercero"));
                rolBean.setAsegurado(rs.getString("Asegurado"));
                rolBean.setPRIMERNOMBRE(rs.getString("PRIMERNOMBRE"));
                rolBean.setPRIMERAPELLIDO(rs.getString("PRIMERAPELLIDO"));
                rolBean.setNombreTercero(rs.getString("NOMTERCERO"));
                rolBean.setTIPOROL(rs.getString("TIPOROL"));
                rolBean.setTIPOCOMPROBANTE(rs.getString("TIPOCOMPROBANTE"));
                rolBean.setTIPOPROVEEDOR(rs.getString("TIPOPROVEEDOR"));
                rolBean.setESPECIALIDAD1(rs.getString("ESPECIALIDAD1"));
                rolBean.setESPECIALIDAD2(rs.getString("ESPECIALIDAD2"));
                rolBean.setESPECIALIDAD3(rs.getString("ESPECIALIDAD3"));
                rolBean.setCLASIFIAREA(rs.getString("CLASIFIAREA"));
                rolBean.setCONTRATO(rs.getString("CONTRATO"));
                rolBean.setCONVENIO(rs.getString("CONVENIO"));
                rolBean.setTIPOPAGO(rs.getString("TIPOPAGO"));
                rolBean.setCANTCTA(rs.getString("CANTCTA"));
                rolBean.setNROCTA(rs.getString("NROCTA"));
                rolBean.setNOMBAN(rs.getString("NOMBAN"));
                rolBean.setTIPCTA(rs.getString("TIPCTA"));
                rolBean.setNOMCONTACTO(rs.getString("NOMCONTACTO"));
                rolBean.setEMAIL(rs.getString("EMAIL"));

                rol.add(rolBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return rol;
    }
}
