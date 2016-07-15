package beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 12/07/2016.
 */
public class BeneficiarioNaturalATerceroJuridicoBean implements Serializable {

    private String tipoTercero;
    private String tipoDocId;
    private String cedula;
    private String rol;


    public String getTipoTercero() {
        return tipoTercero;
    }
    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getTipoDocId() {
        return tipoDocId;
    }
    public void setTipoDocId(String tipoDocId) {
        this.tipoDocId = tipoDocId;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }

    public static ArrayList getBeneficiarioNaturalATerceroJuridico() {

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList terceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, ROL FROM BENEFICIARIO_NATURAL_TERCERO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                BeneficiarioNaturalATerceroJuridicoBean beneficiarioNaturalATerceroJuridicoBean = new BeneficiarioNaturalATerceroJuridicoBean();
                beneficiarioNaturalATerceroJuridicoBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                beneficiarioNaturalATerceroJuridicoBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                beneficiarioNaturalATerceroJuridicoBean.setCedula(rs.getString("CEDULA"));
                beneficiarioNaturalATerceroJuridicoBean.setRol(rs.getString("ROL"));
                terceros.add(beneficiarioNaturalATerceroJuridicoBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return terceros;
    }

}
