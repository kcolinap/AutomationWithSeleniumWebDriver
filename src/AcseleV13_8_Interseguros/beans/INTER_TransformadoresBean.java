package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 03/02/2017.
 */
public class INTER_TransformadoresBean {

    private final static Logger log = Logger.getLogger(INTER_BusquedaSiniestroSimpleBean.class);

    private String buscar;
    private String valorDefecto;
    private String valorPropiedad;


    public String getBuscar() {return buscar;}
    public void setBuscar(String buscar) {this.buscar = buscar;}

    public String getValorDefecto() {return valorDefecto;}
    public void setValorDefecto(String valorDefecto) {this.valorDefecto = valorDefecto;}

    public String getValorPropiedad() {return valorPropiedad;}
    public void setValorPropiedad(String valorPropiedad) {this.valorPropiedad = valorPropiedad;}


    public static ArrayList getINTER_Transformadores() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interTransformadores = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,buscar, valor_Defecto, valor_Propiedad FROM INTER_TRANSFORMADORES ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_TransformadoresBean inter_transformadoresBean= new INTER_TransformadoresBean();

                inter_transformadoresBean.setBuscar(rs.getString("BUSCAR"));
                inter_transformadoresBean.setValorDefecto(rs.getString("VALOR_DEFECTO"));
                inter_transformadoresBean.setValorPropiedad(rs.getString("VALOR_PROPIEDAD"));



                interTransformadores.add(inter_transformadoresBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interTransformadores;

    }
}
