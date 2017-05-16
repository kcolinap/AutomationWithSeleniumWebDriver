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
 * Created by agil on 16/05/2017.
 */
public class Asesuisa_PolizaEmisionTomadoresBean extends Asesuisa_PolizasBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionTomadoresBean.class);

    private String tomadorPorcentajeEditar;

    public String getTomadorPorcentajeEditar() {
        return tomadorPorcentajeEditar;
    }

    public void setTomadorPorcentajeEditar(String tomadorPorcentajeEditar) {
        this.tomadorPorcentajeEditar = tomadorPorcentajeEditar;
    }

    public static ArrayList getAsesuisa_PolizaEmisionTomadores() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tercero = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASE_POLI_EMISION_TOMADORES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_PolizaEmisionTomadoresBean bean = new Asesuisa_PolizaEmisionTomadoresBean();

                bean.setProducto(rs.getString("PRODUCTO"));
                bean.setVigencia(rs.getString("VIGENCIA"));
                bean.setFechaDesde(rs.getString("FECHA_DESDE"));
                bean.setFechaHasta(rs.getString("FEHCA_HASTA"));
                bean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                bean.setFechaMovimiento(rs.getString("FECHA_MOVIMIENTO"));
                bean.setPlanesFinanciamiento(rs.getString("PLAN_FINANCIEMIENTO"));
                bean.setMonedas(rs.getString("MONEDAS"));
                bean.setSucursal(rs.getString("SUCURSAL"));
                bean.setTipoEmision(rs.getString("TIPO_EMISION"));
                bean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                bean.setComisionNegociable(rs.getString("COMISION_NEGOCIABLE"));
                bean.setUnidadComercial(rs.getString("UNIDAD_COMERCIAL"));
                bean.setCanalVenta(rs.getString("CANAL_VENTA"));
                bean.setTomador1Nombre1(rs.getString("TOMADOR_NOMBRE_1"));
                bean.setTomador1Nombre2(rs.getString("TOMADOR_NOMBRE_2"));
                bean.setTomador1Apellido1(rs.getString("TOMADOR_APELLIDO_1"));
                bean.setTomador1Apellido2(rs.getString("TOMADOR_APELLIDO_2"));
                bean.setTomadorPorcentajeEditar(rs.getString("TOMADOR_PORCENTAJE_EDIT"));

                tercero.add(bean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return tercero;
    }
}
