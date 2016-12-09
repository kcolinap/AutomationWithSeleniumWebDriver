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
 * Created by aazuaje on 09/12/2016.
 */
public class INTER_PrevisualizacionCuentaTecnicaBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_ConsultaCuentaTecnicaBean.class);

    private String fechaDesde;
    private String fechaHasta;

    public String getFechaDesde() {return fechaDesde;}
    public void setFechaDesde(String fechaDesde) {this.fechaDesde = fechaDesde;}

    public String getFechaHasta() {return fechaHasta;}
    public void setFechaHasta(String fechaHasta) {this.fechaHasta = fechaHasta;}

    public static ArrayList getInterPrevisualizacionCuentaTecnica() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interPrevisualizacionCuentaTecnica = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Fecha_Desde,Fecha_Hasta FROM PREVI_CUENTA_TECNICA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_PrevisualizacionCuentaTecnicaBean inter_previsualizacionCuentaTecnicaBean = new INTER_PrevisualizacionCuentaTecnicaBean();

                inter_previsualizacionCuentaTecnicaBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                inter_previsualizacionCuentaTecnicaBean.setFechaHasta(rs.getString("FECHA_HASTA"));

                interPrevisualizacionCuentaTecnica.add(inter_previsualizacionCuentaTecnicaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return interPrevisualizacionCuentaTecnica;
    }

}
