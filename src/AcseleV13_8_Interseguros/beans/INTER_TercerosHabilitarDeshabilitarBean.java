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
 * Created by kcolina on 06/02/2017.
 */
public class INTER_TercerosHabilitarDeshabilitarBean extends Inter_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_TercerosEditarNombreApellidoBean.class);


    public static ArrayList getINTER_TercerosHabilitarDeshabilitar() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interTercerosHabilitarDeshabilitar = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM INTER_TERCEROS_HABIL_DESHABIL ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                INTER_TercerosHabilitarDeshabilitarBean inter_tercerosHabilitarDeshabilitarBeanBean = new INTER_TercerosHabilitarDeshabilitarBean();

                inter_tercerosHabilitarDeshabilitarBeanBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                inter_tercerosHabilitarDeshabilitarBeanBean.setNumeroDocumentoIdentidad(rs.getString("NUM_DOC_IDENTIFICACION"));
                inter_tercerosHabilitarDeshabilitarBeanBean.setApellidoPaterno(rs.getString("APELLIDO"));
                inter_tercerosHabilitarDeshabilitarBeanBean.setNombrePrimero(rs.getString("NOMBRE"));

                interTercerosHabilitarDeshabilitar.add(inter_tercerosHabilitarDeshabilitarBeanBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return interTercerosHabilitarDeshabilitar;
    }
}
