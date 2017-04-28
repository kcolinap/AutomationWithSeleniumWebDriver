package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by kcolina on 06/03/2017.
 */
public class Asesuisa_TercerosInformacionFinancieraBean extends Asesuisa_TercerosBean {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosInformacionFinancieraBean.class);

    public static ArrayList getTercerosInformacionTecnicaBean() throws SQLException{

        Connection conexion = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaTercerosInformacionTecnica = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM asesuisa_terceros_inftec ORDER BY prueba ASC");

        try {
            conexion = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){
                Asesuisa_TercerosInformacionFinancieraBean asesuisaTercerosInformacionTecnicaBean = new Asesuisa_TercerosInformacionFinancieraBean();

                asesuisaTercerosInformacionTecnicaBean.setTipoTercero(rs.getString("tipoTercero"));
                asesuisaTercerosInformacionTecnicaBean.setPrimerNombre(rs.getString("primerNombre"));
                asesuisaTercerosInformacionTecnicaBean.setPrimerApellido(rs.getString("primerApellido"));
                asesuisaTercerosInformacionTecnicaBean.setNumeroDocumento(rs.getString("NUMERODOCUMENTO"));

                asesuisaTercerosInformacionTecnica.add(asesuisaTercerosInformacionTecnicaBean);
            }
        }catch (Exception e){
            log.error(e);
        }finally {
            if (conexion != null){
                conexion.close();
            }
        }

        return asesuisaTercerosInformacionTecnica;
    }
}
