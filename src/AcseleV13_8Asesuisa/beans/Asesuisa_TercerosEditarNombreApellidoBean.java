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
 * Created by kcolina on 01/03/2017.
 */
public class Asesuisa_TercerosEditarNombreApellidoBean extends Asesuisa_TercerosBean implements Serializable{

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosEditarNombreApellidoBean.class);

    private String apellidoNuevo;
    private String nombreNuevo;

    public String getApellidoNuevo() {
        return apellidoNuevo;
    }

    public void setApellidoNuevo(String apellidoNuevo) {
        this.apellidoNuevo = apellidoNuevo;
    }

    public String getNombreNuevo() {
        return nombreNuevo;
    }

    public void setNombreNuevo(String nombreNuevo) {
        this.nombreNuevo = nombreNuevo;
    }

    public static ArrayList getAsesuisa_TercerosEditarNombreApellido() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaTercerosEditarNombreApellido = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM asesuisa_terceros_edit_nomape ORDER BY Prueba ASC");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){
                Asesuisa_TercerosEditarNombreApellidoBean asesuisaTercerosEditarNombreApellidoBean = new Asesuisa_TercerosEditarNombreApellidoBean();

                asesuisaTercerosEditarNombreApellidoBean.setTipoTercero(rs.getString("TIPOTERCERO"));
                asesuisaTercerosEditarNombreApellidoBean.setPrimerNombre(rs.getString("PRIMERNOMBRE"));
                asesuisaTercerosEditarNombreApellidoBean.setPrimerApellido(rs.getString("PRIMERAPELLIDO"));
                asesuisaTercerosEditarNombreApellidoBean.setNombreNuevo(rs.getString("NOMBRENUEVO"));
                asesuisaTercerosEditarNombreApellidoBean.setApellidoNuevo(rs.getString("APELLIDONUEVO"));

                asesuisaTercerosEditarNombreApellido.add(asesuisaTercerosEditarNombreApellidoBean);
            }
        }catch (Exception e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }

        return asesuisaTercerosEditarNombreApellido;
    }
}
