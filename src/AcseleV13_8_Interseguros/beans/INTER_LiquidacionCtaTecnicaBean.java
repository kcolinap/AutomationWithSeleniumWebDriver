package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 25/01/2017.
 */
public class INTER_LiquidacionCtaTecnicaBean {

    private final static Logger log = Logger.getLogger(INTER_LiquidacionCtaTecnicaBean.class);

    private String listaCuenta;

    public String getListaCuenta() {return listaCuenta;}
    public void setListaCuenta(String listaCuenta) {this.listaCuenta = listaCuenta;}

    public static ArrayList getINTER_LiquidacionCtaTecnica() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interLiquidacionCuentaTecnica = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Lista_cuenta FROM INTER_LIQUIDACION_CTA_TECNICA ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_LiquidacionCtaTecnicaBean inter_liquidacionCtaTecnicaBean= new INTER_LiquidacionCtaTecnicaBean();

                inter_liquidacionCtaTecnicaBean.setListaCuenta(rs.getString("LISTA_CUENTA"));

                interLiquidacionCuentaTecnica.add(inter_liquidacionCtaTecnicaBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interLiquidacionCuentaTecnica;

    }


}
