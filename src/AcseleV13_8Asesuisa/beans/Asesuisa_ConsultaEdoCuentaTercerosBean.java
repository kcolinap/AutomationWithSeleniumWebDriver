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
 * Created by kcolina on 24/03/2017.
 */
public class Asesuisa_ConsultaEdoCuentaTercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_ConsultaEdoCuentaTercerosBean.class);

    private String tipoTercero;

    //Campos para persona Natural
    private String primerNombre;
    private String primerApellido;
    private String codigoIdentificador;
    private String email;
    private String dctoIdentificacion;

    //Campos para busqueda persona Juridica
    private String razonSocial;
    private String codigoIJuridico;
    private String paisOrigen;
    private String tlfEmpresa;
    private String emailContacto;

    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDctoIdentificacion() {
        return dctoIdentificacion;
    }

    public void setDctoIdentificacion(String dctoIdentificacion) {
        this.dctoIdentificacion = dctoIdentificacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCodigoIJuridico() {
        return codigoIJuridico;
    }

    public void setCodigoIJuridico(String codigoIJuridico) {
        this.codigoIJuridico = codigoIJuridico;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getTlfEmpresa() {
        return tlfEmpresa;
    }

    public void setTlfEmpresa(String tlfEmpresa) {
        this.tlfEmpresa = tlfEmpresa;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public static ArrayList getConsultaEdoCuentaTerceros() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList consultaEdoCuentaTerceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from ASE_CONSULTA_ESTADO_CUENTA order by PRUEBA ASC ");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                Asesuisa_ConsultaEdoCuentaTercerosBean asesuisaConsultaEdoCuentaTercerosBean = new Asesuisa_ConsultaEdoCuentaTercerosBean();

                asesuisaConsultaEdoCuentaTercerosBean.setTipoTercero(rs.getString("TIPOTERCERO"));
                asesuisaConsultaEdoCuentaTercerosBean.setPrimerNombre(rs.getString("PRIMERNOMBRE"));
                asesuisaConsultaEdoCuentaTercerosBean.setPrimerApellido(rs.getString("PRIMERAPELLIDO"));
                asesuisaConsultaEdoCuentaTercerosBean.setCodigoIdentificador(rs.getString("CODIGOIDENTIFICADOR"));
                asesuisaConsultaEdoCuentaTercerosBean.setEmail(rs.getString("EMAIL"));
                asesuisaConsultaEdoCuentaTercerosBean.setDctoIdentificacion(rs.getString("DCTOIDENTIFICACION"));
                asesuisaConsultaEdoCuentaTercerosBean.setRazonSocial(rs.getString("RAZONSOCIAL"));
                asesuisaConsultaEdoCuentaTercerosBean.setCodigoIJuridico(rs.getString("CODIGOIJURIDICO"));
                asesuisaConsultaEdoCuentaTercerosBean.setPaisOrigen(rs.getString("PAISORIGEN"));
                asesuisaConsultaEdoCuentaTercerosBean.setTlfEmpresa(rs.getString("TLFEMPRESA"));
                asesuisaConsultaEdoCuentaTercerosBean.setEmailContacto(rs.getString("EMAILCONTACTO"));


                consultaEdoCuentaTerceros.add(asesuisaConsultaEdoCuentaTercerosBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return consultaEdoCuentaTerceros;
    }
}
