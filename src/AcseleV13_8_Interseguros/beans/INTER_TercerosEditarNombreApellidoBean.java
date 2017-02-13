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
 * Created by kcolina on 19/01/2017.
 */
public class INTER_TercerosEditarNombreApellidoBean extends Inter_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_TercerosEditarNombreApellidoBean.class);


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

    public static ArrayList getINTER_TercerosEditarNombreApellido() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interTercerosEditarNombreApellido = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM INTER_TERCEROS_EDITAR_NOM_APE ORDER BY Prueba ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                INTER_TercerosEditarNombreApellidoBean inter_TercerosEditarNombreApellidoBean = new INTER_TercerosEditarNombreApellidoBean();

                inter_TercerosEditarNombreApellidoBean.setTipoTercero(rs.getString("Tipo_Tercero"));
                inter_TercerosEditarNombreApellidoBean.setNumeroDocumentoIdentidad(rs.getString("Num_Doc_Identificacion"));
                inter_TercerosEditarNombreApellidoBean.setApellidoPaterno(rs.getString("Apellido"));
                inter_TercerosEditarNombreApellidoBean.setNombrePrimero(rs.getString("Nombre"));
                inter_TercerosEditarNombreApellidoBean.setApellidoNuevo(rs.getString("Apellido_Nuevo"));
                inter_TercerosEditarNombreApellidoBean.setNombreNuevo(rs.getString("Nombre_Nuevo"));

                interTercerosEditarNombreApellido.add(inter_TercerosEditarNombreApellidoBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return interTercerosEditarNombreApellido;
    }
}
