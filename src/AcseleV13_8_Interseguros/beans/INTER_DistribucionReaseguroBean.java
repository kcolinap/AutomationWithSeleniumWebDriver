package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 25/01/2017.
 */
public class INTER_DistribucionReaseguroBean {

    private final static Logger log = Logger.getLogger(INTER_DistribucionReaseguroBean.class);

    private String tipoTercero;
    private String nombreEmpresa;
    private String sucursal;

    public String getTipoTercero() {return tipoTercero;}
    public void setTipoTercero(String tipoTercero) {this.tipoTercero = tipoTercero;}

    public String getNombreEmpresa() {return nombreEmpresa;}
    public void setNombreEmpresa(String nombreEmpresa) {this.nombreEmpresa = nombreEmpresa;}

    public String getSucursal() {return sucursal;}
    public void setSucursal(String sucursal) {this.sucursal = sucursal;}

    public static ArrayList getINTER_DistribucionReaseguro() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interDistribucionReaseguro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Tipo_Tercero, Nombre_Empresa,Sucursal FROM INTER_DISTRI_REASEGURO ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_DistribucionReaseguroBean inter_distribucionReaseguroBean= new INTER_DistribucionReaseguroBean();

                inter_distribucionReaseguroBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                inter_distribucionReaseguroBean.setNombreEmpresa(rs.getString("NOMBRE_EMPRESA"));
                inter_distribucionReaseguroBean.setSucursal(rs.getString("SUCURSAL"));

                interDistribucionReaseguro.add(inter_distribucionReaseguroBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interDistribucionReaseguro;

    }
}
