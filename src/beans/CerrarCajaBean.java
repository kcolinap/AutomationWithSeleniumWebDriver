package beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 18/07/2016.
 */
public class CerrarCajaBean implements Serializable{

    private String cajaAbierta;

    public String getCajaAbierta(){
        return cajaAbierta;
    }
    public void setCajaAbierta(String cajaAbierta) {
        this.cajaAbierta = cajaAbierta;
    }

    public static ArrayList getCerrarCaja(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, CAJA_ABIERTA FROM CERRAR_CAJA ORDER BY PRUEBA ASC");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CerrarCajaBean cerrarCajaBean = new CerrarCajaBean();
                cerrarCajaBean.setCajaAbierta(rs.getString("CAJA_ABIERTA"));
                caja.add(cerrarCajaBean);
            }

        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }

        return caja;
    }


}
