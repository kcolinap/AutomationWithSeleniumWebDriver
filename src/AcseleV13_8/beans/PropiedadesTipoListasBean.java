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
 * Created by aazuaje on 22/08/2016.
 */
public class PropiedadesTipoListasBean implements Serializable {

    private final static Logger log = Logger.getLogger(PropiedadesTipoListasBean.class);

    private String nombrePropiedad ;
    private String buscar ;
    private String tipoVisualizacion;


    public String getNombrePropiedad() {return nombrePropiedad;}
    public void setNombrePropiedad(String nombrePropiedad) {this.nombrePropiedad = nombrePropiedad;}

    public String getBuscar() {return buscar;}
    public void setBuscar(String buscar) {this.buscar = buscar;}

    public String getTipoVisualizacion() {return tipoVisualizacion;}
    public void setTipoVisualizacion(String tipoVisualizacion) {this.tipoVisualizacion = tipoVisualizacion;}



    public static ArrayList getPropiedadesTipoListas() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList propiedadesListas = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Nombre_Propiedad,Tipo_Visualizacion, Buscar  from PROPIEDADES_TIPO_LISTAS ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                PropiedadesTipoListasBean propiedadesTipoListasBean = new PropiedadesTipoListasBean();

                propiedadesTipoListasBean.setNombrePropiedad(rs.getString("NOMBRE_PROPIEDAD"));
                propiedadesTipoListasBean.setBuscar (rs.getString("BUSCAR"));
                propiedadesTipoListasBean.setTipoVisualizacion(rs.getString("TIPO_VISUALIZACION"));


                propiedadesListas.add(propiedadesTipoListasBean);


            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return propiedadesListas;

    }

}
