package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 13/07/2016.
 */
public class BeneficiarioJuridicoATerceroNaturalBean implements Serializable{

    private String tipoTercero;
    private String tipoDocId;
    private String nit;
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

    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit= nit;
    }

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }

    public static ArrayList getBeneficiarioJuridicoATerceroNatural() {

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList terceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, NIT, RAZON_SOCIAL, ROL FROM BENEFICIARIO_JURIDICO_TERCERO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                BeneficiarioJuridicoATerceroNaturalBean beneficiarioJuridicoATerceroNaturalBean = new BeneficiarioJuridicoATerceroNaturalBean();
                beneficiarioJuridicoATerceroNaturalBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                beneficiarioJuridicoATerceroNaturalBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                beneficiarioJuridicoATerceroNaturalBean.setNit(rs.getString("NIT"));
                beneficiarioJuridicoATerceroNaturalBean.setRol(rs.getString("ROL"));
                terceros.add(beneficiarioJuridicoATerceroNaturalBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return terceros;
    }

}
