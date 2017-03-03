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
 * Created by kcolina on 03/03/2017.
 */
public class Asesuisa_TercerosDireccionesBean extends Asesuisa_TercerosBean implements Serializable{

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosDireccionesBean.class);

    private String pais;
    private String dpto;
    private String municipio;
    private String avenida;
    private String dirCompleta;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getAvenida() {
        return avenida;
    }

    public void setAvenida(String avenida) {
        this.avenida = avenida;
    }

    public String getDirCompleta() {
        return dirCompleta;
    }

    public void setDirCompleta(String dirCompleta) {
        this.dirCompleta = dirCompleta;
    }

    public static ArrayList getAsesuisa_TercerosDireccionesBean() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaTercerosDirecciones = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM asesuisa_terceros_dir ORDER BY Prueba ASC");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){
                Asesuisa_TercerosDireccionesBean asesuisaTercerosDireccionesBean = new Asesuisa_TercerosDireccionesBean();

                asesuisaTercerosDireccionesBean.setTipoTercero(rs.getString("TIPOTERCERO"));
                asesuisaTercerosDireccionesBean.setPrimerNombre(rs.getString("PRIMERNOMBRE"));
                asesuisaTercerosDireccionesBean.setPrimerApellido(rs.getString("PRIMERAPELLIDO"));
                asesuisaTercerosDireccionesBean.setNumeroDocumento(rs.getString("NUMERODOCUMENTO"));
                asesuisaTercerosDireccionesBean.setPais(rs.getString("PAIS"));
                asesuisaTercerosDireccionesBean.setDpto(rs.getString("DPTO"));
                asesuisaTercerosDireccionesBean.setMunicipio(rs.getString("MUNICIPIO"));
                asesuisaTercerosDireccionesBean.setAvenida(rs.getString("AVENIDA"));
                asesuisaTercerosDireccionesBean.setDirCompleta(rs.getString("DIRCOMPLETA"));

                asesuisaTercerosDirecciones.add(asesuisaTercerosDireccionesBean);
            }
        }catch (Exception e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return asesuisaTercerosDirecciones;
    }
}
