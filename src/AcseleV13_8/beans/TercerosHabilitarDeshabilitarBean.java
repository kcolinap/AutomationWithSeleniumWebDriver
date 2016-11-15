package AcseleV13_8.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 12/07/2016.
 */
public class TercerosHabilitarDeshabilitarBean extends PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(TercerosHabilitarDeshabilitarBean.class);

    private String tipTercer;
    private String tipDcID;
    private String cedulaID;
    private String nombreT;
    private String apellidoT;

    public String getTipTercer(){
        return tipTercer;
    }
    public void setTipTercer(String tipTercer){
        this.tipTercer = tipTercer;
    }

    public String getTipDcID(){
        return tipDcID;
    }
    public void setTipDcID(String tipDcID){
        this.tipDcID = tipDcID;
    }

    public String getCedulaID(){
        return cedulaID;
    }
    public void setCedulaID(String cedulaID){
        this.cedulaID = cedulaID;
    }

    public String getNombreT(){
        return nombreT;
    }
    public void setNombreT(String nombreT){
        this.nombreT = nombreT;
    }

    public String getApellidoT(){
        return apellidoT;
    }
    public void setApellidoT(String apellidoT){
        this.apellidoT = apellidoT;
    }

    public static ArrayList getTerceroHabilitarDeshabilitar() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tercerosHD = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO FROM TERCERO_HABILITAR_DESHABILITAR  ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean = new TercerosHabilitarDeshabilitarBean();

                tercerosHabilitarDeshabilitarBean.setTipTercer(rs.getString("TIPO_TERCERO"));
                tercerosHabilitarDeshabilitarBean.setTipDcID(rs.getString("TIPO_DOC_IDENTIDAD"));
                tercerosHabilitarDeshabilitarBean.setCedulaID(rs.getString("CEDULA"));
                tercerosHabilitarDeshabilitarBean.setNombreT(rs.getString("NOMBRE"));
                tercerosHabilitarDeshabilitarBean.setApellidoT(rs.getString("APELLIDO"));
                tercerosHabilitarDeshabilitarBean.setProducto(rs.getString("PRODUCTO"));
                tercerosHabilitarDeshabilitarBean.setVigencia(rs.getString("VIGENCIA"));
                tercerosHabilitarDeshabilitarBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                tercerosHabilitarDeshabilitarBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                tercerosHabilitarDeshabilitarBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                tercerosHabilitarDeshabilitarBean.setSucursal(rs.getString("SUCURSAL"));
                tercerosHabilitarDeshabilitarBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                tercerosHabilitarDeshabilitarBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                tercerosHabilitarDeshabilitarBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                tercerosHabilitarDeshabilitarBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                tercerosHabilitarDeshabilitarBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));

                tercerosHD.add(tercerosHabilitarDeshabilitarBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return tercerosHD;
    }
}
