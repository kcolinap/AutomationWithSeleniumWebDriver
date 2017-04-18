package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aandrade on 31/03/2017.
 */
public class Asesuisa_GenerarTrazaBean {

    private final static Logger log = Logger.getLogger(Asesuisa_GenerarTrazaBean.class);

    private String nrocaja;

    private String tipoTraza;
    private String categoria_Traza;
    private String desde;
    private String hasta;

    public String getNrocaja() {
        return nrocaja;
    }

    public void setNrocaja(String nrocaja) {
        this.nrocaja = nrocaja;
    }

    public String getTipoTraza() {
        return tipoTraza;
    }

    public void setTipoTraza(String tipoTraza) {
        this.tipoTraza = tipoTraza;
    }

    public String getCategoria_Traza() {
        return categoria_Traza;
    }

    public void setCategoria_Traza(String categoria_Traza) {
        this.categoria_Traza = categoria_Traza;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public static ArrayList getGenerarTraza() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList generarTraza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_GENERARTRAZA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_GenerarTrazaBean generarTrazaBean = new Asesuisa_GenerarTrazaBean();

                generarTrazaBean.setNrocaja(rs.getString("NROCAJA"));
                generarTrazaBean.setTipoTraza(rs.getString("TIPO_TRAZA"));
                generarTrazaBean.setCategoria_Traza(rs.getString("CATEGORIA_TRAZA"));
                generarTrazaBean.setDesde(rs.getString("DESDE"));
                generarTrazaBean.setHasta(rs.getString("HASTA"));
                generarTraza.add(generarTrazaBean);


            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return generarTraza;
    }

}
