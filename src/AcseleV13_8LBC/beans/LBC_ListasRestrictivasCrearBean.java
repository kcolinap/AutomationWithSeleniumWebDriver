package AcseleV13_8LBC.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 31/10/2016.
 */
public class LBC_ListasRestrictivasCrearBean implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_ListasRestrictivasCrearBean.class);

    private String tipo;
    private String nombre;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList getLBC_ListasRestrictivasCrearBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList listaRestrictiva = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, TIPO, NOMBRE FROM LISTA_RESTRICTIVA_CREAR_LBC ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_ListasRestrictivasCrearBean lbcListasRestrictivasCrearBean = new LBC_ListasRestrictivasCrearBean();

                lbcListasRestrictivasCrearBean.setTipo(rs.getString("TIPO"));

                listaRestrictiva.add(lbcListasRestrictivasCrearBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return listaRestrictiva;
    }
}
