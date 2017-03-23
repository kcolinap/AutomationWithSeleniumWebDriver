package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by kcolina on 15/03/2017.
 */
public class Asesuisa_SiniestroBusquedaSimpleBean extends Asesuisa_SiniestroBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroBusquedaSimpleBean.class);

    public static ArrayList getSiniestroBusquedaSimpleBean() throws SQLException{

        Connection conexion = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaSiniestroBusquedaSimple = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select");

        try{
            conexion = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                Asesuisa_SiniestroBusquedaSimpleBean asesuisaSiniestroBusquedaSimpleBean = new Asesuisa_SiniestroBusquedaSimpleBean();

                asesuisaSiniestroBusquedaSimpleBean.setOrdenarPor(rs.getString("ORDENARPOR"));
                asesuisaSiniestroBusquedaSimpleBean.setNroSiniestro(rs.getString("NUMEROSINIESTRO"));
                asesuisaSiniestroBusquedaSimpleBean.setNroPoliza(rs.getString("NUMEROPOLIZA"));
                asesuisaSiniestroBusquedaSimpleBean.setFechaOcurrencia(rs.getString("FECHAOCURRENCIA"));
                asesuisaSiniestroBusquedaSimpleBean.setProducto(rs.getString("PRODUCTO"));

                asesuisaSiniestroBusquedaSimple.add(asesuisaSiniestroBusquedaSimpleBean);
            }

        }catch (SQLException e){
            log.error(e);
        }finally {
            if (conexion!=null){
                conexion.close();
            }
        }

        return asesuisaSiniestroBusquedaSimple;
    }
}
