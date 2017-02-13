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
 * Created by mchurion on 14/12/2016.
 */

/**
 * Modified by kcolina on 09/02/2017
 * Implementando herencia de la clase Inter_TercerosBean
 */
public class INTER_TercerosInfTecnicaBean extends Inter_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_TercerosInfTecnicaBean.class);


    public static ArrayList getTercerosInfTecnicaINTER() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList TercerosInfTecnicaINTER = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Tipo_Terceros,Apellido, Nombre, Num_Doc_Identificacion from TERCEROS_INF_TECNICA_INTER ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_TercerosInfTecnicaBean interTercerosInfTecnicaBean = new INTER_TercerosInfTecnicaBean();

                interTercerosInfTecnicaBean.setTipoTercero(rs.getString("TIPO_TERCEROS"));
                interTercerosInfTecnicaBean.setApellidoPaterno(rs.getString("APELLIDO"));
                interTercerosInfTecnicaBean.setNombrePrimero(rs.getString("NOMBRE"));
                interTercerosInfTecnicaBean.setNumeroDocumentoIdentidad(rs.getString("NUM_DOC_IDENTIFICACION"));


                TercerosInfTecnicaINTER.add(interTercerosInfTecnicaBean);

            }


        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return TercerosInfTecnicaINTER;

    }
}
