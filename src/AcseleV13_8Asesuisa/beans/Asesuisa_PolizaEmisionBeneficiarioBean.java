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
 * Created by agil on 17/05/2017.
 */
public class Asesuisa_PolizaEmisionBeneficiarioBean extends Asesuisa_PolizasBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionBeneficiarioBean.class);

    private String beneficiarioPorcentajeEditar;

    public String getBeneficiarioPorcentajeEditar() {
        return beneficiarioPorcentajeEditar;
    }

    public void setBeneficiarioPorcentajeEditar(String beneficiarioPorcentajeEditar) {
        this.beneficiarioPorcentajeEditar = beneficiarioPorcentajeEditar;
    }

    public static ArrayList getAsesuisa_PolizaEmisionBeneficiario() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tercero = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASE_POLI_EMISION_BENEFICIARIO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_PolizaEmisionBeneficiarioBean bean = new Asesuisa_PolizaEmisionBeneficiarioBean();

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
                bean.setAsesor1Nombre1(rs.getString("ASESOR_NOMBRE_1"));
                bean.setAsesor1Nombre2(rs.getString("ASESOR_NOMBRE_2"));
                bean.setAsesor1Apellido1(rs.getString("ASESOR_APELLIDO_1"));
                bean.setAsesor1Nombre2(rs.getString("ASESOR_APELLIDO_2"));
                bean.setNumeroUnidadRiesgo1(rs.getString("NUMERO_UNIDAD_RIESGO"));
                bean.setTipoObjetoAsegurado1(rs.getString("TIPO_OBJETO_ASEGURADO_1"));
                bean.setNumeroObjetoAsegurado1(rs.getString("NUMERO_OBJETO_ASEGURADO_1"));
                bean.setMarca1(rs.getString("MARCA_1"));
                bean.setModelo1(rs.getString("MODELO_1"));
                bean.setAnio1(rs.getString("ANIO_1"));
                bean.setNumeroAsientos1(rs.getString("NUMERO_ASIENTOS_1"));
                bean.setAsegurado1Nombre1(rs.getString("ASEGURADO_1_NOMBRE_1"));
                bean.setAsegurado1Nombre2(rs.getString("ASEGURADO_1_NOMBRE_2"));
                bean.setAsegurado1Apellido1(rs.getString("ASEGURADO_1_APELLIDO_1"));
                bean.setAsegurado1Apellido2(rs.getString("ASEGURADO_1_APELLIDO_2"));
                bean.setBeneficiario1Nombre1(rs.getString("BENEFICIARIO_1_NOMBRE_1"));
                bean.setBeneficiario1Nombre2(rs.getString("BENEFICIARIO_1_NOMBRE_2"));
                bean.setBeneficiario1Apellido1(rs.getString("BENEFICIARIO_1_APELLIDO_1"));
                bean.setBeneficiario1Apellido2(rs.getString("BENEFICIARIO_1_APELLIDO_2"));
                bean.setBeneficiarioPorcentajeEditar(rs.getString("BENEFICIARIO_PORCENTAJE_EDIT"));

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
