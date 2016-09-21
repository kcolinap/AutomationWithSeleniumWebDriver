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
 * Created by kzambrano on 20/08/2016.
 */
public class TransformadoresBean implements Serializable {

    private final static Logger log = Logger.getLogger(TransformadoresBean.class);

    private String buscar;
    private String valorDefecto;
    private String valorPropiedad;

    public String getBuscar() {return buscar;}
    public void setBuscar (String buscar) {this.buscar = buscar;}

    public String getValorDefecto() {return valorDefecto;}
    public void setValorDefecto (String valorDefecto) {this.valorDefecto = valorDefecto;}


    public String getValorPropiedad() {return valorPropiedad;}
    public void setValorPropiedad (String valorPropiedad) {this.valorPropiedad = valorPropiedad;}


    public static ArrayList getTransformadores() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList transformadores = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, BUSCAR, VALORDEFECTO, VALORPROPIEDAD FROM TRANSFORMADORES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TransformadoresBean transformadoresBean = new TransformadoresBean();

                transformadoresBean.setBuscar(rs.getString("BUSCAR"));
                transformadoresBean.setValorDefecto(rs.getString("VALORDEFECTO"));
                transformadoresBean.setValorPropiedad(rs.getString("VALORPROPIEDAD"));

                transformadores.add(transformadoresBean);


            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return transformadores;

    }

}