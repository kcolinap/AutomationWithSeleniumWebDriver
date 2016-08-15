package AcseleV13_8_Alfa.beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 02/08/2016.
 */
public class HistorialReclamosBean implements Serializable {

    private String numeroReclamo;

    public String getNumeroReclamo() {return numeroReclamo;}
    public void setNumeroReclamo(String numeroReclamo) {
        this.numeroReclamo = numeroReclamo;
    }

    public static ArrayList getHistorialReclamos(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList historialReclamos = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba, Numero_Reclamo from HIST_RECLAMOS ORDER BY PRUEBA ASC");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                HistorialReclamosBean historialReclamosBean = new HistorialReclamosBean();
                historialReclamosBean.setNumeroReclamo(rs.getString("NUMERO_RECLAMO"));
                historialReclamos.add(historialReclamosBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }

        return historialReclamos;
    }
}

