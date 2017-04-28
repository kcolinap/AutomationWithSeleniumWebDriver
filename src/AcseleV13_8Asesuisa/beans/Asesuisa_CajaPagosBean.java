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
public class Asesuisa_CajaPagosBean {
    private final static Logger log = Logger.getLogger(Asesuisa_CajaPagosBean.class);

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
        this.monto = ramo;
    }



    public static ArrayList getAsesuisa_CajaPagos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_CAJA_PAGOS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_CajaPagosBean cajaPagosBean = new Asesuisa_CajaPagosBean();

                cajaPagosBean.setPoliza(rs.getString("POLIZA"));
                cajaPagosBean.setTipotran(rs.getString("TIPOTRAN"));
                cajaPagosBean.setTipopago(rs.getString("TIPOPAGO"));
                cajaPagosBean.setCuentab(rs.getString("CUENTAB"));
                cajaPagosBean.setBancoe(rs.getString("BANCOE"));
                cajaPagosBean.setNumcheq(rs.getString("NUMCHEQ"));
                cajaPagosBean.setPagador(rs.getString("PAGADOR"));
                cajaPagosBean.setDiu(rs.getString("DIU"));
                cajaPagosBean.setTipotarj(rs.getString("TIPOTARJ"));
                cajaPagosBean.setNumerot(rs.getString("NUMEROT"));
                cajaPagosBean.setNumpos(rs.getString("NUMPOS"));
                cajaPagosBean.setVoucher(rs.getString("VOUCHER"));
                cajaPagosBean.setMoneda(rs.getString("MONEDA"));
                cajaPagosBean.setMonto(rs.getString("MONTO"));
                cajaPagosBean.setRamo(rs.getString("RAMO"));

                caja.add(cajaPagosBean);
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
