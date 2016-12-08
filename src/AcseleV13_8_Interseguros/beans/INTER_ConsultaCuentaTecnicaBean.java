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
 * Created by aazuaje on 07/12/2016.
 */
public class INTER_ConsultaCuentaTecnicaBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_ConsultaCuentaTecnicaBean.class);

    private String reasegurador;
    private String corredor;
    private String fechaDesde;
    private String fechaHasta;
    private String tipoContrato;
    private String moneda;

    public String getReasegurador() {return reasegurador;}
    public void setReasegurador(String reasegurador) {this.reasegurador = reasegurador;}

    public String getCorredor() {return corredor;}
    public void setCorredor(String corredor) {this.corredor = corredor;}

    public String getFechaDesde() {return fechaDesde;}
    public void setFechaDesde(String fechaDesde) {this.fechaDesde = fechaDesde;}

    public String getFechaHasta() {return fechaHasta;}
    public void setFechaHasta(String fechaHasta) {this.fechaHasta = fechaHasta;}

    public String getTipoContrato() {return tipoContrato;}
    public void setTipoContrato(String tipoContrato) {this.tipoContrato = tipoContrato;}

    public String getMoneda() {return moneda;}
    public void setMoneda(String moneda) {this.moneda = moneda;}

    public static ArrayList getInterConsultaCuentaTecnica() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interCuentaTecnica = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Reasegurador,Corredor,Fecha_Desde,Fecha_Hasta,Tipo_Contrato,Moneda FROM CONSULTA_CUENTA_TECNICA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_ConsultaCuentaTecnicaBean inter_consultaCuentaTecnicaBean = new INTER_ConsultaCuentaTecnicaBean();

                inter_consultaCuentaTecnicaBean.setReasegurador(rs.getString("REASEGURADOR"));
                inter_consultaCuentaTecnicaBean.setCorredor(rs.getString("CORREDOR"));
                inter_consultaCuentaTecnicaBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                inter_consultaCuentaTecnicaBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                inter_consultaCuentaTecnicaBean.setTipoContrato(rs.getString("TIPO_CONTRATO"));
                inter_consultaCuentaTecnicaBean.setMoneda(rs.getString("MONEDA"));


                interCuentaTecnica.add(inter_consultaCuentaTecnicaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return interCuentaTecnica;
    }





}
