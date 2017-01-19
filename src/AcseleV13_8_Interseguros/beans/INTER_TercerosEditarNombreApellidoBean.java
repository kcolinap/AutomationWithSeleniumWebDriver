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
public class INTER_TercerosEditarNombreApellidoBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_TercerosEditarNombreApellidoBean.class);

    private String tipoTerceros;
    private String apellido;
    private String nombre;

    public String getTipoTerceros() {
        return tipoTerceros;
    }

    public void setTipoTerceros(String tipoTerceros) {
        this.tipoTerceros = tipoTerceros;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList getINTER_TercerosEditarNombreApellido() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interTercerosEditarNombreApellido = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM INTER_TERCEROS_EDITAR_NOMBRE_APELLIDO ORDER BY Prueba ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                INTER_TercerosEditarNombreApellidoBean inter_TercerosEditarNombreApellidoBean = new INTER_TercerosEditarNombreApellidoBean();

                inter_TercerosEditarNombreApellidoBean.setTipoTerceros(rs.getString("Tipo_Tercero"));
                inter_TercerosEditarNombreApellidoBean.setApellido(rs.getString("Apellido"));
                inter_TercerosEditarNombreApellidoBean.setNombre(rs.getString("Nombre"));

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
