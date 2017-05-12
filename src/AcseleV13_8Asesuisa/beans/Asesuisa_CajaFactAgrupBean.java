package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aandrade on 26/04/2017.
 */
public class Asesuisa_CajaFactAgrupBean {
    private final static Logger log = Logger.getLogger(Asesuisa_CajaFactAgrupBean.class);

    private String poliza;
    private String tipotran;
    private String tipopago;
    private String cuentab;
    private String bancoe;
    private String numcheq;
    private String pagador;
    private String diu;
    private String tipotarj;
    private String numerot;
    private String numpos;
    private String voucher;
    private String moneda;
    private String monto;
    private String ramo;




    private String agrupado;
    private String poliza2;
    private String tercero;




    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getTipotran() {
        return tipotran;
    }

    public void setTipotran(String tipotran) {
        this.tipotran = tipotran;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public String getCuentab() {
        return cuentab;
    }

    public void setCuentab(String cuentab) {
        this.cuentab = cuentab;
    }

    public String getBancoe() {
        return bancoe;
    }

    public void setBancoe(String bancoe) {
        this.bancoe = bancoe;
    }

    public String getNumcheq() {
        return numcheq;
    }

    public void setNumcheq(String numcheq) {
        this.numcheq = numcheq;
    }

    public String getPagador() {
        return pagador;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public String getDiu() {
        return diu;
    }

    public void setDiu(String diu) {
        this.diu = diu;
    }

    public String getTipotarj() {
        return tipotarj;
    }

    public void setTipotarj(String tipotarj) {
        this.tipotarj = tipotarj;
    }

    public String getNumerot() {
        return numerot;
    }

    public void setNumerot(String numerot) {
        this.numerot = numerot;
    }

    public String getNumpos() {
        return numpos;
    }

    public void setNumpos(String numpos) {
        this.numpos = numpos;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getAgrupado() {
        return agrupado;
    }

    public void setAgrupado(String agrupado) {
        this.agrupado = agrupado;
    }

    public String getPoliza2() {
        return poliza2;
    }

    public void setPoliza2(String poliza2) {
        this.poliza2 = poliza2;
    }

    public String getTercero() {
        return tercero;
    }

    public void setTercero(String tercero) {
        this.tercero = tercero;
    }



    public static ArrayList getAsesuisa_CajaFactAgrup() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_CAJA_FACTAGRUP ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_CajaFactAgrupBean cajaFactAgrupBean = new Asesuisa_CajaFactAgrupBean();

                cajaFactAgrupBean.setPoliza(rs.getString("POLIZA"));
                cajaFactAgrupBean.setTipotran(rs.getString("TIPOTRAN"));
                cajaFactAgrupBean.setTipopago(rs.getString("TIPOPAGO"));
                cajaFactAgrupBean.setCuentab(rs.getString("CUENTAB"));
                cajaFactAgrupBean.setBancoe(rs.getString("BANCOE"));
                cajaFactAgrupBean.setNumcheq(rs.getString("NUMCHEQ"));
                cajaFactAgrupBean.setPagador(rs.getString("PAGADOR"));
                cajaFactAgrupBean.setDiu(rs.getString("DIU"));
                cajaFactAgrupBean.setTipotarj(rs.getString("TIPOTARJ"));
                cajaFactAgrupBean.setNumerot(rs.getString("NUMEROT"));
                cajaFactAgrupBean.setNumpos(rs.getString("NUMPOS"));
                cajaFactAgrupBean.setVoucher(rs.getString("VOUCHER"));
                cajaFactAgrupBean.setMoneda(rs.getString("MONEDA"));
                cajaFactAgrupBean.setMonto(rs.getString("MONTO"));
                cajaFactAgrupBean.setRamo(rs.getString("RAMO"));
                cajaFactAgrupBean.setAgrupado(rs.getString("AGRUPADO"));
                cajaFactAgrupBean.setPoliza2(rs.getString("POLIZA2"));
                cajaFactAgrupBean.setTercero(rs.getString("TERCERO"));

                caja.add(cajaFactAgrupBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return caja;
    }
}
