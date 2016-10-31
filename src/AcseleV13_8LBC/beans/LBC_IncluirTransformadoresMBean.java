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
 * Created by rmontilla on 26/10/2016.
 */
public class LBC_IncluirTransformadoresMBean implements Serializable{

    private final static Logger log = Logger.getLogger(LBC_IncluirTransformadoresMBean.class);

    private String buscar;
    private String valorDefecto;
    private String valorPropiedad;

    public String getBuscar() {return buscar;}
    public void setBuscar (String buscar) {this.buscar = buscar;}

    public String getValorDefecto() {return valorDefecto;}
    public void setValorDefecto (String valorDefecto) {this.valorDefecto = valorDefecto;}


    public String getValorPropiedad() {return valorPropiedad;}
    public void setValorPropiedad (String valorPropiedad) {this.valorPropiedad = valorPropiedad;}


    public static ArrayList getLBC_IncluirTransformadoresM() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList lbc_IncluirTransformadoresM = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, BUSCAR, VALORDEFECTO, VALORPROPIEDAD FROM LBC_TRANSFORMADORES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_IncluirTransformadoresMBean lbc_incluirTransformadoresMBean = new LBC_IncluirTransformadoresMBean();

                lbc_incluirTransformadoresMBean.setBuscar(rs.getString("BUSCAR"));
                lbc_incluirTransformadoresMBean.setValorDefecto(rs.getString("VALORDEFECTO"));
                lbc_incluirTransformadoresMBean.setValorPropiedad(rs.getString("VALORPROPIEDAD"));

                lbc_IncluirTransformadoresM.add(lbc_incluirTransformadoresMBean);


            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return lbc_IncluirTransformadoresM;
    }
}
