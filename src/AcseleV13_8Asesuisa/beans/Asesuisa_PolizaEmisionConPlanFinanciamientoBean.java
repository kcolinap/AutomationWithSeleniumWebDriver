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
 * Created by agil on 28/04/2017.
 */
public class Asesuisa_PolizaEmisionConPlanFinanciamientoBean extends Asesuisa_PolizasBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionConPlanFinanciamientoBean.class);

    public static ArrayList getAsesuisa_PolizaEmisionConPlanFinanciamiento() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tercero = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASE_POLI_EMISION_CON_PLAN_FIN ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_PolizaEmisionConPlanFinanciamientoBean bean = new Asesuisa_PolizaEmisionConPlanFinanciamientoBean();

                bean.setProducto(rs.getString("PRODUCTO"));
                bean.setVigencia(rs.getString("VIGENCIA"));
                bean.setFechaDesde(rs.getString("FECHA_DESDE"));
                bean.setFechaHasta(rs.getString("FEHCA_HASTA"));
                bean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                bean.setFechaMovimiento(rs.getString("FECHA_MOVIMIENTO"));
                bean.setPlanesFinanciamiento(rs.getString("PLAN_FINANCIEMIENTO"));
                bean.setMonedas(rs.getString("MONEDAS"));
                bean.setSucursal(rs.getString("SUCURSAL"));
                bean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                bean.setComisionNegociable(rs.getString("COMISION_NEGOCIABLE"));
                bean.setCodigoAgenciaVentas(rs.getString("CODIGO_AGENCIA_VENTAS"));
                bean.setTomador1Nombre1(rs.getString("TOMADOR_NOMBRE_1"));
                bean.setTomador1Nombre2(rs.getString("TOMADOR_NOMBRE_2"));
                bean.setTomador1Apellido1(rs.getString("TOMADOR_APELLIDO_1"));
                bean.setTomador1Apellido2(rs.getString("TOMADOR_APELLIDO_2"));
                bean.setAsesor1Nombre1(rs.getString("ASESOR_NOMBRE_1"));
                bean.setAsesor1Nombre2(rs.getString("ASESOR_NOMBRE_2"));
                bean.setAsesor1Apellido1(rs.getString("ASESOR_APELLIDO_1"));
                bean.setAsesor1Apellido2(rs.getString("ASESOR_APELLIDO_2"));
                bean.setNumeroObjetoAsegurado1(rs.getString("NUMERO_OBJETO_ASEGURADO"));
                bean.setOpcionAsegurado1(rs.getString("OPCION_SEGURO"));
                bean.setAsegurado1Nombre1(rs.getString("ASEGURADO_NOMBRE_1"));
                bean.setAsegurado1Nombre2(rs.getString("ASEGURADO_NOMBRE_2"));
                bean.setAsegurado1Apellido1(rs.getString("ASEGURADO_APELLIDO_1"));
                bean.setAsegurado1Apellido2(rs.getString("ASEGURADO_APELLIDO_2"));

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
