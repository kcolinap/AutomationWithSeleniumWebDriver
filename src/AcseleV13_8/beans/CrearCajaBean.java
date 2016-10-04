package AcseleV13_8.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 14/07/2016.
 */
public class CrearCajaBean implements Serializable{

    private final static Logger log = Logger.getLogger(CrearCajaBean.class);

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
    public void setSucursal(String sucursal) {this.sucursal = sucursal; }

    public static ArrayList getCrearCaja() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, DESCRIPCION, UBICACION, SUCURSAL FROM CREAR_CAJA ORDER BY PRUEBA ASC");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CrearCajaBean crearCajaBean = new CrearCajaBean();
                crearCajaBean.setDescripcion(rs.getString("DESCRIPCION"));
                crearCajaBean.setUbicacion(rs.getString("UBICACION"));
                crearCajaBean.setSucursal(rs.getString("SUCURSAL"));
                caja.add(crearCajaBean);
            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return caja;
    }

}
