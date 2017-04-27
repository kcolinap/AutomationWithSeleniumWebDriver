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
 * Created by kcolina on 06/03/2017.
 */
public class Asesuisa_TercerosInformacionTecnicaBean extends Asesuisa_TercerosBean {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosInformacionTecnicaBean.class);

    private String tipoBusqueda;

    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(String tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

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
                Asesuisa_TercerosInformacionTecnicaBean asesuisaTercerosInformacionTecnicaBean = new Asesuisa_TercerosInformacionTecnicaBean();

                asesuisaTercerosInformacionTecnicaBean.setTipoTercero(rs.getString("tipoTercero"));

                asesuisaTercerosInformacionTecnicaBean.setPrimerNombre(rs.getString("primerNombre"));
                asesuisaTercerosInformacionTecnicaBean.setPrimerApellido(rs.getString("primerApellido"));
                asesuisaTercerosInformacionTecnicaBean.setNumeroDocumento(rs.getString("NUMERODOCUMENTO"));
                asesuisaTercerosInformacionTecnicaBean.setTipoDocumentoIdentificacion(rs.getString("TIPODOCUMENTO"));

                asesuisaTercerosInformacionTecnicaBean.setCodigoIdentificador(rs.getString("CODIGOIDENTIFICADOR"));

                asesuisaTercerosInformacionTecnicaBean.setRazonSocial(rs.getString("RAZONSOCIAL"));
                asesuisaTercerosInformacionTecnicaBean.setNroNRC(rs.getString("NRC"));

                asesuisaTercerosInformacionTecnicaBean.setTipoBusqueda(rs.getString("TIPOB"));


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
