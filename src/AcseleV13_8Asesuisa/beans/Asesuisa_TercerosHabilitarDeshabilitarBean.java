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
 * Created by kcolina on 24/02/2017.
 */
public class Asesuisa_TercerosHabilitarDeshabilitarBean extends Asesuisa_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosHabilitarDeshabilitarBean.class);

    public static ArrayList getTecerosHabilitarDeshabilitarBean() throws SQLException{
        Connection conexion = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaTercerosHabilitarDeshabilitar = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM asesuisa_terceros_habdes ORDER BY prueba ASC");

        try{
            conexion = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){
                Asesuisa_TercerosHabilitarDeshabilitarBean asesuisaTercerosHabilitarDeshabilitarBean = new Asesuisa_TercerosHabilitarDeshabilitarBean();

                asesuisaTercerosHabilitarDeshabilitarBean.setTipoTercero(rs.getString("tipoTercero"));
                asesuisaTercerosHabilitarDeshabilitarBean.setPrimerNombre(rs.getString("primerNombre"));
                asesuisaTercerosHabilitarDeshabilitarBean.setPrimerApellido(rs.getString("primerApellido"));
                asesuisaTercerosHabilitarDeshabilitarBean.setNumeroDUI(rs.getString("numeroDUI"));
                asesuisaTercerosHabilitarDeshabilitarBean.setNumeroNIT(rs.getString("numeroNIT"));

                asesuisaTercerosHabilitarDeshabilitar.add(asesuisaTercerosHabilitarDeshabilitarBean);
            }
        }catch (SQLException e){
            log.error(e);
        }finally{
            if (conexion != null){
                conexion.close();
            }
        }

        return asesuisaTercerosHabilitarDeshabilitar;
    }
}
