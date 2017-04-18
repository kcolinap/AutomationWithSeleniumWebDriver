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
public class Asesuisa_ModosdePagoBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_ModosdePagoBean.class);

    private String tipoTercero;
    private String asegurado;
    private String NombreTercero;
    private String MododePago;
    private String Marca_Tarjeta;
    private String Tipo_Tarjeta;
    private String Nro_Tarjeta;
    private String Mes_Venc_Tar;
    private String Ano_Venc_Tar;
    private String Banco_Emi;
    private String Marca_TarjetaAlt;
    private String Tipo_TarjetaAlt;
    private String Nro_TarjetaAlt;
    private String Mes_Venc_TarAlt;
    private String Ano_Venc_TarAlt;
    private String Banco_EmiAlt;
    private String NomPagador;
    private String ApePagador;
    private String Collector;
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

    public String getNombreTercero() {
        return NombreTercero;
    }

    public void setNombreTercero(String nombreTercero) {
        NombreTercero = nombreTercero;
    }

    public String getMododePago() {
        return MododePago;
    }

    public void setMododePago(String mododePago) {
        MododePago = mododePago;
    }

    public String getMarca_Tarjeta() {
        return Marca_Tarjeta;
    }

    public void setMarca_Tarjeta(String marca_Tarjeta) {
        Marca_Tarjeta = marca_Tarjeta;
    }

    public String getTipo_Tarjeta() {
        return Tipo_Tarjeta;
    }

    public void setTipo_Tarjeta(String tipo_Tarjeta) {
        Tipo_Tarjeta = tipo_Tarjeta;
    }

    public String getNro_Tarjeta() {
        return Nro_Tarjeta;
    }

    public void setNro_Tarjeta(String nro_Tarjeta) {
        Nro_Tarjeta = nro_Tarjeta;
    }

    public String getMes_Venc_Tar() {
        return Mes_Venc_Tar;
    }

    public void setMes_Venc_Tar(String mes_Venc_Tar) {
        Mes_Venc_Tar = mes_Venc_Tar;
    }

    public String getAno_Venc_Tar() {
        return Ano_Venc_Tar;
    }

    public void setAno_Venc_Tar(String ano_Venc_Tar) {
        Ano_Venc_Tar = ano_Venc_Tar;
    }

    public String getBanco_Emi() {
        return Banco_Emi;
    }

    public void setBanco_Emi(String banco_Emi) {
        Banco_Emi = banco_Emi;
    }

    public String getMarca_TarjetaAlt() {
        return Marca_TarjetaAlt;
    }

    public void setMarca_TarjetaAlt(String marca_TarjetaAlt) {
        Marca_TarjetaAlt = marca_TarjetaAlt;
    }

    public String getTipo_TarjetaAlt() {
        return Tipo_TarjetaAlt;
    }

    public void setTipo_TarjetaAlt(String tipo_TarjetaAlt) {
        Tipo_TarjetaAlt = tipo_TarjetaAlt;
    }

    public String getNro_TarjetaAlt() {
        return Nro_TarjetaAlt;
    }

    public void setNro_TarjetaAlt(String nro_TarjetaAlt) {
        Nro_TarjetaAlt = nro_TarjetaAlt;
    }

    public String getMes_Venc_TarAlt() {
        return Mes_Venc_TarAlt;
    }

    public void setMes_Venc_TarAlt(String mes_Venc_TarAlt) {
        Mes_Venc_TarAlt = mes_Venc_TarAlt;
    }

    public String getAno_Venc_TarAlt() {
        return Ano_Venc_TarAlt;
    }

    public void setAno_Venc_TarAlt(String ano_Venc_TarAlt) {
        Ano_Venc_TarAlt = ano_Venc_TarAlt;
    }

    public String getBanco_EmiAlt() {
        return Banco_EmiAlt;
    }

    public void setBanco_EmiAlt(String banco_EmiAlt) {
        Banco_EmiAlt = banco_EmiAlt;
    }

    public String getNomPagador() {
        return NomPagador;
    }

    public void setNomPagador(String nomPagador) {
        NomPagador = nomPagador;
    }

    public String getApePagador() {
        return ApePagador;
    }

    public void setApePagador(String apePagador) {
        ApePagador = apePagador;
    }

    public String getCollector() {
        return Collector;
    }

    public void setCollector(String collector) {
        Collector = collector;
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

    public static ArrayList getAsesuisa_ModoPago() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList modoPago = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_MODODEPAGO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_ModosdePagoBean modoPagoBean = new Asesuisa_ModosdePagoBean();

                modoPagoBean.setTipoTercero(rs.getString("TipoTercero"));
                modoPagoBean.setAsegurado(rs.getString("Asegurado"));
                modoPagoBean.setNombreTercero(rs.getString("NombreTercero"));
                modoPagoBean.setMododePago(rs.getString("MododePago"));
                modoPagoBean.setMarca_Tarjeta(rs.getString("Marca_Tarjeta"));
                modoPagoBean.setTipo_Tarjeta(rs.getString("Tipo_Tarjeta"));
                modoPagoBean.setNro_Tarjeta(rs.getString("Nro_Tarjeta"));
                modoPagoBean.setMes_Venc_Tar(rs.getString("Mes_Venc_Tar"));
                modoPagoBean.setAno_Venc_Tar(rs.getString("Ano_Venc_Tar"));
                modoPagoBean.setBanco_Emi(rs.getString("Banco_Emi"));
                modoPagoBean.setMarca_TarjetaAlt(rs.getString("Marca_TarjetaAlt"));
                modoPagoBean.setTipo_TarjetaAlt(rs.getString("Tipo_TarjetaAlt"));
                modoPagoBean.setNro_TarjetaAlt(rs.getString("Nro_TarjetaAlt"));
                modoPagoBean.setMes_Venc_TarAlt(rs.getString("Mes_Venc_TarAlt"));
                modoPagoBean.setAno_Venc_TarAlt(rs.getString("Ano_Venc_TarAlt"));
                modoPagoBean.setBanco_EmiAlt(rs.getString("Banco_EmiAlt"));
                modoPagoBean.setNomPagador(rs.getString("NomPagador"));
                modoPagoBean.setApePagador(rs.getString("ApePagador"));
                modoPagoBean.setCollector(rs.getString("Collector"));
                modoPagoBean.setTipoCta(rs.getString("TipoCta"));
                modoPagoBean.setNroCta(rs.getString("NroCta"));

                modoPago.add(modoPagoBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return modoPago;
    }
}
