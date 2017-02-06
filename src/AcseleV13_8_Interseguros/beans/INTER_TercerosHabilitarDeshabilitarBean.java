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
public class INTER_TercerosHabilitarDeshabilitarBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_TercerosEditarNombreApellidoBean.class);

    private String tipoTerceros;
    private String numDocIdentificacion;
    private String apellido;
    private String nombre;

    public String getTipoTerceros() {
        return tipoTerceros;
    }

    public void setTipoTerceros(String tipoTerceros) {
        this.tipoTerceros = tipoTerceros;
    }

    public String getNumDocIdentificacion() {
        return numDocIdentificacion;
    }

    public void setNumDocIdentificacion(String numDocIdentificacion) {
        this.numDocIdentificacion = numDocIdentificacion;
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

    public static ArrayList getINTER_TercerosHabilitarDeshabilitar() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interTercerosHabilitarDeshabilitar = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM INTER_TERCEROS_HABILITAR_DESHABILITAR ORDER BY Prueba ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                INTER_TercerosHabilitarDeshabilitarBean inter_tercerosHabilitarDeshabilitarBeanBean = new INTER_TercerosHabilitarDeshabilitarBean();

                inter_tercerosHabilitarDeshabilitarBeanBean.setTipoTerceros(rs.getString("Tipo_Tercero"));
                inter_tercerosHabilitarDeshabilitarBeanBean.setNumDocIdentificacion(rs.getString("Num_Doc_Identificacion"));
                inter_tercerosHabilitarDeshabilitarBeanBean.setApellido(rs.getString("Apellido"));
                inter_tercerosHabilitarDeshabilitarBeanBean.setNombre(rs.getString("Nombre"));

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
