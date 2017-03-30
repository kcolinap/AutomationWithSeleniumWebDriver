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
 * Created by aandrade on 29/03/2017.
 */
public class Asesuisa_CajaCrearBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaCrearBean.class);

    private String descripcion;
    private String ubicacion;
    private String sucursal;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public static ArrayList getAsesuisa_CajaCrear() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_CAJA_CREAR ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_CajaCrearBean cajaCrearBean = new Asesuisa_CajaCrearBean();

                cajaCrearBean.setDescripcion(rs.getString("DESCRIPCION"));
                cajaCrearBean.setUbicacion(rs.getString("UBICACION"));
                cajaCrearBean.setSucursal(rs.getString("SUCURSAL"));

                caja.add(cajaCrearBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return caja;
    }
}
